<%@page import="com.sunbeam.pojos.Candidate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
</head>
<body>
<jsp:useBean id="ib" class="com.sunbeam.beans.IndexBean"
		scope="session" />
	<h3>${initParam.appTitle}</h3>
	Hello, ${ib.user.firstName} ${ib.user.lastName}
	<br />
	<jsp:useBean id="cb" class="com.sunbeam.beans.CandListBean" />
	<form method="post" action="vote.jsp">
		<table>
			<tr>
				<td></td>
				<td>Id</td>
				<td>Name</td>
				<td>Party</td>
			</tr>
			<%
			cb.provide();
			%>
			<%
			if (cb.getCandlist() != null) {
				for (Candidate c : cb.getCandlist()) {
			%><tr>
				<td><input type="radio" name="candidate" value=<%=c.getId()%> /></td>
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
			</tr>
			<%
			}
			}
			%>
		</table>
		<input type="submit" value="vote">
	</form>
</body>
</html>