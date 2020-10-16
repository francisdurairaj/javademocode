<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 
	This will not display username after u come here from employee-added.jsp page 
	As Model attribute is modified hence better to retrieve it from sessions
 -->
<h2>Welcome ${employee.userName}</h2>
<center>
	<table>
    	<tr><td><A href="addEmployee">Add Employee</A></td></tr>
    	<tr><td><A href="viewAll">View All</A></td></tr>
    </table>
    </center>
</body>
</html>