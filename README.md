# Campus Lost & Found

## Project Description

Campus Lost & Found is a web application built using Java and Spring Boot. It allows students to report and view lost and found items on campus.

Users must register and sign in before accessing the Lost & Found page. Spring Security handles authentication, and passwords are securely stored using BCrypt hashing.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- H2 Database
- HTML, CSS, JavaScript
- Maven

## Features

- User registration with username and password
- Username and password validation
- Duplicate username checking
- Secure sign-in and sign-out
- BCrypt password hashing
- View reported items
- Report found items
- CSRF protection for form submissions

## How to Run

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java and Maven are configured.
4. Reload the Maven dependencies.
5. Run `LostfoundApplication.java`.
6. Open `http://localhost:8080` in your browser.
7. Register an account and sign in to access the application.

## H2 Database

The application uses an H2 database to store user accounts and reported items.

To view the database:

1. Run the application.
2. Open `http://localhost:8080/h2-console`.
3. Enter the JDBC URL, username, and password configured in `application.yaml`.
4. Run the following SQL query:

```sql
SELECT * FROM APP_USERS;
```

Passwords are stored as BCrypt hashes rather than plain text.

## Security

Spring Security protects the Lost & Found page. Visitors must register and sign in before viewing or reporting items. The registration, login, and H2 console pages are publicly accessible.

## Author
Adithe Das  
