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
<form method=post >
    Login : <input type=text name=login value="" /><br />
    Mot de passe : <input type=text name=mp value="" /><br />
    Role à attribuer : <input type=text name=intitule value="" /><br />
    <input type=submit value="Modifier" />
</form>
</body>
</html>