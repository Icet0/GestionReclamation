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
<c:forEach var="row" items="${Reclamations}">
    Titre : ${row["titre"]}<br />
    Message : ${row.toString()}<br />

    <input type=submit value="valider" onclick=""/>
<%--    TROUVERCOMMENT LANCER LA FONCTION ONCLICK DU JAVA --%>
    <br /><br />
</c:forEach>


</body>
</html>