# Destination API

Spring Boot REST API for managing webhook and API destinations.

## Tech Stack

- **Java 17** + **Spring Boot 3.4.4**
- **Spring Data JPA** (Hibernate)
- **H2** (local dev) / **PostgreSQL** (production)
- **Swagger UI** via springdoc-openapi
- **Lombok** for boilerplate reduction
- **Bean Validation** for request validation

## Project Structure

```
src/main/java/com/destination/api/
├── config/              # Swagger & CORS configuration
├── controller/          # REST controllers
├── dto/                 # Request/Response DTOs + ApiResponse wrapper
├── entity/              # JPA entities
├── exception/           # Custom exceptions & global handler
├── repository/          # Spring Data repositories
└── service/             # Service interface & implementation
```

## API Endpoints

| Method | Endpoint             | Description              |
|--------|----------------------|--------------------------|
| GET    | /destinations        | List all destinations    |
| GET    | /destinations/{id}   | Get destination by ID    |
| POST   | /destinations        | Create a new destination |
| PUT    | /destinations/{id}   | Update a destination     |
| DELETE | /destinations/{id}   | Delete a destination     |

## Running Locally

```bash
# Build
./mvnw clean package

# Run
./mvnw spring-boot:run
```

The app starts on **http://localhost:8080**.

### URLs

| URL                                        | Description        |
|--------------------------------------------|--------------------|
| http://localhost:8080/swagger-ui.html       | Swagger UI         |
| http://localhost:8080/api-docs              | OpenAPI JSON       |
| http://localhost:8080/h2-console            | H2 Database Console|

## Deploying to Render

1. Create a **Web Service** on Render.
2. Set the build command: `./mvnw clean package -DskipTests`
3. Set the start command: `java -jar target/destination-api-1.0.0.jar`
4. Add environment variables:
   - `SPRING_PROFILES_ACTIVE` = `render`
   - `DATABASE_URL` = your PostgreSQL connection URL
   - `DB_USERNAME` = your DB username
   - `DB_PASSWORD` = your DB password
   - `DB_DRIVER` = `org.postgresql.Driver`
   - `DB_DIALECT` = `org.hibernate.dialect.PostgreSQLDialect`

## Sample Request Body

```json
{
  "name": "Slack Webhook",
  "type": "webhook",
  "url": "https://hooks.slack.com/services/xxx",
  "method": "POST",
  "headers": "{\"Authorization\":\"Bearer token\"}",
  "retryCount": 3
}
```
