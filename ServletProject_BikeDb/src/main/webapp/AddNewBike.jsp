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

	<div>
		<h1>Add New Car Details</h1>
		<div>
			<form action="addNewBike" method="post">
				<input type="number" placeholder="Enter Bike Id" required name="bikeId">
				<input type="text" placeholder="Enter Bike Name" required name="bikeName"> 
				<input type="text" placeholder="Enter Bike Brand" required name="bikeBrand"> 
				<input type="text" placeholder="Enter Bike Color" required name="bikeColor"> 
				<input type="number" placeholder="Enter Bike Price" required name="bikePrice">
				<input type="submit" value="ADD">
			</form>
		</div>
	</div>


</body>
</html>