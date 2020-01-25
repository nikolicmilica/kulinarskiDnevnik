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
<c:if test="${not empty zahteviKorisnika }">
<table border="1">
<c:forEach var="z" items="${zahteviKorisnika}">
<c:if test="${z.status=='cekanje'}">
<tr>
<td>${z.korisnik2.username}</td><td><a href="/korisnik/prihvatiZahtev/?idZahtev=${z.idZahtev }">Prihvatam</a></td><td><a href="/korisnik/odbaciZahtev/?idZahtev=${z.idZahtev }">Ne prihvatam</a></td>
</tr>
</c:if>
</c:forEach>
</table>
</c:if>
</body>
</html>