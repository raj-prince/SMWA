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
	<h3>Response</h3>
	
	<c:if test="${isMultiple==1}">
	<table border="1" > 
		<tr>
			 <th>  Response Is</th>
		</tr>
		<c:forEach items="${responses}" var="responses">
			<tr>
				<td>${responses.responseText}</td>
				
				
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
	${response.responseText}
	
	
	
	
</body>

</html>