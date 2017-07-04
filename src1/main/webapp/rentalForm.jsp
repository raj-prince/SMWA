<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<h3>Rental form</h3>
	<form:form commandName="rental" action="rent.do">
		Customer <form:select path="customer.customerId">
		<form:option value="0">SELECT</form:option>
		<form:options items="${customers}"  itemLabel="email" itemValue="customerId"/>
		</form:select><br/>
		REG <form:input path="registrationNo"/><br/>
		RENTAL DATE<form:input path="rentalDate"/> (DD-MM-YYYY HH:MM:SS) <br/>
		<button type="submit">Book a Car</button>
	</form:form>
</body>
</html>