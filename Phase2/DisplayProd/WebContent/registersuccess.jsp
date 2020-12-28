<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Product Registered!<br/>
Product Name: <%= session.getAttribute("sesname") %><br/>
Product Amount: <%= session.getAttribute("sesamt") %><br/>

<a href="register.jsp">Add another product</a>
</body>
</html>