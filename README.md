## API
Upgrade exposes a login API for registered users, that should provide a 200 response if credentials are valid. And a 401 response if the
credentials are invalid. The API endpoint is available at: https://credapi.credify.tech/api/brportorch/v2/login


## How to execute test
#1 
Go to `src/test/java/upgradeApi/<test-file-name>`, that holds testcases
Right click on file name in Package Explorer and `run as` TestNG Test

#2
Right click on  `testNG.xml`, that holds test class(es) name to be executed

#3
execute mvn command from command line mvn clean test -DsuiteXMLFile=testNG.xml


### Endpoints
- `/login` - all users

## Framework
* Framework consist of rest-assured jar, testng Jar, extentreport Jar and simple-json jar.
* Rest-Assured assertions (Hamcrest Matchers) being used here along with JUnit ones and even AssertJ assertions.

### Structure
This project is your standard Maven Java project with `src` folders and `POM.xml`.

### Models
`src/main/java/models` represent Loan API entities with class properties equal to JSON response fields. 
This lets us serialize and deserialize  requests and responses easily.
In order for the serialization to work properly, names of the fields must match JSON convention thus they violate Java camel case convention (it can be overriden using `@JsonProperty` annotations in real-life projects).

### Properties
`src/main/resources/config.properties` is a simple properties file to store various common configurations that are required by any/all tests to be executed.

### Tests
`src/main/java/Base.class` is the tests superclass for configuration and common code
`src/test/java/` holds test classes (TestNG)

### Reports
extentreports get generated as soon as the test are run. Test results are saved insidee `test-output` directory under root. 
HTML file is generated for each run with prefix `testReport-` followed by date and time of the run. 


 
