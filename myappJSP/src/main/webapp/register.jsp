<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>$initParam.appTitle</h2>
	<form method="post" action="registerpage.jsp">
	
		FirstName: <input type="text" name="firstName"/> <br/><br/>
		LastName: <input type="text" name="lastName"/> <br/><br/><br/>
		Email: <input type="text" name="email"/> <br/><br/><br/>
 	 	 Birth: <input type="date" name="birth"/> <br/><br/>
		Password: <input type="password" name="passwd"/> <br/><br/>
		<input type="submit" value="Register"/>
	</form>
	
</body>
</html>