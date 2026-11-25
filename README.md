# CAR-API

A REST API for requesting car transportation services, built with **Java** and **Spring Boot**.

> **Project status: in progress.** This API is under active development. Only the driver
> domain and a few read endpoints are implemented so far. See the [Roadmap](#roadmap) for
> what is planned.

## About

CAR-API aims to expose the backend needed to request a car transportation service. The
current implementation provides a driver entity persisted in an in-memory database and
read-only endpoints to list and fetch drivers. More domains (passengers, rides,
vehicles, etc.) and write operations are still to come.

## Tech Stack

| Technology | Version / Notes |
| --- | --- |
| Java | 25 |
| Spring Boot | 4.2.0 |
| Spring Web MVC | REST controllers |
| Spring Data JPA | Repositories over JPA entities |
| H2 Database | In-memory, runtime |
| Lombok | Boilerplate reduction (`@Data`) |
| Spring Boot DevTools | Hot reload during development |
| Maven | Wrapper included (`mvnw`) |
| JUnit 5 | Testing via `spring-boot-starter-*-test` |

## Project Structure

```
src/main/java/com/joao/api
├── ApiApplication.java              # Spring Boot entry point
└── car
    ├── domain
    │   ├── Driver.java              # JPA entity
    │   └── DriverRepository.java    # JpaRepository<Driver, Long>
    └── interfaces
        └── DriverAPI.java           # REST controller for drivers
```

The code is organized by feature (`car`) with a light layering of `domain`
(entities and repositories) and `interfaces` (HTTP endpoints).

## API Endpoints

Base URL: `http://localhost:8080`

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/drivers` | List all drivers |
| `GET` | `/drivers/{id}` | Get a single driver by ID |

All responses are `application/json`.

Example:

```bash
curl http://localhost:8080/drivers
curl http://localhost:8080/drivers/1
```

## Getting Started

### Prerequisites

- **JDK 25** installed and available on your `PATH`
- No external database needed — the app uses an in-memory H2 database

### Run the application

Using the Maven wrapper:

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

The API will be available at `http://localhost:8080`.

### Build and test

```bash
./mvnw clean package   # build (runs tests)
./mvnw test            # tests only
```

### Run the packaged jar

```bash
./mvnw clean package
java -jar target/api-0.0.1-SNAPSHOT.jar
```

## Roadmap

- [x] Driver domain model and repository
- [x] List drivers (`GET /drivers`)
- [x] Get driver by ID (`GET /drivers/{id}`)
- [ ] Create / update / delete drivers
- [ ] Passenger domain and endpoints
- [ ] Ride / transportation request flow
- [ ] Vehicle domain
- [ ] Input validation and proper error handling (`404`, `400`, etc.)
- [ ] DTOs and mapping layer (avoid exposing entities directly)
- [ ] Automated tests for controllers and repositories
- [ ] API documentation (OpenAPI / Swagger)
- [ ] Database configuration for production (replace in-memory H2)

## Notes

- The H2 console dependency is present; to enable it, add to
  `src/main/resources/application.properties`:

  ```properties
  spring.h2.console.enabled=true
  ```

- Since the database is in-memory, data is lost on every restart.

## Author

**João Marcos Santana Gomes**

- GitHub: [@joaomarcosg](https://github.com/joaomarcosg)

## License

No license has been defined for this project yet.
