<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add new User</h1>
	<form:form modelAttribute="form">
		<form:errors path="" element="div" />
		<div>
			<form:label path="name">User Name</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>
			<form:label path="city">User City</form:label>
			<form:input path="city" />
			<form:errors path="city" />
		</div>
		<div>
			<form:label path="role">User Role</form:label>
			<form:input path="role" />
			<form:errors path="role" />
		</div>

		<div>
			<input type="submit" value="AddUser" />
		</div>
	</form:form>
</body>
</html>