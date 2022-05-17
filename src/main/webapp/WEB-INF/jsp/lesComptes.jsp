<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="row" items="${listeNbreCompte}">
Intitule : ${row[0]}<br />
Nombre : ${row[1]}<br />
</c:forEach>


La liste des comptes : <br />
${Comptes}

<b>Le compte est : </b> ${abc}
<br />
Les comptes dont le mot de passe est ${mp} sont <br />
${lescomptes}

<br />
Le compte ${compte1} est affecté au rôle ${role1}
<br />


</body>
</html>