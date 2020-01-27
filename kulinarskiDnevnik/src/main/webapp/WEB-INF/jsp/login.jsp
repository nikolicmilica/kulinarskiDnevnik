<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Login</title>
</head>
<body>
<c:if test="${not empty msgreg}">
	<p>${msgreg}</p>
</c:if>
<div style=" width:30%; margin: auto; margin-top:10%;">
<form action="/korisnik/login" method="get">
<table>
<tr>
	<td>Username:</td><td><input type="text" name="username"></td>
</tr>
<tr>							
	<td>Password:</td><td><input type="password" name="password"></td>
</tr>
<tr>
	<td><input type="submit" class="btn btn-primary" value="Uloguj se"/></td>
</tr>
	<c:if test="${not empty message}">
	<p>${message}</p>
	</c:if>
</table>		
</form>
</div>
</body>
</html>