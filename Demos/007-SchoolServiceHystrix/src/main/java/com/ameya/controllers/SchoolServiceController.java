package com.ameya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ameya.delegates.StudentServiceDelegate;

@RestController
public class SchoolServiceController {

	@Autowired
	private StudentServiceDelegate studentServiceDelegate;
	
	@RequestMapping(value = "/getschooldetails/{schoolname}", method = RequestMethod.GET)
	public String getStudents(@PathVariable String schoolname) {
		System.out.println("Going to call student service to get data!");
		return studentServiceDelegate.invokeStudentServiceAndGetData(schoolname);
	}
}
