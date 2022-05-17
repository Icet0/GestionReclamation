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
Bienvenue ${identifiant}
<c:forEach var="row" items="${privileges}">
Intitule Privilege : ${row.intitule}<br />
Liste des Roles :
	<c:forEach var="rowRole" items="${row.roles}">
	Intitule Role : ${rowRole}
	</c:forEach>
</c:forEach>
</body>
</html>