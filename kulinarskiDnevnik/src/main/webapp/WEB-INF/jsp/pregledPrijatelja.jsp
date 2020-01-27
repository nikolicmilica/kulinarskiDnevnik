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
<c:if test="${not empty prijatelji }">
<table class="table" align="center" style="width:50%;text-align:center;">
<c:forEach var="p" items="${prijatelji }">
<tr>
<c:if test="${p.korisnik1.idKorisnik==user.idKorisnik }">
<td>${p.korisnik2.username }</td><td><a href="/korisnik/posaljiPoruku?idKorisnik=${p.korisnik2.idKorisnik }">Poruke</a></td>
</c:if>
<c:if test="${p.korisnik2.idKorisnik==user.idKorisnik }">
<td>${p.korisnik1.username }</td><td><a href="/korisnik/posaljiPoruku?idKorisnik=${p.korisnik1.idKorisnik }">Poruke</a></td>
</c:if>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>