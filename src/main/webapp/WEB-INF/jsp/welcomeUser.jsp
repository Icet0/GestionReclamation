<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User dashboard</title>
</head>
<body>
Bienvenue ${identifiant}
<br />
Votre �tes un ${role}
<br/>
<a  href="/reclamationsUser"
        type="button">
    Nouvelle r�clamation
</a>
</body>
</html>