package com.ameya.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	@GetMapping
	public String rootURL() {
		return "This is authorized and permitted to all";
	}
	@GetMapping("/rest/hello")
	public String hello() {
		return "Hello All !! This is authorized and permitted only to role ADMIN";
	}

}
