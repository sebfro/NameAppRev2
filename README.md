Det er tester i mappen com.example.nameapplicationrev2(test).

Alle klasser i denne mappen er laget av gruppen med unntak av ExampleTest. Disse kan kjøres ved å høyreklikke på dem og deretter velge kjør.

CreateListTest tester at selve objektet oppfører seg som forventer og inneholder dataene som den tildeles. I tillegg testes dets oppførsel i en Arrayliste, ingen problemer oppdaget.

I de to resterende test klassene i denne mappen testes de to adapterene som brukes i appen. Begge to bare tester itemCount og avslører ingen problemer.

Resten av testene er i mappen com.example.nameapplicationrev2(androidTest).

Trykk på dropdown menyen til venstre for kjør knappen (grønn pil) og velg appTests. Deretter kjør applikasjonen.
Hvis appTests ikke er der, velg edit configurations og trykk på den grønne pilen og velg android test og kall den appTest og sett module til app.
LearningActivityTest.

Fant ut at EditText for å gjette navnet på personen i bidlet ikke utførte noen form for validering. Ingen error, men kan lede til problemer. Test klassen tester bare at den er tom ved aktivitet start. Fremtidig test vil være i sjekke at den klarer å håndtere “code injection” og ikke lar bruker skrive navn med annet en bokstaver.

Videre testes det om score telles opp korrekt, ingen problemer oppdaget. Dette testes ved hjelp av en for løkke som går 100 ganger. EditText for å submit blir satt til en av de tre alternativene også klikkes knappen, deretter sjekkes det om det var korrekt, hvis det var korrekt økes en int variabel som deretter sammenlignes med LearningActivity klassen sin score variabel.

Når for løkken er ferdig blir slutt summen som test klassen bruker sammenlignet med LearningActivity en siste gang.

Deretter sjekkes det om det er tilfeldig rekkefølge, denne testen er ikke perfekt. Ettersom den kun sjekker om det er tre forskjellige drawables som dukker i hvilken som helst rekkefølge. Den funker stort sett på samme måte som den beskrevet over. Men den sjekker ikke om det var korrekt eller ikke. Istedenfor sjekker den om drawablen som vises ligger i en liste. Hvis den er i listen skjer ingenting. Hvis den ikke er i listen så legges den til, når listen sin lengede er tre settes i = 100 og for løkken avslutter.

Deretter sjekkes det om listen sin lengde er tre eller ikke.

Ingen feil oppdaget, men bør forbedres slik at den også sjekker at bildene ikke kommer i en hvis rekkefølge hver gang.

Tilslutt sjekker den siste metodene bare om knappene fungerer. Ingen problemer oppdaget.

menuTest
Denne testen tester bare knappene siden den ikke gjør mye mer enn det, visste ikke noe nye problemer.

Denne er for å teste mainActivity som hovedsakelig bare binder sammen resten av aktivitetene til appen.
Andre error

Oppdaget denne error-en da jeg testet appen på min personlige mobil Samsung s6 med android 6.0.1 (API 23). Denne error oppstår ikke ved testing av appen på en nexus 5x med API 25. Og fra det jeg har lest virker det som et problem knyttet til Samsung sin touchwiz.

E/SpannableStringBuilder: SPAN_EXCLUSIVE_EXCLUSIVE spans cannot have a zero length

Error skaper ingen problemer ved bruk av appen på s6, kaster bare error og ingenting mer.

PS. Har brukt sourcetree til å laste prosjektet opp og ned uten å røre android studio sin innebygde github funksjon.
