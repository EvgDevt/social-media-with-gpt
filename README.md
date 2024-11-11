
# Social Media API Project

This project is a simple RESTful API for a social media application built using Spring Boot, Hibernate, and PostgreSQL. It allows users to create and view posts, follow other users, and like posts. Each post has a title, body, and author. The project demonstrates a basic CRUD operation setup with Spring Data JPA and contains unit tests for all core functionalities.

---

## Tasks and Feedback

### Task 1: Set Up Spring Boot Project with PostgreSQL and Hibernate
- **Was it easy to complete the task using AI?** Yes, AI provided clear and concise setup instructions.
- **How long did task take you to complete?** Approximately 20 minutes.
- **Was the code ready to run after generation?** Yes, the code ran as expected. I only needed to configure my PostgreSQL database credentials in `application.yml`.
- **Which challenges did you face during completion of the task?** None, the task was straightforward with the guidance.
- **Which specific prompts you learned as a good practice to complete the task?** Asking for a step-by-step guide for "Setting up Spring Boot with PostgreSQL and Hibernate."

### Task 2: Implement User and Post Entities
- **Was it easy to complete the task using AI?** Yes, AI provided detailed entity classes based on requirements.
- **How long did task take you to complete?** Approximately 15 minutes.
- **Was the code ready to run after generation?** Mostly, but I needed to adjust some field names to match the naming conventions in my database.
- **Which challenges did you face during completion of the task?** Minor adjustments to fit existing naming conventions.
- **Which specific prompts you learned as a good practice to complete the task?** Requesting sample code for "basic JPA entity class" for each entity.

### Task 3: Implement User and Post Service Classes
- **Was it easy to complete the task using AI?** Yes, the generated code structure was easy to follow.
- **How long did task take you to complete?** Around 30 minutes.
- **Was the code ready to run after generation?** Mostly, though some custom logic needed adjustments.
- **Which challenges did you face during completion of the task?** Customizing the follow and like functionalities required slight modifications.
- **Which specific prompts you learned as a good practice to complete the task?** Requesting "service class with CRUD methods in Spring" to get a clean starting point.

### Task 4: Implement User and Post Controller Classes
- **Was it easy to complete the task using AI?** Yes, but additional refinements were needed for error handling.
- **How long did task take you to complete?** Approximately 40 minutes.
- **Was the code ready to run after generation?** Almost; error-handling logic was added to improve functionality.
- **Which challenges did you face during completion of the task?** Implementing custom exceptions and ensuring proper HTTP status codes.
- **Which specific prompts you learned as a good practice to complete the task?** Requesting "Spring REST controller for CRUD operations" and asking for "example of handling exceptions in a Spring REST controller."

### Task 5: Unit Tests for Services and Controllers
- **Was it easy to complete the task using AI?** Mostly, but some Mockito syntax required tweaks.
- **How long did task take you to complete?** Around 1 hour.
- **Was the code ready to run after generation?** No, adjustments were needed for Mockito syntax issues.
- **Which challenges did you face during completion of the task?** Fixing `ArgumentMatchers.<Post>any()` in tests to ensure proper mocking.
- **Which specific prompts you learned as a good practice to complete the task?** Requesting "JUnit test examples with Mockito for Spring Boot service" and specifying "explicit type arguments in Mockito."

### Task 6: Code Coverage and Running Tests
- **Was it easy to complete the task using AI?** Yes, AI recommended Jacoco for coverage reporting.
- **How long did task take you to complete?** 20 minutes for setup and review.
- **Was the code ready to run after generation?** Yes, the AI-provided Jacoco setup instructions were ready to use.
- **Which challenges did you face during completion of the task?** None, Jacoco setup was straightforward.
- **Which specific prompts you learned as a good practice to complete the task?** Asking for "setting up Jacoco for code coverage in Spring Boot with Maven."

---

## Usage

### Running the Application
1. **Set up the PostgreSQL database** with the appropriate credentials in `application.yml`.
2. **Build and run** the application with:
   ```bash
   mvn spring-boot:run
   ```

### Running Tests
Execute tests and verify code coverage with:
```bash
mvn test
```

For coverage reports, add Jacoco and run:
```bash
mvn clean test jacoco:report
```

---
