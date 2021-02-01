<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a product</title>
</head>
<body>
    <div align="center">
        <h2>Edit your details</h2>
        <form:form method="POST" modelAttribute="singleproduct">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${singleproduct.id}
                        <form:hidden path="id"/>
                    </td>
                </tr>
                <tr>
                    <td>Image: </td>
                    <td>
                        <form:input path="image"/>
                    </td>
                </tr>       
                <tr>
                    <td>Name: </td>
                    <td><form:input path="productname" /></td>
                </tr>
                <tr>
                    <td>Category: </td>
                    <td><form:input path="category" /></td>
                </tr>
                
                <tr>
                    <td>Description: </td>
                    <td><form:input path="proddescription" /></td>
                </tr>

                <tr>
                    <td>Price: </td>
                    <td><form:input path="price" /></td>
                </tr>
                
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>                   
            </table>
        </form:form>
    </div>
</body>
</html>