<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>${initParam.appTitle}</h3>
	<jsp:useBean id="fcb" class="com.sunbeam.jspapp.FindCandidateBean"/>
	<jsp:setProperty name="fcb" property="id" param="id"/>
	${fcb.fetchCandidate()}
	<form method="post" action="updatedcand.jsp">
	<input type="hidden" name="id" value="${fcb.candidate.id}"/><br/>
	Name:<input type="text" name="name" value="${fcb.candidate.name}" /><br/>
	Party: <input type="text" name="party" value="${fcb.candidate.party}"/> <br/><br/>
		Votes: <input type="text" name="votes" value="${fcb.candidate.votes}" readonly="readonly"/> <br/><br/>
		<input type="submit" value="Update Candidate"/>
	</form>
</body>
</html>