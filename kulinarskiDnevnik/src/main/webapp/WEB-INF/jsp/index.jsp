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
Hello you<c:if test="${not empty user }">, ${user.username }
<a href="/korisnik/dodavanjeRecepta">Dodaj recept</a>
<a href="/korisnik/prikazZahteva">Zahtevi na cekanju</a>
<a href="/korisnik/pregledPrijatelja">Moji prijatelji</a>
<a href="/korisnik/neprocitanePoruke">Neprocitane poruke</a>
<a style="text-align: right;"  href="/korisnik/odjava">Odjavi se</a>
</c:if><br>
<c:if test="${empty user }">
<a href="/korisnik/loginForm">Login</a>
<a href="/korisnik/signUpForm">SignUp</a>
</c:if>
<br>
<c:if test="${not empty msg }">
<p>${msg }</p>
</c:if>
<c:if test="${not empty msgPor }">
<p>${msgPor }</p>
</c:if>
<c:if test="${not empty recepti }">
<c:forEach var="r" items="${recepti }" varStatus="status">
<h2><a href="/korisnik/prikazRecepta/${r.idRecept}"> ${r.naziv }</a></h2>
<img alt="" src="<c:out value="/korisnik/vratiPocetnuSliku/?id=${r.idRecept }"/>" style="max-width: 300px; max-height: 300px;">
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
</p> 

<br>
<br>
</c:forEach>
</c:if>
<br>

</body>
</html>