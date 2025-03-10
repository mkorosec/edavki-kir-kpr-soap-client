package si.edavki.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tempuri.*;
import si.edavki.PackageUploadResult;
import si.edavki.config.Configuration;
import si.edavki.config.ConfigurationLoader;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.ParseException;
import java.util.Properties;

/**
 * Command-line client for authenticating with the Edavki Login Service using a certificate.
 */
public class UploadMain {
    private static final Logger logger = LoggerFactory.getLogger(UploadMain.class);
    private static final String TO_UPLOAD_DIRECTORY = "/to_upload";
    private static final String UPLOADED_DIRECTORY = "/uploaded";
    private static final String DONE_DIRECTORY = "/done";
    private static final String ERROR_DIRECTORY = "/error";

    public static void main(String[] args) {
        if (args.length < 1) {
            logger.info("Usage: UploadMain <pathToDataDirectory>");
            System.exit(1);
        }

        if (logger.isDebugEnabled()) {
            enableJaxWSDebugOutput();
        }

        String pathToDataDirectory = args[0];
        Configuration configuration = ConfigurationLoader.load(pathToDataDirectory);

        File[] toUploadPackages = checkIsAnythingToUpload(pathToDataDirectory);

        //do the login first
        String token;
        try {
            EdavkiClient client = new EdavkiClient(configuration);
            token = client.login();

            // Print the response
            logger.debug("Authentication successful!");
            logger.debug("Token: {}", token);

            //iterate over all folders in to_upload and upload the payloads one by one
            for (File packageFolder : toUploadPackages) {
                if (!packageFolder.isDirectory()) {
                    logger.info("Skipping {} as it's not a directory", packageFolder.getName());
                    continue;
                }

                //TODO - zapiši result v sqlite bazo
                logger.info("Processing folder: {}", packageFolder.getName());
                PackageUploadResult packageUploadResult = processPackage(packageFolder, client, token);
                if (packageUploadResult.isFinished() && packageUploadResult.isSuccess()) {
                    logger.info("Package {} uploaded successfully", packageFolder.getName());
                    Files.move(packageFolder.toPath(), new File(pathToDataDirectory + DONE_DIRECTORY + "/" + packageFolder.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } else if (packageUploadResult.isFinished() && !packageUploadResult.isSuccess()) {
                    logger.error("Error uploading package {}: {}", packageFolder.getName(), packageUploadResult.getErrorMessage());
                    Files.move(packageFolder.toPath(), new File(pathToDataDirectory + ERROR_DIRECTORY + "/" + packageFolder.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } else {
                    logger.info("Package {} is still pending", packageFolder.getName());
                    Files.move(packageFolder.toPath(), new File(pathToDataDirectory + UPLOADED_DIRECTORY + "/" + packageFolder.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            System.exit(1);
        }
    }

    private static PackageUploadResult processPackage(File packageFolder, EdavkiClient client, String token) throws IOException, DatatypeConfigurationException, UnrecoverableKeyException, ISoapServiceUploadInvoiceBookBadRequestFaultFaultFaultMessage, ISoapServiceUploadInvoiceBookServerErrorFaultFaultFaultMessage, CertificateException, KeyStoreException, NoSuchAlgorithmException, ParseException, ISoapServiceUploadInvoiceBookUnauthorizedFaultFaultFaultMessage, KeyManagementException, ISoapServiceGetInvoiceBookStatusForbiddenFaultFaultFaultMessage, ISoapServiceGetInvoiceBookStatusNotFoundFaultFaultFaultMessage, ISoapServiceGetInvoiceBookStatusUnauthorizedFaultFaultFaultMessage, ISoapServiceGetInvoiceBookStatusBadRequestFaultFaultFaultMessage, ISoapServiceGetInvoiceBookStatusServerErrorFaultFaultFaultMessage {
        File[] zipFiles = packageFolder.listFiles((dir, name) -> name.endsWith(".zip"));
        if (zipFiles == null || zipFiles.length == 0) {
            return PackageUploadResult.error("No ZIP file found in " + packageFolder.getName());
        } else if (zipFiles.length > 1) {
            return PackageUploadResult.error("Multiple ZIP files found in " + packageFolder.getName());
        }

        File payloadFile = zipFiles[0];

        //find the *.meta file in the package folder
        File[] metaFiles = packageFolder.listFiles((dir, name) -> name.endsWith(".meta"));
        if (metaFiles == null || metaFiles.length == 0) {
            return PackageUploadResult.error("No .meta file found in " + packageFolder.getName());
        } else if (metaFiles.length > 1) {
            return PackageUploadResult.error("Multiple .meta files found in " + packageFolder.getName());
        }

        File metaFile = metaFiles[0];

        Properties packageProps = new Properties();
        try (FileInputStream fis = new FileInputStream(metaFile)) {
            // Use UTF-8 encoding to load properties
            packageProps.load(new InputStreamReader(fis, StandardCharsets.UTF_8));
        } catch (IOException e) {
            return PackageUploadResult.error("Error loading .meta file: " + e.getMessage());
        }

        // Extract package variables from properties
        String periodStart = packageProps.getProperty("period.begin");
        String periodEnd = packageProps.getProperty("period.end");
        String format = packageProps.getProperty("format");
        String correlationId = packageProps.getProperty("correlationId");

        // Read the payload file
        byte[] packagePayload = Files.readAllBytes(payloadFile.toPath());

        // Upload the payload
        return client.upload(token, packagePayload, periodStart, periodEnd, format, correlationId);
    }

    private static File[] checkIsAnythingToUpload(String pathToDataDirectory) {
        //#2.0 check if there is anything to upload in to_upload folder
        File toUploadFolder = new File(pathToDataDirectory + TO_UPLOAD_DIRECTORY);
        if (!toUploadFolder.exists()) {
            logger.error("to_upload folder does not exist");
            System.exit(1);
        }
        File[] toUploadPackages = toUploadFolder.listFiles();
        if (toUploadPackages == null || toUploadPackages.length == 0) {
            logger.error("No files to upload in to_upload folder");
            System.exit(1);
        }

        return toUploadPackages;
    }

    private static void enableJaxWSDebugOutput() {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
    }
} 
