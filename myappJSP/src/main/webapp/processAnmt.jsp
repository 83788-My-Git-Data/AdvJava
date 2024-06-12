<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="an" class="com.sunbeam.jspapp.AnnouncementBean" scope="application"/>
	<jsp:setProperty property="msg" name="an" param="announce"/>
	<jsp:forward page="result.jsp"></jsp:forward>
	
</body>
</html>