# Student Management REST API Using Database.

## Overview

This project is a Spring Boot REST API for managing student information.

## Features

- Create a new student
- Retrieve all students
- Retrieve a student by ID
- Update student details
- Partially update student details
- Delete a student

## Endpoints

### Get All Students

- **URL:** `/student-service/get-all-students`
- **Method:** `GET`

### Get Student by ID

- **URL:** `/student-service/get-student/{id}`
- **Method:** `GET`

### Create Student

- **URL:** `/student-service/create`
- **Method:** `POST`
- **Request Body:**

```json
{
    "firstName": "pabitra",
    "lastName": "bera",
    "email": "pabitra@gmail.com",
    "phone": "5484585"
}
```

### Update Student

- **URL:** `/student-service/update/{id}`
- **Method:** `PUT`
- **Request Body:**

```json
{
    "firstName": "pabitra",
    "lastName": "bera",
    "email": "pabitrabera2001@gmail.com",
    "phone": "5484585"
}
```

### Partial Update Student

- **URL:** `/student-service/partial-update/{id}`
- **Method:** `PATCH`
- **Request Body:**

```json
{
    "lastName": "bera",
    "email": "pabitrabera@gmail.com",
    "phone": "5484585"
}
```

### Delete Student

- **URL:** `/student-service/delete/{id}`
- **Method:** `DELETE`

## Database Configuration and Swagger Documentation

### Database Configuration

The application uses an in-memory H2 database for persistence. The database schema is automatically created and dropped at application startup and shutdown. You can access the H2 console for database management at `/h2-console`.

### Swagger Documentation

The application includes Swagger for API documentation. You can access the Swagger UI at:

- **Swagger UI URL:** `http://localhost:8080/swagger-ui.html`

## Example Usage

- Get all students: `GET http://localhost:8080/student-service/get-all-students`
- Create a student: `POST http://localhost:8080/student-service/create`
- Update a student: `PUT http://localhost:8080/student-service/update/{id}`
- Partial update a student: `PATCH http://localhost:8080/student-service/partial-update/{id}`
- Delete a student: `DELETE http://localhost:8080/student-service/delete/{id}`


## Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run the following command to start the application:

```sh
mvn spring-boot:run
```

4. The application will be accessible at `http://localhost:8080`
