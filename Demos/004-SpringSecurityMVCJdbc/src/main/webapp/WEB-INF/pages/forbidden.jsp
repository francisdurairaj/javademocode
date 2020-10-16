<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Spring Security Example</title>
</head>
<body>
	<div>
	<h2>Spring Security - JDBC Authentication</h2>
		
	</div>
	<div>		
		<div>
			<h3>You do not have permission to access this page!</h3>	
		</div>
		<form action="logout" method="post">
			<input type="submit" value="Sign in as different user" /> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>		
	</div>	
</body>
</html>