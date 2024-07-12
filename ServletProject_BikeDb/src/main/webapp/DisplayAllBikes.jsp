<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body>

	<%@include file="navbar.jsp"%>

	<% ResultSet result = (ResultSet)request.getAttribute("resultSet"); %>
	<div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Bike Id</th>
						<th scope="col">Bike Name</th>
						<th scope="col">Bike Brand</th>
						<th scope="col">Bike Color</th>
						<th scope="col">Bike Price</th>
					</tr>
				</thead>
				<tbody>
					<% while(result.next()) { %>
					<tr><%= result.getInt(1) %></tr>
					<tr><%= result.getString(2) %></tr>
					<tr><%= result.getString(3) %></tr>
					<tr><%= result.getString(4) %></tr>
					<tr><%= result.getInt(5) %></tr>
					<tr><a href="Delete.jsp">Update</a></tr>
					<tr><a href="Delete.jsp">Delete</a></tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>