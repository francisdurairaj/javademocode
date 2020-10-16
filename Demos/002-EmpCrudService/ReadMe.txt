Create a spring starter project
dependencies web jpa mysql, actuator, swagger,

Observe the entries in application.properties file
Rest URLS :

GET  : http://localhost:9001/employees/103
GET  : http://localhost:9001/employees
GET  : http://localhost:9001/getbyfnameignorecase/ameya
POST : http://localhost:9001/employees --->This will have Json in body
PUT  : http://localhost:9001/employees/103--->this will have Json in body
DELETE : http://localhost:9001/employees/103

NOTE : See the console for SQL queries
NOTE : Change the name of getByFirstNameIgnoreCase() to getByFirstName() in controller/service/serviceImpl/dao

rerun the code
and invoke GET  : http://localhost:8080/getbyfname/ameya


Actuators : 
Observe the entriesin application.properties for management endpoints

#Post request
#http://localhost:9001/actuator/shutdown

#Get request
#http://localhost:9001/actuator/health
#http://localhost:9001/actuator/info
#http://localhost:9001/actuator/beans
#http://localhost:9001/actuator/env

Swagger :
Add the dependencies in pom.xml update maven project
Code in the com.ameya.employee.SwaggerConfig class
Make Use of @ApiModelProperty in model class
Make Use of @Api, @ApiOperation,@ApiResponses,@ApiResponse in Controller.
URLS : 
http://localhost:9001/v2/api-docs
http://localhost:9001/swagger-ui.html

