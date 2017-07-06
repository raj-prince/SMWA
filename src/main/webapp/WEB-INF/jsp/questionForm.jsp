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
	<input type="hidden" name="survey2" value={survey2}>
	<table>
    <tr>
    <td>
        <ul>
		<form:select path="questionType">
                <form:option value="oc">one correct</form:option>
                <form:option value="mc">multi correct</form:option>
                <form:option selected="selected" value="ol">one line</form:option>
                <form:option value="desc">descriptive</form:option>
            </form:select>
       </ul>
    </td>
    </tr>
    <tr><td>Question Text <form:input path="qText"/></td> </tr>
	 <tr><td>Option A <form:input path="opA"/></td> </tr>
	<tr><td>Option B <form:input path="opB"/></td> </tr>
	<tr><td>Option C <form:input path="opC"/></td> </tr>
	<tr><td>Option D <form:input path="opD"/></td> </tr>
	<tr>
        <td>
           <input type="submit" value=" Save and add new question"/>
        </td>
    </tr>
    
    </table>
	</form:form>
	
	<form action="distribute.do">
    <input type="submit"value="Quit and Distribute">
	</form>

</body>
</html>