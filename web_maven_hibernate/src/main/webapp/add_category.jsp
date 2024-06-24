<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<jsp:useBean id="category_bean" class="com.sunbeam.beans.CategoryBean" scope="session"></jsp:useBean>
<body>
	<form action="addC.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter Category Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter Description</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add A Product" /></td>
			</tr>
		</table>
	</form>

</body>
</html>