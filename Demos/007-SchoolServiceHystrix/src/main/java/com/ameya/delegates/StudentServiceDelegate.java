package com.ameya.delegates;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class StudentServiceDelegate {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@HystrixCommand(fallbackMethod = "fallBackForSchoolService")
	public String invokeStudentServiceAndGetData(String schoolname) {
		System.out.println("Getting School Details for :: "+schoolname);
		String response=restTemplate
				.exchange(
						"http://localhost:8098/getstudentdetailsforschool/{schoolname}",
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<String>() {
						},
						schoolname
						).getBody();
		System.out.println("Response Recieved as "+response+" - "+new Date());
		return "Normal Flow !! School Name - "+schoolname+" Students - "
		+response+" - "+new Date();
	}
	
	private String fallBackForSchoolService(String schoolname) {
		System.out.println("Student Service Not Responding Fallback enabled");
		return "Circuite Breaker Enabled !! No "+
				"Response from Student service at this moment.Service will be back shortly - "
					+new Date();
	}

}
