<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${initParam.appTitle }</h3>

<jsp:useBean id="res" class="com.sunbeam.jspapp.CandidateListBean"/>
${res.fetchCandidates()}
<table border="1">
<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Party</th>
			<th>Votes</th>
			<th>Action</th>
</thead>
<tbody>
<c:forEach var="c" items="${res.candidateList }">
<tr>
					<td>${c.id }</td>
					<td>${c.name}</td>
					<td>${c.party}</td>
					<td>${c.votes}</td>
					<td>
					<a href="editcand.jsp?id=${c.id }">
					<img alt="Edit" src="images/edit.png" width="24" height="24"/ >
					</a>
					
					<a href="delcand.jsp?id=${c.id }">
					<img alt="Del" src="images/delete.png" width="24" height="24"/ >
					</a>
					</td>
					
</tr>
</c:forEach>
</tbody>

</table>
<a href="announcement.jsp">Announcement</a>
</body>
</html>
