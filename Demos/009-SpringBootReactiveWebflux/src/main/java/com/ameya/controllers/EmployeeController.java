/*
 * package com.ameya.controllers;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.ameya.daos.EmployeeRepository; import com.ameya.models.Employee;
 * 
 * import reactor.core.publisher.Flux; import reactor.core.publisher.Mono;
 * 
 * @RestController
 * 
 * @RequestMapping("/employees") public class EmployeeController {
 * 
 * @Autowired private EmployeeRepository employeeRepository;
 * 
 * @GetMapping("/{id}") public Mono<Employee> getEmployeeById(@PathVariable
 * String id) { return employeeRepository.findEmployeeById(id); }
 * 
 * @GetMapping public Flux<Employee> getAllEmployees(){ return
 * employeeRepository.findAllEmployees(); } }
 */