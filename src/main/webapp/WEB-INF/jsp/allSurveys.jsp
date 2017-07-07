<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Surveys</title>
</head>
<body>
	<h2>Select a survey to distribute</h2>
	<form:form commandName="survey" action="distribute.do">
	<form:select path="surveyId">
	<%
	List<String> surveyTitles=(List<String>)request.getAttribute("surveyTitles");
	List<Integer> surveyIds=(List<Integer>)request.getAttribute("surveyIds");
	for(int i=0; i< surveyIds.size(); i++)
	{
		int ids=surveyIds.get(i);
		String title=surveyTitles.get(i);
	%>
	<form:option value="<%=ids %>" label="<%=title %>" />
	<%} %>
	</form:select>
	<button type="submit"> Load distribution form </button>
	</form:form>
</body>
</html>