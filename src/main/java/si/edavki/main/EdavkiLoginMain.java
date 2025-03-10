package si.edavki.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.durs.wsdl.loginservice.TaxPayerType;
import si.edavki.config.Configuration;

import java.time.format.DateTimeFormatter;

/**
 * Command-line client for authenticating with the Edavki Login Service using a certificate.
 */
public class EdavkiLoginMain {
    private static final Logger logger = LoggerFactory.getLogger(EdavkiLoginMain.class);

    public static void main(String[] args) {
        if (args.length < 4) {
            logger.info("Usage: EdavkiLoginClient <keystorePath> <keystorePassword> <keyAlias> <taxPayerId> [taxPayerType]");
            logger.info("  taxPayerType: FO, SP, or PO (default: PO)");
            System.exit(1);
        }

        String keystorePath = args[0];
        String keystorePassword = args[1];
        String keyAlias = args[2];
        Integer taxPayerId = Integer.parseInt(args[3]);

        // Default tax payer type is PO (legal entity)
        TaxPayerType taxPayerType = TaxPayerType.PO;
        if (args.length >= 5) {
            try {
                taxPayerType = TaxPayerType.fromValue(args[4]);
            } catch (IllegalArgumentException e) {
                logger.error("Invalid tax payer type: " + args[4]);
                logger.error("Valid values are: FO, SP, PO");
                System.exit(1);
            }
        }

        try {
            // Create the client
            EdavkiClient client = new EdavkiClient(new Configuration(keystorePath, keystorePassword, keyAlias, taxPayerId, taxPayerType));

            // Login and get the token
            String token = client.login();

            // Print the response
            logger.info("Authentication successful!");
            logger.info("Token: " + token);
            logger.info("Expires: " + client.getTokenExpiration().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));


        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 