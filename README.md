# Spring Boot File Upload and Download

A simple Spring Boot application that provides REST API endpoints for uploading, downloading, and listing files.

## Technologies Used

- Java 21
- Spring Boot 3.5.0
- Maven
- Lombok
- JUnit 5
- Mockito

## Prerequisites

- Java 21 or higher
- Maven 3.9.9 or higher

## Project Structure

The project follows a standard Spring Boot application structure:

- `controller`: Contains the REST API endpoints
- `service`: Contains the business logic for file operations
- `model`: Contains the data model

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/spring-boot-fileupload-download.git
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

Make sure the `temp` directory exists in the project root, or modify the `filePath` property to point to an existing
directory.

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

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

Hendi Santika

- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
- Link: s.id/hendisantika
