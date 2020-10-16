package com.ameya.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class AppMVCConfig implements WebMvcConfigurer {
	
	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = 
	    		new DriverManagerDataSource();
		 driverManagerDataSource.setDriverClassName
		    ("com.mysql.jdbc.Driver");
		 driverManagerDataSource.setUrl
		    ("jdbc:mysql://localhost:3306/verizondb");
		 driverManagerDataSource.setUsername("root");
		 driverManagerDataSource.setPassword("root");
		 return driverManagerDataSource;
		
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = 
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry reg) {
		reg.addViewController("/home").setViewName("home");
		reg.addViewController("/").setViewName("home");
		reg.addViewController("/hello").setViewName("hello");
		reg.addViewController("/login").setViewName("login");
		reg.addViewController("/forbidden").setViewName("forbidden");
		
	}
}
