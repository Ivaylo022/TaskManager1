# Task Manager

## Description
Task Manager is a Spring Boot web application for managing tasks.

## Technologies
- Java 17
- Spring Boot 3.4.0
- Spring Data JPA
- Thymeleaf
- H2 Database
- Maven

## Features
- Create Task
- View All Tasks
- Delete Task
- Mark Task as Done
- Manage Categories
- Web Interface with Thymeleaf

## Entities
### Task
- id (UUID)
- title
- description
- status

### Category
- id (UUID)
- name

### User
- id (UUID)
- username
- password

## Database
- H2 In-Memory Database
- UUID Primary Keys
- JPA/Hibernate

## Run Application
1. Open the project in IntelliJ IDEA
2. Run `TaskmanagerApplication.java`
3. Open:
    - http://localhost:8080/
    - http://localhost:8080/tasks-page

## Author
Ivaylo