# Placement Tracker

A simple full-stack app to track job applications (company, role, status) with a status summary.

**Tech:** Java 17, Spring Boot, Spring Data JPA, H2 (relational DB), HTML, JavaScript, jQuery, JUnit 5, Maven

## Run
1. Install Java 17 and Maven
2. Run `mvn spring-boot:run`
3. Open http://localhost:8080

## REST APIs
- GET    /api/applications
- POST   /api/applications
- PUT    /api/applications/{id}/status?value=INTERVIEW
- DELETE /api/applications/{id}
- GET    /api/applications/summary

## Test
`mvn test`
