<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome 2 Spring Boot @ ${requestScope.ts}</h4>
	<h5>
		<c:url var="url" value="products/list" />
		<a href="${url}">Purchase Product</a>
	</h5>
</body>
</html>