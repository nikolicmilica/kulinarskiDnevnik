<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Pocetna</title>
</head>
<body>

<c:if test="${not empty user and user.ulogakorisnika.idUloga==2}">
<ul class="nav justify-content-center">
<li class="nav-item">
<a class="nav-link" href="/korisnik/dodavanjeRecepta">Dodaj recept</a>
</li>
<li class="nav-item">
<a class="nav-link" href="/korisnik/prikazZahteva">Zahtevi na cekanju</a>
</li>
<li class="nav-item">
<a class="nav-link" href="/korisnik/pregledPrijatelja">Moji prijatelji</a>
</li>
<li class="nav-item">
<a class="nav-link" href="/korisnik/neprocitanePoruke">Neprocitane poruke</a>
</li>
<li class="nav-item">
<a class="nav-link" href="/korisnik/odjava">Odjavi se</a>
</li>
</ul>
</c:if>
<c:if test="${not empty user and user.ulogakorisnika.idUloga==1}">
<ul class="nav justify-content-center">
<li class="nav-item">
<a class="nav-link" href="/korisnik/dodajKategorijuForma" >Dodaj kategoriju</a>
</li>
<li class="nav-item">
<a class="nav-link" href="/korisnik/odjava">Odjavi se</a>
</li>
</ul>
</c:if>
<br>
<c:if test="${empty user }">
<ul class="nav justify-content-end">
<li class="nav-item">
<a class="nav-link" href="/korisnik/loginForm">Login</a>
</li>
<li class="nav-item">
<a class="nav-link" href="/korisnik/signUpForm">SignUp</a>
</li>
</ul>
</c:if>
<br>
<c:if test="${not empty msg }">
<p>${msg }</p>
</c:if>
<c:if test="${not empty msgPor }">
<p>${msgPor }</p>
</c:if>
<c:if test="${not empty porukaAdmin }">
<p>${porukaAdmin }</p>
</c:if>
<c:if test="${not empty recepti }">
<c:forEach var="r" items="${recepti }" varStatus="status">
<h2><a href="/korisnik/prikazRecepta/${r.idRecept}"> ${r.naziv }</a></h2>

<img alt="" src="<c:out value="/korisnik/vratiPocetnuSliku/?id=${r.idRecept }"/>" style="max-width: 300px; max-height: 300px;" class="img-thumbnail">
<p>Postavljeno: ${r.datumPostavke }</p>
<p>Kategorija: ${r.kategorijaBean.nazivKategorije }</p>
<p>Korisnika: ${r.korisnikBean.username }
<c:if test="${not empty user }">
<c:if test="${empty zahtevi[status.index] and user.idKorisnik!=r.korisnikBean.idKorisnik}">
<a href="/korisnik/posaljiZahtev/?idKorisnik=${r.korisnikBean.idKorisnik }">Posalji zahtev</a>
</c:if>
<c:if test="${not empty zahtevi[status.index] and zahtevi[status.index].status=='neprihvacen'}">
<a href="/korisnik/posaljiZahtev/?idKorisnik=${r.korisnikBean.idKorisnik }">Posalji zahtev</a>
</c:if>
<c:if test="${not empty zahtevi[status.index] and zahtevi[status.index].status=='prihvacen'}">
<a href="/korisnik/posaljiPoruku/?idKorisnik=${r.korisnikBean.idKorisnik  }">Posalji poruku</a>
</c:if>
</c:if>
 
<br>
<br>
<br>
<br>
<br>
</c:forEach>
</c:if>
<br>
</body>
</html>