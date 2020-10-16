package com.ameya.services;

import org.springframework.stereotype.Service;

import com.ameya.models.Employee;

@Service
public class EmployeeService {

	public Employee createEmployee(String name,String empId) {
		Employee emp=new Employee();
		emp.setName(name);
		emp.setEmpId(empId);
		return emp;
	}
	public void deleteEmployee(String empId) {
		System.out.println("+++ Employee with id "+empId+" DELETED +++");
	}
}
