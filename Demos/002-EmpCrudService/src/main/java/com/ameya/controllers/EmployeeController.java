package com.ameya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ameya.models.Employee;
import com.ameya.services.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@Api(value="EmployeeCRUDService",description="Operations pertaining to EmployeeCrudService")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value="View List of Employees",response= Iterable.class)
	@ApiResponses(value= {
			@ApiResponse(code=401, message="You are not authorized to view the resources"),
			@ApiResponse(code=403, message="Resource Forbidden"),
			@ApiResponse(code=200, message="Operation Successful")		
	})
	@GetMapping(path="/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@GetMapping(path="/employees/{empId}")
	@ApiOperation(value = "Search a Employee with an empId",response = Employee.class)
	public Employee getEmployee(@PathVariable("empId") Integer empId) {
		return employeeService.getEmployee(empId);
	}
	@PostMapping(path="/employees")
	@ApiOperation(value = "Add a Employee")
	public String addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	@PutMapping(path="/employees/{empId}")
	@ApiOperation(value = "Update a Employee")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable("empId") Integer empId) {
		return employeeService.updateEmployee(empId, employee);
	}
	@DeleteMapping(path="/employees/{empId}")
	@ApiOperation(value = "Delete a Employee")
	public String deleteEmployee(@PathVariable("empId") Integer empId) {
		return employeeService.deleteEmployee(empId);
	}
	@GetMapping(path="/employees/getbyfnameignorecase/{firstName}")
	@ApiOperation(value = "Search Employee based on firstName")
	public Employee getByFirstNameIgnoreCase(@PathVariable String firstName) {
		return employeeService.getByFirstNameIgnoreCase(firstName);
	}
}
