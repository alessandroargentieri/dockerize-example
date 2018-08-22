
l'architettura consta di:

- front end in Vue js in cui scriviamo la mail e inviamo la richiesta tramite POST per visualizzare le info utente e il carrello ad esso associato
- microservizio aggregatore che ricevuta la mail invia una richiesta al microservizio dell'utente e, se esiste, invia la richiesta al microservizio del carrello per aggregare i dati
- microservizio che recupera i dati dell'utente
- microservizio che recupera il carrello associato all'utente

Ho creato i singoli servizi e provati in locale 
Ho fatto ./mvnw clean package per creare i jar in target di ogni microservizio
Ho creato i Dockerfile in ogni cartella di ogni microservizio (fare attenzione!)

Per i servizi con spring boot mi servono le variabili d'ambiente (anche in application.properties e con @Value) ed uso java 8 alpine come immagine di base e il fat jar generato prima con il maven package.
Per il front end metto tutto nella cartella build e poi chiedo a docker di copiarla e inserirla in /html dell'immagine base di nginx che verrà scaricata tramite le istruzioni contenute nel Dockerfile.
Avvio Docker

Creiamo le immagini usando i dockerfile

vado nella cartella dell'aggregator (non dimenticare il punto al termine dell'istruzione seguente):
docker build -f Dockerfile -t alessandroargentieri/dockerize-aggregator .

vado nella cartella dello user service (non dimenticare il punto al termine dell'istruzione seguente):
docker build -f Dockerfile -t alessandroargentieri/dockerize-user-service .

vado nella cartella del chart service (non dimenticare il punto al termine dell'istruzione seguente):
docker build -f Dockerfile -t alessandroargentieri/dockerize-chart-service .

vado nella cartella del front-end (non dimenticare il punto al termine dell'istruzione seguente):
docker build -f Dockerfile -t alessandroargentieri/dockerize-frontend .

controllo le immagini create:
docker images

Ora che ho le immagini voglio creare una subnet per dare ai miei container (che creero') un IP statico.

controllo le subnet presenti:
docker network ls

cancello la rete che usa la mia stessa subnet (se esiste e non mi serve):
docker network rm <sha>

creo una nuova subnet che chiamo docknet:
docker network create --subnet=172.18.0.0/16 docknet

Adesso creo e mando in run i container partendo dalle immagini create prima.
In quest caso non ho bisogno di essere nella cartella dei singoli progetti perchè agisco con Docker a livello globale.
Ad ogni container che creo specifico la subnet, l'IP statico, la porta di ascolto interna ed esterna, le eventuali variabili d'ambiente ed ovviamente l'immagine che voglio utilizzare:

docker run --net docknet --ip 172.18.0.27 -d -p 80:80 alessandroargentieri/dockerize-frontend
docker run --net docknet --ip 172.18.0.22 -d -p 8081:8081 alessandroargentieri/dockerize-user-service
docker run --net docknet --ip 172.18.0.23 -d -p 8082:8082 alessandroargentieri/dockerize-chart-service
docker run --net docknet --ip 172.18.0.20 -d -p 8080:8080 -e AGGREGATOR_USER_SERVICE_ADDRESS='http://172.18.0.22:8081/user' -e AGGREGATOR_CHART_SERVICE_ADDRESS='http://172.18.0.23:8082/chart' alessandroargentieri/dockerize-aggregator

Ora i container sono avviati e posso controllare con 
docker ps

I container totali (avviati e stoppati sono)
docker ps -a

Posso stopparli con:
docker stop <sha>

Farli ripartire con:
docker start <sha>

eliminarli con:
docker rm <sha>

le immagini sono:
docker images

le immagini possono essere cancellate con:
docker rmi <sha>

posso ispezionare un container con:
docker inspect <sha>

Bando alle ciance, il nostro frontend ci aspetta (se i container sono avviati) all'indirizzo http://localhost:80

Se volessi eliminare tutti i container in docker:
docker rm `docker ps --no-trunc -aq`

PS: se volessi pushare le immagini create su DockerHub basta fare l'accesso:
docker login -u="$USER_ID" -p="$USER_PWD"

push dell'immagine su dockerhub:
docker push $USER_ID/nomeimmagine

pull dell'immagine da dockerhub (quando ci servirà):
docker pull $USER_ID/nomeimmagine