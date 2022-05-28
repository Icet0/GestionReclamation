<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin dashboard</title>
</head>
<body>
Bienvenue ${identifiant}
<br />
V�tre r�le : ${role}
<br />
Liste des privileges : <br/>
<c:forEach var="row" items="${privileges}">
Intitule : ${row.intitule}<br />
</c:forEach>

<button><a href="/reclamationsAdmin">Voir toutes les r�clamations</a></button>
<br />

<button type="button"><a href="/roleattrib"> Attribuer un r�le � un compte </a></button>
</body>
</html>