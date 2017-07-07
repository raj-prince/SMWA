<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey Distribution Form</title>
</head>
<body>
	<h2>Survey Distribution Form (distribute to a user one at a time)</h2>
	<form:form commandName="user" action="addDistribution.do">
	<form:select path="userName" style="width: 150px;">
	<form:options items="${userList}"/>
	</form:select>
	<br>
	<button type="submit" style="margin-top:15px;"> Distribute to this user </button>
	</form:form>
	<form action="reviewResponseForSurvey.do">
    <input type="submit" value="Quit and Show Results" style="margin-top:5px;">
	</form>
</body>
</html>