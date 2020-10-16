package com.ameya.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ameya.models.Student;

@RestController
public class StudentServiceController {
	private static Map<String, List<Student>> schoolRecords = 
			new HashMap<String, List<Student>>();
	static {
		schoolRecords = new HashMap<String, List<Student>>();

		List<Student> lst = new ArrayList<Student>();
		Student std = new Student("Ameya", "Class X");
		lst.add(std);
		std = new Student("Avani", "Class VI");
		lst.add(std);

		schoolRecords.put("BCA", lst);

		lst = new ArrayList<Student>();
		std = new Student("Sanjay", "Class IX");
		lst.add(std);
		std = new Student("Kalpesh", "Class VI");
		lst.add(std);

		schoolRecords.put("VPNCPS", lst);

	}
	@RequestMapping(value = "/getstudentdetailsforschool/{schoolname}", 
					method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
		System.out.println("Getting Student details for " + schoolname);

		List<Student> studentList = schoolRecords.get(schoolname);
		if (studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not Found", "N/A");
			studentList.add(std);
		}
		return studentList;
	}
	
}
