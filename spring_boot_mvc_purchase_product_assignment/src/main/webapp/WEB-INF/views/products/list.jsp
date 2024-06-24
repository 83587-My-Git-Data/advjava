<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List</title>
</head>
<body>
	<h5 style="text-align: center">${sessionScope.message}</h5>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>
					<h5>Products list will be shown here</h5>
				</td>
			</tr>
			<tr>
				<td><select name=productId>
						<c:forEach var="product" items="${sessionScope.product_list}">
							<option value="${product.id}">${product.productName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter the quantity <input type="number" name="quantity" />
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Purchase" /></td>
			</tr>
		</table>
	</form>
</body>
</html>