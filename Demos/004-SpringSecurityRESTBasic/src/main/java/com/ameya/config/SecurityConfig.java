package com.ameya.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("ameya").password("{noop}1234").roles("ADMIN").and()
		.withUser("avani").password("{noop}1234").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests() //all requests must be through authorizaation
		.antMatchers("/").permitAll() // "/" is permitted to all
		.antMatchers("/rest/hello*").access("hasRole('ROLE_ADMIN')")//accessible only to admins
		.and()
		.httpBasic();
		http.csrf().disable();
		
	}

}
