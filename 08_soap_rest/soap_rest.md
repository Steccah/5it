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

# SOAP e REST

---

## Introduzione
Il Web rappresenta un’enorme piattaforma per la condivisione di documenti in formato ipertestuale interconnessi mediante parole chiave, indipendentemente dalla piattaforma hardware o software utilizzata. Inoltre il web si è evoluto grazie alla standardizzazione di alcuni semplici concetti, come:
- URI: il meccanismo per individuare risorse in una rete
- Http: il protocollo semplice e leggero per richiedere una risorsa a una macchina
- HTML: il linguaggio per la rappresentazione dei contenuti

Il Web è diventato “una piattaforma applicativa distribuita” dove ai documenti testuali si sono aggiunti contenuti multimediali, alle staticità delle pagine HTML dei primi anni si è passati a un’interazione tra più componenti software e a una dinamicità anche dovuta alla presenza di applicazioni software interoperabili: vennero introdotte lato server inizialmente le CGI e successivamente JSP, PHP, ASP ecc.

---

## Introduzione

L'evoluzione ha portato con sé una serie di problemi, tra cui il più importante è l'integrazione:

1. Tra le applicazioni informatiche sviluppate in modo indipendente in diverse parti del mondo.
2. Tra le applicazioni esistenti all'interno di un'azienda, a causa delle diverse tecnologie presenti all'interno dell'organizzazione.

Inoltre, il grande successo del Web negli anni passati ha spinto la rete a svolgere un ruolo più completo, per soddisfare le nuove esigenze legate alle interazioni tra applicazioni in contesti diversi.

---

## Introduzione

Negli anni Novanta nascono architetture complesse, vincolate dalla limitatezza del protocollo di comunicazione e dalle tecnologie coinvolte, che cercano comunque di fornire specifiche per rappresentare gli oggetti che vengono inviati e ricevuti. Tra le più famose ricordiamo CORBA (Common Object Request Broker Architecture),  Java RMI (Remote Method Invocation) e DCOM (Distributed Component Object Model).

Per superare i limiti del protocollo e garantire l'interoperabilità tra sistemi e piattaforme diverse, si sono sviluppate soluzioni RPC (Remote Procedure Call) che utilizzano XML. Questi meccanismi consentono a client e server di essere implementati con linguaggi e tecnologie diverse.

---

## Web service

Il passo successivo è stato quello di cercare di rendere standard le tecnologie coinvolte: nascono i primi Web Service
Un Web Service rappresenta la disponibilità di un servizio attraverso il Web, per esempio un servizio di ricerca di un volo, le disponibilità di un posto vengono restituite grazie ad un collegamento in tempo reale con il sistema di prenotazione della compagnia aerea, attraverso un **API** (Application Programming Interface) che espone le funzionalità del sistema.

---

## Web service
Per poter far comunicare tra loro applicazioni sviluppate in linguaggi diversi, è necessario che esse utilizzino un linguaggio comune per lo scambio di informazioni, come XML o JSON. Inoltre, è necessario che le applicazioni siano in grado di comunicare con un protocollo comune, come HTTP.

> "Un WS è un’applicazione software identificata da un URI, le cui interfacce pubbliche e relativi binding sono definiti e descritti in XML. La sua definizione può essere trovata da altre applicazioni software. Questi ultimi possono poi interagire con il WS seguendo le direttive presenti nella definizione del servizio, usando messaggi XML trasportati da protocolli Internet.""
> 
> [Web Services Architecture](https://www.w3.org/TR/ws-arch/)

---

## Web service

Un Web Service non trasmette testo e grafica, ma soddisfa richieste, che interagiscono direttamente tra due computer spesso senza alcun intervento umano: i computer possono utilizzare i servizi Web per comunicare direttamente tra loro a basso livello, inviare e ricevere dati, condividere funzioni e metodi.

> Un servizio è quindi una risorsa che offre un set di funzionalità astratte mediante un’interfaccia che ne nasconde i dettagli implementativi garantendo indipendenza dalla sua implementazione.

Un Web Service è un framework utilizzato per consentire la comunicazione tra due computer tramite il Web, utilizzando una delle due soluzioni seguenti:

- Web Service SOAP (medium Http (POST) e formato XML)
- Web Service REST (medium Http (POST, GET, PUT, DELETE) e formato XML, JSON, Text)

---

## Web service

Quando uno sviluppatore crea un Web Service, si deve preoccupare di definire:
1. la logica di funzionamento del servizio, ovvero quello che dovrà fare: questo può spaziare da una semplice classe a un’applicazione molto complessa
2. il Web Container (Server) su cui verrà installato (per esempio Apache, Tomcat, JBoss, GlassFish) e che ne consentirà l’uso da parte dei client.

---

## L'architettura SOA

L'architettura SOA (Service Oriented Architecture) è un modello architetturale che permette di realizzare applicazioni software distribuite, basate su servizi, che interagiscono tra loro.

L’architettura SOA deve fornire una piattaforma per costruire servizi applicativi aventi le seguenti caratteristiche:

- loosely coupled: l’utente di un servizio non deve preoccuparsi di scegliere con quali servizi comunicare, “ci pensa” l’infrastruttura
- location transparent: l’infrastruttura deve nascondere quanti più dettagli tecnici possibili, relativi a tecnologie tra loro differenti, al richiedente del servizio
- protocol independent: deve essere possibile aggiornare in qualunque momento le implementazioni, senza modificare le interfacce

---

## L'architettura SOA

Gli attori principali di un’architettura SOA sono 3:

- **Service Provider**: è il fornitore del servizio, che lo rende disponibile agli utenti
- **Service Registry**: contiene il repository dei servizi disponibili, con le relative interfacce. Fornisce al Service Consumer l'interface contract del Service Provider. Praticamente è un catalogo dei servizi disponibili
- **Service Consumer**: è l'utente del servizio, che ne fa richiesta al Service Registry

---

## L'architettura SOA
In sintesi la dinamica avviene in tre fasi:
1. Richiesta del servizio da parte del Service Consumer
2. Richiesta della descrizione del servizio
3. Il Service Consumer utilizza l'interface contract per invocare il servizio

Naturalmente affinché un servizio sia disponibile deve essere pubblicata (`publish`) nel Service Registry dal Service Provider una copia della descrizione del servizio (service description)
Il servizio può essere cercato con `find` e poi invocato con `bind` e `invoke`.

---

## L'architettura SOA
Ad oggi ci sono due modi per implementare un'architettura SOA:
- SOAP (Simple Object Access Protocol)
- REST (REpresentational State Transfer)
