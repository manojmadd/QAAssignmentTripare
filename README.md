# Tripare QA Assignment

This repository contains a Selenium automation testing project built using
Java, TestNG, and Maven as part of the Tripare QA assignment.

---

## Tech Stack
- Java (JDK 8 or above)
- Selenium WebDriver
- TestNG
- Maven
- Eclipse IDE
- Git

---

## Project Structure

TripareQAAssignment
├── src
│   └── main
│       └── java
│           └── Base
│               └── BaseTest.java
├── src
│   └── test
│       └── java
│           └── Tests
│               ├── ConditionalLoginTest.java
│               ├── DelayedButtonTest.java
│               ├── DynamicIdTest.java
│               ├── ModalFlowTest.java
│               └── VerifyLazyList.java
├── test-output
├── pom.xml
├── testng.xml
└── README.md


---

## Prerequisites

Make sure the following are installed on your system:

- Java JDK 8+
- Maven
- Git
- Eclipse IDE

Verify installations:

java -version  
mvn -version  
git --version  

---

## How to Run the Project

### 1. Clone the Repository

git clone <repository-url>  
cd TripareQAAssignment  

---

### 2. Run Tests Using Maven

mvn clean test

---

### 3. Run Tests Using TestNG XML

mvn test -DsuiteXmlFile=testng.xml

---

## Run Tests from Eclipse

1. Open Eclipse
2. Import → Existing Maven Project
3. Select the project folder
4. Right-click on testng.xml
5. Run As → TestNG Suite

---

## Test Reports

After execution, TestNG reports are generated in:

test-output/

Open index.html inside this folder to view the execution report.

---

## Notes

- TestNG dependency is managed via Maven pom.xml
- Selenium version is defined explicitly (not LATEST or RELEASE)
- No file movement is required to run the project

---

## Author

Manoj Maddheshiya
