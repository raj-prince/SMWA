<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Completed Surveys</h3>
	<table border="4" > 
		<tr style="height:40px; width:450px; margin:0; ">
			<th>Title</th><th>Description</th> <th> Show Survey</th>
		</tr>
		<c:forEach items="${survey}" var="surveys">
			<tr style="height:40px; width:450px; margin:0; ">
				
				<td style="height:40px; width:300px; margin:0; ">${surveys.surveyTitle}</td>
				<td style="height:40px; width:300px; margin:0; ">${surveys.surveyDescription}</td>
				<td style="height:40px; width:300px; margin:0; "><a href="<c:url value='/showClosedSurvey/${surveys.surveyId}'/>"> show </a> </td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
</body>

</html>