<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>

    <body>
        <h1>Registration Page</h1>
        <form:form modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr><form:errors path="" element="div"/></tr>
            <tr>
                <td>Name: </td>
                <td><form:input path="username" />
                    <form:errors path="username"/></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><form:input path="password" />
                    <form:errors path="password"/></td>
            </tr>
            
            <tr>
                <td>Email: </td>
                <td><form:input path="email" />
                    <form:errors path="email"/></td>
            </tr>
            
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>                   
        </table>
    </form:form>
    </body>

    </html>