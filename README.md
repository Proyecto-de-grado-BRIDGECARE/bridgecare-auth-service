# BridgeCare Auth Service

## Overview
The **BridgeCare Auth Service** is responsible for handling authentication and authorization within the BridgeCare platform. It is built using **Spring Boot** and **Spring Security**, implementing JWT-based authentication to ensure secure access to system resources.

## Features
- User authentication using **JWT tokens**.
- Role-based access control.
- Secure storage of user credentials.
- Database integration with **PostgreSQL**.
- Environment-based configuration using **dotenv**.

## Tech Stack
- **Spring Boot 3.4.3**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker**

## Getting Started

### Prerequisites
- Java **17+**
- Maven **3.8+**
- Docker & Docker Compose
- PostgreSQL Database

### Installation

#### Clone the repository
```bash
git clone https://github.com/Proyecto-de-grado-BRIDGECARE/bridgecare-auth-service.git
cd bridgecare-auth-service
```

#### Setup environment variables
Copy `.env.example` to `.env` and set the required environment variables:
`cp .env.example .env`

#### Build and Run

To build and run the service, ensure you have a .env file in the project root with the following:
```
GITHUB_USERNAME=bridgecare-bot
GITHUB_TOKEN=<bridgecare-bot-personal-access-token>
```
Copy .env.example to .env and replace `<bridgecare-bot-personal-access-token>` with a valid GitHub PAT with read:packages scope.

##### Local Build and Run
Use the Maven Wrapper to build and run the application locally (works on Linux, macOS, and Windows):

1. **Build the JAR:**
   ```bash
   # Windows:
   .\mvnw.cmd clean package -U

   # Linux:
   ./mvnw clean package -U
   ```
   - The `-U` flag ensures the latest dependencies are fetched (needed only once or after updates).

2. **Run the JAR:**
   ```bash
   java -jar target/auth-0.0.1-SNAPSHOT.jar
   ```

3. **Or Run with Maven Wrapper:**
   ```bash
   # Windows:
   .\mvnw.cmd spring-boot:run

   # Linux:
   ./mvnw spring-boot:run
   ```

##### Docker Build and Run
To build and run the service in a Docker container:

```bash
docker-compose up --build
```
- Ensure Docker and Docker Compose are installed.
- This builds the image and starts the service on port 8080.
- On Windows, run this in Command Prompt or PowerShell with Docker Desktop running.

For a fresh build (e.g., after dependency updates):
```bash
docker-compose build --no-cache
docker-compose up
```

## API Endpoints

| Method | Endpoint           | Description              | Auth Required | Disabled |
|:------:|--------------------|--------------------------|:-------------:|:--------:|
| POST   | /api/auth/login    | User login               | ✅            | ❌       |
| POST   | /api/auth/register | User registration        | ✅            | ✅       |
| GET    | /api/auth/me       | Get current user details | ✅            | ❌       |
| POST   | /api/auth/logout   | Invalidate JWT token     | ✅            | ❌       |

## Security
This service uses **Spring Security** with **JWT-based authentication**.
Tokens must be included in the `Authorization` header as:
`Authorization: Bearer <your_token>`

## Running Tests
To run tests:
`mvn test`

## Contributing
1. Fork the repository.
2. Create a new branch.
3. Commit your changes.
4. Push to your fork.
5. Create a Pull Request.

## License
This project is licensed under the MIT License.
