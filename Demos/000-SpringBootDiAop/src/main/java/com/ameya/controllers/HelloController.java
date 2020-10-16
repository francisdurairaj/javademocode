package com.ameya.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
	
	@RequestMapping(path="/greet",method=RequestMethod.GET)
	public String greetWorld(){
		return "Hello World....!! Welcome To Spring Boot !!";
	}

}