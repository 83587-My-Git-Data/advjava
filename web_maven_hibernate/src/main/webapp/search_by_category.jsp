<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search By Category</title>
</head>
<jsp:useBean id="search" class="com.sunbeam.beans.CategoryBean"
	scope="session"/>
<body>
	<form action="show_products_by_category.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Choose Category</td>
				<td><select name="categoryId">
						<c:forEach var="category"
							items="${sessionScope.search.allCategories()}">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form>
</body>

</html>