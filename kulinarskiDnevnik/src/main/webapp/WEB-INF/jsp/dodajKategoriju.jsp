<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	
	<form action="/korisnik/dodajKategoriju" method="post">
		<table class="table" align="center" style="width:50%;text-align:center;">
		<tr><td>Naziv kategorije:</td>
			<td><input type="text" name="naziv"></td>
			<td><input type="submit" value="UNESI"></td>
		</tr>
		</table>
	</form>

</body>
</html>