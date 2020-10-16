<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${sessionScope.userName}</h2>
<center>
	<h2>List Of Employees</h2>
	<table border="2">
		<tr><th>EMPID</th><th>FIRSTNAME</th><th>MIDNAME</th><th>LASTNAME</th><th>SALARY</th><th>USERNAME</th></tr>
		<c:forEach var="emp" items="${empList}">
		<tr><td>${emp.empId}</td><td>${emp.firstName}</td><td>${emp.midName}</td><td>${emp.lastName}</td><td>${emp.salary}</td><td>${emp.userName}</td></tr>
		</c:forEach>
	</table>
</center>
</body>
</html>