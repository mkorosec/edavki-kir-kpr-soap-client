-include .env
JAVA_HOME ?= $(shell echo $$JAVA_HOME)

generate_wsdl:
	wsimport src/main/resources/wsdl/LoginService.wsdl -Xnocompile -p si.durs.wsdl.loginservice -d ./src/main/java -extension -keep -XadditionalHeaders -B-XautoNameResolution
	wsimport src/main/resources/wsdl/SoapService.wsdl -Xnocompile -d ./src/main/java -extension -keep -XadditionalHeaders -B-XautoNameResolution

run-login:
	$(JAVA_HOME)/bin/java -Dsi.edavki.beta=true -cp target/edavki-api-java-1.0-SNAPSHOT-jar-with-dependencies.jar si.edavki.main.EdavkiLoginMain $(KEYSTORE_PATH) $(KEYSTORE_PASSWORD) $(KEYSTORE_ALIAS) $(TAXPAYER_ID) $(TAXPAYER_TYPE)

run-upload:
	$(JAVA_HOME)/bin/java -Dsi.edavki.beta=true -cp target/edavki-api-java-1.0-SNAPSHOT-jar-with-dependencies.jar si.edavki.main.UploadMain test-data/$(TAXPAYER_ID)/