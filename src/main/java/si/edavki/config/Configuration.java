package si.edavki.config;

import si.durs.wsdl.loginservice.TaxPayerType;

public class Configuration {
    private final String keystorePath;
    private final String keystorePassword;
    private final String keyAlias;
    private final Integer taxPayerId;
    private final TaxPayerType taxPayerType;

    public Configuration(String keystorePath, String keystorePassword, String keyAlias, Integer taxPayerId, TaxPayerType taxPayerType) {
        this.keystorePath = keystorePath;
        this.keystorePassword = keystorePassword;
        this.keyAlias = keyAlias;
        this.taxPayerId = taxPayerId;
        this.taxPayerType = taxPayerType;
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public Integer getTaxPayerId() {
        return taxPayerId;
    }

    public TaxPayerType getTaxPayerType() {
        return taxPayerType;
    }
}
