<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${sessionScope.userName}</h2>
	<form:form method="POST" modelAttribute="employee" action="saveEmployee">
		<center>
			<table>
				<tr>
					<td>Emp Id :</td>
					<td><form:input path="empId" /></td>
				</tr>
				<tr>
					<td>FirstName :</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>MidName :</td>
					<td><form:input path="midName" /></td>
				</tr>
				<tr>
					<td>LastName :</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Salary :</td>
					<td><form:input path="salary" /></td>
				</tr>
				<tr>
					<td>Username :</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="ADD"></td>
					<td><input type="reset" value="CLEAR" /></td>
				</tr>
			</table>
		</center>
	</form:form>
</body>
</html>