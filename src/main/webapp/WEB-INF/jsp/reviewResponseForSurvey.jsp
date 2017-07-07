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
	<a id="id1" href="reviewResponseQuestion.do?">link </a>
	
	<h3>Review Response For Survey</h3>
	
		<%
		List<Long> ltotal = (List<Long>)request.getAttribute("totalCntList");
		List<Long> lresponse = (List<Long>)request.getAttribute("responseCntList");
		List<Date> ldistribution = (List<Date>)request.getAttribute("distributionList");
		List<Integer> lsurveyId = (List<Integer>)request.getAttribute("surveyIdList");
		List<String> lsurveyTitle = (List<String>)request.getAttribute("surveyTitleList");
		int len = ltotal.size();
		for (int i = 0; i < len; i++) { %>
			<a href="reviewResponseForQuestion.do?surveyId=<%=lsurveyId.get(i)+" "%>"><%=lsurveyTitle.get(i)%></a>
			<%=ldistribution.get(i) + " "%> <%= ltotal.get(i) + " " %><%=lresponse.get(i) + " " %>
		<%}%>
</body>
</html>