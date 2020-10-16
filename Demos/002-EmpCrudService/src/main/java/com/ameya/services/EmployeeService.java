package com.ameya.services;

import java.util.List;

import com.ameya.models.Employee;

public interface EmployeeService {
	public List<Employee>getAllEmployees();
	public String addEmployee(Employee employee);
	public String updateEmployee(Integer empId,Employee employee);
	public Employee getEmployee(Integer empId);
	public String deleteEmployee(Integer empId);
	public Employee getByFirstNameIgnoreCase(String firstName);
}
