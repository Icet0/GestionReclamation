<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Dashboard Admin</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body id="page-top">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="mainNav">
    <a class="navbar-brand" href="#">Barre de Navigation</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="">Home </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/reclamationsAdmin">Réclamations <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/roleattrib">Modification de rôles</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/privilegerole">Attribuer Privilège</a>
            </li>
        </ul>
    </div>
</nav>
<div style="margin-left: 15px">
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
        <a href="/privilegerole" class="btn btn-primary">Attribuer un Privilège</a>
    </div>
</div>
</body>
</html>