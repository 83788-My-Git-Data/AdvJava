<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.sunbeam.pojos.Candidate" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidates</title>
</head>
<body>
<h3>${initParam.appTitle }</h3>
Announcement:${an.msg}<br/>
Hello, ${lb.user.firstName} ${lb.user.lastName}<hr/>
<jsp:useBean id="clb" class="com.sunbeam.jspapp.CandidateListBean"/>
${clb.fetchCandidates() }
<form method="post" action="vote.jsp">
<c:forEach var="c" items="${clb.candidateList}">
<input type="radio" name="candidate" value="${c.id}"/>${c.name }- ${c.party } <br/>
</c:forEach> 
<br/>
<input type="submit" value="vote" />
</form>

</body>
</html>