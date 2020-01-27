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
<c:if test="${not empty msg }">${msg }</c:if>
<div style=" width:30%; margin: auto; margin-top:10%;">
<form action="/korisnik/dodavanjeSastojka" method="get">
<table>
<tr>
<td>Sastojak:</td><td><input type="text" name="sastojak"></td>
</tr>
<tr>
<td>Kolicina:</td><td><input type="text" name="kolicina"></td>
</tr>
<tr>
<td><input type="submit" value="Dodaj sastojak"></td>
</tr>
</table>
</form>
<br>
<form action="/korisnik/dodavanjeRecepta" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>Naziv recepta:</td><td><input type="text" name="nazivRecepta"></td>
</tr>
<tr>
<td>Nacin pripreme:</td><td><input type="textarea" name="nacinPripreme"></td>
</tr>
<tr>
<select name="kategorija">
<option value="-1">Izaberi kategoriju</option>
<c:forEach var="k" items="${kategorije }">
<option value="${k.idKategorija }">${k.nazivKategorije }</option>
</c:forEach>
</select>
</tr>
<c:if test="${not empty sastojci }">
<table>
<c:forEach var="s" items="${sastojci}">
<tr>
<td>${s.sastojak }</td><td>${s.kolicina }</td>
</tr>
</c:forEach>
</table>
</c:if>
<tr>
<td><input type="file" name="slike" multiple></td>
</tr>
<tr>
<td><input type="submit" value="Dodaj recept"></td>
</tr>
</table>
</form>
</div>
</body>
</html>