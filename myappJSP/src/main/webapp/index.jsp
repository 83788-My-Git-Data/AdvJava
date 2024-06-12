<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${initParam.appTitle}</h2>
<form method="post" action="login.jsp">
Email: <input type="text" name="email"/> <br/><br/>
Password: <input type="password" name="passwd"/> <br/><br/>
<input type="submit" value="Sign In">
<a href="register.jsp">Sign Up</a>
</form>
</body>
</html>