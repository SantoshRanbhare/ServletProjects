<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="AddCar.css" rel="stylesheet">
</head>
<body>
	<div>
		<h1>Welcome To Car Management System</h1>
		<form action="addNewCar" method="post">
			<input type="number" placeholder="Enter Car Id" name="carId"><br>
			<input type="text" placeholder="Enter Car Name" name="carName"><br>
			<input type="text" placeholder="Enter Car Brand" name="carBrand"><br>
			<input type="text" placeholder="Enter Car Color" name="carColor"><br>
			<input type="number" placeholder="Enter Car Price" name="carPrice"><br>
			<input type="submit" value="ADD">
		</form>
	</div>
</body>
</html>