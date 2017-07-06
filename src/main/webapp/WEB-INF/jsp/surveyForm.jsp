<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Movie Form</h2>
	<form:form commandName="survey" action="addSurvey.do">
	Title of Survey <form:input path="surveyTitle"/> <br />
	Description of Survey <form:input path="surveyDescription"/> <br />
	
	<button type="submit"> Create Survey</button>
	</form:form>
</body>
</html>