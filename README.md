# Parabank Automation Test Suite

This project is an automated test suite for testing the key functionalities of the Parabank web application. It is built using Selenium WebDriver for browser automation and JUnit 5 for testing purposes.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Technologies Used](#technologies-used)
3. [Use Cases](#use-cases)
    - [Register a New Account](#use-case-1-register-a-new-account)
    - [Handle Registration Errors](#use-case-2-handle-registration-errors)
    - [Login to an Existing Account](#use-case-3-login-to-an-existing-account)
    - [View Account Overview](#use-case-4-view-account-overview)
    - [Log Out of the System](#use-case-5-log-out-of-the-system)
4. [Running the Tests](#running-the-tests)

## Project Overview

This suite is designed to validate key functionalities such as user registration, login, and viewing account details on the Parabank web application. It helps ensure that these core features work as expected.

## Technologies Used

- **Java**: The core language for the project.
- **Selenium WebDriver**: Used for browser automation and interaction with the web elements.
- **JUnit 5**: A testing framework for writing and running tests.
- **Maven**: A build automation tool that manages project dependencies.

## Use Cases

### Use Case 1: Register a New Account

**Primary Actor**: New user

**Preconditions**:
- The user is on the Parabank home page.

**Trigger**:
- The user clicks on the "Register" link to create a new account.

**Basic Flow**:
1. The user navigates to the registration page.
2. The user fills out the registration form with valid data (first name, last name, address, contact information, and login credentials).
3. The user submits the registration form.
4. The system creates the account and automatically logs the user in.
5. The system displays a welcome message with the user’s full name.
6. The system displays a success message confirming that the account has been created successfully.
7. The "Log Out" button is displayed, allowing the user to end the session.

**Postconditions**:
- The user is logged in and redirected to the account overview page.
- The user can view the "Log Out" button and the success message.

**Exceptions**:
- If mandatory fields are left blank or invalid information is entered, error messages should appear for each respective field.

---

### Use Case 2: Handle Registration Errors

**Primary Actor**: New user

**Preconditions**:
- The user is on the Parabank home page.

**Trigger**:
- The user clicks on the "Register" link to create a new account and submits an incomplete or invalid form.

**Basic Flow**:
1. The user navigates to the registration page.
2. The user attempts to submit the form with empty or invalid fields.
3. The system checks the form validation rules.
4. The system displays error messages next to the fields that are invalid or left empty.

**Postconditions**:
- Error messages are displayed, informing the user to complete all mandatory fields correctly.

**Exceptions**:
- If the user attempts to fill some fields but misses others, the system only displays error messages for the incomplete or incorrect fields.

---

### Use Case 3: Login to an Existing Account

**Primary Actor**: Registered user

**Preconditions**:
- The user already has an account registered with valid credentials (username and password).

**Trigger**:
- The user enters their username and password on the home page and attempts to log in.

**Basic Flow**:
1. The user navigates to the Parabank home page.
2. The user fills in their valid username and password in the login form.
3. The user submits the login form.
4. The system authenticates the user and redirects them to the account overview page.
5. The system displays the user’s full name with a welcome message.
6. The "Log Out" button is visible, indicating a successful login.

**Postconditions**:
- The user is logged in and can access account features from the overview page.

**Exceptions**:
- If the username or password is incorrect, an error message is displayed, and the login fails.
- If any required field is left blank, an error message is shown to prompt the user to fill it out.

---

### Use Case 4: View Account Overview

**Primary Actor**: Logged-in user

**Preconditions**:
- The user is logged into the system.

**Trigger**:
- The user is directed to the account overview page after logging in.

**Basic Flow**:
1. The system displays the account overview page after a successful login.
2. The page displays the user’s full name with a welcome message.
3. The user can see their current account balance in the account overview table.
4. The "Log Out" button is displayed, allowing the user to end the session.

**Postconditions**:
- The user can view their account information, including balance details, and can log out if necessary.

**Exceptions**:
- If the account data is delayed (e.g., due to a slow network), the balance might not appear immediately. In this case, the system could implement a loading indicator or provide a message to inform the user of any delays.

---

### Use Case 5: Log Out of the System

**Primary Actor**: Logged-in user

**Preconditions**:
- The user is logged into the system.

**Trigger**:
- The user clicks on the "Log Out" button.

**Basic Flow**:
1. The user navigates to the account overview page.
2. The user clicks on the "Log Out" button.
3. The system logs the user out and redirects them to the home page.

**Postconditions**:
- The user is logged out and returned to the home page.

**Exceptions**:
- If there is a session timeout or network issue, the user might be automatically logged out, and a message is displayed indicating the session has expired.

---

## Running the Tests

To run the test suite, follow these steps:

1. **Ensure that all dependencies are installed** (e.g., Java, Maven, WebDriver, etc.).

2. **Run the tests using Maven**:
   ```bash
   mvn clean test
