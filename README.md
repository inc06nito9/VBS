Virtual Banking System

A full‑stack web application that simulates a secure online banking platform. Built with modern Java 21 and Spring Boot on the backend, it delivers a responsive UI powered by HTML & CSS and runs on Apache Tomcat 10. All data is persisted in a MySQL database, and the project is managed with IntelliJ IDEA Community Edition.
Key Technologies
LayerTechnologyBackendJava 21, Spring Boot, Apache Tomcat 10FrontendHTML5, CSS3 (responsive layout)DatabaseMySQL (SQL scripts included)IDEIntelliJ IDEA Community EditionVersion ControlGit (hosted on GitHub)
Core Features
RoleCapabilitiesCustomer• Register a new account (Sign‑Up) • Secure login with encrypted credentials • View current balance • Perform deposits • Browse transaction history (date, amount, type)Admin• Log in with elevated privileges • Manage all user accounts (create, edit, deactivate) • Access comprehensive operation logs for every user action • Generate reports on deposits, withdrawals, and overall system activity

Highlights
• Secure Authentication – Passwords are hashed (e.g., BCrypt) before storage, and session management follows Spring Security best practices.
• Role‑Based Access Control – Distinct permission sets for customers and administrators ensure that each user sees only the functionalities they’re authorized for.
• Detailed Auditing – Every operation (login, deposit, balance check, admin modifications) is recorded with timestamps, user IDs, and IP addresses, providing a clear audit trail.
• Modular Architecture – Controllers, services, and repositories are cleanly separated, making the codebase easy to extend (e.g., adding fund transfers or loan modules).

Getting Started
• Clone the repo
git clone https://github.com/inc06nito9/VBS/

• Configure the database
Create a MySQL schema Spring111.db.

Access the app at http://localhost:8080/virtual-banking.

Future Enhancements (Ideas)
• Add fund transfer between accounts.
• Implement two‑factor authentication for extra security.
