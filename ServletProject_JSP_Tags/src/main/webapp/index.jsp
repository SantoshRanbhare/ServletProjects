<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Directive Tag -->
    <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Declarative Tag -->
	<%!
		int a = 10;
		String n = "Sandy";
		String[] names = {"Abi","Deva","Harsha","Tamil"};
	%>
	
	<!-- Expression Tag  -->
	<h2><%= a %></h2>
	<h2><%= n %></h2>
	
	<!-- Scriptlet Tag -->
	<%for(String name:names) {%>
	<h2><%= name %></h2>
	<%} %>
</body>
</html>