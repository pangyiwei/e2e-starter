# E2E Starter with Selenium and JUnit 5

## Overview
This is a starter kit for those who want to have a standalone project for end-to-end testing of Web Applications. The Project has been configured to run tests against Google. https://www.google.com

## Usage
Fork or copy the code in this repository and change the package names and classnames accordingly. Do refer to the existing examples before editting them out

## Configurations
There are some configurations in the e2e.properties. Refer to those, you can create your own properties files, but make sure to use the format which the java Properties class supports. Subsequently remember to change the file reference either via a JVM argument `config.filename` or changing the `DEFAULT_PROPERTY_FILE_NAME` in PropertiesReader.java.

## Running Tests
You can either use maven to run the tests:
```
mvn clean test
```
Or you can trigger individual tests/test clasess from you IDE.
