# Selenium WebDriver Automation Framework

## Overview

This project is a production-ready Selenium WebDriver Automation Framework built using:

* Java 17+
* Selenium 4
* TestNG
* Maven
* WebDriverManager
* Page Object Model (POM)
* ExtentReports
* Log4j2
* Apache POI
* Jackson
* AssertJ
* Selenium Grid / BrowserStack Support

The framework is designed for:

* Cross-browser testing
* Parallel execution
* CI/CD integration
* Data-driven testing
* Maintainability and scalability

---

# Project Structure

```text
project-root/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/
│   │       ├── pages/
│   │       ├── components/
│   │       ├── utils/
│   │       ├── config/
│   │       └── constants/
│   │
│   └── test/
│       └── java/
│           ├── tests/
│           └── data/
│
├── resources/
│   ├── config.properties
│   ├── dev.properties
│   ├── staging.properties
│   ├── prod.properties
│   ├── testdata/
│   └── log4j2.xml
│
├── reports/
│
├── testng.xml
├── pom.xml
└── README.md
```

---

# Prerequisites

## Java

Install Java 17 or later.

Verify installation:

```bash
java -version
javac -version
```

Expected output:

```bash
openjdk version "17.x"
javac 17.x
```

---

## Maven

Verify Maven:

```bash
mvn -version
```

Expected output:

```bash
Apache Maven 3.9+
```

If Maven is missing:

### Windows

```powershell
winget install Apache.Maven
```

### macOS

```bash
brew install maven
```

### Linux

```bash
sudo apt install maven
```

---

# Framework Features

## WebDriverManager

No driver downloads required.

Supported browsers:

* Chrome
* Firefox
* Edge
* Safari

Example:

```java
WebDriverManager.chromedriver().setup();
```

---

## Parallel Execution

Framework uses:

```java
ThreadLocal<WebDriver>
```

for thread-safe execution.

Configured via:

```xml
parallel="methods"
thread-count="4"
```

---

## Configuration Management

Configuration values are stored in:

```text
resources/
├── config.properties
├── dev.properties
├── staging.properties
└── prod.properties
```

Example:

```properties
browser=chrome
headless=false
timeout=15
base.url=https://www.saucedemo.com
```

Override using:

```bash
mvn test -Dbrowser=firefox
```

---

# Running Tests

## Run All Tests

```bash
mvn clean test
```

---

## Run Smoke Tests

```bash
mvn clean test -Dgroups=smoke
```

---

## Run Regression Tests

```bash
mvn clean test -Dgroups=regression
```

---

## Run Headless

```bash
mvn clean test -Dheadless=true
```

---

## Run On Chrome

```bash
mvn clean test -Dbrowser=chrome
```

---

## Run On Firefox

```bash
mvn clean test -Dbrowser=firefox
```

---

## Run On Edge

```bash
mvn clean test -Dbrowser=edge
```

---

# TestNG Suites

Run specific suite:

```bash
mvn test -DsuiteXmlFile=testng-smoke.xml
```

Available suites:

```text
testng-smoke.xml
testng-regression.xml
testng-parallel.xml
```

---

# Data Driven Testing

## Excel

Location:

```text
resources/testdata/
```

Example:

```java
@DataProvider
public Object[][] loginData() {
    return ExcelDataProvider.getData("LoginData.xlsx");
}
```

---

## JSON

Example:

```java
List<User> users =
JsonDataProvider.readUsers("users.json");
```

---

# Reporting

Reports are generated automatically.

Location:

```text
reports/
```

Generated files:

```text
ExtentReport.html
```

Contents include:

* Test Name
* Browser
* Environment
* Execution Time
* Pass / Fail Status
* Screenshots

---

# Screenshots

Failure screenshots are captured automatically.

Location:

```text
reports/screenshots/
```

Example:

```java
ScreenshotUtil.capture(driver, "LoginFailure");
```

---

# Logging

Framework uses Log4j2.

Location:

```text
logs/
```

Outputs:

* Console logs
* Rolling file logs

Example:

```java
logger.info("Navigating to login page");
logger.info("Entering username");
logger.error("Login failed");
```

---

# BrowserStack Execution

Set:

```properties
execution.mode=browserstack
browserstack.username=YOUR_USERNAME
browserstack.accessKey=YOUR_ACCESS_KEY
```

Run:

```bash
mvn test
```

---

# Selenium Grid Execution

Start Grid:

```bash
docker-compose up -d
```

Set:

```properties
execution.mode=grid
grid.url=http://localhost:4444/wd/hub
```

Run:

```bash
mvn test
```

---

# Mobile Emulation

Example:

```java
Map<String, Object> mobileEmulation =
new HashMap<>();

mobileEmulation.put("deviceName", "iPhone 14 Pro");

ChromeOptions options =
new ChromeOptions();

options.setExperimentalOption(
    "mobileEmulation",
    mobileEmulation
);
```

---

# CI/CD

## Jenkins

```bash
mvn clean test \
-Dbrowser=chrome \
-Denv=staging \
-Dgroups=smoke
```

Artifacts:

* ExtentReport.html
* Logs
* Screenshots

---

## GitHub Actions

Workflow:

```text
.github/workflows/selenium.yml
```

Runs automatically on:

* Push
* Pull Request
* Manual Trigger

---

# Best Practices

✔ Use Page Object Model

✔ Avoid Thread.sleep()

✔ Use Explicit Waits

✔ Keep Tests Independent

✔ No Hardcoded Credentials

✔ Use Config Files

✔ Use Data Providers

✔ Capture Screenshots On Failure

✔ Use Logging

✔ Run Tests In Parallel

✔ Prefer ID/CSS Selectors Over XPath

---

# Sample Execution

```bash
mvn clean test \
-Dbrowser=chrome \
-Denv=staging \
-Dgroups=smoke \
-Dheadless=true
```

---

# Author

QA Automation Framework

Version: 1.0.0

Technology Stack:

* Selenium 4
* Java 17
* TestNG
* Maven
* ExtentReports
* Log4j2
* Apache POI
* AssertJ
* BrowserStack
* Selenium Grid
