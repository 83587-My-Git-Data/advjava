<%@page import="com.sunbeam.pojos.Candidate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<jsp:useBean id="cb" class="com.sunbeam.beans.CandListBean" />
	<table border='1'>
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Party</td>
			<td>Votes</td>
			<td>Action</td>
		</tr>
		<%
		cb.provide();
		%>
		<%
		if (cb.getCandlist() != null) {
			for (Candidate c : cb.getCandlist()) {
		%><tr>

			<td>
				<%
				out.println(c.getId());
				%>
			</td>
			<td>
				<%
				out.println(c.getName());
				%>
			</td>
			<td>
				<%
				out.println(c.getParty());
				%>
			</td>
			<td>
				<%
				out.println(c.getVotes());
				%>
			</td>
			<td><a href="editcandlist.jsp"><img alt="edit" src="images/edit.png" height="24px" width="24px" /></a>
			<a><img alt="delete" src="images/delete.png" height="24px" width="24px" /></a></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<input type="submit" value="Save">
</body>
</html>