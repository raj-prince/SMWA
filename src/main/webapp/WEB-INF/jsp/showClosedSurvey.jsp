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
	<table border="4" > 
		<tr style="height:40px; width:450px; margin:0; ">
			<th>Type</th><th>Question</th><th>OptionA</th> <th> Option B</th><th>Option C</th><th>Option D</th><th> Response </th>
		</tr>
		<c:forEach items="${question}" var="question">
			<tr style="height:40px; width:450px; margin:0; ">
			<c:if test="${ question.questionType=='ONE_CORRECT'}">
			<td>Single Choice</td>
			</c:if>
			<c:if test="${ question.questionType=='MORE_CORRECT'}">
			<td>Multiple Choice</td>
			</c:if>
			
			
			<c:if test="${ question.questionType=='ONE_LINE'}">
			<td>Single Line</td>
			</c:if>
			
			<c:if test="${ question.questionType=='DESCRIPTIVE'}">
			<td>Descriptive</td>
			</c:if>
			
				<td>${question.qText}</td>
				
				<c:choose>
   
				<c:when test="${ question.questionType=='ONE_LINE' || question.questionType=='DESCRIPTIVE'}">
				
				<td  style="border:0;"></td>
				<td  style="border:0;"></td>
				<td  style="border:0;">No Options</td>
				<td  style="border:0;"></td>
				
				<td><a href="<c:url value='/showResponse/${question.questionId}'/>"> View Response  </a> </td>
			
			</c:when>
			<c:otherwise>
				<td>${question.opA}</td>
				<td>${question.opB}</td>
				<td>${question.opC}</td>
				<td>${question.opD}</td>
				<td><a href="<c:url value='/showResponse/${question.questionId}'/>"> View Response  </a> </td>
				</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</body>

</html>