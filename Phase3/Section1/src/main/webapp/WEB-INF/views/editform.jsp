<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
    <div align="center">
        <h2>Edit User</h2>
        <form:form action="edituser" method="post" modelAttribute="edituser">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${edituser.id}
                        <form:hidden path="id"/>
                    </td>
                </tr>       
                <tr>
                    <td>Name: </td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>City: </td>
                    <td><form:input path="city" /></td>
                </tr>
                
                <tr>
                    <td>Role: </td>
                    <td><form:input path="role" /></td>
                </tr>
                
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>                   
            </table>
        </form:form>
    </div>
</body>
</html>