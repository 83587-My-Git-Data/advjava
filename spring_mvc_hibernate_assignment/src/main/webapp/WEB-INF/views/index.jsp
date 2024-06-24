<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h5>Welcome to DMART...</h5>
	<h5>
		<c:url var="url" value="/products/view?categoryName=Books" />
		<a href="${url}">List Products By Category Name</a>
	</h5>
</body>
</html>