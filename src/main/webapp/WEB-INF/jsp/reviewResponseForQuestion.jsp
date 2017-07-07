<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.adobe.prj.entity.Question" %>
<%@ page import="com.adobe.prj.entity.Survey" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review Question Analysis!</title>
</head>
<body>
	<%	List<Question> mcqQuestion = (List<Question>)request.getAttribute("mcqQuestion");
		List<Long> cntForA = (List<Long>)request.getAttribute("cntForA");
		List<Long> cntForB = (List<Long>)request.getAttribute("cntForB");
		List<Long> cntForC = (List<Long>)request.getAttribute("cntForC");
		List<Long> cntForD = (List<Long>)request.getAttribute("cntForD");
		List<Question> descQuestion = (List<Question>)request.getAttribute("descQuestion");
		List<List<String>> descAnswer = (List<List<String>>) request.getAttribute("descAnswer");
		Survey survey = (Survey)request.getAttribute("survey");
		%>
	<h3> Title :  <%=survey.getSurveyTitle() %></h3>
	<h3> Description : <%=survey.getSurveyDescription() %></h3>
	
	<%
		for (int i = 0; i < mcqQuestion.size(); i++) { 
			Question q = mcqQuestion.get(i);
			%>
			<h4> Question : <%=q.getqText() + "?"%></h4>
			<p> (A) <%=q.getOpA() + " " %> </p>
			<p> user selected option (A) : <%=cntForA.get(i) %></p>
			
			<p> (B) <%=q.getOpB() + " " %> </p>
			<p> user selected option (B) : <%=cntForB.get(i) %></p>
			
			<p> (C) <%=q.getOpC() + " " %> </p>
			<p> user selected option (C) : <%=cntForC.get(i) %></p>
			
			<p> (D) <%=q.getOpD() + " " %> </p>
			<p> user selected option (D) : <%=cntForD.get(i) %></p>
			 
		<% }%>
		
		<% for (int i = 0; i < descQuestion.size(); i++) {
			Question q = descQuestion.get(i);
			List<String> res = descAnswer.get(i); %>
			
			<h4> Question : <%=q.getqText() + "?"%></h4>
			<%for (int j = 0; j < res.size(); j++) {%>
				<p> Response - <%=res.get(j) + " " %> </p> <br />
			<%}
		}%>

</body>
</html>