<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin dashboard</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet"/>
</head>
<body style="margin-right: 100px; margin-left: 15px">
<h1>Bienvenue ${identifiant}</h1>
<br />
<h3>Vôtre rôle : ${role}</h3>
<br />
<h3>Liste des privileges : </h3><br/>
<ul class="list-group">
    <c:forEach var="row" items="${privileges}">
        <li class="list-group-item" aria-current="true">Intitule : ${row.intitule}</li>
    </c:forEach>
</ul>
<br/>
<div class="btn-group">
    <a href="/reclamationsAdmin" class="btn btn-primary active" aria-current="page">Voir toutes les réclamations</a>
    <a href="/roleattrib" class="btn btn-primary">Attribuer un rôle à un compte</a>
</div>
</body>
</html>