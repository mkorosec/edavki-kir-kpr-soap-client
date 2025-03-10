package si.edavki.main;

import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.InvoiceBookFormat;
import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.InvoiceBookStatusResponse;
import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tempuri.*;
import si.durs.wsdl.loginservice.*;
import si.edavki.PackageUploadResult;
import si.edavki.config.Configuration;

import javax.net.ssl.*;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

/**
 * Client for interacting with the Edavki API.
 */
public class EdavkiClient {
    private static final Logger logger = LoggerFactory.getLogger(EdavkiClient.class);

    private static final String DEFAULT_TEST_LOGIN_SERVICE_URL = "https://beta.edavki.durs.si/InvoiceBookService/SoapService/Login/";
    private static final String DEFAULT_TEST_INVOICE_BOOK_SERVICE_URL = "https://beta.edavki.durs.si/InvoiceBookService/SoapService/";
    private static final String DEFAULT_LOGIN_SERVICE_URL = "https://edavki.durs.si/InvoiceBookService/SoapService/Login/";
    private static final String DEFAULT_INVOICE_BOOK_SERVICE_URL = "https://edavki.durs.si/InvoiceBookService/SoapService/";

    private static final String LOGIN_SERVICE_URL;
    private static final String INVOICE_BOOK_SERVICE_URL;
    private static final boolean BETA_MODE;

    private static final int WAIT_FOR_VALIDATION_SECONDS = Integer.parseInt(System.getProperty("si.edavki.async.validation.pollingTimeSeconds", "2"));
    private static final int WAIT_FOR_VALIDATION_POLL_INTERVAL_SECONDS = Integer.parseInt(System.getProperty("si.edavki.async.validation.waitTimeSeconds", "120"));

    static {
        BETA_MODE = "TRUE".equalsIgnoreCase(System.getProperty("si.edavki.beta"));

        if (System.getProperty("si.edavki.loginService.url") != null) {
            LOGIN_SERVICE_URL = System.getProperty("si.edavki.loginService.url");
        } else {
            LOGIN_SERVICE_URL = BETA_MODE ? DEFAULT_TEST_LOGIN_SERVICE_URL : DEFAULT_LOGIN_SERVICE_URL;
        }

        if (System.getProperty("si.edavki.invoiceBookService.url") != null) {
            INVOICE_BOOK_SERVICE_URL = System.getProperty("si.edavki.invoiceBookService.url");
        } else {
            INVOICE_BOOK_SERVICE_URL = BETA_MODE ? DEFAULT_TEST_INVOICE_BOOK_SERVICE_URL : DEFAULT_INVOICE_BOOK_SERVICE_URL;
        }

    }

    private final Configuration configuration;

    private TokenResponse tokenResponse;
    private ZonedDateTime tokenExpiration;

    public EdavkiClient(Configuration configuration) {
        this.configuration = configuration;
    }

    public PackageUploadResult upload(String token, byte[] payload, String periodStart, String periodEnd, String format, String correlationId) throws DatatypeConfigurationException, UnrecoverableKeyException, ISoapServiceUploadInvoiceBookBadRequestFaultFaultFaultMessage, ISoapServiceUploadInvoiceBookServerErrorFaultFaultFaultMessage, CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException, ParseException, ISoapServiceUploadInvoiceBookUnauthorizedFaultFaultFaultMessage, KeyManagementException, ISoapServiceGetInvoiceBookStatusForbiddenFaultFaultFaultMessage, ISoapServiceGetInvoiceBookStatusNotFoundFaultFaultFaultMessage, ISoapServiceGetInvoiceBookStatusUnauthorizedFaultFaultFaultMessage, ISoapServiceGetInvoiceBookStatusBadRequestFaultFaultFaultMessage, ISoapServiceGetInvoiceBookStatusServerErrorFaultFaultFaultMessage {
        logger.info("uploading invoiceBook to Edavki (URL: {})", INVOICE_BOOK_SERVICE_URL);

        try {
            // Set up SSL context with the certificate
            SSLContext sslContext = createSSLContext();

            // Set the default SSL socket factory
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            // Create the service
            URL url = new URL(INVOICE_BOOK_SERVICE_URL);
            logger.debug("Connecting to invoiceBook service at: {}", INVOICE_BOOK_SERVICE_URL);

            SoapService service = new SoapService(url);
            ISoapService invoiceBookService = service.getBasicHttpBindingISoapService();
            BindingProvider bindingProvider = (BindingProvider) invoiceBookService;
            bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url.toString());
            SOAPBinding binding = (SOAPBinding) bindingProvider.getBinding();
            binding.setMTOMEnabled(true);

            // Set the authorization token
            Map<String, List<String>> headers = new HashMap<>();
            headers.put("Authorization", Collections.singletonList("Bearer " + token));
            headers.put("MIME-Version", Collections.singletonList("1.0"));
            headers.put("Accept-Encoding", Collections.singletonList("gzip,deflate"));
            headers.put("Connection", Collections.singletonList("Keep-Alive"));
            bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);

            //set the payload
            UploadInvoiceBookRequest parameters = new UploadInvoiceBookRequest();
            parameters.setData(payload);

            Period period = new Period();
            period.setBegin(toJAXBGregorianCalendar(periodStart, "Begin"));
            period.setEnd(toJAXBGregorianCalendar(periodEnd, "End"));

            //upload dokumenta
            UploadInvoiceBookResponse uploadInvoiceBookResponse = invoiceBookService.uploadInvoiceBook(parameters,
                    correlationId,
                    InvoiceBookFormat.valueOf(format.toUpperCase()),
                    period,
                    0
            );

            String edpId = uploadInvoiceBookResponse.getEdpId().getValue();
            String uploadStatus = uploadInvoiceBookResponse.getStatus().value();    //Uploaded, lahko pa je tudi že validated itd - bomo z edpId preverili status

            return handleUploadResult(uploadStatus, edpId, invoiceBookService);

        } catch (Exception e) {
            logger.error("Error during upload: {}", e.getMessage(), e);
            throw e;
        }
    }

    private boolean isFinalStatus(String uploadStatus) {
        /*
        0 = Uploaded – knjiga je naložena
        1 = Validating – knjiga je v procesu validacije v sistemu eDavki
        2 = ValidatedOk – knjiga je bila uspešno validirana v sistemu eDavki
        3 = ValidationError – knjiga je bila validirana v sistemu eDavki, vendar vsebuje napake
        4 = InProcess – knjiga je v procesu obdelave v zalednih sistemih
        5 = ProcessedOk – knjiga je bila uspešno obdelana v zalednih sistemih
        6 = ProcessedError– knjiga ni bila uspešno obdelana v zalednih sistemih
        */
        return "ValidationError".equalsIgnoreCase(uploadStatus)
                || "ValidatedOk".equalsIgnoreCase(uploadStatus)
                || (uploadStatus != null && uploadStatus.toLowerCase().contains("error"));
    }

     /*
        Naložene knjige računov servis validira na sintaktične in vsebinske napake.
        Knjige, za katere validacija ne najde kritičnih napak, gredo v status ValidatedOk in čakajo na prenos v zaledje.
        Knjige, ki vsebujejo kritične napake, gredo v status ValidationError in se posledično ne prenesejo v zaledje;
        uporabnik mora naložiti novo knjigo z odpravljenimi napakami.
     */
    private PackageUploadResult handleUploadResult(String uploadStatus, String edpId, ISoapService invoiceBookService) {
        logger.info("uploadStatus = {}", uploadStatus);
        logger.info("edpId = {}", edpId);

        if (edpId == null) {
            //moralo je priti do neke napake
            return PackageUploadResult.error("Upload failed: " + uploadStatus + "; edpId is null");
        }

        //sprašuj servis po statusu paketa, dokler ne pridemo v final status (aka obdelava na edavki je končana)
        logger.info("preverjam status paketa, edpId={}", edpId);
        AtomicReference<InvoiceBookStatusResponse> invoiceBookStatus = new AtomicReference<>();
        await().atMost(WAIT_FOR_VALIDATION_SECONDS, SECONDS).pollInterval(WAIT_FOR_VALIDATION_SECONDS, SECONDS).until(() -> {
            InvoiceBookStatusResponse s = invoiceBookService.getInvoiceBookStatus(edpId);
            invoiceBookStatus.set(s);
            logger.info("> preverjam status paketa, edpId={}, status={}", edpId, s != null && s.getStatus() != null ? s.getStatus().value() : "null");
            return s != null && s.getStatus() != null && isFinalStatus(s.getStatus().value());
        });

        //dobili smo final status, ali -> preteklo je 2 minuti
        String validationMessage = null;
        String backendMessage = null;
        logger.info("invoiceBookStatus = {}", invoiceBookStatus.get());
        if (invoiceBookStatus.get() != null) {
            uploadStatus = invoiceBookStatus.get().getStatus().value();
            logger.info("invoiceBookStatus.status = {}", uploadStatus);
            if (invoiceBookStatus.get().getBackendMessage() != null) {
                backendMessage = invoiceBookStatus.get().getBackendMessage().getValue();
                logger.info("invoiceBookStatus.backendmessage = {}", backendMessage);
            }
            if (invoiceBookStatus.get().getValidationMessage() != null) {
                validationMessage = invoiceBookStatus.get().getValidationMessage().getValue();
                logger.info("invoiceBookStatus.validationmessage = {}", validationMessage);
            }
        }

        if ("Uploaded".equalsIgnoreCase(uploadStatus)) {
            return PackageUploadResult.pending(edpId);
        } else if ("ValidatedOk".equalsIgnoreCase(uploadStatus)) {
            return PackageUploadResult.success(edpId);
        } else {
            return PackageUploadResult.error(String.format("Upload failed. Status: %s, backendmessage: %s, valdationmessage: %s", uploadStatus, backendMessage, validationMessage));
        }
    }

    private static JAXBElement<XMLGregorianCalendar> toJAXBGregorianCalendar(String date, String elementName) throws ParseException, DatatypeConfigurationException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Instant instant = sdf.parse(date).toInstant();
        GregorianCalendar calendar = GregorianCalendar.from(instant.atZone(ZoneId.systemDefault()));
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar startXmlGregorianCalendar = datatypeFactory.newXMLGregorianCalendarDate(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                0                      // Timezone (0 means no time zone)
        );

        // Create a JAXBElement<XMLGregorianCalendar> to wrap the value
        QName qName = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", elementName);
        return new JAXBElement<>(qName, XMLGregorianCalendar.class, startXmlGregorianCalendar);
    }

    /**
     * Logs in to the Edavki service using the client certificate.
     *
     * @return The authentication token
     * @throws Exception If login fails
     */
    public String login() throws Exception {
        logger.info("Logging in to Edavki service (URL: {}) with certificate from: {}", LOGIN_SERVICE_URL, configuration.getKeystorePath());

        try {
            // Set up SSL context with the certificate
            SSLContext sslContext = createSSLContext();

            // Set the default SSL socket factory
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            // Create the service
            URL url = new URL(LOGIN_SERVICE_URL);
            logger.debug("Connecting to login service at: {}", LOGIN_SERVICE_URL);

            LoginService service = new LoginService(url);
            ILoginService loginService = service.getBasicHttpBindingILoginService();
            BindingProvider bindingProvider = (BindingProvider) loginService;
            bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url.toString());

            // Call the login method
            logger.debug("Calling loginUsingClientCertificate with tax payer ID: {}, type: {}", configuration.getTaxPayerId(), configuration.getTaxPayerType());
            tokenResponse = loginService.loginUsingClientCertificate(configuration.getTaxPayerId(), configuration.getTaxPayerType());
            logger.debug("Done! Calling loginUsingClientCertificate with tax payer ID: {}, type: {}", configuration.getTaxPayerId(), configuration.getTaxPayerType());

            // Convert XMLGregorianCalendar to ZonedDateTime
            GregorianCalendar gc = tokenResponse.getExpires().toGregorianCalendar();
            tokenExpiration = ZonedDateTime.ofInstant(
                    Instant.ofEpochMilli(gc.getTimeInMillis()),
                    ZoneId.systemDefault()
            );

            logger.info("Successfully logged in. Token expires at: {}", tokenExpiration);
            return tokenResponse.getToken();

        } catch (ILoginServiceLoginUsingClientCertificateBadRequestFaultFaultFaultMessage e) {
            logger.error("Bad request during login: {}", e.getMessage());
            throw e;
        } catch (ILoginServiceLoginUsingClientCertificateServerErrorFaultFaultFaultMessage e) {
            logger.error("Server error during login: {}", e.getMessage());
            throw e;
        } catch (ILoginServiceLoginUsingClientCertificateUnauthorizedFaultFaultFaultMessage e) {
            logger.error("Unauthorized during login: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Error during login: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Gets the current authentication token, logging in if necessary.
     *
     * @return The authentication token
     * @throws Exception If login fails
     */
    public String getToken() throws Exception {
        if (tokenResponse == null || isTokenExpired()) {
            logger.debug("Token is null or expired, logging in again");
            login();
        }
        return tokenResponse.getToken();
    }

    /**
     * Checks if the current token is expired.
     *
     * @return true if the token is expired or about to expire (within 5 minutes), false otherwise
     */
    public boolean isTokenExpired() {
        if (tokenExpiration == null) {
            logger.debug("Token expiration is null, considering token expired");
            return true;
        }

        // Consider the token expired if it expires within the next 5 minutes
        ZonedDateTime now = ZonedDateTime.now();
        boolean expired = now.plusMinutes(5).isAfter(tokenExpiration);

        if (expired) {
            logger.debug("Token is expired or will expire within 5 minutes");
        }

        return expired;
    }

    /**
     * Gets the token expiration date/time.
     *
     * @return The token expiration date/time, or null if no token has been obtained
     */
    public ZonedDateTime getTokenExpiration() {
        return tokenExpiration;
    }

    /**
     * Creates an SSL context with the client certificate.
     */
    private SSLContext createSSLContext()
            throws KeyStoreException, IOException, NoSuchAlgorithmException,
            CertificateException, UnrecoverableKeyException, KeyManagementException {

        logger.debug("Creating SSL context with keystore: {}", configuration.getKeystorePath());

        // Load the keystore
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream(configuration.getKeystorePath())) {
            keyStore.load(fis, configuration.getKeystorePassword().toCharArray());
        }

        // Set up key manager factory
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, configuration.getKeystorePassword().toCharArray());

        // Set up trust manager factory
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        // Create SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");

        if (BETA_MODE) {
            //this disables certificate validation
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            };
            sslContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{trustManager}, new SecureRandom());
        } else {
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        }

        logger.debug("SSL context created successfully");
        return sslContext;
    }
} 