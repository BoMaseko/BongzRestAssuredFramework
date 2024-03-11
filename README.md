# Derivco Technical Assessment
# Cocktail Exercise

This is Derivco technical assessment to automate the test cases using a language/framework of choice for  cocktail API. Follow these steps to clone and execute the project.

# Prerequisites
Make sure you have the following installed on your machine:

- Java Development Kit (JDK)
- Maven
- Git

# Clone the Repository

Open a terminal or command prompt and run the following command to clone the repository:


`git clone https://github.com/BoMaseko/derivco-technical-assessment.git`<br>

# Navigate to the Project Directory

Change into the project directory:

`cd derivco-technical-assessment`
# Build the Project
Use Maven to build the project. Run the following command:

`mvn clean install`

This command will download dependencies, compile the code, and run tests.

# Execute Tests
To execute the REST Assured tests, run the following command:

`mvn test`

This will execute all tests in the project.

# Test Reports

After running the tests, you can find the test reports in the `target` directory. Open the `target/surefire-reports` folder to view the test results.

# Customize Tests
Feel free to customize the REST Assured tests according to your needs. The test code is located in the `src/test/java directory`.

# Additional Configuration
If you need to change the test data, check the `DataProvider` method  in the `src/test/java directory`.

# Troubleshooting
If you encounter issues, ensure that the `JDK`, `Maven`, and `Git` are correctly installed and configured on your machine.
Verify that you have an active internet connection to download dependencies.

This README provides a basic guide for executing the Cocktail API test cases with the REST Assured Maven project. Adjustments may be needed based on the configurations and settings of your computer.






