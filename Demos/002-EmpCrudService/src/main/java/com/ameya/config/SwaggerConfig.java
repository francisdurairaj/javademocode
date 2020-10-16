package com.ameya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private ApiInfo metaData() {
		ApiInfo apiInfo=new ApiInfo(
				"Spring Boot Rest Api",
				"Spring Boot REST API for EmployeeCRUDService",
				"1.0",
				"Terms Of Service",
				new Contact("Ameya Joshi","https://ameyajoshi.com/about","ameya@ameyajoshi.com"),
				"Apache License Version 2.0",
				"htts://www.apache.org/license/LICENSE-2.0"
				);
		return apiInfo;
	}
	private Predicate<String> paths(){
		return Predicates.and(
					PathSelectors.regex("/employees.*"),
					Predicates.not(PathSelectors.regex("/error.*"))
				);
	}
	
	@Bean
	public Docket employeeCrudApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ameya.controllers"))
				.paths(paths())
				.build().apiInfo(metaData());
	}
}
