create the spring starter project with web jdbc jpa mysql security add the other dependencies as from pom.xml

Create the SecurityConfiguration class

Create the MVCConfig class Observe the overridden methods and beans created int it.

Create the jsp pages forbidden.jsp hello.jsp home.jsp login.jsp in webapp/WEB-INF/pages

Create the DB and tables and values as shown in db.sql

URLs :localhost:9001/mywebapp/
	  localhost:9001/mywebapp/home
	  	
	  click on link shown on the page
	  
	  try login with ameya/1234
	  try login with avani/1234
	  try login with wrong username/password.
	  
++++++++++++++++In this demo we hardcode password using a simple main calss EnocdePassword.java and copy/paste in DB ++++++++++++++++
package com.ameya;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {

	public static void main(String[] args) {
		String encoded=new BCryptPasswordEncoder().encode("1234");
		System.out.println(encoded);

	}
	
The Spring documentation suggests:

Our recommendation is to use CSRF protection for any request that could be processed by a browser by normal users. 
If you are only creating a service that is used by non-browser clients, you will likely want to disable CSRF protection.
OR You are using another token mechanism.
OR You want to simplify interactions between a client and the server.

}