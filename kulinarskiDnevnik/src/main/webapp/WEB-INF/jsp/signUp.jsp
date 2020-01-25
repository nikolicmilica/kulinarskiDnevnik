<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/korisnik/signUp" method="post">
Ime: <input type="text" name="ime"><br>
Prezime: <input type="text" name="prezime"><br>
Username: <input type="text" name="username"><br>
Password: <input type="text" name="password"><br>
Potvrdi password: <input type="text" name="passwordPotvrda"><br>
<c:if test="${not empty err1}">
	<p>${err1}</p>
</c:if>
<c:if test="${not empty err2}">
	<p>${err2}</p>
</c:if>
<c:if test="${not empty err3}">
	<p>${err3}</p>
</c:if>
<button type="submit"><i class="fa fa-sign-in"></i> Sign Up</button>
</form>
</body>
</html>