# Virtual Banking System (VBS)

Built with modern Java 21 and Spring Boot on the backend, it delivers a responsive UI powered by HTML & CSS and runs on Apache Tomcat 10. All data is persisted in a MySQL database, and the project is managed with IntelliJ IDEA Community Edition.

## Key Technologies

*   ***TechStack:*** \
    **Backend:** Java 21, Spring Boot, Apache Tomcat 10\
    **Frontend:** HTML5, CSS3\
    **Database:** MySQL\
    **IDE:** IntelliJ IDEA Community Edition
    
*   **Version Control:** Git (hosted on GitHub: [https://github.com/inc06nito9/VBS](https://github.com/inc06nito9/VBS))

## Core Features

*   **Customer:**
    *   Register a new account (Sign-Up)
    *   Secure login with encrypted credentials
    *   View current balance
    *   Perform deposits
    *   Browse transaction history (date, amount, type)
*   **Admin:**
    *   Log in with elevated privileges
    *   Manage all user accounts (create, edit, deactivate)
    *   Access comprehensive operation logs for every user action
    *   Generate reports on deposits, withdrawals, and overall system activity

## Highlights

*   **Secure Authentication:** Passwords are hidden, and session management follows Spring Security best practices, ensuring the confidentiality of user credentials.
*   **Role-Based Access Control:** Distinct permission sets for customers and administrators ensure that each user sees only the functionalities they’re authorized for, enhancing security and usability.
*   **Detailed Auditing:** Every operation (login, deposit, balance check, admin modifications) is recorded with timestamps, user IDs, and names, providing a clear audit trail for compliance and troubleshooting.
*   **Modular Architecture:** Controllers, services, and repositories are cleanly separated, making the codebase easy to extend (e.g., adding fund transfers or loan modules). This design promotes maintainability and future development.

## Getting Started

1.  **Clone the repo:**
    ```bash
    git clone https://github.com/inc06nito9/VBS
    ```
2.  **Configure the database:**
    *   Ensure you have MySQL installed and running.
    *   Create the `Spring111.db` Schema to create the necessary database schema. .
3.  **Access the app:**
    Open your web browser and navigate to: `http://localhost:8081/`

## Future Enhancements (Ideas)

*   Add fund transfer between accounts.
*   Implement two-factor authentication for extra security.
*   Implement a loan module.
*   Add interest calculations.
