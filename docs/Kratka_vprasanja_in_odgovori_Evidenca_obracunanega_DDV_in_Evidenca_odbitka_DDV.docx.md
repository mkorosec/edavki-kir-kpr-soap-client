**Kratka vprašanja in odgovori -** **evidenci obračunanega DDV in odbitka DDV ter predizpolnitev obračuna DDV**

2\. izdaja, FEBRUAR 2025

Vsebina

[1\. Evidenci obračunanega DDV in odbitka DDV 5](#__RefHeading___Toc191385027)

[1.1. Kje so objavljene tehnične specifikacije za oddajo evidence obračunanega DDV in evidence odbitka DDV? (13. 2. 2025) 5](#__RefHeading___Toc191385028)

[1.2. V pojasnilih je navedeno, da morata biti evidenci DDV v predpisani strukturirani obliki ter da bo zahtevano elektronsko vodenje evidenc. Ali bo dovoljeno DDV evidence ročno pripraviti v excel obliki ter jih pretvoriti v predpisan xml format ali se bo zahtevalo, da so podatki iz ERP sistema avtomatsko/direktno izvoženi v predpisan strukturiran xml format. (13. 2. 2025) 5](#__RefHeading___Toc191385029)

[1.3. Ali bo mogoče evidenci obračunanega DDV in odbitka DDV oddati tudi z ročnim nalaganjem XML datoteke, kot je to npr. za ostale obrazce npr. RP-O, PD-O, REK, ...? Če da, kdaj se predvidoma lahko pričakuje, da bo v testnem okolju na voljo ta obrazec? (13. 2. 2025) 5](#__RefHeading___Toc191385030)

[1.4. V glavi evidenc se nahaja polje »NAČIN OBRAVNAVE«. V njem so tri vrednosti, kdaj se uporabi katero od njih? (13. 2. 2025) 5](#__RefHeading___Toc191385031)

[1.5. Ali se v evidencah obračunanega DDV in odbitka DDV na nivoju posamezne listine (vrstice) vrednost 1 – obračun v polju »NAČIN OBRAVNAVE« napolni ob oddaji evidence za tekoče/redno davčno obdobje? (13. 2. 2025) 6](#__RefHeading___Toc191385032)

[1.6. Ali so v evidencah obračunanega DDV in odbitka DDV na nivoju posamezne listine (vrstice) v polju »DAVEK88« dovoljene zgolj pozitivne ali tudi negativne obresti? (13. 2. 2025) 6](#__RefHeading___Toc191385033)

[1.7. Ali se lahko za potrebe testiranja evidenc obračunanega DDV in odbitka DDV preko spletnega servisa v testnem okolju uporabi isti testni certifikat, ki se sicer uporablja za dostop do testnega okolja eDavkov (https://beta.edavki.durs.si/)? (13. 2. 2025) 6](#__RefHeading___Toc191385034)

[1.8. Ali bo davčni zavezanec po uspešnem posredovanju evidenc obračunanega DDV in odbitka DDV, le te lahko samo pregledoval ali tudi popravljal v eDavkih? (13. 2. 2025) 6](#__RefHeading___Toc191385035)

[1.9. V dokumentu “Spremembe zakonodaje na področju DDV.doc” je navedeno, da z dnem uveljavitve Pravilnika prenehata veljati točka 2.2 Izpis odbitka DDV in točka 2.3 Izpis obračunanega DDV Priloge Pravilnika o vsebini, obliki, načinu in rokih za predložitev izpisa podatkov iz elektronsko vodenih poslovnih knjig in evidenc zavezanca za davek, uporabljata pa se za izpise podatkov za davčna obdobja, ki se končajo pred 1. julijem 2025. 7](#__RefHeading___Toc191385036)

[Navedeno pomeni, da če bo davčni zavezanec pozvan k predložitvi podatkov o odbitku DDV in obračunu DDV za obdobja pred 1. 7. 2025 (npr. za Davčno obdobje December 2024), mora predložiti podatke v obliki kot je predpisana v točki 2.2 Izpis odbitka DDV in točka 2.3 Izpis obračunanega DDV Priloge Pravilnika o vsebini, obliki, načinu in rokih za predložitev izpisa podatkov iz elektronsko vodenih poslovnih knjig in evidenc zavezanca za davek? 7](#__RefHeading___Toc191385037)

[Koliko časa po uvedbi novih evidenc (od 1. 7. 2025) je treba strankam zagotavljati možnost priprave podatkov v trenutno veljavni TXT obliki? (13. 2. 2025) 7](#__RefHeading___Toc191385038)

[1.10 Ali mora davčni zavezanec, katerega davčno obdobje je koledarsko trimesečje, vsak mesec oddati evidenci? (13. 2. 2025) 7](#__RefHeading___Toc191385039)

[1.11 V katerih primerih se v evidencah obračunanega DDV na nivoju posamezne listine (vrstice) v polju »NAČIN OBRAVNAVE« izbere vrednost 3 – samo obresti? (. 2025) 7](#__RefHeading___Toc191385040)

[1.12 V katerih primerih se v evidencah odbitka DDV na nivoju posamezne listine (vrstice) v polju »NAČIN OBRAVNAVE« izbere vrednost 3 – samo obresti? (. 2025) 8](#__RefHeading___Toc191385041)

[1.13 Ali je treba v evidenci obračunanega DDV navesti podatke o posameznih računih (izdanih iz maloprodaje in za komunalne storitve po številkah računov in prejemnikih) oziroma je za tovrstne račune (iz maloprodaje in ponavljajoče storitve npr. telekomunikacijske storitve, komunala, voda, elektrika, plin) lahko naveden zbir računov (kot so bili posredovani v centralni informacijski sistem)? Enako vprašanje velja tudi za evidence odbitnega DDV. 8](#__RefHeading___Toc191385042)

[1.14 Če je v evidenci obračunanega DDV lahko izkazan zbir računov (kot je bil posredovan v centralni informacijski sistem) ali je dovolj, če davčni zavezanec zagotavlja npr. Evidenco izdanih računov po posameznih računih iz teh rešitev specializiranih za maloprodajo oz. periodično zaračunavanje storitev in jih predloži FURS-u na zahtevo? 9](#__RefHeading___Toc191385043)

[1.15 Ali bo rešitev Servisa sprejema knjige (Metode za delo s knjigami računov - /api/v1/InvoiceBook?) omogočala sprejem podatkov o evidenci obračunanega DDV oz. evidenci odbitnega DDV iz večih datotek, npr. na način, da bo davčni zavezanec lahko npr. pripravil in posredoval podatke o računih iz različnih informacijskih sistemov ločeno na FURS (in ne vse v eni datoteki)? 9](#__RefHeading___Toc191385044)

[2\. Predizpolnitev obračuna DDV 9](#__RefHeading___Toc191385045)

[2.1. Davčni zavezanec je oddal evidenci 23. v mesecu, ki sledi mesecu obdobja evidenc. Iz predloženih evidenc oziroma podatkov v evidencah izhaja, da je davčni zavezanec opravljal transakcije znotraj Unije in je bil zato dolžan predložiti rekapitulacijsko poročilo iz 90. člena ZDDV-1. Ali bo davčni organ predizpolnil obračun DDV? (13. 2. 2025) 9](#__RefHeading___Toc191385046)

[2.2. Davčni zavezanec je 8. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je 9. v mesecu predizpolnil obračun. Davčni zavezanec je v predloženih evidencah uveljavljal vračilo presežka DDV. S katerim dnem začne teči 21 dnevni rok za vračilo presežka DDV? (13. 2. 2025) 9](#__RefHeading___Toc191385047)

[2.3. Davčni zavezanec je 8. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je 9. v mesecu predizpolnil obračun. Davčni zavezanec je v predloženih evidencah uveljavljal vračilo presežka DDV. Ali lahko davčni zavezanec ponovno sam odda obračun na eDavkih? (13. 2. 2025) 10](#__RefHeading___Toc191385048)

[2.4. Davčni zavezanec je 22. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je še isti dan predizpolnil obračun. Iz predloženih evidenc oziroma podatkov v evidencah ne izhaja, da je davčni zavezanec uveljavljal vračilo presežka DDV, niti ni opravljal transakcij znotraj Unije, za kar bi bil dolžan predložiti rekapitulacijsko poročilo. Ali lahko davčni zavezanec ponovno odda evidenci, davčni organ pa mu bo ponovno predizpolnil obračun? (13. 2. 2025) 10](#__RefHeading___Toc191385049)

[2.5. Davčni zavezanec je 22. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je še isti dan predizpolnil obračun. Iz predloženih evidenc oziroma podatkov v evidencah ne izhaja, da je davčni zavezanec uveljavljal vračilo presežka DDV, niti ni opravljal transakcij znotraj Unije, za kar bi bil dolžan predložiti rekapitulacijsko poročilo. Ali lahko davčni zavezanec sam na eDavkih odda obračun? (13. 2. 2025) 10](#__RefHeading___Toc191385050)

[2.6. Davčni zavezanec je 22. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je še isti dan predizpolnil obračun. Iz predloženih evidenc oziroma podatkov v evidencah ne izhaja, da je davčni zavezanec uveljavljal vračilo presežka DDV, niti ni opravljal transakcij znotraj Unije, za kar bi bil dolžan predložiti rekapitulacijsko poročilo. Davčni zavezanec je nato 24. v mesecu sam oddal obračun DDV. Ali lahko davčni zavezanec 25. v mesecu ponovno pošlje evidenci in bo davčni organ ponovno predizpolnil obračun DDV? (13. 2. 2025) 10](#__RefHeading___Toc191385051)

[2.7. Davčni zavezanec je 22. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je še isti dan predizpolnil obračun. Iz predloženih evidenc oziroma podatkov v evidencah ne izhaja, da je davčni zavezanec uveljavljal vračilo presežka DDV, niti ni opravljal transakcij znotraj Unije, za kar bi bil dolžan predložiti rekapitulacijsko poročilo. Davčni zavezanec je nato 24. v mesecu sam oddal obračun DDV, ki se razlikuje od že predizpolnjenega obračuna na podlagi predloženih evidenc. Ali mora davčni zavezanec ponovno poslati evidenci za to obdobje, ki morajo biti skladne z oddanim obračunom? (13. 2. 2025) 11](#__RefHeading___Toc191385052)

[2.8 Davčni zavezanec je 24. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ do zadnjega delovnega dne v mesecu ni predizpolnil obračuna DDV. Ali mora davčni zavezanec sam oddati obračun? (13. 2. 2025) 11](#__RefHeading___Toc191385053)

[2.9. Davčni zavezanec je 15. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Iz predloženih evidenc oziroma podatkov v evidencah izhaja, da je davčni zavezanec opravljal transakcije znotraj Unije, za kar je bil dolžan predložiti rekapitulacijsko poročilo. Davčni organ mu do 20. dne v mesecu ni predizpolnil obračuna DDV. Do kdaj mora davčni zavezanec sam oddati obračun? (13. 2. 2025) 11](#__RefHeading___Toc191385054)

[2.10. Davčni zavezanec je oddal evidenci po roku za predložitev, npr. 10. v mesecu, ki sledi mesecu, v katerem bi moral predložiti evidenci. Obračuna DDV za to davčno obdobje še ni predložil. Bo davčni organ naredil predizpolnitev obračuna DDV? 12](#__RefHeading___Toc191385055)

[2.11. Davčni organ je na predlog davčnega zavezanca, ki iz opravičljivih razlogov ni mogel predložiti davčnega obračuna v predpisanem roku, na podlagi 52. člena Zakona o davčnem postopku dovolil predložitev davčnega obračuna po izteku predpisanega roka. Ali se rok za predložitev evidenc tudi prestavi? Bo davčni organ naredil predizpolnitev obračuna DDV? 12](#__RefHeading___Toc191385056)

# 1\. Evidenci obračunanega DDV in odbitka DDV

## 1.1. Kje so objavljene tehnične specifikacije za oddajo evidence obračunanega DDV in evidence odbitka DDV? (13. 2. 2025)

**ODGOVOR:**

Tehnične specifikacije so objavljene na povezavi: [spletni_servis_za_sprejem_kir_kpr.docx](https://view.officeapps.live.com/op/view.aspx?src=https%3A%2F%2Fedavki.durs.si%2FOpenPortal%2FDokumenti%2Fspletni_servis_za_sprejem_kir_kpr.docx&wdOrigin=BROWSELINK).

## 1.2. V pojasnilih je navedeno, da morata biti evidenci DDV v predpisani strukturirani obliki ter da bo zahtevano elektronsko vodenje evidenc. Ali bo dovoljeno DDV evidence ročno pripraviti v excel obliki ter jih pretvoriti v predpisan xml format ali se bo zahtevalo, da so podatki iz ERP sistema avtomatsko/direktno izvoženi v predpisan strukturiran xml format. (13. 2. 2025)

**ODGOVOR:**

Oddaja predpisanih evidenc bo mogoča samo preko spletnega servisa, ki ima REST (podpira podatke, kodirane v JSON) in SOAP vmesnik. Tehnična dokumentacija je objavljena na strani [eDavki - Za razvijalce](https://beta.edavki.durs.si/EdavkiPortal/OpenPortal/CommonPages/Opdynp/PageB.aspx?category=razvijalci). Davčni zavezanci, zlasti tisti z manjšim obsegom poslovanja, bodo obveznost predložitve evidence odbitka DDV in evidence obračunanega DDV lahko izpolnjevali tudi z uporabo brezplačne spletne aplikacije davčnega organa (miniBLAGAJNA), ki bo v ta namen nadgrajena z možnostjo vodenja teh evidenc in njihovo predložitvijo davčnemu organu. Informacija glede možnosti uporabe MiniBlagajne je bila že v obrazložitvi predloga novele ZDDV-1O. Informacijo o nadgradnji miniBLAGAJNE in njeni uporabi bomo objavili, ko bo le ta na voljo davčnim zavezancem.

## 1.3. Ali bo mogoče evidenci obračunanega DDV in odbitka DDV oddati tudi z ročnim nalaganjem XML datoteke, kot je to npr. za ostale obrazce npr. RP-O, PD-O, REK, ...? Če da, kdaj se predvidoma lahko pričakuje, da bo v testnem okolju na voljo ta obrazec? (13. 2. 2025)

**ODGOVOR:**

Evidenci bo mogoče oddajati izključno, kot je opisano v tehnični specifikaciji. Ročno nalaganje evidenc ni predvideno.

## 1.4. V glavi evidenc se nahaja polje »NAČIN OBRAVNAVE«. V njem so tri vrednosti, kdaj se uporabi katero od njih? (13. 2. 2025)

**ODGOVOR:**

Polje »NAČIN OBRAVNAVE« dovoljuje naslednje vrednosti:

1 – Samoprijava,

2 – Vloga za predložitev po roku,

3 – Ne bom uporabil instituta samoprijave.

Za vsa ta tri polja velja, da se lahko izpolnijo samo v primeru, ko je rok za oddajo obračuna že potekel, **davčni zavezanec obračuna DDV sam še ni oddal** in je davčni zavezanec po tem roku predložil evidenci, zato davčni organ ne bo predizpolnil obračuna DDV. Kadar se evidenci oddajata po roku in davčni zavezanec ne želi uporabiti instituta samoprijave po 88.c členu ZDDV-1 (vrednost 1) oziroma tudi ne izpolnjuje pogojev za predložitev po roku po 52. členu Zakona o davčnem postopku - ZDavP-2 (vrednost 2), se lahko uporabi vrednost 3.

Iz navedenega izhaja, da se ta polja izpolnijo v primeru, ko davčni zavezanec ne predloži obračuna DDV v roku in zato davčni organ na podlagi tako predloženih evidenc ne bo predizpolnil obračuna DDV, ampak bo moral davčni zavezanec obračun DDV oddati sam. Ne glede na to, pa morajo biti ti podatki v evidencah navedeni tako, kot jih bo davčni zavezanec navedel na eDavkih na oddanem obračunu DDV.

## 1.5. Ali se v evidencah obračunanega DDV in odbitka DDV na nivoju posamezne listine (vrstice) vrednost 1 – obračun v polju »NAČIN OBRAVNAVE« napolni ob oddaji evidence za tekoče/redno davčno obdobje? (13. 2. 2025)

**ODGOVOR:**

Ne, vrednost 1 se ne bo napolnila ob oddaji evidence. Davčni zavezanec vpiše vrednost 1, če ne uporabi vrednosti 2 ali 3 pred oddajo evidenc.

Polje »NAČIN OBRAVNAVE« dovoljuje naslednje vrednosti:

1 - obračun,

2 – samoprijava obračun in obresti (popravki napak iz preteklih obdobij),

3 – samo obresti.

## 1.6. Ali so v evidencah obračunanega DDV in odbitka DDV na nivoju posamezne listine (vrstice) v polju »DAVEK88« dovoljene zgolj pozitivne ali tudi negativne obresti? (13. 2. 2025)

**ODGOVOR:**

Samo pozitivne vrednosti (tako kot je na obračunih DDV-O v razdelku V. Samoprijava/Popravek).

## 1.7. Ali se lahko za potrebe testiranja evidenc obračunanega DDV in odbitka DDV preko spletnega servisa v testnem okolju uporabi isti testni certifikat, ki se sicer uporablja za dostop do testnega okolja eDavkov (<https://beta.edavki.durs.si/>)? (13. 2. 2025)

**ODGOVOR:**

Za testiranje na Beta eDavkih se lahko uporabi isti certifikat za vse procese.

## 1.8. Ali bo davčni zavezanec po uspešnem posredovanju evidenc obračunanega DDV in odbitka DDV, le te lahko samo pregledoval ali tudi popravljal v eDavkih? (13. 2. 2025)

**ODGOVOR:**

Uspešno oddane evidence ne bodo prikazane na eDavkih tako kot ostali obrazci, saj to ni obrazec. Pripravljen bo vpogled v oddane knjige, kjer bodo podatki o oddanih evidencah ter možnost pridobitve podatkov iz oddanih evidenc. V primeru popravkov evidenc ne bo mogoče urejati na eDavkih, temveč jih bo treba ponovno oddati.

## 1.9. V dokumentu “Spremembe zakonodaje na področju DDV.doc” je navedeno, da z dnem uveljavitve Pravilnika prenehata veljati točka 2.2 Izpis odbitka DDV in točka 2.3 Izpis obračunanega DDV Priloge Pravilnika o vsebini, obliki, načinu in rokih za predložitev izpisa podatkov iz elektronsko vodenih poslovnih knjig in evidenc zavezanca za davek, uporabljata pa se za izpise podatkov za davčna obdobja, ki se končajo pred 1. julijem 2025

## Navedeno pomeni, da če bo davčni zavezanec pozvan k predložitvi podatkov o odbitku DDV in obračunu DDV za obdobja pred 1. 7. 2025 (npr. za Davčno obdobje December 2024), mora predložiti podatke v obliki kot je predpisana v točki 2.2 Izpis odbitka DDV in točka 2.3 Izpis obračunanega DDV Priloge Pravilnika o vsebini, obliki, načinu in rokih za predložitev izpisa podatkov iz elektronsko vodenih poslovnih knjig in evidenc zavezanca za davek?

## Koliko časa po uvedbi novih evidenc (od 1. 7. 2025) je treba strankam zagotavljati možnost priprave podatkov v trenutno veljavni TXT obliki? (13. 2. 2025)

**ODGOVOR:**

Z dnem uveljavitve novele Pravilnika o izvajanju davka na dodano vrednost (Uradni list RS št. [112/24](https://www.uradni-list.si/glasilo-uradni-list-rs/celotno-kazalo/2024112)) prenehata veljati točka 2.2 Izpis odbitka DDV in točka 2.3 Izpis obračunanega DDV Priloge [Pravilnika o vsebini, obliki, načinu in rokih za predložitev izpisa podatkov iz elektronsko vodenih poslovnih knjig in evidenc zavezanca za davek](https://pisrs.si/pregledPredpisa?id=PRAV8099), uporabljata pa se za izpise podatkov za davčna obdobja, ki se končajo pred 1. julijem 2025. Davčnemu zavezancu se mora zagotoviti možnost oddaje izpisov odbitka DDV in obračunanega DDV v obliki TXT vsaj še pet let po preklicu uporabe točke 2.2 in 2.3 zgoraj omenjenega [Pravilnika o vsebini, obliki, načinu in rokih za predložitev izpisa podatkov iz elektronsko vodenih poslovnih knjig in evidenc zavezanca za davek](https://pisrs.si/pregledPredpisa?id=PRAV8099)

## 1.10 Ali mora davčni zavezanec, katerega davčno obdobje je koledarsko trimesečje, vsak mesec oddati evidenci? (13. 2. 2025)

**ODGOVOR:**

Skladno z drugim odstavkom 85.b člena ZDDV-1 davčni zavezanec vodi evidenci za vsako posamezno davčno obdobje. Davčni zavezanec, čigar davčno obdobje bo koledarsko trimesečje, ne bo oddal evidenci za vsak mesec, ampak za vsako koledarsko trimesečje.

## 1.11 V katerih primerih se v evidencah obračunanega DDV na nivoju posamezne listine (vrstice) v polju »NAČIN OBRAVNAVE« izbere vrednost 3 – samo obresti? (25. 2. 2025)

**ODGOVOR:**

Polje »NAČIN OBRAVNAVE« dovoljuje naslednje vrednosti:

1 - obračun,

2 – samoprijava obračun in obresti (popravki napak iz preteklih obdobij)

3 – samo obresti

Vrednost 3 se izpolni v primeru, ko je davčni zavezanec za napako iz preteklih obdobij, za katero je znesek DDV že vključil v obračun DDV za pretekla obdobja, v evidenci obračunanega DDV namesto vrednosti 2 izpolnil vrednost 1, zato pogoji za samoprijavo po 88.b členu ZDDV-1 niso bili izpolnjeni. Z izpolnitvijo vrednosti 3 v evidenci obračunanega DDV za tekoče davčno obdobje se od zneska DDV iz preteklih obdobij, ki ga je davčni zavezanec vključil v enega od prejšnjih obračunov DDV, obračunajo (na obračunu DDV) samo še obresti po 88.b členu ZDDV-1 in s tem so za to napako iz preteklih obdobij izpolnjeni pogoji po 88.b členu ZDDV-1 in je davčni zavezanec razbremenjen odgovornosti za prekršek.

V tekočem obračunu DDV se za to listino upoštevajo le podatki v razdelku V. Samprijava/popravek, ne pa tudi podatkov o davčni osnovi in znesku obračunanega DDV.

## 1.12 V katerih primerih se v evidencah odbitka DDV na nivoju posamezne listine (vrstice) v polju »NAČIN OBRAVNAVE« izbere vrednost 3 – samo obresti? (25. 2. 2025)

**ODGOVOR:**

Polje »NAČIN OBRAVNAVE« dovoljuje naslednje vrednosti:

1 - obračun,

2 – samoprijava obračun in obresti (popravki napak iz preteklih obdobij)

3 – samo obresti

Vrednost 3 se izpolni npr. v primeru, ko je davčni zavezanec preuranjeno uveljavljal odbitek DDV v enem izmed preteklih davčnih obdobij. Če se želi razbremeniti odgovornosti za prekršek, v evidenco odbitka DDV ponovno vnese listino in izbere vrednost 3. Na tej podlagi se obračunajo (na obračunu DDV) samo še obresti po 88.b členu ZDDV-1 in s tem so za to napako iz preteklih obdobij izpolnjeni pogoji po 88.b členu ZDDV-1.

V tekočem obračunu DDV se za to listino upoštevajo le podatki v razdelku V. Samprijava/popravek, ne pa tudi podatkov o davčni osnovi in znesku odbitka DDV.

## 1.13 Ali je treba v evidenci obračunanega DDV navesti podatke o posameznih računih (izdanih iz maloprodaje in za komunalne storitve po številkah računov in prejemnikih) oziroma je za tovrstne račune (iz maloprodaje in ponavljajoče storitve npr. telekomunikacijske storitve, komunala, voda, elektrika, plin) lahko naveden zbir računov (kot so bili posredovani v centralni informacijski sistem)? Enako vprašanje velja tudi za evidence odbitnega DDV

**ODGOVOR:**

Vsak račun, ki se nanaša na davčnega zavezanca (ne zgolj identificiranega za namene DDV, ampak davčnega zavezanca po 5. členu ZDDV-1) mora biti evidentiran posebej. Prodaja končnim potrošnikom se v evidenco obračunanega DDV evidentira z obdobnimi obračuni blagajne, ki lahko zajemajo eno ali več zaključkov blagajne po posameznih blagajniških mestih. Pri blagajniškem poslovanju se podatki v temeljne poslovne knjige in evidenco obračunanega DDV evidentirajo na podlagi obdobnih obračunov blagajne. Knjigovodsko listino torej predstavlja obdobni obračun blagajne. Ta obdobni obračun blagajne je lahko narejen na ravni posameznega blagajniškega mesta ali na ravni prodajnega mesta. Če je narejen na ravni prodajnega mesta, so vanj vključeni obračuni (blagajniški zaključki) vseh njegovih posameznih blagajniških mest. Blagajniške obračune spremljajo oziroma so preko njih dostopne izvirne knjigovodske listine (izdani računi). Dolžina blagajniškega obdobja je odvisna od organizacije dela blagajnikov in števila blagajniških dogodkov v določenem času. Obračuni blagajne se praviloma opravljajo dnevno. Izjema so lahko davčni zavezanci z majhnim obsegom oziroma nerednim poslovanjem, primeroma društva, klubi itd. Navedeno pa ne velja za zgoraj naštete storitve kot npr. telekomunikacijske, komunala, voda, plin, elektrika,….. V evidenco odbitnega DDV se ne evidentirajo prejeti računi davčnih zavezancev, ki niso identificirani za namene DDV.

## 1.14 Če je v evidenci obračunanega DDV lahko izkazan zbir računov (kot je bil posredovan v centralni informacijski sistem) ali je dovolj, če davčni zavezanec zagotavlja npr. Evidenco izdanih računov po posameznih računih iz teh rešitev specializiranih za maloprodajo oz. periodično zaračunavanje storitev in jih predloži FURS-u na zahtevo?

##

**ODGOVOR:**

Izdani računi, če so zajeti v obdobnem obračunu blagajne, se pri oddaji evidenc ne pošiljajo na FURS in se lahko predložijo na zahtevo v davčnem postopku nadzora. V evidenco obračunanega DDV se bo vedno vpisal obdobni obračun blagajne in to se bo posredovalo FURS, posamezni računi pa na zahtevo.

## 1.15 Ali bo rešitev Servisa sprejema knjige (Metode za delo s knjigami računov - /api/v1/InvoiceBook?) omogočala sprejem podatkov o evidenci obračunanega DDV oz. evidenci odbitnega DDV iz večih datotek, npr. na način, da bo davčni zavezanec lahko npr. pripravil in posredoval podatke o računih iz različnih informacijskih sistemov ločeno na FURS (in ne vse v eni datoteki)?

**ODGOVOR:**

Podatke iz evidence obračunanega DDV in evidence odbitnega DDV za določeno davčno obdobje je treba poslati na FURS v eni datoteki. Zadnja poslana verzija bo upoštevana kot veljavna.

# 2\. Predizpolnitev obračuna DDV

## 2.1. Davčni zavezanec je oddal evidenci 23. v mesecu, ki sledi mesecu obdobja evidenc. Iz predloženih evidenc oziroma podatkov v evidencah izhaja, da je davčni zavezanec opravljal transakcije znotraj Unije in je bil zato dolžan predložiti rekapitulacijsko poročilo iz 90. člena ZDDV-1. Ali bo davčni organ predizpolnil obračun DDV? (13. 2. 2025)

**ODGOVOR:**

Skladno s prvim odstavkom 88.d člena ZDDV-1 mora davčni zavezanec, če želi, da mu davčni organ predizpolni obračun DDV, evidence oddati najpozneje tri dni pred potekom roka za predložitev obračuna DDV. Ker je davčni zavezanec opravil transakcije znotraj Unije in je zato dolžan predložiti rekapitulacijsko poročilo iz 90. člena ZDDV-1, mora obračun DDV predložiti do 20. dne naslednjega meseca po poteku davčnega obdobja, to pa pomeni, da bi moral, če bi želel, da davčni organ sestavi predizpolnjen obračun DDV, oddati evidenci vsaj tri delovne dni pred potekom roka za predložitev obračuna DDV. Ker je davčni zavezanec oddal evidenci po roku, določenem za predizpolnitev obračuna, mu davčni organ ne bo predizpolnil obračuna DDV, zato ga mora davčni zavezanec oddati sam.

## 2.2. Davčni zavezanec je 8. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je 9. v mesecu predizpolnil obračun. Davčni zavezanec je v predloženih evidencah uveljavljal vračilo presežka DDV. S katerim dnem začne teči 21 dnevni rok za vračilo presežka DDV? (13. 2. 2025)

**ODGOVOR:**

Če davčni zavezanec v evidencah uveljavlja vračilo presežka DDV, se predizpolnjen obračun, skladno s petim odstavkom 88.d člena ZDDV-1, šteje za obračun davčnega zavezanca z dnem vročitve predizpolnjenega obračuna DDV davčnemu zavezancu. Vročitev se šteje za opravljeno z dnem, ko davčni organ odloži predizpolnjen obračun DDV v informacijski sistem davčnega organa, do katerega dostopa davčni zavezanec. Navedeno pomeni, da je obračun oddan 9. v mesecu in od tega dne začne teči 21 dnevni rok za vračilo presežka DDV.

## 2.3. Davčni zavezanec je 8. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je 9. v mesecu predizpolnil obračun. Davčni zavezanec je v predloženih evidencah uveljavljal vračilo presežka DDV. Ali lahko davčni zavezanec ponovno sam odda obračun na eDavkih? (13. 2. 2025)

**ODGOVOR:**

Ne, skladno s petim odstavkom 88.d člena ZDDV-1 se, če davčni zavezanec v evidencah uveljavlja vračilo presežka DDV, šteje za obračun davčnega zavezanca z dnem vročitve predizpolnjenega obračuna DDV. Davčni zavezanec, ki je že pred potekom roka za predložitev obračuna predložil obračun DDV in je po tem obračunu zahteval vračilo DDV, že vloženi obračun ne more več nadomesti z novim. Navedeno tako ne odstopa od dosedanje prakse oddaje obračunov DDV z uveljavljanjem zahtevka za vračilo presežka DDV.

## 2.4. Davčni zavezanec je 22. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je še isti dan predizpolnil obračun. Iz predloženih evidenc oziroma podatkov v evidencah ne izhaja, da je davčni zavezanec uveljavljal vračilo presežka DDV, niti ni opravljal transakcij znotraj Unije, za kar bi bil dolžan predložiti rekapitulacijsko poročilo. Ali lahko davčni zavezanec ponovno odda evidenci, davčni organ pa mu bo ponovno predizpolnil obračun? (13. 2. 2025)

**ODGOVOR:**

Da, evidenci lahko ponovno odda. Davčni organ bo davčnemu zavezancu ponovno predizpolnil obračun DDV, če bo evidenci oddal vsaj tri delovne dni pred potekom roka za predložitev obračuna DDV.

## 2.5. Davčni zavezanec je 22. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je še isti dan predizpolnil obračun. Iz predloženih evidenc oziroma podatkov v evidencah ne izhaja, da je davčni zavezanec uveljavljal vračilo presežka DDV, niti ni opravljal transakcij znotraj Unije, za kar bi bil dolžan predložiti rekapitulacijsko poročilo. Ali lahko davčni zavezanec sam na eDavkih odda obračun? (13. 2. 2025)

**ODGOVOR:**

Da, davčni zavezanec lahko do poteka roka za predložitev sam odda obračun DDV na eDavkih.

## 2.6. Davčni zavezanec je 22. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je še isti dan predizpolnil obračun. Iz predloženih evidenc oziroma podatkov v evidencah ne izhaja, da je davčni zavezanec uveljavljal vračilo presežka DDV, niti ni opravljal transakcij znotraj Unije, za kar bi bil dolžan predložiti rekapitulacijsko poročilo. Davčni zavezanec je nato 24. v mesecu sam oddal obračun DDV. Ali lahko davčni zavezanec 25. v mesecu ponovno pošlje evidenci in bo davčni organ ponovno predizpolnil obračun DDV? (13. 2. 2025)

**ODGOVOR:**

Skladno s prvim odstavkom 88.d člena ZDDV-1 bo davčni organ sestavil predizpolnjen obračun zgolj takrat, ko davčni zavezanec sam še ni predložil obračuna DDV. Ker je davčni zavezanec že sam oddal obračun DDV, davčni organ kljub ponovni oddaji evidenc ne bo več preizpolnil obračuna DDV.

## 2.7. Davčni zavezanec je 22. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ je še isti dan predizpolnil obračun. Iz predloženih evidenc oziroma podatkov v evidencah ne izhaja, da je davčni zavezanec uveljavljal vračilo presežka DDV, niti ni opravljal transakcij znotraj Unije, za kar bi bil dolžan predložiti rekapitulacijsko poročilo. Davčni zavezanec je nato 24. v mesecu sam oddal obračun DDV, ki se razlikuje od že predizpolnjenega obračuna na podlagi predloženih evidenc. Ali mora davčni zavezanec ponovno poslati evidenci za to obdobje, ki morajo biti skladne z oddanim obračunom? (13. 2. 2025)

**ODGOVOR:**

Če davčni zavezanec za davčno obdobje predloži obračun, ki ni skladen s podatki v že predloženih evidencah, mora skladno s četrtim odstavkom 85.b člena ZDDV-1 davčnemu organu nemudoma oziroma najpozneje v treh delovnih dneh od predložitve obračuna DDV predložiti popravek evidenc.

## 2.8 Davčni zavezanec je 24. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Davčni organ do zadnjega delovnega dne v mesecu ni predizpolnil obračuna DDV. Ali mora davčni zavezanec sam oddati obračun? (13. 2. 2025)

**ODGOVOR:**

Skladno s šestim odstavkom 88.d člena ZDDV-1 mora davčni zavezanec sam predložiti obračun DDV v predpisanem roku, če ni prejel predizpolnjenega obračuna DDV. Navedeno pomeni, da mora davčni zavezanec, ne glede na razloge, ki so lahko nastali na strani davčnega zavezanca ali davčnega organa, vedno sam oddati obračun DDV do poteka roka za predložitev, če ni prejel predizpolnjenega obračuna DDV.

## 2.9. Davčni zavezanec je 15. v mesecu, ki sledi mesecu obdobja evidenc, oddal evidenci. Iz predloženih evidenc oziroma podatkov v evidencah izhaja, da je davčni zavezanec opravljal transakcije znotraj Unije, za kar je bil dolžan predložiti rekapitulacijsko poročilo. Davčni organ mu do 20. dne v mesecu ni predizpolnil obračuna DDV. Do kdaj mora davčni zavezanec sam oddati obračun? (13. 2. 2025)

**ODGOVOR:**

Davčni zavezanec mora najkasneje do 20. dne naslednjega meseca po poteku davčnega obdobja oddati obračun DDV, kot je določeno v tretjem odstavku 88. člena ZDDV-1.

## 2.10. Davčni zavezanec je oddal evidenci po roku za predložitev, npr. 10. v mesecu, ki sledi mesecu, v katerem bi moral predložiti evidenci. Obračuna DDV za to davčno obdobje še ni predložil. Bo davčni organ naredil predizpolnitev obračuna DDV?

**ODGOVOR:**

Ne. Skladno s prvim odstavkom 88.d člena ZDDV-1 mora davčni zavezanec, če želi, da mu davčni organ predizpolni obračun DDV, evidence oddati najpozneje tri dni pred potekom roka za predložitev obračuna DDV.

## 2.11. Davčni organ je na predlog davčnega zavezanca, ki iz opravičljivih razlogov ni mogel predložiti davčnega obračuna v predpisanem roku, na podlagi 52. člena Zakona o davčnem postopku dovolil predložitev davčnega obračuna po izteku predpisanega roka. Ali se rok za predložitev evidenc tudi prestavi? Bo davčni organ naredil predizpolnitev obračuna DDV?

**ODGOVOR:**

Ne, rok za predložitev evidenc se v tem primeru ne prestavi. V skladu s prvim odstavkom 85.b člena ZDDV-1 mora vsak davčni zavezanec predložiti evidenci davčnemu organu najpozneje do roka, v katerem mora predložiti obračun DDV v skladu z 88. členom tega zakona. Davčni zavezanec mora v glavi evidenc v tem primeru označiti polje Oddaja po roku. V tem primeru predizpolnitev obračuna ne bo narejena.