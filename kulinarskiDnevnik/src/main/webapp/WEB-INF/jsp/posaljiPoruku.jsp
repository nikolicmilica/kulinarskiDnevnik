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
<c:if test="${not empty poruke }">
<div>
<c:forEach var="p" items="${poruke }">
${p.korisnik1.username }  ${p.datumSlanja }<br>
${p.text }<br> 
</c:forEach>
</div>
</c:if>
<form action="/korisnik/posaljiPoruku/?idKorisnik=${korisnik }" method="post">
<input type="text" name="text">
<input type="submit" value="Posalji">
</form>
</body>
</html>