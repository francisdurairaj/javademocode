ENSURE IN LINUX ENV. ALL PERMISSIONS ARE GRANTED TO EVERYONE for your ws
ubuntu1804javaspringboot@ubuntu:~/practice/springboot/ws1902$ chmod -R 777 ./

The class Application created by spring boot must extend from SpringBootServletInitializer

The first step in producing a deployable war file is to provide a SpringBootServletInitializer 
subclass and override its configure method. 
Doing so makes use of Spring Framework�s Servlet 3.0 support and lets you configure your application when it is launched by the servlet container.
 Typically, you should update your application�s main class to extend SpringBootServletInitializer

extending the SpringBootServletInitializer and overrides the configure() method. That method uses SpringApplicationBuilder to simply register our 
class as a configuration class of the application
It binds Servlet, Filter and ServletContextInitializer beans from the application context to the server.

If not present create the hierarchy src/main/webapp/WEB-INF/jsp/
Look at the application.properties file.
http://localhost:8080/empapp/

MVC architecture

Models--> Java POJOs
Controllers--> Spring Controllers (NOT RESTCONTROLLERS)
View --> jsp pages

DispatcherServlet--> CustomControllers

Custom Controllers will take care of application flow wrt where to go next and with what request data


index.jsp-->will display a link to login page
login.jsp--> accept username/password and go to -->showoptions.jsp
showoptions.jsp-->2 links 1. Add Employee-->that adds employee to DB-->addemployee.jsp
									  -->employeeadded.jsp
			  2. View All Employees  Display all employees in tabular format-->viewall.jsp




Controller should return 1. Model data (ModelMap)2. Viewname-->String value


index

WEB-INF/jsps/
	--index.jsp	


spring mvc should convert the viewname to displayable view i.e. index---> /WEB-INF/jsps/index.jsp
This mapping of viewname to view resource is done by ViewResolver component

viewResolver requires 2 properties
				1. prefix for viewname -->/WEB-INF/jsp/
				2. suffix for viewname -->.jsp
as a result viewname index---> /WEB-INF/jsps/index.jsp  (prefix+viewname+suffix)

Model-->Employee.java
views--> index.jsp,login.jsp,showoptions.jsp,addemployee.jsp,employee-added.jsp,viewall.jsp
Controller-->EmployeeController
		startup()-->/-->index
		login()-->/login-->showoptions
		addEmployee()-->/addEmployee-->model and view-->addemployee
		saveEmployee()-->/saveEmployee-->employee-added
		viewAll()-->/viewAll-->viewall

		In most of JSPs u will require a model(Employee) to be present
		Spring provides 2 apis
				1. ModelMap--->deals only with request scoped model data
				2. ModelAndView ---> deals with req scoped model data/viewname







