<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="garageNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentList">
				<tr>
					<td><input type="radio" name="ID"
						value="${currentList.ID}">
					<td><h2>${currentList.garageName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Owner: ${currentList.garageOwner.name}</td>
				</tr>
				<c:forEach var="listVal" items="${currentList.vehicles}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.plateNum},${listVal.makeModelYear}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList"><input
			type="submit" value="delete" name="doThisToList"><input
			type="submit" value="add" name="doThisToList">
	</form>
	<a href="addVehiclesForListServlet"> Create a new garage.</a>
	<a href="index.html">Add a new vehicle.</a>
</body>
</html>