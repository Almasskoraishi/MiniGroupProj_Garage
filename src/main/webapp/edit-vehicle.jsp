<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Vehicle</title>
</head>
<body>
<body>
	<form action="editVehicleServlet" method="post">
		<!-- Owner name -->
		Owner name: <input type="text" name="ownerName" value="${itemToEdit.ownerName}">
		<!-- Make, model, year -->
		Make, Model, Year: <input type="text" name="makeModelYear" value="${itemToEdit.makeModelYear}">
		<!-- PlateNum -->
		<input type="hidden" name="plateNum" value="${itemToEdit.plateNum}">
		<!-- submit -->
		<input type="submit" value="Save Edited Vehicle Information">
		<br />
		Attention: Plate numbers cannot be edited. If you entered the plate number incorrectly please delete and re-add your vehicle. Thank you.
	</form>
</body>
</html>