<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Gestion de Réclamation</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="mainNav">
    <a class="navbar-brand" href="#">Barre de Navigation</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Home </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Connexion </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/addCompte">Inscription <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<section class="vh-100" style="background-color: #eee; ">
        <div class="row d-flex justify-content-center align-items-center h-100" style="margin-left: 15px">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-left h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">S'inscrire</p>

                                <form class="mx-1 mx-md-4" method="post">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="form3Example1c" class="form-control" name=login />
                                            <label class="form-label" for="form3Example1c">Votre login </label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="password" id="form3Example4c" class="form-control" name=mp />
                                            <label class="form-label" for="form3Example4c">Votre mot de passe</label>
                                        </div>
                                    </div>
                                    <div class="d-flex mb-3 mb-lg-4">
                                        <input type="submit" class="btn btn-primary btn-lg" value="Inscription" >
                                    </div>
                                    <div class="d-flex mb-3 mb-lg-4">
                                        <a type="button" class="btn btn-primary btn-lg" href="login" >Se connecter</a>
                                    </div>
                                </form>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
</section>
<%--<form method=post >--%>
<%--Login : <input type=text name=login value="" /> <br />--%>
<%--Mot de passe : <input type=text name=mp value="" />  <br />--%>
<%--<input type=submit value="Inscription" />--%>
<%--</form>--%>
</body>
</html>