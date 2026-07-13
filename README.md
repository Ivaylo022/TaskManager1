Task Manager
Description

Task Manager is a Spring Boot web application for creating, organizing, editing and managing tasks. The application supports user authentication, task categorization and server-side validation.

Technologies
Java 17
Spring Boot 3.4.0
Spring Data JPA
Spring Validation
Thymeleaf
H2 Database
Maven
Features
User Registration
User Login / Logout
Password encryption with BCrypt
Session-based authentication
Create Task
Edit Task
Delete Task
Mark Task as Done
Create Categories
Delete Categories
Assign Categories to Tasks
Server-side Validation
Web Interface with Thymeleaf
Entities
Task
UUID id
title
description
status
category
Category
UUID id
name
User
UUID id
username
password (encrypted)
Database
H2 In-Memory Database
UUID Primary Keys
Spring Data JPA / Hibernate
Many-to-One relationship (Task → Category)
Functionalities
Register new users
Login and Logout
Create, edit and delete tasks
Assign categories to tasks
Mark tasks as completed
Create and delete categories
Run Application
Open the project in IntelliJ IDEA.
Run TaskmanagerApplication.java.
Open your browser:
http://localhost:8080/
http://localhost:8080/tasks-page
Author

Ivaylo