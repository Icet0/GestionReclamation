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
    <title>Dashboard Admin attribution de privilege</title>
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
                <a class="nav-link" href="/login">Home </a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="/reclamationsAdmin">Réclamations <span class="sr-only">(current)</span></a>
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
<p class="text-left h1 fw-bold  mt-4">Liste des réclamations</p>
<br/>
<div class="list-group" style="margin-left: 15px">
    <c:forEach var="row" items="${Reclamations}">
    <a href="#" class="list-group-item list-group-item-action" aria-current="true">
        Id : ${row.id}<br/>
        Titre : ${row["titre"]}<br />
        Message : ${row.message}<br />
        Date : ${row.date}<br />
        Compte ayant soumit la réclamation : ${row.compte} <br/>
        État de la réclamation : ${row.valide}<br/><br/>

        <input type=button value="valider" onclick="${row.id} = 'true'"/>
        <%--    TROUVERCOMMENT LANCER LA FONCTION ONCLICK DU JAVA --%>
        <br /><br />
    </a>
    </c:forEach>
</div>


</body>
</html>