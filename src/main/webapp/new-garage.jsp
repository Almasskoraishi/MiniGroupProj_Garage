<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="createNewGarageServlet" method="post">
		<!-- Garage Name -->
		Garage Name: <input type="text" name="garageName"
			placeholder="Eli's Garage"> <br />
		<!-- Owner name -->
		Owner Name: <input type="text" name="ownerName"
			placeholder="Eli Edlund"> <br />
		<!--  Submit -->
		<input type="submit" value="Create a garage.">
	</form>
	<a href="index.html"> Add a vehicle instead.</a>
</body>
</html>