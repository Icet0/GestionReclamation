<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User dashboard</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<h1 class="display-3" style="margin-bottom: 10px;">Bienvenue ${identifiant}</h1>
<h2 class="display-6" style="margin-bottom: 5px;">Liste de vos réclamations</h2>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Titre réclamation</th>
        <th scope="col">Date</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${reclamation}">
        <tr>
            <th scope="row">${row.id}</th>
            <td>${row.titre}</td>
            <td>${row.date}</td>
            <td>
                <c:if test="${row.traiter==true}">
                    <c:if test="${row.valide==true}">
                        Validé
                    </c:if>
                    <c:if test="${row.valide==false}">
                        Refusé
                    </c:if>
                </c:if>
                <c:if test="${row.traiter==false}">
                    En traitement
                </c:if>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a  href="/reclamationsUser"
    type="button"class="btn btn-primary btn-lg">
    Nouvelle réclamation
</a>
</body>
</html>