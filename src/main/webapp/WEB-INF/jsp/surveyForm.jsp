<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey Form</title>
</head>
<body>
	<h2>Survey Form</h2>
	<form:form commandName="survey" action="addSurvey.do">
	<span style="width:200px; display:inline-block;">Title of Survey</span> <form:input path="surveyTitle" style="margin-left:-4px;"/> <br /><br />
	<span style="width:200px; display:inline-block;">Description of Survey</span><form:input path="surveyDescription"/> <br />
	
	<button type="submit" style="margin-top:20px;"> Create Survey</button>
	</form:form>
</body>
</html>