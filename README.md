# Your Car Your Way, PoC Tchat

Preuve de concept d'un tchat en temps réel entre un client et le service client. Elle valide les choix d'architecture sur une fonctionnalité ciblée.

## Stack

- Backend : Spring Boot (Java 21), WebSocket avec STOMP, Spring Data JPA, base H2 en mémoire.
- Frontend : Angular (ajouté dans une prochaine étape).
- Temps réel : WebSocket exposé via SockJS et STOMP.

## Prérequis

- JDK 21
- Git

## Lancer le backend

Le projet inclut le wrapper Maven, inutile d'installer Maven.

```bash
cd backend
./mvnw spring-boot:run
```

Le backend démarre sur http://localhost:8080. L'historique des messages est exposé sur http://localhost:8080/api/messages.
