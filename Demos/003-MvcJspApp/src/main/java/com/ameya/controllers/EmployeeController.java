package com.ameya.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ameya.models.Employee;
import com.ameya.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@RequestMapping("/")
	public String startup() {
		return "index";
	}
	@RequestMapping("/login")
	public ModelAndView login(ModelMap model) {
		ModelAndView mav=new ModelAndView();
		model.addAttribute("employee",new Employee());
		mav.setViewName("login");
		//mav.addObject("employee",new Employee());
		return mav;
	}
	@RequestMapping(value="/showoptions")
	public ModelAndView showOptions(@ModelAttribute("employee") Employee employee,
			ModelMap model,HttpSession session) {
		model.addAttribute(employee);
		session.setAttribute("username", employee.getUserName());
		return new ModelAndView("showoptions");
		
	}
	@RequestMapping(value="/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee,
			ModelMap model) {
		model.addAttribute(employee);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("addemployee");
		return mav;
	}
	@RequestMapping(value="/saveEmployee",method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			ModelMap model) {
		employeeService.addEmployee(employee);
		model.addAttribute(employee);
		return "employee-added";
	}
	@RequestMapping(value="/viewAll")
	public ModelAndView getAllEmployees(ModelMap model) {
		ModelAndView mav=new ModelAndView();
		List<Employee> empList=employeeService.getAllEmployees();
		model.addAttribute("empList",empList);
		mav.setViewName("viewall");
		return mav;
	}
}
