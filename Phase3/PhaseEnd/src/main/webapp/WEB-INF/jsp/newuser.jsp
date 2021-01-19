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
			<form:label path="username">User Name</form:label>
			<form:input path="username" />
			<form:errors path="username" />
		</div>
		<div>
			<input type="submit" value="AddUser" />
		</div>
	</form:form>
</body>
</html>