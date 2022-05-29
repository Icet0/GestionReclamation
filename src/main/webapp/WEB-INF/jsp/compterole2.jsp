<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet"/>
</head>
<body style="margin-left: 15px">
<h2 class="lead">
    ${erreur}
    Le rôle attribué à ${log} est ${Role}
</h2>
<a type="button" class="btn btn-primary btn-lg" href="/roleattrib" >Back</a>

</body>
</html>