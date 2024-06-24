<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Products by Category</title>
</head>
<jsp:useBean id="display" class="com.sunbeam.beans.ProductBean"
	scope="session" />
<jsp:setProperty property="categoryId" name="display" />
<body>
	<form action="purchase_a_product.jsp" method="post">
		<table border='1' style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Product Id</td>
				<td>Product Name</td>
				<td>Quantity</td>
			</tr>
			<c:forEach var="product" items="${display.productsByCategory()}">
				<tr>
					<td>${product.id}</td>
					<td>${product.productName}</td>
					<td>${product.quantity}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="search_by_category.jsp">Search Again</a></td>
				<td><a href="index.jsp">Home Page</a></td>
				<td><a href="logout.jsp">Logout</a></td>
			</tr>
		</table>

	</form>
</body>
</html>