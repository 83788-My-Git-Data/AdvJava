<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h3>${initParam.appTitle }</h3>
<jsp:useBean id="vb" class="com.sunbeam.jspapp.voteBean" scope="session"/>
<jsp:setProperty property="id" name="vb" param="candidate"/>
<jsp:setProperty property="userid" name="vb" value="${lb.user.id }"/>
${vb.votetocandidate()};
<c:choose>
	<c:when test="${lb.user.status == 0}">
	
		<c:choose>
		<c:when test="${vb.count == 1}">
			Thankyou.Voted successful.
			<%-- HttpSession session=request.getSession(); --%>
			<% session.invalidate(); %>
			<a href="login.jsp">Logout</a>
		</c:when>
		<c:otherwise>
			vote not count.
			<a href="candlist.jsp">try again</a>
		</c:otherwise>
	</c:choose>
	
	</c:when>
	<c:otherwise>
			Already voted...!
			<a href="login.jsp">Logout</a>
		</c:otherwise>
</c:choose>


</body>
</html>