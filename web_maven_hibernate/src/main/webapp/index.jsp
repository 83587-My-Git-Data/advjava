<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		Welcome 2 Web App with Hibernate @
		<%=new Date()%></h3>
	<h5>
		<a href="add_product.jsp">Add Product</a>
	</h5>
	<h5>
		<a href="add_category.jsp">Add Category</a>
	</h5>
	<h5>
		<a href="search_by_category.jsp">Search By Category</a>
	</h5>
	<h5>
		<a href="purchase_a_product.jsp">Purchase Product</a>
	</h5>
</body>
</html>