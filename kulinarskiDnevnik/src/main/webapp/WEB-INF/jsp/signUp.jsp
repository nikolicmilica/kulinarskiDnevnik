<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div style=" width:30%; margin: auto; margin-top:10%;">
<form action="/korisnik/signUp" method="post">
<table>
<tr>
<td>Ime:</td> <td><input type="text" name="ime"></td>
</tr>
<tr>
<td>Prezime:</td> <td><input type="text" name="prezime"></td>
</tr>
<tr>
<td>Username:</td><td> <input type="text" name="username"></td>
</tr>
<tr>
<td>Password:</td> <td><input type="text" name="password"></td>
</tr>
<tr>
<td>Potvrdi password: </td><td><input type="text" name="passwordPotvrda"></td>
</tr>
<c:if test="${not empty err1}">
	<p>${err1}</p>
</c:if>
<c:if test="${not empty err2}">
	<p>${err2}</p>
</c:if>
<c:if test="${not empty err3}">
	<p>${err3}</p>
</c:if>
<tr>
<td><input type="submit" value="Sign Up" class="btn btn-primary"></td>
</tr>
</table>
</form>
</div>
</body>
</html>