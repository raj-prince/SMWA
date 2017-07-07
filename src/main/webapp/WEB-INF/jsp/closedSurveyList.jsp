<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Surveys</h3>
	<table border="1" > 
		<tr>
			<th>ID</th><th>Title</th><th>Description</th> <th> Show Survey</th>
		</tr>
		<c:forEach items="${survey}" var="surveys">
			<tr>
				<td>${surveys.surveyId}</td>
				<td>${surveys.surveyTitle}</td>
				<td>${surveys.surveyDescription}</td>
				<td><a href="<c:url value='/showClosedSurvey/${surveys.surveyId}'/>"> show </a> </td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
</body>

</html>