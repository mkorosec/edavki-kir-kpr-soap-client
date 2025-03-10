# Tehnične specifikacije CSV datoteke za servis KIR/KPR

<table><tbody><tr><th><p><strong>Različica</strong></p></th><th><p><strong>Datum</strong></p></th><th><p><strong>Opis</strong></p></th></tr><tr><td><p>1.0</p></td><td><p>22. 5. 2024</p></td><td><p>Osnutek specifikacije.</p></td></tr><tr><td><p>1.1</p></td><td><p>18. 6. 2024</p></td><td><p>Popravki sheme.</p></td></tr><tr><td><p>1.2</p></td><td><p>12. 7. 2024</p></td><td><p>Popravki sheme: iz glave odstranjeno polje STORNO.</p></td></tr><tr><td><p>1.3</p></td><td><p>22. 7. 2024</p></td><td><p>Popravki sheme:</p><ul><li>Shema dovoljuje hkratno prisotnost Lista_KIR in Lista_KPR</li><li>yesNoType zamenjan z xs:boolean</li><li>Iz glave odstranjeno polje PREDIDDVO</li></ul></td></tr></tbody></table>

## Splošno

Podatki v CSV datoteki so med seboj ločeni z ločilom podpičje »;«.

Pripravljeno CSV datoteko se shrani kot tip CSV (comma delimited).

Datoteka sestoji iz prve vrstice - glave (glej poglavje »Specifikacije prve vrstice - glave«) in poljubnega števila vrstic s podatki (glej poglavje »Specifikacije vrstic s podatki«).

V primeru, ko je naveden tip polja s predpono »xs«, to ustreza definiciji v XSD shemi <http://www.w3.org/2001/XMLSchema>. Tipi polj brez predpone so definirani v poglavju »Definicija tipov«.

## Specifikacije prve vrstice - glave

| **Zaporedna številka polja** | **Naziv polja** | **Tip oz. možne vrednosti polja** | **Omejitev vsebine polja** | **Obvezno** | **Opis** |
| --- | --- | --- | --- | --- | --- |
| 1   | TaxPayerID | xs:positiveInteger | Regex »\[0-9\]{8}« | da  | TaxPayer (DŠ) |
| 2   | TUJEC1 | countryCodeType |     | ne  | koda države zavezanca (tujec) |
| 3   | TUJEC2 | xs:string |     | ne  | dš zavezanca (tujec) |
| 4   | OBDOBJE_OD | xs:date |     | da  | Datum začetka obdobja poročanja |
| 5   | OBDOBJE_DO | xs:date |     | da  | Datum konca obdobja poročanja |
| 6   | KIR | xs:boolean |     | da  | Knjiga vsebuje KIR podatke |
| 7   | KPR | xs:boolean |     | da  | Knjiga vsebuje KIR podatke |
| 8   | VRACILO | xs:boolean |     | ne  | Zahtevam Vračilo |
| 9   | ODBDELEZ | xs:boolean |     | da  | Izračunavam odbitni delež |
| 10  | NACIN | xs:string | Regex »1\|2\|3« | ne  | Način obravnave:  <br>»1« - samoprijava  <br>»2«, Vloga za predložitev po roku  <br>»3« - Ne bom uporabil instituta samoprijave... |
| 11  | INSPOS | xs:boolean |     | ne  | Insolventni postopek |
| 12  | PREDLODO | xs:boolean |     | ne  | Predložitev na podlagi odločitve davčnega organa |
| 13  | OPOMBA | text250Type |     | ne  | Opombe |

## Specifikacije vrstic s podatki

### Knjiga vsebuje KIR podatke

| **Zaporedna številka polja** | **Naziv polja** | **Tip oz. možne vrednosti polja** | **Omejitev vsebina polja** | **Obvezno** | **Opis** |
| --- | --- | --- | --- | --- | --- |
| 1   | TIP | xs:string | »KIR« | da  | Konstanta »KIR«, določa tip vrstice. |
| 2   | ZAPST | xs:int |     | da  | Zap. št. Unikatna številka znotraj KIR (od 1….). Številke si morajo slediti." |
| 3   | OBDOBJE | xs:string | Regex »\[0-9\]{4}« | da  | Davčno obdobje: MMMM |
| 4   | P2  | xs:date |     | da  | datum knjiženja listine |
| 5   | P3  | text250Type |     | da  | številka listine |
| 6   | P4  | xs:date |     | da  | datum listine |
| 7   | P5  | text250Type |     | ne  | firma/ime in sedež kupca |
| 8   | P6  | countryCodeType |     | ne  | koda države članice kupca |
| 9   | P6DS | xs:string |     | ne  | kupčeva identifikacijska številka za DDV oziroma DŠ (brez kode države) |
| 10  | P7  | amountType |     | ne  | vrednost dobav blaga in storitev brez DDV |
| 11  | P8  | amountType |     | ne  | vrednost dobav blaga in storitev v Sloveniji za samoobdavčitev |
| 12  | P9  | amountType |     | ne  | oproščene dobave brez pravice do odbitka DDV |
| 13  | P10 | amountType |     | ne  | oproščene dobave blaga in storitev znotraj Unije |
| 14  | P11 | amountType |     | ne  | oproščena tristranska dobava blaga znotraj unije |
| 15  | P12 | amountType |     | ne  | prodaja blaga na daljavo |
| 16  | P13 | amountType |     | ne  | prodaja blaga z montažo ali napeljavo |
| 17  | P14 | amountType |     | ne  | obračunan DDV po 22% |
| 18  | P15 | amountType |     | ne  | obračunan DDV po 9,5% |
| 19  | P16 | amountType |     | ne  | obračunan DDV po 5% |
| 20  | P17 | amountType |     | ne  | obračunan DDV po 22% za pridobitev blaga znotraj unije |
| 21  | P18 | amountType |     | ne  | obračunan DDV po 22% za prejete storitve znotraj unije |
| 22  | P19 | amountType |     | ne  | obračunan DDV po 9,5% za pridobitev blaga znotraj unije |
| 23  | P20 | amountType |     | ne  | obračunan DDV po 9,5% za prejete storitve znotraj unije |
| 24  | P21 | amountType |     | ne  | obračunan DDV po 5% za pridobitev blaga znotraj unije |
| 25  | P22 | amountType |     | ne  | obračunan DDV po 5% za prejete storitve znotraj unije |
| 26  | P23 | amountType |     | ne  | obračunan DDV po 22% na podlagi samoobdavčitve prejemnika blaga in storitev |
| 27  | P24 | amountType |     | ne  | obračunan DDV po 9,5% na podlagi samoobdavčitve prejemnika blaga in storitev |
| 28  | P25 | amountType |     | ne  | obračunan DDV po 5% na podlagi samoobdavčitve prejemnika blaga in storitev |
| 29  | P26 | amountType |     | ne  | obračunan DDV na podlagi samoobdavčitve od uvoza |
| 30  | P27 | amountType |     | ne  | vrednost dobav s pravico do odbitka DDV, pri kateri je kraj dobave zunaj Slovenije |
| 31  | P29 | text250Type |     | ne  | Opomba |
| 32  | OBRAVNAVA | xs:string | Regex »1\|2\|3« | da  | Način obravnave:<br><br>»1« - obračun<br><br>»2« - obračun in obresti (samoprijava 88.b člen)<br><br>»3« - samo obresti |
| 33  | OBDOBJE88 | xs:string | Regex »\[0-9\]{8}« | ne  | Davčno obdobje 88.b (mmmmllll) |
| 34  | DAVEK88 | amountType |     | ne  | Znesek davka 88.b |

### Knjiga vsebuje KPR podatke

| **Zaporedna številka polja** | **Naziv polja** | **Tip oz. možne vrednosti polja** | **Omejitev vsebine polja** | **Obvezno** | **Opis** |
| --- | --- | --- | --- | --- | --- |
| 1   | TIP | xs:string | »KPR« | da  | Konstanta »KPR«, določa tip vrstice. |
| 2   | ZAPST | xs:int |     | da  | Zap. št. Unikatna številka znotraj KPR (od 1….). Številke si morajo slediti. |
| 3   | OBDOBJE | xs:string | Regex »\[0-9\]{4}« | da  | Davčno obdobje: MMMM |
| 4   | P2  | xs:date |     | da  | datum knjiženja listine |
| 5   | P3  | text250Type |     | da  | številka listine |
| 6   | P4  | xs:date |     | da  | datum prejema listine |
| 7   | P5  | xs:date |     | da  | datum listine |
| 8   | P6  | text250Type |     | da  | firma/ime in sedež dobavitelja |
| 9   | P7  | countryCodeType |     | ne  | koda države članice dobavitelja |
| 10  | P7DS | xs:string |     | ne  | dobaviteljeva identifikacijska številka za DDV oziroma DŠ (brez kode države) |
| 11  | P8  | amountType |     | ne  | vrednost nabav blaga in storitev brez DDV |
| 12  | P9  | amountType |     | ne  | vrednost nabav blaga in storitev v Sloveniji od samoobdavčitve |
| 13  | P10 | amountType |     | ne  | vrednost obdavčenih pridobitev blaga brez DDV |
| 14  | P11 | amountType |     | ne  | vrednost obdavčenih prejetih storitev brez DDV |
| 15  | P12 | amountType |     | ne  | vrednost obdavčenih nabav nepremičnin brez DDV |
| 16  | P13 | amountType |     | ne  | vrednost obdavčenih nabav drugih osnovnih sredstev brez DDV |
| 17  | P14 | amountType |     | ne  | oproščene nabave in pridobitve |
| 18  | P15 | amountType |     | ne  | vrednost oproščenih nabav nepremičnin brez DDV |
| 19  | P16 | amountType |     | ne  | vrednost oproščenih nabav drugih osnovnih sredstev brez DDV |
| 20  | P17 | amountType |     | ne  | DDV, ki se ne odbija |
| 21  | P18 | amountType |     | ne  | odbitni DDV 22 % |
| 22  | P19 | amountType |     | ne  | odbitni DDV 9,5 % |
| 23  | P20 | amountType |     | ne  | odbitni DDV 5 % |
| 24  | P21 | amountType |     | ne  | pavšalno nadomestilo 8 % |
| 25  | P22 | text250Type |     | ne  | Opombe |
| 26  | OBRAVNAVA | xs:string | Regex »1\|2\|3« | da  | Način obravnave:<br><br>»1« - obračun<br><br>»2« - obračun in obresti (samoprijava 88.b člen)<br><br>»3« - samo obresti |
| 27  | OBDOBJE88 | xs:string | Regex »\[0-9\]{8}« | ne  | Davčno obdobje 88.b (mmmmllll) |
| 28  | DAVEK88 | amountType |     | ne  | Znesek davka 88.b |

## Definicija tipov

| Tip | Osnovni tip | Omejitev | Opis |
| --- | --- | --- | --- |
| amountType | xs:decimal | do dve decimalki, lahko negativen, absolutno manjši od 5.000.000.000 | znesek |
| countryCodeType | xs:string | dolžina = 2 | dvomestna koda države |
| text250Type | xs:string | Dolžina <= 250 | besedilo do 250 znakov |