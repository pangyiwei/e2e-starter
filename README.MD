# E2E Starter with Selenium and JUnit 5

## Overview
This is a starter kit for those who want to have a standalone project for end-to-end testing of Web Applications. The Project has been configured to run tests against Google. https://www.google.com

## Usage
Fork or copy the code in this repository and change the package names and classnames accordingly. Do refer to the existing examples before editting them out

## Configurations
There are some configurations in the e2e.properties and e2e-local.properties files (Similar to SpringBoot). Refer to those, you can create your own properties files using "e2e-YOUR_ENV_NAME.properties". Subsequently remember to change the active profile either in e2e.properties or pass it in as a JVM argument. Do take a look at PropertiesReader.java in the com.example.app.util package to see how this is implemented.

## Running Tests
You can either use maven to run the tests:
```
mvn clean test
```
Or you can trigger individual tests/test clasess from you IDE.
