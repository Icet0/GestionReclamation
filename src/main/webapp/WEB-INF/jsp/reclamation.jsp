<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Reclamation</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body style="margin-top:30px;margin-left: 50px; ">
<h1 class="display-4" style="margin-bottom: 5px;">Nouvelle réclamation</h1>
<form method=post >
    <div  class="mx-auto" style="width: 500px;" >
        <label for="exampleFormControlInput1" class="form-label">titre de la réclamation :</label>
        <input type=text class="form-control" id="exampleFormControlInput1" name=titre>
    </div>

    <div  class="mx-auto" style="width: 500px;">
        <label for="exampleFormControlTextarea1" class="form-label">Texte :</label>
    <textarea name="message" rows="5" cols="30" class="form-control" id="exampleFormControlTextarea1"
                     placeholder="Indiquez le sujet de votre réclamation." name=message></textarea>
    </div>

    <input class="btn btn-primary btn-lg" type=submit value="Envoyer" />
</form>
</body>
</html>