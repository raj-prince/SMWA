<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome Respondent</title>
</head>
<body>
	<h2>title</h2>
	<div>${msg}</div>
	<h5>Hello  ${userName} </h5>
	<a href="getSurvey.do">Get surveys for you !</a><br />
	<a href="getClosedSurvey.do">Get surveys for which you responded !</a><br />
	
	
	
</body>
</html>