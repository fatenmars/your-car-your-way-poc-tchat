# Your Car Your Way, PoC Tchat

Preuve de concept d'un tchat en temps réel entre un client et le service client. Elle valide les choix d'architecture sur une fonctionnalité ciblée.

## Stack

- Backend : Spring Boot 4.1.1 (Java 21), WebSocket avec STOMP, Spring Data JPA, base H2 en mémoire.
- Frontend : Angular 21.
- Temps réel : WebSocket exposé via SockJS et STOMP.

## Structure du projet

```text
your-car-your-way-poc-tchat/
  backend/    application Spring Boot (API REST et WebSocket)
  frontend/   application Angular
  README.md
```

## Prérequis

- JDK 21
- Node.js 22 ou 24, avec npm
- Git

## Lancer le projet

Le tchat nécessite le backend et le frontend démarrés en même temps, dans deux terminaux séparés. Lance d'abord le backend, puis le frontend.

### Backend

Le projet inclut le wrapper Maven, inutile d'installer Maven.

```bash
cd backend
./mvnw spring-boot:run
```

Le backend démarre sur http://localhost:8080. L'historique des messages est exposé sur http://localhost:8080/api/messages.

### Frontend

```bash
cd frontend
npm install
npm start
```

Le frontend démarre sur http://localhost:4200.

## Tester le tchat

Ouvre http://localhost:4200 dans deux onglets. Saisis un nom, envoie un message depuis un onglet, il apparaît en temps réel dans l'autre.
