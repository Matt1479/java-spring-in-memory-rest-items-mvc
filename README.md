# In-Memory REST Items MVC

A Spring Boot application for practicing server-side web development with Spring MVC and Thymeleaf.

The application provides both a REST API and a server-rendered web interface for performing CRUD (Create, Read, Update, Delete) operations on items.

The REST API is handled by a `@RestController`, while a separate `@Controller` serves HTML views rendered with Thymeleaf. Both controllers share the same service and in-memory data store.

The project is a continuation of my previous projects:

- [In-Memory REST Items](https://github.com/Matt1479/java-spring-in-memory-rest-items)
- [Consuming In-Memory REST Items](https://github.com/Matt1479/java-spring-consuming-in-memory-rest-items)

Check out my [notes](docs/notes.md).

## Tech Stack

- Java
- Spring Boot:
    - Dependencies:
        - Spring Web
        - Thymeleaf
        - Spring Boot DevTools
- Bootstrap
- Maven

## Features

- REST API for CRUD operations
- Server-rendered HTML pages using Spring MVC and Thymeleaf
- Shared service layer between REST and MVC controllers
- In-memory `HashMap` data store
- Thymeleaf fragments for reusable page elements
- Flash messages for success and error feedback
- HTML form handling with `@ModelAttribute`
- HTTP method overriding for DELETE forms using Spring's hidden method support
- Basic manual input validation

All data is stored in memory, so it is lost when the application stops.

## Web Interface

The web interface is available at:

`http://localhost:8080/`

## MVC Routes

| Method | Endpoint | Description |
|---|---|---|
| GET | `/` | Home page |
| GET | `/items` | View all items |
| GET | `/items/{id}` | View an item |
| GET | `/items/new` | Show create-item form |
| POST | `/items/new` | Create an item |
| GET | `/items/{id}/edit` | Show edit-item form |
| POST | `/items/{id}/edit` | Edit an item |
| DELETE | `/items/{id}/delete` | Delete an item |

## REST API

The REST API is available under `/api/items`.

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/items` | Get all items |
| GET | `/api/items/{id}` | Get an item by ID |
| POST | `/api/items` | Create a new item |
| PUT | `/api/items/{id}` | Replace an existing item |
| DELETE | `/api/items/{id}` | Delete an item |

## Example

Create an item:

```
POST /api/items
Content-Type: application/json

{
    "name": "Example item",
    "description": "An example item",
    "price": 9.99
}
```

## Run the Application

Run the application with Maven:

```bash
./mvnw spring-boot:run
```

Then visit:

`http://localhost:8080/`

## Build the Application

Build the JAR file:

```bash
./mvnw clean package
```

Run the JAR file:

```bash
java -jar target/in-memory-rest-items-mvc-0.0.1-SNAPSHOT.jar
```

## References / Tutorials

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service)
- [Serving Web Content With Spring MVC](https://spring.io/guides/gs/serving-web-content)
- [Tutorial: Thymeleaf (2.1) + Spring](https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html)
- [Tutorial: Using Thymeleaf (3.1)](https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html)
