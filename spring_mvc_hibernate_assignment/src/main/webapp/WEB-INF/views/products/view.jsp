<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List Page</title>
</head>
<body>
	<h5>All the List of products will be shown here</h5>
	<table style="background-color: lightgrey; margin: auto" border="1">
		<tr>
			<td>id</td>
			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
		</tr>
		<c:forEach var="prods" items="${requestScope.products_list}">
			<tr>
				<td>${prods.id}</td>
				<td>${prods.productName}</td>
				<td>${prods.quantity}</td>
				<td>${prods.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>