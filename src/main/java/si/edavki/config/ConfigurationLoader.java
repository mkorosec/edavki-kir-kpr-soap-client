package si.edavki.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.durs.wsdl.loginservice.TaxPayerType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigurationLoader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationLoader.class);

    public static Configuration load(String pathToDataDirectory) {
        //#1 Load environment variables from .env file from the root folder
        String envPath = pathToDataDirectory + "/.env";
        Properties envProps = new Properties();
        try (FileInputStream fis = new FileInputStream(envPath)) {
            // Use UTF-8 encoding to load properties
            envProps.load(new InputStreamReader(fis, StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Error loading .env file: {}", e.getMessage());
            System.exit(1);
        }

        // Extract variables from properties
        String keystorePath = envProps.getProperty("KEYSTORE_PATH");
        String keystorePassword = envProps.getProperty("KEYSTORE_PASSWORD");
        String keyAlias = envProps.getProperty("KEYSTORE_ALIAS");
        String taxPayerId = envProps.getProperty("TAXPAYER_ID");
        String taxPayerTypeString = envProps.getProperty("TAXPAYER_TYPE");
        TaxPayerType taxPayerType = TaxPayerType.fromValue(taxPayerTypeString);

        // Validate required properties
        if (keystorePath == null || keystorePassword == null || keyAlias == null ||
                taxPayerId == null || taxPayerType == null) {
            logger.error("Missing required properties in .env file");
            System.exit(1);
        }

        return new Configuration(keystorePath, keystorePassword, keyAlias, Integer.parseInt(taxPayerId), taxPayerType);

    }
}
