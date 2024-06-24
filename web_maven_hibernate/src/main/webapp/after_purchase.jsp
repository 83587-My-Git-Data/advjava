<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>After Purchase Page</title>
</head>
<jsp:setProperty property="*" name="display" />
<body>
	<c:set var="status"
		value="${sessionScope.product_bean.purchaseProduct()}" scope="session" />
	<c:redirect url="/" />
</body>
</html>