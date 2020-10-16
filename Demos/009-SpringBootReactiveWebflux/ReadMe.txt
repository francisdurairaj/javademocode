Create a new spring starter project dependencies -> web, spring webflux(spring reactive web)

Create com.ameya.models.Employee.java as shown
Create com.ameya.daos.EmployeeRepository.java as shown Note the annotations
Create com.ameya.controllers.EmployeeController as shown

Reactive data type called MONO or FLUX is used to model the reactive stream.
MONO or FLUX under the hood is just a function which iterates over the data source and pushes the values to consumer.
Flux is a stream which can emit 0..N elements:
Mono is a stream of 0..1 elements

Create com.ameya.webclient. EmployeeWebClient.java as shown.

Add the WebClient related code in Application.java.

also invoke from browser :  localhost:8080/employees
							localhost:8080/employees/1
							
The NON-BLOCKING controller with Mono/Flux is used to get response

Now comment out the web dependency from pom.xml update the maven project
Comment out all the EmployeeController class

Create com.ameya.routers.EmployeeReactiveRouter.java as shown Note the @Configuration  and @Bean  WebfluxConfigurer RouterFunction route

re-run the code.... the Router will be used in place of controller.