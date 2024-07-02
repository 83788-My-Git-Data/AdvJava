<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>
		Welcome to Spring MVC!
	</h5>
	<h3>
	<c:url var="url" value="/test/multiply?num1=123&num2=155"/>
	<a href="${url}">Test Model Map with Request Parameters</a>
	</h3>
	
	<h3>
	<c:url var="url" value="/posts/views?categoryName=cat-1"/>
	<a href="${url}">List Blog Posts By Category Name</a>
	</h3>
	
</body>
</html>