# Selfhosting

## Cos'è il selfhosting?

Il selfhosting è la pratica di ospitare e gestire i propri servizi e applicazioni web. Questo può essere fatto su un server dedicato, un VPS o un computer personale. Il selfhosting è una pratica molto popolare tra gli appassionati di tecnologia e gli sviluppatori, poiché offre un maggiore controllo e flessibilità rispetto all'utilizzo di servizi di terze parti, nonché la garanzia che i propri dati siano al sicuro e non siano condivisi con terze parti.

## Perché fare selfhosting?

Ci sono molti motivi per fare selfhosting, tra cui:

- **Controllo**: Con il selfhosting, hai il controllo completo sui tuoi dati e sulle tue applicazioni. Puoi personalizzare e configurare i servizi come preferisci, senza dover dipendere da terze parti.
- **Privacy**: Quando utilizzi servizi di terze parti, i tuoi dati possono essere condivisi con terze parti o utilizzati per scopi pubblicitari. Con il selfhosting, i tuoi dati sono al sicuro e non vengono condivisi con nessuno.
- **Sicurezza**: Quando ospiti i tuoi servizi, puoi garantire che siano configurati in modo sicuro e che siano protetti da attacchi informatici e violazioni della sicurezza.
- **Flessibilità**: Con il selfhosting, sei libero di installare qualsiasi applicazione o servizio desideri e di personalizzarlo come preferisci. Non sei limitato dalle funzionalità o dalle politiche di terze parti.
- **Risparmio economico**: Il selfhosting **PUÒ** essere più economico a lungo termine rispetto all'utilizzo di servizi di terze parti, poiché non devi pagare abbonamenti o licenze.
- **Apprendimento**: Il selfhosting è un ottimo modo per imparare di più sulla gestione dei server e sulla la sicurezza informatica.
- **Flex**: Ci si può vantare di avere un server personale.

## Cosa posso selfhostare?

Ci sono molte applicazioni e servizi che puoi selfhostare, tra cui:

- **Servizi google**: Come Drive, Calendar e Photos, puoi selfhostare Nextcloud e/o Immich.
- **Email**: Puoi selfhostare un server di posta elettronica come mailcow.
- **Gestione password**: Puoi selfhostare Bitwarden, o meglio ancora Vaultwarden.
- **Media server**: Puoi selfhostare Plex, Jellyfin o Emby, combinandoli con Sonarr e Radarr, Qbittorrent e Overseer/Jellyseer.
- **Gestione progetti**: Puoi selfhostare Gitea o Gitlab.
- **Web server**: Puoi selfhostare un web server come Nginx o Apache.
- **LLM**: Puoi selfhostare un large language model llama3, gemma o phi3.


## Selfhostare LLM con Ollama

Ollama è un progetto open source che ti permette di selfhostare degli LLM. Ci sono più metodi di installazione, ufficialmente nativo e docker.

`docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama`

Installerà Ollama in un container docker, esponendo la porta 11434.

A noi non interessa ollama senza interfaccia grafica, quindi selfhosteremo OpenWebUI, con Ollama integrato.

`docker run -d -p 3000:8080 -v ollama:/root/.ollama -v open-webui:/app/backend/data --name open-webui --restart always ghcr.io/open-webui/open-webui:ollama`

Questo comando installerà OpenWebUI in un container docker, esponendo la porta 3000.