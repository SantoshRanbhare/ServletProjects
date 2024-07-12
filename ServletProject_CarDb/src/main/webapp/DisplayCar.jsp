<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="DisplayCar.css" rel="stylesheet" />
</head>
<body>
	<% ResultSet result = (ResultSet)request.getAttribute("result"); 
	%>
	<div>
			<table>
			<thead>
				<th>CarId</th>
				<th>CarName</th>
				<th>CarBrand</th>
				<th>CarColor</th>
				<th>CarPrice</th>
				<th>Update</th>
				<th>Delete</th>
			</thead>
			<% while(result.next()) {%>
			<tbody>
				<tr>
					<td><%= result.getInt(1) %></td>
					<td><%= result.getString(2) %></td>
					<td><%= result.getString(3) %></td>
					<td><%= result.getString(4) %></td>
					<td><%= result.getInt(5) %></td>
					<td><a href="updateCar?carId=<%= result.getInt(1) %>">Update</a></td>
					<td><a href="deleteCar?carId=<%= result.getInt(1) %>">Delete</a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<div>
	<a href="index.jsp">Go Back To DashBoard</a>
	</div>
</body>
</html>