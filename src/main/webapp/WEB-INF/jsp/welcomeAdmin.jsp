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
Liste des privileges : <br/>
<c:forEach var="row" items="${privileges}">
Intitule Privilege : ${row.intitule}<br />
</c:forEach>

<button><a href="/reclamationsAdmin">Voir toutes les réclamations</a></button>
</body>
</html>