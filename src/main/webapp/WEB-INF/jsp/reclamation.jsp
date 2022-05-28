<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Reclamation</title>
</head>
<body>
<form method=post >
    titre de la réclamation : <input type=text name=titre value="" /> <br />
    Texte :<textarea name="message" rows="5" cols="30"
                     placeholder="Indiquez le sujet de votre réclamation." name=message></textarea> <br />
    <input type=submit value="Envoyer" />
</form>
</body>
</html>