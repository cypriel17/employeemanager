# Employee Manager API

A Spring Boot REST API for managing employee information with CRUD operations.
Using an actuator as well for tracking requests, stability, and functionality of the application at large.

## Overview

The Employee Manager API provides endpoints for creating, reading, updating, and deleting employee records. It's built using Spring Boot and includes features like:

- Complete CRUD operations for employee management
- UUID-based employee code generation
- Custom exception handling
- CORS configuration for frontend integration
- JPA-based persistence

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Jakarta Persistence
- Lombok
- SLF4J (Logging)

## Prerequisites

- Java 17 or higher
- Maven
- MySQL/PostgreSQL database
- Frontend application running on ports 4200 or 4500

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

## API Endpoints

### Employee Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/employee/all` | Retrieve all employees |
| GET | `/employee/find/{id}` | Find employee by ID |
| POST | `/employee/add` | Add a new employee |
| PUT | `/employee/update` | Update existing employee |
| DELETE | `/employee/delete/{id}` | Delete employee by ID |

### Request/Response Format

#### Employee Object Structure
```json
{
    "id": "Long",
    "name": "String",
    "email": "String",
    "jobTitle": "String",
    "phone": "String",
    "imageUrl": "String",
    "employeeCode": "String"
}
```

## Configuration

### CORS Configuration
The application is configured to accept requests from:
- `http://localhost:4200`
- `http://localhost:4500`

### Database Configuration
Add the following properties to `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employeemanager
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Application

1. Clone the repository:
```bash
git clone git@github.com:cypriel17/employeemanager.git
```

2. Navigate to the project directory:
```bash
cd employee-manager
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## Error Handling

The API includes custom error handling for:
- User not found exceptions
- General API exceptions

## Logging

The application uses SLF4J for logging. Important operations like employee creation are logged with appropriate information.

## Security Considerations

- The application includes CORS configuration for development purposes
- Consider implementing authentication/authorization for production use
- Review and adjust CORS settings before deployment

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License
