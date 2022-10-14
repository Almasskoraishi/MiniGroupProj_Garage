<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Garage</title>
</head>
<body>
	<form action="editGarageListServlet" method="post">
		<input type="hidden" name="ID" value="${listToEdit.ID}">
		<!-- GARAGE NAME -->
		Garage name: <input type="text" name="garageName"
			value="${listToEdit.garageName}"> <br />
		<!-- OWNER NAME -->
		Owner name: <input type="text" name="ownerName"
			value="${listToEdit.garageOwner.name}"> <br /> Available vehicles:
		<br /> <select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentItem">
				<option value="${currentItem.plateNum}">${currentItem.ownerName}|${currentItem.makeModelYear}</option>
			</c:forEach>
		</select><br /> <input type="submit" value="Save">
	</form>
	<a href="index.html">Add a new vehicle instead.</a>
</body>
</html>