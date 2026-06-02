# API REST de Books - Spring Boot + Kotlin + H2

Proyecto desarrollado con arquitectura por capas para gestionar libros.

## Tecnologias

- Spring Boot
- Kotlin
- Gradle
- Spring Data JPA
- H2 Database

## Estructura del proyecto

```text
src/main/kotlin/com/pucetec/ae1473exam1
├── controllers
│   └── BookController.kt
├── services
│   └── BookService.kt
├── repositories
│   └── BookRepository.kt
├── entities
│   └── Book.kt
├── dto
│   ├── BookRequest.kt
│   └── BookResponse.kt
└── Ae1473Exam1Application.kt
```

## Configuracion H2

- URL JDBC: `jdbc:h2:mem:bookdb`
- Consola H2: `http://localhost:8787/h2-console`
- JDBC URL en consola: `jdbc:h2:mem:bookdb`
- User: `sa`
- Password: (vacio)

## Como ejecutar

1. Tener Java 17 instalado.
2. Ejecutar:

```bash
./gradlew bootRun
```

En Windows PowerShell:

```powershell
.\gradlew.bat bootRun
```

La API inicia en `http://localhost:8787`.

## Endpoints

### 1) Crear libro

- Metodo: `POST`
- URL: `/api/books`

Body ejemplo:

```json
{
  "title": "  el principito  ",
  "author": "antoine de saint-exupery",
  "priceUsd": 10.0
}
```

Respuesta esperada (201):

```json
{
  "id": 1,
  "title": "El Principito",
  "author": "Antoine De Saint-exupery",
  "slug": "el-principito",
  "priceUsd": 10.0,
  "finalPrice": 11.2
}
```

### 2) Listar libros

- Metodo: `GET`
- URL: `/api/books`

Respuesta esperada (200):

```json
[
  {
    "id": 1,
    "title": "El Principito",
    "author": "Antoine De Saint-exupery",
    "slug": "el-principito",
    "priceUsd": 10.0,
    "finalPrice": 11.2
  }
]
```

## Pruebas rapidas con curl

Crear libro:

```bash
curl -X POST http://localhost:8787/api/books \
  -H "Content-Type: application/json" \
  -d '{"title":"  el principito  ","author":"antoine de saint-exupery","priceUsd":10.0}'
```

Listar libros:

```bash
curl http://localhost:8787/api/books
```

## Coleccion Postman

La coleccion se encuentra en:

- `postman/ae-1473-nombre-apellido.postman_collection.json`

## Entregables

- Repositorio GitHub: https://github.com/Nandox3s/ae-1473-fernando-socasi.git
- Coleccion Postman: incluida en la carpeta `postman`.
