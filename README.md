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

Current report will be generated in a new folder (under output) with name *current_yyyyMMddHHmmss* while older report would be moved to *output/archived test results/current_yyyyMMddHHmmss*

To run the test in Firefox, make sure to add/update path to its binary in *firefoxBinary* in *env.properties*


Issues with InternetExplorer:
1. Cache clean is not working -> make sure to clean the cart before each run
2. Hover and Click action is not working -> using JavascriptExecutor as a workaround
3. Browser hangs during some runs
4. Sometimes tests pass but driver throws an exception *window not visible*

Scripts were verified on following System Configuration:
* OS - Windows 10, 64 bit
* Java - 1.8.0_131
* Maven - 3.6.0
* Chrome - 90.0.4430.212, 64-bit
* InternetExplorer - 11.572.19041.0
* Edge - 90.0.818.62, 64-bit
* Firefox - 88.0.1, 64-bit

