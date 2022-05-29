<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="button" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <c:choose>
            <c:when test="${row.valide==false}">
                    <c:set var = "var" value="alert-danger"></c:set>
            </c:when>
            <c:when test="${row.valide==true}">
                <c:set var = "var" value= "alert-success"></c:set>
            </c:when>
            <c:otherwise>
                <c:set var = "var" value= "alert-secondary"></c:set>
            </c:otherwise>
        </c:choose>


        <c:if test="${row.traiter==false}">
            <div class="alert <c:out value="${var}"></c:out>" role="alert"  >
                <a class="list-group-item list-group-item-action" aria-current="false">

                    Titre : ${row["titre"]}<br />
                    Message : ${row.message}<br />
                    Date : ${row.date}<br />
                    Compte ayant soumit la réclamation : ${row.compte} <br/>
                    État de la réclamation : ${row.valide}<br/><br/>



                    <%--    TROUVERCOMMENT LANCER LA FONCTION ONCLICK DU JAVA --%>
                    <form method=post >
                        <div  class="mx-auto" style="width: 500px;" >
                            <input type=hidden class="form-control" id="exampleFormControlInput1" name=id value="${row.id}">
                        </div>
                        <input class="btn btn-primary btn-lg" type=submit value="valider" name = "type"/>
                        <input class="btn btn-primary btn-lg" type=submit value="refuser" name = "type"/>

                        <br /><br />
                    </form>

                </a>
                </a>
            </div>
        </c:if>


    </c:forEach>
</div>



</body>
</html>