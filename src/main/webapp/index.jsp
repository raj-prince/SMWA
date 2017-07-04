<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page!</title>
</head>
<body>
	<h2>Please do login here.</h2>
	<div>${msg}</div>
	<form action="login.do" method="POST">
	Username <input type="text" name="userName"/> <br />
	Password <input type="password" name="password"/> <br />
			 <input type="submit" value="login" />
			 </form>
</body>
</html>
<%-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Movie Application</h3>
	<div>${msg}</div>
	<a href="listMovies.do">List all movies</a> <br />
	<a href="newMovie.do">Add a new Movie.</a>
	<a href="rentalForm.do">Rent a CAR.</a>
</body>
</html> --%>