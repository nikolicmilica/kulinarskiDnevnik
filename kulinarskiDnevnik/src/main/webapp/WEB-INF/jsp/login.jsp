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
<c:if test="${not empty msgreg}">
	<p>${msgreg}</p>
</c:if>
<form action="/korisnik/login" method="get">

	<input type="text" name="username" placeholder="Username"><br>							
	<input type="password" name="password" placeholder="Password"><br>
	<c:if test="${not empty message}">
	<p>${message}</p>
	</c:if>
	<button type="submit"><i class="fa fa-sign-in"></i> Uloguj se</button>			
</form>
</body>
</html>