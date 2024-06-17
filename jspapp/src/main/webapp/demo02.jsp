<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header Footer</title>
</head>
<body>
	<table border="1" width="100%" >
		<tr style="text-align: center">
			<td>
				<%@ include file="header.jsp" %>
			</td> 
		</tr>
		<tr>
			<td height="400px">
				Main content
			</td> 
		</tr>
		<tr style="text-align: center">
			<td>
				<%@ include file="footer.jsp" %>
			</td> 
		</tr>
	</table>
</body>
</html>