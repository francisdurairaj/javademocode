package com.ameya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ameya.webclient.EmployeeWebClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		EmployeeWebClient client=new EmployeeWebClient();
		client.consume();

	}

}
