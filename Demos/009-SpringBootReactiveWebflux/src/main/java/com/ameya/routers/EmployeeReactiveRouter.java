package com.ameya.routers;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ameya.daos.EmployeeRepository;
import com.ameya.models.Employee;

@Configuration
public class EmployeeReactiveRouter {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Bean
	RouterFunction<ServerResponse> getAllEmployees(){
		return route(
				GET("/employees"),
				req->ok().body(employeeRepository.findAllEmployees(),Employee.class)
				);
				
	}
	@Bean
	RouterFunction<ServerResponse> getEmployeeById(){
		return route(
				GET("/employees/{id}"),
				req->ok().body(
							employeeRepository.findEmployeeById(req.pathVariable("id"))
							,Employee.class));
	}
	
	/*
    @Bean
    RouterFunction<ServerResponse> updateEmployeeRoute() {
    	System.out.println("++++ updateEmployeeRoute() ++++");
      return route(POST("/employees/update"), 
        req -> req.body(toMono(Employee.class))
                  .doOnNext(employeeRepository::updateEmployee)
                  .then(ok().build()));
    }
	 */
}
