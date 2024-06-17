<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h3>Registration USING JSP</h3>
	<form method="post" action="registerbean.jsp">
		First Name: <input type="text" name="first_name" /> <br /> <br />
		Last Name: <input type="text" name="last_name" /> <br /> <br />
		Email: <input type="text" name="email" /> <br /> <br /> Password: <input
			type="password" name="password" /> <br /> <br /> Dob: <input
			type="date" name="dob" /> <br /> <br /> <input type="hidden"
			name="status" value="0" /> <input type="hidden" name="role"
			value="voter" /> <input type="submit" value="Sign Up" /> <a
			href="index.html">Sign In</a>
	</form>
</body>
</html>