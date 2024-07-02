<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>select category</h3>
<table  style="background-color: lightgrey; margin: auto" border="1">
<c:forEach var="category" items="${requestScope.categories}">
<tr>
<td>
<select>
<option value="${category.id}">${category.title} </option>
</select>
</td>

</tr>
</c:forEach>
</table>
</body>
</html>