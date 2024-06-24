<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase a Product</title>
</head>
<jsp:useBean id="display" class="com.sunbeam.beans.ProductBean"
	scope="session" />
<body>
	<form action="index.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Choose a product</td>
				<td><select name=productId>
						<c:forEach var="product" items="${display.getAllProducts()}">
							<option value="${product.id}">${product.productName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter the Quantity</td>
				<td><input type="number" name="quantity" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Buy" /></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>