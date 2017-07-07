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
	<h2>Question Form, For descriptive and one liners, leave the option fields blank</h2>
	<form:form commandName="question" action="addQuestion.do">
	
	<table>
    <tr>
    <td>
        <ul style="padding-left:0px;">
		<form:select path="questionType" style="width:200px; margin-left:0px;">
                <form:option value="ONE_CORRECT">one correct</form:option>
                <form:option value="MORE_CORRECT">multi correct</form:option>
                <form:option selected="selected" value="ONE_LINE">one line</form:option>
                <form:option value="DESCRIPTIVE">descriptive</form:option>
            </form:select>
       </ul>
    </td>
    </tr>
    <tr><td><span style="width:200px; display:inline-block;">Question Text</span> <form:input path="qText" style="margin-left:-4px;"/></td> </tr>
	 <tr><td><span style="width:200px; display:inline-block;">Option A</span><form:input path="opA"/></td> </tr>
	<tr><td><span style="width:200px; display:inline-block;">Option B</span> <form:input path="opB" style="margin-left:-4px;"/></td> </tr>
	<tr><td><span style="width:200px; display:inline-block;">Option C</span><form:input path="opC"/></td> </tr>
	<tr><td><span style="width:200px; display:inline-block;">Option D</span> <form:input path="opD" style="margin-left:-4px;"/></td> </tr>
	<tr>
        <td>
           <input type="submit" value=" Save and add new question" style="margin-top: 15px;"/>
        </td>
    </tr>
    
    </table>
	</form:form>
	
	<form action="distribute.do">
    <input type="submit" value="Quit and Distribute" style="margin-left:4px;">
	</form>

</body>
</html>