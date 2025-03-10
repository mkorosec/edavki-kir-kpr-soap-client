Spletni servis za sprejem KIR KPR

Področje: DDV

Verzija: 0.03

Kazalo

[1\. Uvod 4](#_Toc187322006)

[2\. Funkcionalnosti servisa 4](#_Toc187322007)

[3\. Dostop do servisa 4](#_Toc187322008)

[4\. Format knjige računov 5](#_Toc187322009)

[5\. Definicija vmesnika REST servisa 5](#_Toc187322010)

[5.1. Splošni parametri klicev 5](#_Toc187322011)

[Avtentikacija 5](#_Toc187322012)

[Tip kodiranja vhodnih parametrov 5](#_Toc187322013)

[Tip kodiranja izhodnih parametrov 5](#_Toc187322014)

[5.2. Splošne HTTP kode odgovorov 6](#_Toc187322015)

[5.3. Metode za prijavo – /api/v1/Auth 6](#_Toc187322016)

[Metoda /api/v1/Auth/Representing/{taxPayerId}/{taxPayerType} 7](#_Toc187322017)

[Metoda /api/v1/Auth/Certificate/Representing/{taxPayerId}/{taxPayerType} 8](#_Toc187322018)

[5.4. Metode za delo s knjigami računov - /api/v1/InvoiceBook 8](#_Toc187322019)

[Metoda /api/v1/InvoiceBook 8](#_Toc187322020)

[Metoda /api/v1/InvoiceBook/Status/{edpId} 10](#_Toc187322021)

[5.5. Ostale metode v zvezi s knjigami - /api/v1/Documents 11](#_Toc187322022)

[Metoda /api/v1/Documents/OpenPeriods/{formCode} 11](#_Toc187322023)

[Metoda /api/v1/Documents/Permissions 12](#_Toc187322024)

[5.6. Metode v zvezi z delovanjem servisa - /api/v1/Heartbeat 14](#_Toc187322025)

[Metoda /api/v1/Heartbeat 14](#_Toc187322026)

[6\. Definicija vmesnika SOAP servisa 15](#_Toc187322027)

[6.1. Obravnavanje napak 15](#_Toc187322028)

[6.2. Servis za prijavo 16](#_Toc187322029)

[Metoda LoginUsingClientCertificate 16](#_Toc187322030)

[6.3. servis za vsebinske funkcionalnosti 16](#_Toc187322031)

[Metoda UploadInvoiceBook 16](#_Toc187322032)

[Metoda GetInvoiceBookStatus 18](#_Toc187322033)

[Metoda GetOpenPeriods 18](#_Toc187322034)

[Metoda GetPermissions 18](#_Toc187322035)

[7\. Validacija 19](#_Toc187322036)

[8\. Priloge 20](#_Toc187322037)

# Uvod

Spletni servis, opisan v tem dokumentu, omogoča oddajo podatkov iz KIR (knjiga izdanih računov) in KPR (knjiga prejetih računov) za uporabnike sistema eDavki.

Spletni servis ima REST (podpira podatke, kodirane v JSON) in SOAP vmesnik.

# Funkcionalnosti servisa

Spletni servis ima naslednje funkcionalnosti:

- Prijava, ki je omogočena z:
  - digitalnimi potrdili, podprtimi v eDavkih;
  - avtentikacijskimi žetoni, ki jih izda OAuth spletni servis eDavkov.
- Preverjanje pravic in pooblaščencev za oddajo knjig.
- Oddaja knjig (prenos datoteke v sistem eDavki).
- Preverjanje statusa oddane knjige.
- Preverjanje odprtih obdobij za oddajo knjig.

# Dostop do servisa

Spletni servis je na voljo na naslednjih URL:

- REST servis:
  - Produkcijsko okolje: <https://edavki.durs.si/InvoiceBookService/>
  - Testno okolje: <https://beta.edavki.durs.si/InvoiceBookService/>
- SOAP servis za prijavo:
  - Produkcijsko okolje: <https://edavki.durs.si/InvoiceBookService/SoapService/Login/>
  - Testno okolje: <https://beta.edavki.durs.si/InvoiceBookService/SoapService/Login/>
- SOAP servis za vsebinske funkcionalnosti:
  - Produkcijsko okolje: <https://edavki.durs.si/InvoiceBookService/SoapService/>
  - Testno okolje: <https://beta.edavki.durs.si/InvoiceBookService/SoapService/>

Vmesnik REST spletnega servisa si je mogoče ogledati in preizkusiti s pomočjo Swagger spletnega vmesnika na naslednjih naslovih:

- Produkcijsko okolje: <https://edavki.durs.si/InvoiceBookService/swagger/index.html>
- Testno okolje: <https://beta.edavki.durs.si/InvoiceBookService/swagger/index.html>

WSDL SOAP servisa je na voljo na naslednjih naslovih:

- SOAP servis za prijavo:
  - Produkcijsko okolje: <https://edavki.durs.si/InvoiceBookService/SoapService/Login/?singleWsdl>
  - Testno okolje: <https://beta.edavki.durs.si/InvoiceBookService/SoapService/Login/?singleWsdl>
- SOAP servis za vsebinske funkcionalnosti:
  - Produkcijsko okolje: <https://edavki.durs.si/InvoiceBookService/SoapService/?singleWsdl>
  - Testno okolje: <https://beta.edavki.durs.si/InvoiceBookService/SoapService/?singleWsdl>

# Format knjige računov

Servis sprejema knjige, formatirane v enem izmed naslednjih treh formatov: XML, JSON, CSV. Specifikacije formatov so priložene v poglavju »Priloge«.

# Definicija vmesnika REST servisa

V tem poglavju so opisane posamezne metode REST servisa, združene po sklopih funkcionalnosti.

## Splošni parametri klicev

Pri vseh klicih servisa se uporablja nekaj splošnih parametrov, ki se pošiljajo v glavi zahtevka.

### Avtentikacija

Za dostop do vseh funkcionalnosti servisa (razen za prijavo samo) se mora uporabnik avtenticirati. To stori tako, da v klicu metode pošlje avtentikacijski žeton, ki ga pridobi pri prijavi (glej podpoglavje 5.3). Žeton je potrebno poslati v glavi zahtevka v polju Authorization. Vrednost v polju mora imeti naslednjo obliko:

Bearer {žeton}

Primer celotnega polja:

Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI1NDYxMTMxMCIsImp0aSI6IjA0ZDgwYTYxLTk1MTEtNDEzNy04ODI1LTEwNTc4MzllZTkxYSIsImlhdCI6MTcyMjUwNTExMSwiTG9naW5JZCI6IjI3OSIsIkxvZ2luVHlwZSI6IkNlcnRpZmljYXRlIiwiVXNlclByb2ZpbGVJZCI6IjQzMCIsIkluZGl2aWR1YWxQZXJzb25JZCI6IjU0NjExMzEwIiwiVGF4UGF5ZXJJZCI6IjU0NjExMzEwIiwiVGF4UGF5ZXJUeXBlIjoiRk8iLCJSZXByZXNlbnRpbmdJZCI6IjU0NjExMzEwIiwiUmVwcmVzZW50aW5nVHlwZSI6IkZPIiwiZXhwIjoxNzIyNTkxNTExLCJpc3MiOiJodHRwczovL2R1cnN3ZWIuZW5kYXZhLm5ldDo0NjIvIiwiYXVkIjoiaHR0cHM6Ly9kdXJzd2ViLmVuZGF2YS5uZXQ6NDYyLyJ9.pl4AmJkVRTZkmYKuKCz13xkvS5V2cuIhRr0qvAnb5bM

### Tip kodiranja vhodnih parametrov

Tip kodiranja vhodnih parametrov je definiran v glavi zahtevka v polju Content-Type. Podprti tipi so »application/json« za JSON (izjema je metoda /api/v1/InvoiceBook – glej spodaj).

Primer celotnega polja:

Content-Type: application/json

### Tip kodiranja izhodnih parametrov

Tip kodiranja izhodnih parametrov je definiran v glavi zahtevka v polju accept. Podprti tipi so »application/json« za JSON.

Primer celotnega polja:

accept: application/json

## Splošne HTTP kode odgovorov

V primeru uspešnega klica servisa le-ta v splošnem odgovori s HTTP kodo 200 OK in za metodo specifičnim odgovorom v obliki JSON.

V primeru, ko pri klicu servisa pride do napake, servis odgovori s primerno HTTP kodo. V večini primerov vrne tudi JSON odgovor s podrobnejšimi podatki o vzroku napake tipa _ErrorResponse_:

ErrorResponse{

| errorReason | ErrorReason integer($int32)<br><br>Tip napake:<br><br>0 = BadRequest<br><br>1 = Unauthorized<br><br>2 = Forbidden<br><br>3 = NotFound<br><br>4 = ServerError<br><br>Enum:  <br>\[ 0, 1, 2, 3, 4 \] |
| --- | --- |
| errorMessage | string  <br>nullable: true<br><br>Opis napake. |
| incidentId | string  <br>nullable: true<br><br>Opcijski ID incidenta. |

}

Pri vseh klicih servisa so v primeru napak možne naslednje HTTP kode odgovora:

- 400 Bad Request: napačni vhodni podatki
- 401 Unauthorized: uporabnik se ni avtenticiral z veljavnim prijavnim mehanizmom. V večini primerov je telo odgovora prazno, izjemoma lahko vsebuje JSON odgovor.
- 500 InternalServerError: interna napaka na servisu. Pri tej napaki je izpolnjeno opcijsko polje incidentId, ki je namenjeno lažjemu sledenju napaki.

Servis lahko v primeru napak vrne tudi druge HTTP kode, ki so specifične za posamezne metode servisa.

## Metode za prijavo – /api/v1/Auth

S klicem ene izmed metod za prijavo se uporabnik hkrati avtenticira in izbere zastopanega davčnega zavezanca. Servis podpira dva načina avtentikacije:

- Z digitalnimi potrdili, podprtimi v eDavkih. To je priporočen način avtentikacije.
- Z avtentikacijskimi žetoni, ki jih izda OAuth spletni servis eDavkov. Ta način naj bi se uporabljal izjemoma, ko iz tehničnih razlogov ni možna avtentikacija z digitalnimi potrdili.

### Metoda /api/v1/Auth/Representing/{taxPayerId}/{taxPayerType}

- Opis: metoda omogoča izbiro zastopanega davčnega zavezanca, uporabnik se avtenticira z avtentikacijskim žetonom. Obstajata dve možnosti:
  - Uporabnik uporabi žeton, ki ga je izdala eDavki OAuth storitev. Ta izda žeton, v katerem zastopani davčni zavezanec še ni izbran.
  - Uporabnik uporabi predhodno izdan žeton, ki ga je pridobil s klicem te metode ali metode /api/v1/Auth/Certificate/Representing/{taxPayerId}/{taxPayerType} (glej spodaj). Na ta način lahko uporabnik zamenja zastopanega davčnega zavezanca.
- HTTP metoda: GET
- Vhodni parametri:
  - taxPayerId (integer($int32)): davčna številka zastopanega zavezanca
  - taxPayerType (integer($int32): tip zastopanega davčnega zavezanca:
    - _0 = FO_
    - _1 = SP_
    - _2 = PO_
- Specifične HTTP kode odgovora:
  - 403 Forbidden: dostop ni dovoljen (npr. uporabnik nima pravic za izbranega zastopanega zavezanca)
- Izhodni parametri:
  - Status odgovora 200 OK:

TokenResponse{

| expires | string($date-time)<br><br>Datum in čas poteka žetona. |
| --- | --- |
| token | string  <br>nullable: true<br><br>Avtentikacijski žeton. |

}

- Primeri:
  - Vhodni parametri:
  - taxPayerId: 54611310

taxPayerType: 0

- - Odgovor za HTTP status 200 OK:

{

"expires": "2024-01-01T01:12:01",

"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI1NDYxMTMxMCIsImp0aSI6IjA0ZDgwYTYxLTk1MTEtNDEzNy04ODI1LTEwNTc4MzllZTkxYSIsImlhdCI6MTcyMjUwNTExMSwiTG9naW5JZCI6IjI3OSIsIkxvZ2luVHlwZSI6IkNlcnRpZmljYXRlIiwiVXNlclByb2ZpbGVJZCI6IjQzMCIsIkluZGl2aWR1YWxQZXJzb25JZCI6IjU0NjExMzEwIiwiVGF4UGF5ZXJJZCI6IjU0NjExMzEwIiwiVGF4UGF5ZXJUeXBlIjoiRk8iLCJSZXByZXNlbnRpbmdJZCI6IjU0NjExMzEwIiwiUmVwcmVzZW50aW5nVHlwZSI6IkZPIiwiZXhwIjoxNzIyNTkxNTExLCJpc3MiOiJodHRwczovL2R1cnN3ZWIuZW5kYXZhLm5ldDo0NjIvIiwiYXVkIjoiaHR0cHM6Ly9kdXJzd2ViLmVuZGF2YS5uZXQ6NDYyLyJ9.pl4AmJkVRTZkmYKuKCz13xkvS5V2cuIhRr0qvAnb5bM"

}

### Metoda /api/v1/Auth/Certificate/Representing/{taxPayerId}/{taxPayerType}

- Opis: metoda omogoča izbiro zastopanega davčnega zavezanca, uporabnik se avtenticira z digitalnim potrdilom, ki ga uporabi pri vzpostavitvi TLS povezave.
- V vseh ostalih pogledih se metoda obnaša enako kot metoda /api/v1/Auth/Representing/{taxPayerId}/{taxPayerType} (glej zgoraj).

## Metode za delo s knjigami računov - /api/v1/InvoiceBook

### Metoda /api/v1/InvoiceBook

- Opis: metoda omogoča prenos nove knjige računov za zastopanega davčnega zavezanca. Telo klica servisa mora biti formatirano v obliki »multipart/form-data«. Vsebovati mora natanko dve sekciji:
  - Prva sekcija mora vsebovati metapodatke o knjigi računov v JSON obliki. Tip podatkov mora biti eden izmed "application/json", "application/\*+json", "text/json".
  - Druga sekcija mora vsebovati knjigo računov v binarni obliki. Tip podatkov mora biti "application/octet-stream" ali "application/x-zip-compressed".
- HTTP metoda: POST
- Vhodni parametri (metapodatki o knjigi v JSON obliki v prvi sekciji):

UploadInvoiceBookRequest{

period

Period{

|     | Obdobje knjige |
| --- | --- |
| begin | string($date-time)  <br>nullable: true<br><br>Začetek obdobja |
| end | string($date-time)  <br>nullable: true<br><br>Konec obdobja |

}

format

InvoiceBookFormat integer($int32)

Format knjige.

0 = XML

1 = JSON

2 = CSV

Enum:  
\[ 0, 1, 2 \]

schemaVersion

integer($int32)

Verzija sheme knjige računov.

correlationId

string  
nullable: true

Klientski korelacijski ID. Namenjen lažjemu sledenju procesa obdelave knjig.

}

- Specifične HTTP kode odgovora:
- Izhodni parametri:
  - Status odgovora 200 OK:

UploadInvoiceBookResponse{

| edpId | string  <br>nullable: true<br><br>Oznaka knjige v sistemu eDavki. |
| --- | --- |
| status | InvoiceBookStatus integer($int32)<br><br>Status knjige (glej spodaj).<br><br>Enum:  <br>\[ 0, 1, 2, 3, 4, 5, 6 \] |

}

- Primeri:
  - Vhodni parametri (prva sekcija):

{

"period": {

"begin": "2024-01-01",

"end": "2024-01-31"

},

"format": 0,

"schemaVersion": 1,

"correlationId": "098sdkljf8907asd8f"

}

- - Odgovor za HTTP status 200 OK:

{

"edpId": "KIR-12345678-123",

"status": 0

}

### Metoda /api/v1/InvoiceBook/Status/{edpId}

- Opis: metoda vrača podatke o statusu predhodno naložene knjige računov.
- HTTP metoda: GET
- Vhodni parametri:
  - _edpId_: oznaka knjige v sistemu eDavki
- Specifične HTTP kode odgovora:
  - 403 Forbidden: knjiga računov s podano oznako ne pripada zastopanemu davčnemu zavezancu.
  - 404 Not Found: knjiga računov s podano oznako ne obstaja v sistemu eDavki
- Izhodni parametri:
  - Status odgovora 200 OK:

InvoiceBookStatusResponse{

| status | InvoiceBookStatus integer($int32)<br><br>Oznake statusa knjige:<br><br>0 = Uploaded – knjiga je naložena<br><br>1 = Validating – knjiga je v procesu validacije v sistemu eDavki<br><br>2 = ValidatedOk – knjiga je bila uspešno validirana v sistemu eDavki<br><br>3 = ValidationError – knjiga je bila validirana v sistemu eDavki, vendar vsebuje napake<br><br>4 = InProcess – knjiga je v procesu obdelave v zalednih sistemih<br><br>5 = ProcessedOk – knjiga je bila uspešno obdelana v zalednih sistemih<br><br>6 = ProcessedError– knjiga ni bila uspešno obdelana v zalednih sistemih<br><br>Enum:  <br>\[ 0, 1, 2, 3, 4, 5, 6 \] |
| --- | --- |
| validationMessage | string  <br>nullable: true<br><br>Opcijsko poročilo o najdenih napakah pri validaciji v sistemu eDavki. Poročilo je v JSON formatu (glej poglavje 7). |
| backendMessage | string  <br>nullable: true<br><br>Opcijsko sporočilo o obdelavi v zalednih sistemih. |

}

- Primeri:
  - Odgovor JSON za HTTP status 200 OK:

{

"status": 3,

"validationMessage": "\[{\\"Type\\":2,\\"Code\\":5,\\"Message\\":\\"Oznaka države 'AB' ne obstaja v seznamu držav.\\",\\"BookId\\":null,\\"BookArrayIndex\\":null},{\\"Type\\":2,\\"Code\\":7,\\"Message\\":\\"Knjig ne morete oddati, ker v izbranem obdobju '1.6.2023 - 30.6.2023' niste zastopnik tujca v 'string'.\\",\\"BookId\\":null,\\"BookArrayIndex\\":null}\]",

"backendMessage": null

}

## Ostale metode v zvezi s knjigami - /api/v1/Documents

### Metoda /api/v1/Documents/OpenPeriods/{formCode}

- Opis: metoda vrača seznam odprtih obdobij za zastopanega davčnega zavezanca in specificirano kodo obrazca.
- HTTP metoda: GET
- Vhodni parametri:
  - _formCode_: oznaka tipa obrazca. Trenutno sta podprta tipa »DDV_EVID« (za knjige računov) in informativno tudi »DDV_O« (za obrazce DDV-O).
- Specifične HTTP kode odgovora: /
- Izhodni parametri:
  - Status odgovora 200 OK:

OpenPeriodsResponse{

openPeriods

\[  
nullable: true

Lista odprtih obdobij.

OpenPeriod{

Odprto obdobje

period

Period{

|     | Obdobje |
| --- | --- |
| begin | string($date-time)  <br>nullable: true<br><br>Začetek obdobja |
| end | string($date-time)  <br>nullable: true<br><br>Konec obdobja |

}

representedForeignerId

string  
nullable: true

Opcijska identifikacijska oznaka zastopanega tujca.

dueDate

string($date-time)  
nullable: true

Rok za oddajo

}\]

}

- Primeri:
  - Odgovor za HTTP status 200 OK:

{

"openPeriods": \[

{

"period": {

"begin": "2024-01-01T00:00:00",

"end": "2024-01-31T00:00:00"

},

"representedForeignerId": null,

"dueDate": "2024-01-31T00:00:00"

},

{

"period": {

"begin": "2024-02-01",

"end": "2024-02-29"

},

"representedForeignerId": "XY1234567890",

"dueDate": null

}

\]

}

### Metoda /api/v1/Documents/Permissions

- Opis: metoda vrača seznam pravic, ki jih ima uporabnik v sistemu eDavki.
- HTTP metoda: GET
- Vhodni parametri:
  - _formCode_: opcijska oznaka tipa obrazca. Trenutno je podprt samo tip »DDV_O«.
- Specifične HTTP kode odgovora: /
- Izhodni parametri:
  - Status odgovora 200 OK:

DocumentPermissionsResponse{

permissions

\[  
nullable: true

Lista pravic.

DocumentPermission{

Specifikacija pravic za tip obrazca.

mandator

TaxPayer{

|     | Podatki o pooblastitelju. |
| --- | --- |
| id  | integer($int32)<br><br>Davčna številka |
| type | TaxPayerType integer($int32)<br><br>Tip davčnega zavezanca.<br><br>0 = FO<br><br>1 = SP<br><br>2 = PO<br><br>Enum:  <br>\[ 0, 1, 2 \] |

}

formCode

string  
nullable: true

Oznaka tipa obrazca.

fill

boolean

Pravica za vnos obrazca.

sign

boolean

Pravica za vložitev obrazca.

viewSent

boolean

Pravica za pregled vloženega obrazca.

}\]

}

- Primeri:
  - Odgovor za HTTP status 200 OK:

{

"permissions": \[

{

"mandator": {

"id": 12345678,

"type": 0

},

"formCode": "DDV_O",

"fill": true,

"sign": false,

"viewSent": true

},

{

"mandator": {

"id": 23456789,

"type": 2

},

"formCode": "DDV_O",

"fill": true,

"sign": true,

"viewSent": true

}

\]

}

## Metode v zvezi z delovanjem servisa - /api/v1/Heartbeat

### Metoda /api/v1/Heartbeat

- Opis: metoda je namenjena preverjanju delovanja servisa.
- HTTP metoda: GET
- Vhodni parametri: _-_
- Specifične HTTP kode odgovora: /
- Izhodni parametri:
  - Status odgovora 200 OK:

_HeartbeatResponse{_

|     | _Odgovor na poizvedbo za delovanje servisa_ |
| --- | --- |
| _hostingEnvironment_ | _string  <br>nullable: true_<br><br>_Oznaka izvajalnega okolja._ |
| _apiVersion_ | _string  <br>nullable: true_<br><br>_Verzija vmesnika servisa._ |
| _productVersion_ | _string  <br>nullable: true_<br><br>_Verzija servisa._ |
| _serverTime_ | _string($date-time)_<br><br>_Trenutni čas na servisu._ |

_}_

# Definicija vmesnika SOAP servisa

Iz tehničnih razlogov je SOAP servis razdeljen na dva ločena servisa, servis za prijavo in servis za vsebinske funkcionalnosti.

Funkcionalno SOAP servis podvaja funkcionalnosti REST servisa, zato se pri tehničnih podrobnostih metod (vhodni in izhodni parametri, …) večinoma sklicujemo na ustrezne metode REST servisa.<sup>[\[1\]](#footnote-1)</sup>

## Obravnavanje napak

V primeru, ko klic SOAP servisa ne uspe, ta vrne objekt tipa Fault. Podrobnosti o napaki se nahajajo v elementu _detail_, vsebinsko ustrezajo HTTP kodam oz. odgovorom, ki jih v primeru napak vrača REST servis.

Primer:

&lt;s:Envelope xmlns:s="<http://schemas.xmlsoap.org/soap/envelope/>"&gt;

&lt;s:Body&gt;

&lt;s:Fault&gt;

&lt;faultcode&gt;s:Client&lt;/faultcode&gt;

&lt;faultstring xml:lang="en-US"&gt;Unauthorized&lt;/faultstring&gt;

&lt;detail&gt;

&lt;UnauthorizedFault xmlns="<http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap>" xmlns:i="<http://www.w3.org/2001/XMLSchema-instance>"&gt;

&lt;Message&gt;Niste prijavljeni oziroma ni izbrana zastopana oseba.&lt;/Message&gt;

&lt;/UnauthorizedFault&gt;

&lt;/detail&gt;

&lt;/s:Fault&gt;

&lt;/s:Body&gt;

&lt;/s:Envelope&gt;

## Servis za prijavo

### Metoda LoginUsingClientCertificate

- Opis: Metoda omogoča izbiro zastopanega davčnega zavezanca, uporabnik se avtenticira z digitalnim potrdilom, ki ga uporabi pri vzpostavitvi TLS povezave. Rezultat uspešnega klica metode vsebuje avtentikacijski žeton, s katerim se uporabnik avtenticira pri klicu metod servisa za vsebinske funkcionalnosti.
- Vhodni parametri:
  - taxPayerId (int): davčna številka zastopanega zavezanca
  - taxPayerType (TaxPayerType): tip zastopanega davčnega zavezanca
- Izhodni parametri pri uspešnem klicu: objekt tipa TokenResponse
- Tehnične podrobnosti: glej »Metoda /api/v1/Auth/Certificate/Representing/{taxPayerId}/{taxPayerType}«

## servis za vsebinske funkcionalnosti

### Metoda UploadInvoiceBook

- Opis: Metoda omogoča prenos nove knjige računov za zastopanega davčnega zavezanca. Metoda podpira MTOM (Message Transmission Optimization Mechanism) z XOP (XML-binary Optimized Packaging) in tako omogoča prenos knjig računov v binarni obliki (brez kodiranja v base64). Uporabo MTOM pri klicu metode močno priporočamo, še posebej pri velikih knjigah.
- Vhodni parametri: iz tehničnih razlogov se struktura zahtevka razlikuje glede na ekvivalentno metodo REST servisa: del vhodnih parametrov se nahaja v glavi zahtevka (element soapenv:Header), del pa v telesu zahtevka (element soapenv:Body).
  - Parametri v glavi SOAP zahtevka: podatki o naloženi knjigi računov, ustrezajo parametrom schemaVersion, period, format in correlationId v tipu UploadInvoiceBookRequest.
  - Parametri v telesu SOAP zahtevka (element soapenv:Body): data (byte\[\]): knjiga računov v binarni obliki (referenca na binarni del sporočila, če je uporabljen MTOM oz. base64 kodirana vsebina knjige, če ni uporabljen MTOM)
- Izhodni parametri pri uspešnem klicu: objekt tipa UploadInvoiceBookResponse
- Tehnične podrobnosti: glej »Metoda /api/v1/InvoiceBook«
- Primer klica z uporabo MTOM:

_POST <http://localhost:5288/SoapService/> HTTP/1.1_

_Accept-Encoding: gzip,deflate_

_Content-Type: multipart/related; type="application/xop+xml"; start="&lt;<rootpart@soapui.org>&gt;"; start-info="text/xml"; boundary="----=\_Part_41_364276937.1727935652947"_

_SOAPAction: "<http://tempuri.org/ISoapService/UploadInvoiceBook>"_

_MIME-Version: 1.0_

_Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI1NDYxMTMxMCIsImp0aSI6IjcwZmU0YzQ0LWRkZGQtNDk4MS05MzcwLTE2MGMwNzg0ZjNhNyIsImlhdCI6MTcyNzg3NTE0MCwiTG9naW5JZCI6IjM0MCIsIkxvZ2luVHlwZSI6IkNlcnRpZmljYXRlIiwiVXNlclByb2ZpbGVJZCI6Ijk3IiwiSW5kaXZpZHVhbFBlcnNvbklkIjoiNTQ2MTEzMTAiLCJUYXhQYXllcklkIjoiNTQ2MTEzMTAiLCJUYXhQYXllclR5cGUiOiJGTyIsIlJlcHJlc2VudGluZ0lkIjoiNTQ2MTEzMTAiLCJSZXByZXNlbnRpbmdUeXBlIjoiRk8iLCJleHAiOjE3Mjc5NjE1NDAsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NjM5MzkvIiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo2MzkzOS8ifQ.bvhMdskZDRgPKFhEaanIRrTb-J50XZ99tuO9toCNpgY_

_Content-Length: 1538_

_Host: localhost:5288_

_Connection: Keep-Alive_

_User-Agent: Apache-HttpClient/4.5.5 (Java/12.0.1)_

_\------=\_Part_41_364276937.1727935652947_

_Content-Type: application/xop+xml; charset=UTF-8; type="text/xml"_

_Content-Transfer-Encoding: 8bit_

_Content-ID: &lt;<rootpart@soapui.org>&gt;_

_&lt;soapenv:Envelope xmlns:soapenv="<http://schemas.xmlsoap.org/soap/envelope/>" xmlns:tem="<http://tempuri.org/>" xmlns:end="<http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models>"&gt;_

_&lt;soapenv:Header&gt;_

_&lt;tem:SchemaVersion&gt;0&lt;/tem:SchemaVersion&gt;_

_&lt;tem:Period&gt;_

_&lt;!--Optional:--&gt;_

_&lt;end:Begin&gt;2024-01-01&lt;/end:Begin&gt;_

_&lt;!--Optional:--&gt;_

_&lt;end:End&gt;2024-01-31&lt;/end:End&gt;_

_&lt;/tem:Period&gt;_

_&lt;tem:Format&gt;0&lt;/tem:Format&gt;_

_&lt;tem:CorrelationId&gt;lfkadjsfklj&lt;/tem:CorrelationId&gt;_

_&lt;/soapenv:Header&gt;_

_&lt;soapenv:Body&gt;_

_&lt;tem:UploadInvoiceBookRequest&gt;_

_&lt;tem:data&gt;&lt;inc:Include href="cid:1405716680238" xmlns:inc="<http://www.w3.org/2004/08/xop/include"/&gt;&lt;/tem:data>&gt;_

_&lt;/tem:UploadInvoiceBookRequest&gt;_

_&lt;/soapenv:Body&gt;_

_&lt;/soapenv:Envelope&gt;_

_\------=\_Part_41_364276937.1727935652947_

_Content-Type: application/zip; name=test_KIR_CSV.zip_

_Content-Transfer-Encoding: binary_

_Content-ID: &lt;1405716680238&gt;_

_Content-Disposition: attachment; name="test_KIR_CSV.zip"; filename="test_KIR_CSV.zip"_

_….(binarna vsebina izpuščena)…_

_\------=\_Part_41_364276937.1727935652947--_

### Metoda GetInvoiceBookStatus

- Opis: Metoda vrača podatke o statusu predhodno naložene knjige računov.
- Vhodni parametri:
  - edpId (string): oznaka knjige v sistemu eDavki
- Izhodni parametri pri uspešnem klicu: objekt tipa InvoiceBookStatusResponse
- Tehnične podrobnosti: glej »Metoda /api/v1/InvoiceBook/Status/{edpId}«

### Metoda GetOpenPeriods

- Opis: Metoda vrača seznam odprtih obdobij za zastopanega davčnega zavezanca in specificirano kodo obrazca.
- Vhodni parametri:
  - formCode (string): oznaka tipa obrazca. Trenutno je podprt samo tip »DDV_O«
- Izhodni parametri pri uspešnem klicu: objekt tipa OpenPeriodsResponse
- Tehnične podrobnosti: glej »Metoda /api/v1/Documents/OpenPeriods/{formCode}«

### Metoda GetPermissions

- Opis: metoda vrača seznam pravic, ki jih ima uporabnik v sistemu eDavki.
- Vhodni parametri:
  - formCode (string): opcijska oznaka tipa obrazca. Trenutno je podprt samo tip »DDV_O«
- Izhodni parametri pri uspešnem klicu: objekt tipa DocumentPermissionsResponse
- Tehnične podrobnosti: glej »Metoda /api/v1/Documents/Permissions«

# Validacija

Naložene knjige računov servis validira na sintaktične in vsebinske napake. Knjige, za katere validacija ne najde kritičnih napak, gredo v status _ValidatedOk_ in čakajo na prenos v zaledje. Knjige, ki vsebujejo kritične napake, gredo v status _ValidationError_ in se posledično ne prenesejo v zaledje; uporabnik mora naložiti novo knjigo z odpravljenimi napakami.

Po opravljeni validaciji naložene knjige lahko uporabnik pridobi rezultat validacije s klicem metode /api/v1/InvoiceBook/Status/{edpId}) na REST vmesniku (glej Metoda /api/v1/InvoiceBook/Status/{edpId}) oz. metode GetInvoiceBookStatus na SOAP vmesniku (glej Metoda GetInvoiceBookStatus).

Sintaksa seznama napak v formatu JSON:

\[ValidationError{

| type | ValidationErrorType string<br><br>Info<br><br>Warning<br><br>Error<br><br>Enum:  <br>Array \[ 3 \]<br><br>**_Tip napake. Napake tipa Error se štejejo kot kritične._** |
| --- | --- |
| code | ValidationErrorMessaage string<br><br>Enum:  <br>Array \[ 48 \]<br><br>**_Koda napake v sistemu eDavki._** |
| message | string  <br>nullable: true<br><br>**_Opis napake._** |
| bookId | integer($int32)  <br>nullable: true<br><br>**_Zaporedna številka vnosa v listi računov, ki vsebuje napako. Ni definirano za napake v glavi._** |
| bookArrayIndex | integer($int32)  <br>nullable: true<br><br>**_Zaporedna številka polja v vnosu, ki vsebuje napako, če jo je moč določiti._** |

}\]

#

# Priloge

XML shema knjig računov:

![](data:image/x-emf;base64,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CY3A/hJJW5IAAAAAAAAAAAAAAAAAAAAAf39/9f7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3/i4uL/4mJif+JiYn/iYmJ/4eHh/+CgoL8LVpquSWCpP5Aeo3+U3J7/gkMDB0AAAAAAAAAAAAAAAB/f3/1/////+Xg1P/l4NT/5eDU/+Xg1P/l4NT/5eDU/+Xg1P/l4NT/5eDU/+Xg1P/l4NT/5eDU/+nl1//p5df/6eXX/+nl1/+JiYn/q6ur//39/f/t7Oz/j46O8hYWFSUAAAAAUGNpv4SEgf1/dnD+QTs2jAAAAAAAAAAAAAAAAH9/f/X///////////39/P///////////////////////////////////////////////////////////////////////Pv6/4iIiP/9/f3/qaen/4aFhecLCwsVAAAAAAAAAAA0MC5Pq6CZ/o2IhP1yZGT8BgUJFwAAAAAAAAAAf39/9f////+zs7P//////7Ozs///////s7Oz//////+zs7P//////7a2tv//////tra2//////+4uLj//////7a2tv//////iIeH/5+env9sa2u2AwMDBQAAAAAAAAAAAAAAAAAAAABzamnFdmt0/kxCdf4bFTuHAAAAAAAAAAB/f3/1/v7+/u3s7P/Ozs7/7ezs/87Ozv/t7Oz/zs7O/+3s7P/Ozs7/7ezs/87Ozv/t7Oz/zs7N/+3s7P/Ozc3/7ezs/8jIyP6EhIT+VFRUmQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB4cL1U5NJv+LSuR/xAPc/cAAAAAAAAAAH19ffGCgoL6b29vuYSEhPxvb2+5goKC+W9vb7mCgoL5b29vuYSEhPtvb2+5goKC+W9vb7mEhIT7b29vuYKCgvl1dXW6goKC9SQkJD8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACsqh8obFTuHAAAAAAAAAAAYAAAADAAAAAAAAAISAAAADAAAAAEAAABSAAAAcAEAAAEAAAAUAAAAAAAAAAAAAAAAAAAAvAIAAAAAAAABAgIiUwB5AHMAdABlAG0AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABkdgAIAAAAACUAAAAMAAAAAQAAACUAAAAMAAAADQAAgCgAAAAMAAAAAQAAAFIAAABwAQAAAQAAAPX///8AAAAAAAAAAAAAAACQAQAAAAAAAABAACJTAGUAZwBvAGUAIABVAEkAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGR2AAgAAAAAJQAAAAwAAAABAAAAVAAAALQAAAABAAAAIgAAAGMAAAAuAAAAAQAAAFXV10EAANhBAQAAACIAAAARAAAATAAAAAQAAAAAAAAAAAAAAGYAAABCAAAAcAAAAEQARABWAF8ASwBJAFIAXwBLAFAAUgBfADEALgB4AHMAZAB4bQgAAAAIAAAABwAAAAUAAAAGAAAAAwAAAAcAAAAFAAAABgAAAAYAAAAHAAAABQAAAAYAAAADAAAABQAAAAUAAAAHAAAAJQAAAAwAAAANAACARgAAACAAAAASAAAASQBjAG8AbgBPAG4AbAB5AAAAAABGAAAAMAAAACQAAABEAEQAVgBfAEsASQBSAF8ASwBQAFIAXwAxAC4AeABzAGQAAABGAAAAEAAAAAIAAAAAAAAARgAAABAAAAAEAAAANwAAAEYAAAAgAAAAEgAAAEkAYwBvAG4ATwBuAGwAeQAAAAAADgAAABQAAAAAAAAAEAAAABQAAAA=)

JSON shema knjig računov:

![](data:image/x-emf;base64,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CY3A/hJJW5IAAAAAAAAAAAAAAAAAAAAAf39/9f7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3/i4uL/4mJif+JiYn/iYmJ/4eHh/+CgoL8LVpquSWCpP5Aeo3+U3J7/gkMDB0AAAAAAAAAAAAAAAB/f3/1/////+Xg1P/l4NT/5eDU/+Xg1P/l4NT/5eDU/+Xg1P/l4NT/5eDU/+Xg1P/l4NT/5eDU/+nl1//p5df/6eXX/+nl1/+JiYn/q6ur//39/f/t7Oz/j46O8hYWFSUAAAAAUGNpv4SEgf1/dnD+QTs2jAAAAAAAAAAAAAAAAH9/f/X///////////39/P///////////////////////////////////////////////////////////////////////Pv6/4iIiP/9/f3/qaen/4aFhecLCwsVAAAAAAAAAAA0MC5Pq6CZ/o2IhP1yZGT8BgUJFwAAAAAAAAAAf39/9f////+zs7P//////7Ozs///////s7Oz//////+zs7P//////7a2tv//////tra2//////+4uLj//////7a2tv//////iIeH/5+env9sa2u2AwMDBQAAAAAAAAAAAAAAAAAAAABzamnFdmt0/kxCdf4bFTuHAAAAAAAAAAB/f3/1/v7+/u3s7P/Ozs7/7ezs/87Ozv/t7Oz/zs7O/+3s7P/Ozs7/7ezs/87Ozv/t7Oz/zs7N/+3s7P/Ozc3/7ezs/8jIyP6EhIT+VFRUmQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB4cL1U5NJv+LSuR/xAPc/cAAAAAAAAAAH19ffGCgoL6b29vuYSEhPxvb2+5goKC+W9vb7mCgoL5b29vuYSEhPtvb2+5goKC+W9vb7mEhIT7b29vuYKCgvl1dXW6goKC9SQkJD8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACsqh8obFTuHAAAAAAAAAAAYAAAADAAAAAAAAAISAAAADAAAAAEAAABSAAAAcAEAAAEAAAAUAAAAAAAAAAAAAAAAAAAAvAIAAAAAAAABAgIiUwB5AHMAdABlAG0AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABkdgAIAAAAACUAAAAMAAAAAQAAACUAAAAMAAAADQAAgCgAAAAMAAAAAQAAAFIAAABwAQAAAQAAAPX///8AAAAAAAAAAAAAAACQAQAAAAAAAABAACJTAGUAZwBvAGUAIABVAEkAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGR2AAgAAAAAJQAAAAwAAAABAAAAVAAAALQAAAACAAAAIgAAAGIAAAAuAAAAAQAAAFXV10EAANhBAgAAACIAAAARAAAATAAAAAQAAAAAAAAAAAAAAGYAAABCAAAAcAAAAEQARABWAF8ASwBJAFIAXwBLAFAAUgBfADEALgBqAHMAbwBvYwgAAAAIAAAABwAAAAUAAAAGAAAAAwAAAAcAAAAFAAAABgAAAAYAAAAHAAAABQAAAAYAAAADAAAAAwAAAAUAAAAHAAAAVAAAAFQAAAAvAAAALwAAADUAAAA7AAAAAQAAAFXV10EAANhBLwAAAC8AAAABAAAATAAAAAQAAAAAAAAAAAAAAGYAAABCAAAAUAAAAG4AQUEHAAAAJQAAAAwAAAANAACARgAAACAAAAASAAAASQBjAG8AbgBPAG4AbAB5AAAAAABGAAAANAAAACYAAABEAEQAVgBfAEsASQBSAF8ASwBQAFIAXwAxAC4AagBzAG8AbgAAAAAARgAAABAAAAACAAAAAAAAAEYAAAAQAAAABAAAADcAAABGAAAAIAAAABIAAABJAGMAbwBuAE8AbgBsAHkAAAAAAA4AAAAUAAAAAAAAABAAAAAUAAAA)

Specifikacija CSV formata knjig:

![](data:image/x-emf;base64,AQAAAGwAAAAAAAAAAQAAAGQAAAA7AAAAAAAAAAAAAADECgAA9wYAACBFTUYAAAEACBYAABUAAAACAAAAAAAAAAAAAAAAAAAAgAcAALAEAAAGAgAARAEAAAAAAAAAAAAAAAAAAHDnBwCg8QQAGAAAAAwAAAAAAAAAGQAAAAwAAAD///8AcgAAAKAQAAAjAAAAAQAAAEIAAAAgAAAAIwAAAAEAAAAgAAAAIAAAAACA/wEAAAAAAAAAAAAAgD8AAAAAAAAAAAAAgD8AAAAAAAAAAP///wAAAAAAbAAAADQAAACgAAAAABAAACAAAAAgAAAAKAAAACAAAAAgAAAAAQAgAAMAAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAA/wAA/wAA/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABaW12ydHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/WltdsgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAARiEIYL1aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/476l//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAL1aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAvVoY/71aGP+9Whj/vVoY//v18f//////0o5g/71aGP+9Whj/0o5g///////79fH/vVoY/71aGP+9Whj/vVoY//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/71aGP/FbzX////////////it5r/vVoY/71aGP/it5r////////////FbzX/vVoY/71aGP+9Whj/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAL1aGP+9Whj/vVoY/9KOYP////////////fr4/+9Whj/vVoY//fr4////////////9KOYP+9Whj/vVoY/71aGP/6+vr/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAvVoY/71aGP+9Whj/3q2M/////////////////8l5Q//FbzX///////v18f//////3q2M/71aGP+9Whj/vVoY//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/71aGP/rzLf//////+K3mv//////3q2M/9qiff//////68y3///////rzLf/vVoY/71aGP+9Whj/+vr6/9N8K//TfCv/03wr/9N8K//TfCv/03wr/9N8K//6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAL1aGP+9Whj/vVoY//fr4///////wWQm///////z4dT/68y3///////FbzX///////fr4/+9Whj/vVoY/71aGP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAvVoY/71aGP/BZCb///////v18f+9Whj/68y3////////////9+vj/71aGP/z4dT//////8FkJv+9Whj/vVoY//r6+v/upUH/7qVB/+6lQf/upUH/7qVB/+6lQf/upUH/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/86DUv//////79bG/71aGP/aon3////////////it5r/vVoY/+bCqf//////zoNS/71aGP+9Whj/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/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)

OpenApi (OAS 3.0) datoteka REST spletnega servisa:

![](data:image/x-emf;base64,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CYy//hJJW5IAAAAAAAAAAAAAAAAAAAAAf39/9f7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3//v79//7+/f/+/v3/i4uL/4mJif+JiYn/iYmJ/4eHh/+BgYH8LVpquSWBo/5Aeoz+U3J7/gkMDB0AAAAAAAAAAAAAAAB/f3/1/////+Xg1P/l4NT/5eDU/+Xg1P/l4NT/5eDU/+Xg1P/l4NT/5eDU/+Xg1P/l4NT/5eDU/+nl1//p5df/6eXX/+nl1/+JiYn/q6ur//39/f/t7Oz/jo2N8hYWFSUAAAAAUGNpv4SEgf1/dnD+QTs2jAAAAAAAAAAAAAAAAH9/f/X///////////39/P///////////////////////////////////////////////////////////////////////Pv6/4iIiP/9/f3/qaen/4aEhOcLCwsVAAAAAAAAAAA0MC5Pqp+Y/o2IhP1yZGT8BgUJFwAAAAAAAAAAf39/9f////+zs7P//////7Ozs///////s7Oz//////+zs7P//////7a2tv//////tra2//////+4uLj//////7a2tv//////iIeH/5+env9ra2u2AwMDBQAAAAAAAAAAAAAAAAAAAABzamnFdmt0/kxCdf4bFTuHAAAAAAAAAAB/f3/1/v7+/u3s7P/Ozs7/7ezs/87Ozv/t7Oz/zs7O/+3s7P/Ozs7/7ezs/87Ozv/t7Oz/zs7N/+3s7P/Ozc3/7ezs/8fHx/6Dg4P+VFRUmQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB4cL1U5NJr+LSuR/w8PcvcAAAAAAAAAAH19ffGBgYH6b29vuYODg/xvb2+5goKC+W9vb7mCgoL5b29vuYSEhPtvb2+5goKC+W9vb7mEhIT7b29vuYKCgvl0dHS6goKC9SQkJD8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACsqhsobFTuHAAAAAAAAAAAYAAAADAAAAAAAAAISAAAADAAAAAEAAABSAAAAcAEAAAEAAAAQAAAAAAAAAAAAAAAAAAAAvAIAAAAAAAABAgIiUwB5AHMAdABlAG0AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABkdgAIAAAAACUAAAAMAAAAAQAAACUAAAAMAAAADQAAgCgAAAAMAAAAAQAAAFIAAABwAQAAAQAAAPX///8AAAAAAAAAAAAAAACQAQAAAAAAAABAACJTAGUAZwBvAGUAIABVAEkAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGR2AAgAAAAAJQAAAAwAAAABAAAAVAAAAJQAAAAQAAAAIgAAAFQAAAAuAAAAAQAAAFXV10EAANhBEAAAACIAAAAMAAAATAAAAAQAAAAAAAAAAAAAAGYAAABCAAAAZAAAAHMAdwBhAGcAZwBlAHIALgBqAHMAbwBuAAUAAAAJAAAABgAAAAcAAAAHAAAABgAAAAQAAAADAAAAAwAAAAUAAAAHAAAABwAAACUAAAAMAAAADQAAgEYAAAAgAAAAEgAAAEkAYwBvAG4ATwBuAGwAeQAAAAAARgAAACgAAAAaAAAAcwB3AGEAZwBnAGUAcgAuAGoAcwBvAG4AAAAAAEYAAAAQAAAAAgAAAAAAAABGAAAAEAAAAAQAAAAzAAAARgAAACAAAAASAAAASQBjAG8AbgBPAG4AbAB5AAAAAAAOAAAAFAAAAAAAAAAQAAAAFAAAAA==)

Enkratna prijava s protokolom oauth

![](data:image/x-emf;base64,AQAAAGwAAAAAAAAAAQAAAH0AAABLAAAAAAAAAAAAAADeCAAAuwUAACBFTUYAAAEA1CAAABUAAAACAAAAAAAAAAAAAAAAAAAAgAcAADgEAABYAQAAwQAAAAAAAAAAAAAAAAAAAMA/BQDo8QIAGAAAAAwAAAAAAAAAGQAAAAwAAAD///8AcgAAAKAZAAArAAAAAQAAAFIAAAAoAAAAKwAAAAEAAAAoAAAAKAAAAACA/wEAAAAAAAAAAAAAgD8AAAAAAAAAAAAAgD8AAAAAAAAAAP///wAAAAAAbAAAADQAAACgAAAAABkAACgAAAAoAAAAKAAAACgAAAAoAAAAAQAgAAMAAAAAGQAAAAAAAAAAAAAAAAAAAAAAAAAA/wAA/wAA/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABaXF2ydHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/WlxdsgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIxAEMLFUFvC9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/wWMl/+/cz//6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAALFUFvC9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP/BYyX/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAvVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAL1aGP+9Whj/vVoY/71aGP+9Whj/zoNS/96tjP/erYz/xW81/71aGP+9Whj/xW81/96tjP/erYz/0o5g/71aGP+9Whj/vVoY/71aGP+9Whj/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/71aGP+9Whj/vVoY/+/Wxv///////////9qiff+9Whj/vVoY/9aYb////////////+/Wxv+9Whj/vVoY/71aGP+9Whj/vVoY//r6+v+RPxD/kT8Q/5E/EP+RPxD/kT8Q/5E/EP+RPxD/kT8Q/5E/EP/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAvVoY/71aGP+9Whj/vVoY/71aGP/////////////////rzLf/vVoY/71aGP/mwqn/////////////////vVoY/71aGP+9Whj/vVoY/71aGP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAL1aGP+9Whj/vVoY/71aGP/Og1L/////////////////9+vj/71aGP+9Whj/9+vj/////////////////86DUv+9Whj/vVoY/71aGP+9Whj/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/71aGP+9Whj/2qJ9///////v1sb/9+vj///////FbzX/xW81////////////5sKp///////erYz/vVoY/71aGP+9Whj/vVoY//r6+v+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAvVoY/71aGP+9Whj/vVoY/+vMt///////3q2M/+bCqf//////0o5g/9aYb///////79bG/9qiff//////68y3/71aGP+9Whj/vVoY/71aGP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAL1aGP+9Whj/vVoY/71aGP/79fH//////9KOYP/WmG///////+K3mv/it5r//////96tjP/Og1L///////v18f+9Whj/vVoY/71aGP+9Whj/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/71aGP/JeUP////////////FbzX/yXlD///////v1sb/8+HU///////Og1L/vVoY////////////yXlD/71aGP+9Whj/vVoY//r6+v/TfCv/03wr/9N8K//TfCv/03wr/9N8K//TfCv/03wr/9N8K//6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAvVoY/71aGP+9Whj/2qJ9///////79fH/vVoY/71aGP/79fH/////////////////wWQm/71aGP/z4dT//////9qiff+9Whj/vVoY/71aGP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAL1aGP+9Whj/vVoY/+bCqf//////79bG/71aGP+9Whj/68y3////////////8+HU/71aGP+9Whj/5sKp///////mwqn/vVoY/71aGP+9Whj/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/71aGP/36+P//////96tjP+9Whj/vVoY/9qiff///////////+K3mv+9Whj/vVoY/9qiff//////9+vj/71aGP+9Whj/vVoY//r6+v/upUH/7qVB/+6lQf/upUH/7qVB/+6lQf/upUH/7qVB/+6lQf/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAvVoY/71aGP+9Whj/3q2M/96tjP/FbzX/vVoY/71aGP/FbzX/3q2M/96tjP/JeUP/vVoY/71aGP/FbzX/3q2M/96tjP+9Whj/vVoY/71aGP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAL1aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAsVQW8L1aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/8FjJf/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMQBDCxVBbwvVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/71aGP+9Whj/vVoY/8FjJf/v3M//+vr6//r6+v/6+vr/+vr6/6aoqf90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5//r6+v/6+vr/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef/6+vr/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/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)

WSDL SOAP spletnega servisa za prijavo

![](data:image/x-emf;base64,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)

WSDL SOAP spletnega servisa za funkcionalnosti

![](data:image/x-emf;base64,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)

Popis polj:

![](data:image/x-emf;base64,AQAAAGwAAAABAAAAAQAAAHsAAABLAAAAAAAAAAAAAADeCAAAuwUAACBFTUYAAAEAsB8AABUAAAACAAAAAAAAAAAAAAAAAAAAgAcAADgEAABYAQAAwQAAAAAAAAAAAAAAAAAAAMA/BQDo8QIAGAAAAAwAAAAAAAAAGQAAAAwAAAD///8AcgAAAKAZAAArAAAAAQAAAFIAAAAoAAAAKwAAAAEAAAAoAAAAKAAAAACA/wEAAAAAAAAAAAAAgD8AAAAAAAAAAAAAgD8AAAAAAAAAAP///wAAAAAAbAAAADQAAACgAAAAABkAACgAAAAoAAAAKAAAACgAAAAoAAAAAQAgAAMAAAAAGQAAAAAAAAAAAAAAAAAAAAAAAAAA/wAA/wAA/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABaXF2ydHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/WlxdsgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADBcDMD10D/BBfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/TIMe/9fizv/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD10D/BBfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9Mgx7/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEF8EP9BfBD/QXwQ/0F8EP9BfBD/lLZ5/6C+iP+gvoj/QXwQ/0F8EP9BfBD/QXwQ/6C+iP+gvoj/lLZ5/0F8EP9BfBD/QXwQ/0F8EP9BfBD/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBfBD/QXwQ/0F8EP9BfBD/QXwQ/5S2ef///////////4mtav9BfBD/QXwQ/4mtav///////////6C+iP9BfBD/QXwQ/0F8EP9BfBD/QXwQ//r6+v83XBj/N1wY/zdcGP83XBj/+vr6/yxKE/8sShP/LEoT/yxKE//6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/3OfT///////o7+L/TYQf/0F8EP/o7+L//////9zn0/9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP/6+vr/N1wY/zdcGP83XBj/N1wY//r6+v8sShP/LEoT/yxKE/8sShP/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEF8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/2WVPf///////////6C+iP+Utnn///////////9xnUz/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/oL6I///////09/H/9Pfx//////+4zqb/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP/o7+L////////////09/H/TYQf/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP/6+vr/QXwQ/0F8EP9BfBD/QXwQ//r6+v9moyH/ZqMh/2ajIf9moyH/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEF8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/3OfT////////////6O/i/02EH/9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/+vr6/0F8EP9BfBD/QXwQ/0F8EP/6+vr/ZqMh/2ajIf9moyH/ZqMh//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/lLZ5////////////9Pfx//////+sxpf/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/TYQf//T38f//////0N/E/4mtav///////////2WVPf9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEF8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/7jOpv///////////3GdTP9BfBD/6O/i///////Q38T/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/+vr6/2ajIf9moyH/ZqMh/2ajIf/6+vr/gcQz/4HEM/+BxDP/gcQz//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBfBD/QXwQ/0F8EP9BfBD/QXwQ/2WVPf///////////9DfxP9BfBD/QXwQ/32lW////////////5S2ef9BfBD/QXwQ/0F8EP9BfBD/QXwQ//r6+v9moyH/ZqMh/2ajIf9moyH/+vr6/4HEM/+BxDP/gcQz/4HEM//6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQXwQ/0F8EP9BfBD/QXwQ/0F8EP99pVv/oL6I/6C+iP9llT3/QXwQ/0F8EP9BfBD/lLZ5/6C+iP+Utnn/QXwQ/0F8EP9BfBD/QXwQ/0F8EP/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEF8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPXQP8EF8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0yDHv/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAwXAzA9dA/wQXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0yDHv/X4s7/+vr6//r6+v/6+vr/+vr6/6aoqf90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5//r6+v/6+vr/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef/6+vr/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/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)

Pravopis pravil:

![](data:image/x-emf;base64,AQAAAGwAAAAAAAAAAQAAAHwAAAA6AAAAAAAAAAAAAADeCAAAuwUAACBFTUYAAAEAVB8AABQAAAACAAAAAAAAAAAAAAAAAAAAgAcAADgEAABYAQAAwQAAAAAAAAAAAAAAAAAAAMA/BQDo8QIAGAAAAAwAAAAAAAAAGQAAAAwAAAD///8AcgAAAKAZAAArAAAAAQAAAFIAAAAoAAAAKwAAAAEAAAAoAAAAKAAAAACA/wEAAAAAAAAAAAAAgD8AAAAAAAAAAAAAgD8AAAAAAAAAAP///wAAAAAAbAAAADQAAACgAAAAABkAACgAAAAoAAAAKAAAACgAAAAoAAAAAQAgAAMAAAAAGQAAAAAAAAAAAAAAAAAAAAAAAAAA/wAA/wAA/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABaXF2ydHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/WlxdsgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/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QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPXQP8EF8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0yDHv/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAwXAzA9dA/wQXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0F8EP9BfBD/QXwQ/0yDHv/X4s7/+vr6//r6+v/6+vr/+vr6/6aoqf90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef90d3n/dHd5/3R3ef8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5//r6+v/6+vr/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef/6+vr/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/+vr6//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/dHd5//r6+v/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdHd5//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6/3R3ef/6+vr/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHR3ef/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v90d3n/yMnJ/3R3ef8rLC1gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB0d3n/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/+vr6//r6+v/6+vr/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)

Vse priloge so na voljo tudi v zip datoteki, objavljeni na naslovu: <https://edavki.durs.si/OpenPortal/Dokumenti/DDV_KIR_KPR.zip>

1. Pomembna razlika je v serializaciji enum vrednosti. V REST servisu so serializirane kot tip integer, v SOAP servisu pa kot tip string. [↑](#footnote-ref-1)