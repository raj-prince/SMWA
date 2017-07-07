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
			<th>Type</th><th>Question</th><th>OptionA</th> <th> Option B</th><th>Option C</th><th>Option D</th>
		</tr>
		<c:forEach items="${question}" var="question">
			<tr>
				<td>${question.questionType}</td>
				<td>${question.qText}</td>
				<td>${question.opA}</td>
				<td>${question.opB}</td>
				<td>${question.opC}</td>
				<td>${question.opD}</td>
				<td><a href="<c:url value='/showResponse/${question.questionId}'/>"> show </a> </td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
</body>

</html>