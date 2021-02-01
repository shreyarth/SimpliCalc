<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Add a product</title>
            </head>

            <body>
                Something to test
                <h1>Add Product Page</h1>
                <form:form modelAttribute="product">
                    <form:errors path="" element="div" />
                    <div>
                        <form:hidden path="id" />
                    </div>
                    <div>
                        <form:label path="productname">Product Name</form:label>
                        <form:input path="productname" />
                        <form:errors path="productname" />
                    </div>
                    <div>
                        <form:label path="category">Category</form:label>
                        <form:input path="category" />
                        <form:errors path="category" />
                    </div>
                    <div>
                        <form:label path="proddescription">Description</form:label>
                        <form:input path="proddescription" />
                        <form:errors path="proddescription" />
                    </div>
                    <div>
                        <form:label path="image">Image</form:label>
                        <form:input path="image" />
                        <form:errors path="image" />
                    </div>
                    <div>
                        <form:label path="price">Price</form:label>
                        <form:input path="price" />
                        <form:errors path="price" />
                    </div>
                    <div>
                        <input type="submit" value="Add" />
                    </div>
                </form:form>
            </body>

            </html>