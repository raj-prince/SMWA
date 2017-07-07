<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review Response</title>
</head>
<body>
	<h3>Review Response For Survey</h3>
	<h4><span style="width:500px; display:inline-block;">Name of Survey(TimeStamp)</span>
	<span style="width:150px; display:inline-block;">Distribution Count</span>
	<span style="width:150px; display:inline-block;">Response Count</span></h4>
	
		<%
		List<Long> ltotal = (List<Long>)request.getAttribute("totalCntList");
		List<Long> lresponse = (List<Long>)request.getAttribute("responseCntList");
		List<Date> ldistribution = (List<Date>)request.getAttribute("distributionList");
		List<Integer> lsurveyId = (List<Integer>)request.getAttribute("surveyIdList");
		List<String> lsurveyTitle = (List<String>)request.getAttribute("surveyTitleList");
		int len = ltotal.size();
		for (int i = 0; i < len; i++) { %>
			<span style="width:500px; display:inline-block;">
				<a href="reviewResponseForQuestion.do?surveyId=<%=lsurveyId.get(i)%>">
					<%=lsurveyTitle.get(i)%>
				</a>
			
			(<%=ldistribution.get(i)==null?"0": ldistribution.get(i)+ " "%>) 
			</span>
			
			<span style="width:150px; display:inline-block;"><%= ltotal.get(i) + " " %></span>
			<span style="width:150px; display:inline-block;"><%=lresponse.get(i) + " " %></span>
			<br>
		<%}%>
</body>
</html>