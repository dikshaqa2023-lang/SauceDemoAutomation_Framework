# SauceDemo Selenium Java Automation Framework

## Included
- Selenium WebDriver
- Java 17
- Maven

## Application
https://www.saucedemo.com/

## Demo credentials
Username: standard_user
Password: secret_sauce

## Run
1. Install JDK 17+ and Maven.
2. Import this folder as a Maven project.
3. Run:
   mvn clean test

## Reports
After execution:
test-output/ExtentReport.html

Failure screenshots:
test-output/screenshots/

## Parallel execution
Configured in testng.xml:
parallel="tests"
thread-count="2"

