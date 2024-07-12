<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
	ResultSet result = (ResultSet)request.getAttribute("resultSet"); 
	result.next();
	%>
	<div class="container">
		<h1>Welcome To Car Management System</h1>
		<form action="saveUpdatedCar" method="post">
			<input type="number" value="<%= result.getInt(1) %>" name="carId" readonly="true"><br> 
			<input type="text" value="<%= result.getString(2) %>" name="carName"><br> 
			<input type="text" value="<%= result.getString(3) %>" name="carBrand"><br> 
			<input type="text" value="<%= result.getString(4) %>" name="carColor"><br>
			<input type="number" value="<%= result.getInt(5) %>" name="carPrice"><br> 
			<input type="submit" value="UPDATE">
		</form>
	</div>
</body>
</html>