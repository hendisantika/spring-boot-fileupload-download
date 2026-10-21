# Spring Boot File Upload and Download

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-fileupload-download/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-fileupload-download/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen)

A simple Spring Boot application that provides REST API endpoints for uploading, downloading, and listing files.

## Technologies Used

- Java 25
- Spring Boot 4.1.1
- Maven (wrapper included)
- Lombok
- JUnit 5
- Mockito

## Prerequisites

- Java 25 or higher
- Maven 3.9.9 or higher (or use the bundled `./mvnw`)

## Project Structure

The project follows a standard Spring Boot application structure:

- `controller`: Contains the REST API endpoints
- `service`: Contains the business logic for file operations
- `model`: Contains the data model

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/hendisantika/spring-boot-fileupload-download.git
   cd spring-boot-fileupload-download
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on the default port 8080.

## Configuration

The application uses the following configuration properties in `application.properties`:

```properties
spring.application.name=spring-boot-fileupload-download
filePath=./temp/
```

The directory configured by `filePath` is created automatically on startup if it does not exist.

## API Endpoints

### List Files

```
GET /file/list
```

Returns a list of all files in the configured directory.

**Curl Example:**

```bash
curl -X GET http://localhost:8080/file/list
```

**Response:**

```json
[
   "file1.txt",
   "file2.txt"
]
```

### Upload File

```
POST /file/upload
```

Uploads a file to the configured directory.

**Request Body:**

- MultipartFile

**Curl Example:**

```bash
curl -X POST -F "file=@/path/to/your/file.txt" http://localhost:8080/file/upload
```

**Response:**

- 201 CREATED: File uploaded successfully
- 304 NOT MODIFIED: File already exists
- 417 EXPECTATION FAILED: Upload failed

### Download File

```
GET /file/download/{fileName}
```

Downloads a file from the configured directory.

**Path Parameters:**

- fileName: Name of the file to download

**Curl Example:**

```bash
curl -X GET http://localhost:8080/file/download/example.txt -o downloaded_example.txt
```

**Response:**

- 200 OK with file content: File downloaded successfully
- 404 NOT FOUND: File not found

## Testing

The application includes unit tests for both the controller and service layers. You can run the tests using:

```bash
mvn test
```

The controller tests use Spring Boot 4's `@WebMvcTest` (from `spring-boot-starter-webmvc-test`) together with
`@MockitoBean`, which replaces the removed `@MockBean` annotation.

## Continuous Integration

GitHub Actions (`.github/workflows/maven.yml`) builds and tests the project with Temurin JDK 25 on every push and pull
request to `main`. On pushes to `main` it also submits the Maven dependency graph to GitHub for better Dependabot
alerts (non-blocking; enable *Settings → Code security → Dependency graph* for it to succeed).

## Dependency Updates

Dependabot (`.github/dependabot.yml`) checks for updates daily at 05:00 (Asia/Jakarta):

- **Maven** – minor/patch updates are grouped into `spring-boot`, `testing`, `maven-plugins` and
  `other-dependencies` PRs; major updates arrive as individual PRs. Commits use the `build(deps)` /
  `build(deps-dev)` prefixes.
- **GitHub Actions** – all action updates are grouped into a single PR with the `ci(deps)` prefix.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

Hendi Santika

- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
- Link: s.id/hendisantika
