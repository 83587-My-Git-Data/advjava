<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="ib" class="com.sunbeam.beans.IndexBean"
		scope="session" />
	<jsp:setProperty name="ib" property="email" param="email" />
	<jsp:setProperty name="ib" property="password" param="password" />

	<%
	ib.authenticate();
	if (ib.getUser() != null) {
	%>
	<br /> Welcome,
	<jsp:getProperty name="ib" property="email" />
	<br />
	<% if(ib.getUser().getRole().equals("admin")){ %>
	<a href="reslist.jsp">Click here to see the Result List</a>
	<% } else{%>
		<a href="candlist.jsp">Click here to see the Candidate List</a>
	<% } %>
	<%} else {
	%>
	Invalid Credentials
	<a href="index.jsp">Login Again</a>
	<%
	}
	%>

</body>
</html>