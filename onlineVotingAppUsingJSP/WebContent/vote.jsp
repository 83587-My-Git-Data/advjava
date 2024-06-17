<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
	<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean" />
	<jsp:useBean id="ib" class="com.sunbeam.beans.IndexBean"
		scope="session" />
	<jsp:setProperty name="vb" property="candId" param="candidate" />
	<jsp:setProperty name="vb" property="userId" value="${ib.user.id}" />
	<%
	vb.vote();
	%>
	<h3>Online Voting</h3>
	You have successfully voted.
	<a href="index.jsp">Logout</a>
</body>
</html>