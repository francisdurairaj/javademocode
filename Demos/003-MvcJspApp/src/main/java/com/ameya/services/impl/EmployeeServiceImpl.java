package com.ameya.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ameya.daos.EmployeeDAO;
import com.ameya.models.Employee;
import com.ameya.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=new ArrayList<>();
		employeeDao.findAll().forEach(employees::add);
		return employees;
	}

	@Override
	public String addEmployee(Employee employee) {
		return (employeeDao.save(employee)!=null?"Employee saved":"Error while saving");
	}

	@Override
	public String updateEmployee(Integer empId, Employee employee) {
		Optional<Employee> container=employeeDao.findById(empId);
		Employee empToUpdate=container.get();
		empToUpdate.setFirstName(employee.getFirstName());
		empToUpdate.setMidName(employee.getMidName());
		empToUpdate.setLastName(employee.getLastName());
		empToUpdate.setSalary(employee.getSalary());
		return (employeeDao.save(empToUpdate)!=null?"Employee Updated":"Error while updating");
	}

	@Override
	public Employee getEmployee(Integer empId) {
		return employeeDao.findById(empId).get();
	}

	@Override
	public String deleteEmployee(Integer empId) {
		String retVal="Deleted Employee";
		try {
			employeeDao.deleteById(empId);
		}catch(Exception e) {
			retVal="Error while deleting";
		}
		return retVal;
	}
}
