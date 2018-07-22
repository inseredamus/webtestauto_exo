22.7.2018 author : inseredamus (dm)
-------------------
GENERAL USAGE NOTES
-------------------

_________________________________________________________
PART 1 : UI Automated test using Java, Selenium WebDriver
_________________________________________________________

The given url to test is : http://automationpractice.com/index.php
Project realised in 5 working days : test automation test
This is using selenium webdriver for testing some functions of a website.
The 3 initial Test are placed into testclasses categories : CheckoutTest and RegistrationAndLogin.

PAGE OBJECT PATTERN :
The Structure of the project is the page object pattern :
For each web page of an application you can create corresponding class which encapsulate the mechanics required
to perform some action on that page. We can think about page objects like they represent the services offered
by a particular page and hide the details and mechanics of the page.
3 +1 layers :
- UI-Elements in a property file
- PAGE : reference to each module or page in the web application
- SERVICES : all services in one page you need for the testing
- TEST : a clear scenario of each page are opened and which services we need
particularity : css,xpath,id,etc -elements are not on the page but in ui_elements.properties.
Sometimes the developer changes the structure or ids or name of an element. Our goal is that the tests stays stable:
we need to update the ui elements. You also don't need to find the page class, how many times the ui element was implemented,
but only open the properties file. One place, one change and that's it.
Same use for the urls, they are placed in application.properties.

BROWSERS :
I know a better solution to use more browsers at the same time : Docker (https://docs.docker.com/docker-hub/builds/).
I have suggested in the project the use of two browsers : firefox and chromedriver. chromedriver should work on all platforms,
the geckodriver for firefox in only for mac os.
You easily change the configuration (config.properties). You currently can use firefox or chromedriver.
TODO : testing with browsers in parallel in this configuration or Docker.

JDK :
I'm using the jdv java version : 1.8.0_181 and I have fixed the language level to 8 : lambdas, Type and annotation. So please use any jdk 1.8.* versions.

LOGGER : LOG4J
Perhaps I'm using to many log events in the projects. There is one reason. If you can see in directory logs,
the log event can be exported and reused for example in a database or on jenkins. The goal is to get a understandable clickflow to reproduce
the problem if the test fails. We never can catch all the error we could have on an application. Such a clickflow could be very useful.
Even the ASSERTS (if passed or not) are injected in the logs too.

CUSTOM-ASSERT :
It is always important to described what we are expecting. Sometimes we don't know really what we should have and what we don't.
With this customized Assert, you know exactly

ENUMS :
I love enums, I think it makes the codes more readable. Don't it?

OBJECTMAP :
Export a ui_elements between the pages with : By.cssSelector/By.id value is more complicated than with a String css->value.
The Objectmap class doesnt the transformation and you only to export your By element. See PAGE OBJECT PATTERN and particularity

SMOKE TESTS AND LONG/EXPLORATIVE TESTS :
For the testclass : RegistrationAndLoginTest, there are smoketests (marked as Ignore) and 2 other test more explorative.
I think it necessary to split a long test into more smoke tests. The goal is to know which function does't work.
If the test as testing 3 functions and stop to the first one, you don't know the status about the 2 other functions.
The smoketest could test it.
Because of too few time I don't do some smokeTest in CheckoutTest
Why do I @ignored the smoketest? see MAVEN

MAVEN :
You have to download maven (locally or on jenkins) : http://maven.apache.org/ + PATH
With jenkins or some other software, you could configure a job with this command :
"mvn test" : it will test all the testclasses *Test
"mvn -Dtest=CheckoutTest test"  or  "mvn -Dtest=RegistrationAndLoginTest test" for the specific testclasses
"mvn -Dtest=RegistrationAndLoginTest#logInTest test"
NB : you should execute mvn only in the workspace (where the project is located)

///// or ||||| :
What does it mean ?
the first one indicates that the log event belongs to the page services where whe are. The second one belongs to the general services.
For example : general services : ASSERT or WaitClass. Why? In order to debug easilier. The characters | or / could be changed but the lecture
is not optimal => too much info.

SCREENSHOTS :
If the test fails, a screenshot will be taken : screenshots/testname_HH-mm-ss.ms.png
These will be deleted each time you start a test suite.

______________________________________
PART 2 : API Automated test using Java
______________________________________
The given url were :
http://services.groupkt.com/ country/get/all
http://services.groupkt.com/ country/get/iso2code/{COUNTRY_ ISO2CODE} (e.g. http://services.groupkt.com/ country/get/iso2code/us )
I could use rest-assured.io, but unfortunately I'm more comfortable with org.json and org.apache.httpcomponents
All the test are under the directory : apiTestclasses, the testclass is called : CountryApiTest

OBJECT :
I found interesting to use an object to collect the different information from the second url : individual country.

MAVEN :
You can run the whole testclass with :
"mvn -Dtest=CountryApiTest test" or more specific "mvn -Dtest=CountryApiTest#are_all_countries_responses_code_200_Test test"

TOOLS USED :
- Postman
- https://jsoneditoronline.org/