package com.ameya.webclient;

import org.springframework.web.reactive.function.client.WebClient;

import com.ameya.models.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmployeeWebClient {

	public WebClient client=WebClient.create("http://localhost:8080");
	public void consume() {
		Mono<Employee> empMono=client.get()
				.uri("/employees/{id}","1")
				.retrieve()
				.bodyToMono(Employee.class);
		
		empMono.subscribe(System.out::println);
		System.out.println("====================");
		
		Flux<Employee> empFlux=client.get()
				.uri("/employees")
				.retrieve()
				.bodyToFlux(Employee.class);
		empFlux.subscribe(System.out::println);		
				
	}
}
