<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Page</title>
</head>
<body>
<div align="center">
    <h2>Edit your details</h2>
    <form:form method="POST" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${user.id}
                    <form:hidden path="id"/>
                </td>
            </tr>       
            <tr>
                <td>Name: </td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><form:input path="password" /></td>
            </tr>
            
            <tr>
                <td>Email: </td>
                <td><form:input path="email" /></td>
            </tr>
            
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>                   
        </table>
    </form:form>
</div>
</body>
</html>