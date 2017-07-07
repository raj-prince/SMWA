<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!int idx=0; %>
	<h2>Survey Response Form</h2>
	<form:form commandName="responseList" action="addResponse.do">
	<input type='hidden' id='sid' name='sid' value='${survey.surveyId}'/>
	<table>
	<tr>
			<th>Question Type </th><th>Question</th><th>OptionA</th> <th>optionB</th><th>Option C </th> <th> Option D</th> 
		</tr>
		<c:forEach items="${question}" var="question" varStatus="i">
		<c:set var="count" value="0" scope="page" />
			<tr>
			<td>${question.questionType}</td>
		
				<td>${question.qText}</td>
 
		<td>
		<form:select path="responseList[${i.index}].questionId" >
		<form:option value="${question.questionId}" >Id
		</form:option>
		</form:select></td>
		
		<c:if test="${ question.questionType=='ONE_CORRECT'}">
          <td> <form:radiobutton path="responseList[${i.index}].responseText" value="A" />${question.opA}</td> 
          <td> <form:radiobutton path="responseList[${i.index}].responseText" value="B" />${question.opB}</td>
          <td> <form:radiobutton path="responseList[${i.index}].responseText" value="C" />${question.opC}</td>
          <td> <form:radiobutton path="responseList[${i.index}].responseText" value="D" />${question.opD}</td>
     
				</c:if>
				
			<c:if test="${ question.questionType=='MORE_CORRECT'}">
     
			<td><form:checkbox path="responseList[${i.index}].responseText" value="A"/>${question.opA}</td>
			
			<td><form:checkbox path="responseList[${i.index}].responseText" value="B"/>${question.opB}</td>
			
			<td><form:checkbox path="responseList[${i.index}].responseText" value="C"/>${question.opC}</td>
		
			<td><form:checkbox path="responseList[${i.index}].responseText" value="D"/>${question.opD}</td>
			
			</c:if>
				<c:if test="${ question.questionType=='ONE_LINE' }">
        <td colspan="2">
				<form:input path="responseList[${i.index}].responseText"/></td>
				</c:if>
				
				
				
					<c:if test="${ question.questionType=='DESCRIPTIVE' }">
        <td colspan="2">
			<form:input path="responseList[${i.index}].responseText"/>	</td>
				</c:if>
			
				
			</tr>
		</c:forEach>
	</table>
	<button type="submit"> Add Response</button>
	</form:form>
	

</body>
</html>