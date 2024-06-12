<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dbu" class="com.sunbeam.jspapp.deletecand" scope="session"/>
	<jsp:setProperty property="id" name="dbu" param="id"/>
	${dbu.deleteCandidate()}
	<c:choose>
		<c:when test="${dbu.count == 1}">
			deleted successful.
			<a href="result.jsp">show result page</a>
		</c:when>
		<c:otherwise>
			delete failed.
			<a href="result.jsp">show result page</a>
		</c:otherwise>
	</c:choose>
	
	

</body>
</html>