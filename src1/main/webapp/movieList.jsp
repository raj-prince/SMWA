<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Movies</h3>
	<table border="1">
	<tr>
		<th>ID</th><th>Name</th><th>Year of Release</th>
	</tr>
	<c:forEach items="${movies}" var="movie">
	<tr>
	<td>${movie.id}</td>
	<td>${movie.name}</td>
	<td>${movie.year}</td>
	</tr>
	</c:forEach>
	</table>

</body>
</html>