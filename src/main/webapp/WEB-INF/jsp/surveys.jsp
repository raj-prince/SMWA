<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Surveys</title>
</head>
<body>
	<h3>Surveys </h3>
	<% System.out.println(request.getAttribute("survey"));%> 
	
	<form:form commandName="response" action="addResponse.do">
		Surveys <form:select path="survey.surveyId">
		
		<form:option value="0"> SELECT</form:option>
		<form:options items="${survey}" itemLabel="Surveys" itemValue="surveyTitle"/>
		</form:select> <br />
	
		<button type="submit">Add Response</button>
	</form:form>
</body>
</html>