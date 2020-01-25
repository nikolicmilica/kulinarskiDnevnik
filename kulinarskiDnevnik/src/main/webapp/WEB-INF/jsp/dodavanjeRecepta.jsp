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
<c:if test="${not empty msg }">${msg }</c:if>

<form action="/korisnik/dodavanjeSastojka" method="get">
Sastojak:<input type="text" name="sastojak"><br>
Kolicina:<input type="text" name="kolicina"><br>
<input type="submit" value="Dodaj sastojak"><br>
</form>

<form action="/korisnik/dodavanjeRecepta" method="post" enctype="multipart/form-data">
Naziv recepta:<input type="text" name="nazivRecepta"><br>
Nacin pripreme:<input type="textarea" name="nacinPripreme"><br>
<select name="kategorija">
<option value="-1">Izaberi kategoriju</option>
<c:forEach var="k" items="${kategorije }">
<option value="${k.idKategorija }">${k.nazivKategorije }</option>
</c:forEach>
</select><br>
<c:if test="${not empty sastojci }">
<table border="1">
<c:forEach var="s" items="${sastojci}">
<tr>
<td>${s.sastojak }</td><td>${s.kolicina }</td>
</tr>
</c:forEach>
</table>
</c:if>
<input type="file" name="slike" multiple>
<input type="submit" value="Dodaj recept">
</form>

</body>
</html>