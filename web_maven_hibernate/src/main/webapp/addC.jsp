<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product Page</title>
</head>
<jsp:setProperty property="*" name="category_bean"/>
<body>
	<h5>${sessionScope.category_bean.addNewCategory()}</h5>
</body>
</html>