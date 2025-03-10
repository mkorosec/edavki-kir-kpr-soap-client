
# Zagon

## Preizkus delovanja prijave

```
$(JAVA_HOME)/bin/java -Dsi.edavki.beta=true -cp target/edavki-api-java-1.0-SNAPSHOT-jar-with-dependencies.jar si.edavki.main.EdavkiLoginMain $(KEYSTORE_PATH) $(KEYSTORE_PASSWORD) $(KEYSTORE_ALIAS) $(TAXPAYER_ID) $(TAXPAYER_TYPE)
```

Primer:
```
KEYSTORE_PATH=/home/user/certificates/my-cert.p12
KEYSTORE_PASSWORD=p12password
KEYSTORE_ALIAS=p12alias
TAXPAYER_ID=davcnaStevilka
TAXPAYER_TYPE=FO
```

## Preizkus delovanja pošiljanja računov

```
$(JAVA_HOME)/bin/java -Dsi.edavki.beta=true -cp target/edavki-api-java-1.0-SNAPSHOT-jar-with-dependencies.jar si.edavki.main.UploadMain test-data/1234567/
```

Pričakovana struktura mape test-data/1234567/
- .env
- error
- to_upload
- uploaded

### .env - vsebuje parametre za prijavo s to davčno številko, certifikat
```
KEYSTORE_PATH=/home/user/certificates/my-cert.p12
KEYSTORE_PASSWORD=p12password
KEYSTORE_ALIAS=p12alias
TAXPAYER_ID=davcnaStevilka
TAXPAYER_TYPE=FO
```

### to_upload

Vsebuje pakete datotek, ki jih želimo oddati
- podmapa1 
  - datoteka.zip
  - datoteka.meta
- podmapa2
  - datoteka.zip
  - datoteka.meta

Vsaka podmapa predstavlja en paket, ki ga želimo oddati. 
datoteka.zip je arhiv z datoteko v predpisanem formatu, datoteka.meta pa vsebuje metapodatke o paketu.  

datoteka.meta
```
period.begin=2024-01-01
period.end=2024-01-31
format=CSV
correlationId=lfkadjsfklj
```

# Runtime parametri (-Dparam=value):
- si.edavki.beta: če nastavljeno na true se uporabljajo beta endpointi (default: false)
- si.edavki.async.validation.waitTimeSeconds: čas čakanja na asinhrono validacijo (default: 120)
- si.edavki.async.validation.pollingTimeSeconds: čas med posameznimi preverjanji asinhrone validacije (default: 2)
- si.edavki.loginService.url: override url za login service
- si.edavki.invoiceBookService.url: override url za invoice book service
