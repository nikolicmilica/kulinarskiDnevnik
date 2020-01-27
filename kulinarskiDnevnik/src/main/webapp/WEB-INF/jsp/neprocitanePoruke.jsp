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
<c:if test="${not empty neprocitane }">
<table class="table">
<c:forEach var="p" items="${neprocitane }">
<tr>
<td>Poruka od: ${p.korisnik1.username }, datum: ${p.datumSlanja }</td><td><a href="/korisnik/posaljiPoruku/?idKorisnik=${p.korisnik1.idKorisnik }"> Pregled </a></td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>