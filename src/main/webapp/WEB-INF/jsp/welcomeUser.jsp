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
<body style="margin-left: 15px">
<h1 class="display-3" style="margin-bottom: 10px;">Bienvenue ${identifiant}</h1>
<h2 class="display-6" style="margin-bottom: 5px;">Liste de vos réclamations</h2>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Titre réclamation</th>
        <th scope="col">Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${reclamation}">
        <tr>
            <th scope="row">${row.id}</th>
            <td>${row.titre}</td>
            <td>${row.date}</td>
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