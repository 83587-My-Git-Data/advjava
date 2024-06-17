<%@page import="com.sunbeam.pojos.User"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean" />
	<jsp:setProperty name="rb" property="firstName" param="first_name" />
	<jsp:setProperty name="rb" property="lastName" param="last_name" />
	<jsp:setProperty name="rb" property="email" param="email" />
	<jsp:setProperty name="rb" property="password" param="password" />
	<jsp:setProperty name="rb" property="dob" param="dob" />
	<jsp:setProperty name="rb" property="status" param="status" />
	<jsp:setProperty name="rb" property="role" param="role" />
	<%
	System.out.println("OK");
	rb.register();
	%>
	<%
	if (rb.getUser() != null) {
	%>
	Registration Successful
	<br /> Welcome,
	<jsp:getProperty name="rb" property="firstName" />
	<br />
	<a href="index.jsp">Login</a>
	<%
	} else {
	%>
	Login Failed.
	<%
	}
	%>
</body>
</html>