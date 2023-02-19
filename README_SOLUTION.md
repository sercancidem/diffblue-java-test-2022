# Test Test Project

This project contains solution of an interview question designed to assess Sercan Cidem's Java coding ability.

### Project Technologies and Dependencies
* Java 8
* junit-jupiter v5.8.1
* mockito-core v5.1.0
* junit v4.13.1

### Guides

The simplest steps are the following:

* Navigate to the project source root and type: `mvn clean install`. This will run all tests and generate a jar file in target folder.
* Navigate to the target folder and type: `java -jar testing-test-1.0-SNAPSHOT.jar "../sample.txt"` to run the application

### Development

Main function in Main class performs the following steps:
* 1. Validates that only one argument has been passed to the program.
* 2. Loads the file from the file system.
* 3. Validates that the file exists and is a valid file.
* 4. Creates a `CodeClass` instance from the file.
* 5. Creates a `CodeAnalyzer` instance.
* 6. Creates a `CodeTest` instance for the code class.
* 7. Runs the test using the code analyzer.
* 8. Prints the code coverage details.

If any exceptions occur during these steps, the program will log a `SEVERE` level message to the log.

### Unit Test

* To run tests, type: `mvn clean test`
* `CodeAnalyzerImplTest` class contains unit tests for `CodeAnalyzerImpl` class.
* `CodeClassTest` class contains unit tests for `CodeClassImpl` class.
* `CodeTestImplTest` class contains unit tests for `CodeTestImpl` class.
* `CodeLineImplTest` class contains unit tests for `CodeLineImpl` class.
* `ValidationUtilsTest` class contains unit tests for `ValidationUtils` class.
* `test.txt` file in used for test purposes.
