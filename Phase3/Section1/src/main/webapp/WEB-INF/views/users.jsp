<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Users</title>
</head>
<body>
	<h1 style="color: blue">
		<marquee behavior="alternate">List of Users</marquee>
	</h1>
	<br />

	<table style="border: solid;">

		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>City</th>
				<th>Role</th>
			</tr>
		</thead>
		<c:forEach items="${users}" var="users">
			<tbody>
				<tr>
					<td>${users.id}</td>
					<td>${users.name}</td>
					<td>${users.city}</td>
					<td>${users.role}</td>
				</tr>
			</tbody>


		</c:forEach>
	</table>
</body>
</html>