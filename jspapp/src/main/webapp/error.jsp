<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h3>Error Page</h3>
	Some error has occurred. Please contact your vendor.
	<br /> Email: abhaydange89@gmail.com
	<br />
	<br />
	Error: <%= exception.getMessage() %>
</body>
</html>