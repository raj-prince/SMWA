<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<h2>New User Form</h2>
	<form:form commandName="user" action="addUser.do">
	 First Name <form:input path="firstName"/> <br />
	 Last Name  <form:input path="lastName"/> <br />
	Password <form:input path="password"/> <br />
	User Name<form:input path="userName"/> <br />
	User Type<form:input path="userType"/> <br />
	<button type="submit"> Add User</button>
	</form:form>
</body>
</html>