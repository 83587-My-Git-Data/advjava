<%-- JSP DIRECTIVE --%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Syntax</title>
</head>
<body>
	<h1>JSP Syntax Demo</h1>
	<%-- JSP Declaration --%>
	<%!
	//fields (of generated servlet class)
	int count = 0;
	//methods (of generated servlet class)
	public void jspInit(){
		System.out.println("demo01 jspInit() called");
	}
	public void jspDestroy(){
		System.out.println("demo01 jspDestroy() called");
	}
	%>
	
	<%-- JSP Scriplet --%>
	<%
	Date now = new Date();
	out.println("Server Time: " + now);
	%>
	<br/><br/>
	<% count++; %>
	<% if(count%2 == 0){ %>
		Even Count: <%= count %>
	<%} else { %>
		Odd Count: <%= count %>
	<% } %>
	<br/><br/>
	
	<%
		if(count % 2 == 0){
			out.println("Event count: " + count);
		}
		else{
			out.println("Odd count: " + count);
		}
	%>
</body>
</html>