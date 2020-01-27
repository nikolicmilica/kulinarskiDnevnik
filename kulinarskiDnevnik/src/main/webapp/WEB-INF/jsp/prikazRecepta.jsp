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
<h2>${recept.naziv }</h2>

<p>Kategorija: ${recept.kategorijaBean.nazivKategorije }</p>
<c:forEach var="s" items="${recept.slikas }">
<img alt="" src="<c:out value = "/korisnik/vratiSlike/?idSlika=${s.idSlika }"/>" style="max-width: 300px; max-height: 300px;">
</c:forEach>

<h2>Sastojci</h2>
<table class="table" style="width:30%;">
<c:forEach var="s" items="${recept.sastojaks }">
<tr>
<td>${ s.sastojak}</td><td> ${s.kolicina }</td>
</tr>
</c:forEach>
</table>
<h2>Nacin pripreme</h2>
<p>${recept.nacinPripreme }</p>

<p>Postavljeno: ${recept.datumPostavke }</p>
<p>Korisnika: ${recept.korisnikBean.username }</p>

<c:if test="${not empty user}">
<c:if test="${not empty omiljeni }">
<p>Recept pripada vasoj omiljenoj kategoriji: ${omiljeni.omiljenakat.naziv }</p>
</c:if>
<c:if test="${empty omiljeni }">
<form action="/korisnik/dodajUOmiljene/?idRecepta=${recept.idRecept }" method="post">
Izaberite omiljenu kategoriju:
<select name="kat">
<option value="-1">Biraj...</option>
<c:forEach var="k" items="${omiljenekat }">
<option value="${k.idOmiljenaKat }">${k.naziv }</option>
</c:forEach>
</select>
Ili dodajte novu:<input type="text" name="omkateg">
<input type="submit" value="Dodaj recept">
</form>
<c:if test="${not empty msg1 }">
<p>${msg1 }</p>
</c:if>
</c:if>
</c:if>


</body>
</html>