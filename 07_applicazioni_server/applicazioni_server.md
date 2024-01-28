---
marp: true
---

<style>
:root {
  font-family: 'SF Pro Text', serif !important;
}

code {
   font-family:  "Fantasque Sans Mono", monospace !important;
}

h1 {
  font-size: 2.5em !important;
  color: #1E1E1E !important;
}

section{
  justify-content: flex-start;
}

img[alt~="right"] {
  display: block;
  margin: 0 0;
  float: right;
}

img[alt~="center"] {
  display: block;
  margin: 0 auto;
}
</style>

# Applicazioni lato server

---

## Applicazioni lato server

Con il termine programmazione server-side viene indicato il meccanismo mediante il quale tutto o parte del documento richiesto dal client, e atteso in formato HTML, viene generato in seguito a un’elaborazione che viene eseguita sul server, cioè il processo Web server genera dinamicamente la risposta in funzione della richiesta e dei parametri che vengono inclusi con essa.

>Per esempio, se il client chiede gli orari dei treni per una certa destinazione e per una certa data la risposta del server è naturalmente sempre diversa e, di conseguenza, la pagina che verrà generata e inviata al client dovrà essere elaborata volta per volta e generata per ogni caso specifico.

---

## Applicazioni lato server
Il Web server deve essere opportunamente configurato e strutturato per mandare in esecuzione uno specifico programma in modo che generi il contenuto "dinamico" al momento della richiesta: questa elaborazione che avviene sul server prende il nome di elaborazione server-side e la programmazione di componenti software che vengono elaborati sul server, di conseguenza, viene chiamata programmazione server-side.

Oggi sono disponibili diverse tecniche di programmazione server-side che si differenziano per:
- il linguaggio di programmazione utilizzato
- i web server sui quali possono essere eseguiti
- i meccanismi di "aggancio" al web server
- l'ambito applicativo

---

## Applicazioni lato server

Una prima classificazione può essere fatta in base alla “relazione“ che questi programmi hanno con l’HTML, e cioè:
- Codice separato:
    - CGI (Common Gateway Interface)
    - Java Servlet
    - NSAPI (Netscape Server API) / ASAPI (Apache Server API) / ISAPI (Internet Server API)
- Codice incorporato:
    - ASP (Active Server Pages)
    - PHP
    - JSP (Java Server Pages)

---

## Applicazioni lato server
In HTML, il meccanismo dei form consente di inviare informazioni da un Web browser client-side a un programma in esecuzione server-side. Nonostante sia considerato "rudimentale, datato e obsoleto", è lo strumento essenziale per trasformare un Web browser in un'interfaccia grafica universale. Possiamo definire componenti interattivi come text box, combo-box e check-box, che inviano i dati inseriti come parametri al server quando viene premuto un pulsante di submit, generalmente denominato "Conferma". Questi dati possono poi essere utilizzati per eseguire interrogazioni o elaborazioni appropriate.

---

## Modello a codice separato

Nei modelli a codice separato abbiamo tre possibili alternative: CGI, Java servlet e NSAPI.

---

## CGI (Common Gateway Interface)

Il Common Gateway Interface (CGI) è un protocollo che permette di far interagire un server web con un programma esterno, detto CGI script, che può essere scritto in diversi linguaggi di programmazione. Il CGI script viene eseguito dal server web ogni volta che un utente richiede una pagina web che richiede l'esecuzione di tale script. Il risultato dell'esecuzione dello script viene inviato al client come una pagina web. Le operazioni si svolgono così:
1. in una pagina HTML il client invia al server la richiesta di eseguire un programma CGI con alcuni parametri e dati in ingresso, utilizzando il protocollo HTTP
2. il server esegue il programma CGI, passandogli i parametri e i dati in ingresso
3. il programma CGI esegue le operazioni opportune e comunica al server i dati elaborati in una pagina HTML, sempre utilizzando l’interfaccia CGI
4. il server invia al client la pagina HTML generata dal programma CGI

---

## Servlet

Un'alternativa a CGI è rappresentata dalle servlet, che sono programmi scritti in Java che vengono eseguiti da un server Web. Le servlet sono state progettate per superare i limiti delle CGI, in particolare per quanto riguarda la portabilità. Le servlet sono state progettate per essere indipendenti dalla piattaforma e dal server.
Un'altra differenza è che gli script CGI vengono caricati ed eseguiti una volta per richiesta, mentre le servlet vengono caricate una volta e possono gestire più richieste attraverso i thread, riducendo così il tempo di caricamento e l'utilizzo della memoria.

---

## NSAPI

Essendo che NSAPI non è uno standard, le applicazioni che lo utilizzando non sono portabili per ogni server.

>Essendo legate al tipo di server e non essendo standard esulano dalla nostra trattazione.