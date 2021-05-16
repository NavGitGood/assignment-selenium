Test Automation Framework

All configurations are loaded from properties file

Following browsers are supported:
* Chrome
* InternetExplorer
* Edge
* Firefox

To run in a particular browser, modify value of *browser* variable in *env.properties* using following mapping
  
  | Browser | Value |
  | ----------- | ----------- |
  | Chrome | chrome |
  | InternetExplorer | ie |
  | Edge | edge |
  | Firefox | firefox |
  

Following TestNg xml files are present:
1. testng_homepage.xml - includes 8 tests in total (between 2 classes) 
2. testng_loginpage.xml - includes 1 test

To run from command prompt, navigate to root directory of the project, and run either of the following:
* mvn -DsuiteXmlFile="src/test/resources/testng_homepage.xml" test
* mvn -DsuiteXmlFile="src/test/resources/testng_loginpage.xml" test

Current report will be generated in a new folder (under output) with name *current_yyyyMMddHHmmss* while older report would be moved to *output/archived test results/older_folder*

To run the test in firefox, make sure to add/update path to its binary in *firefoxBinary* in *env.properties*

