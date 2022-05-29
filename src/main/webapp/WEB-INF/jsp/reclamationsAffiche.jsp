<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet"/>
</head>
<body style="margin-left: 15px; margin-right: 150px">
<p class="text-left h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Liste des réclamations</p>
<br/>
<div class="list-group">
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