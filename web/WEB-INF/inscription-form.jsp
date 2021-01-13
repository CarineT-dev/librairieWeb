<%-- 
    Document   : inscription-form
    Created on : 12 janv. 2021, 14:41:14
    Author     : djtew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>inscription</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/style01.css" rel="stylesheet" type="text/css"/>
       
    </head>
    <body>
        <!-- navigation -->
        <c:import url="WEB-INF/menus/menus-main.jsp" />

        <!-- contenu -->
        <div class="container mt-4">
            <h1>Formulaire d'inscription</h1>   
            
            <c:if test="${not empty requestScope.msg}">
                <p class="erreur">${requestScope.msg}</p>
                
            </c:if>
                
            
            <form action="inscription" method ="POST">
                <div class="form-group">
                    <label for="id-nom">Nom :</label>
                    <input type="text" name="nom" class="form-control" placeholder="Entrer votre nom" id="id-nom">
                </div>
                
                <div class="form-group">
                    <label for="id-prenom">Prénom :</label>
                    <input type="text" name="prenom" class="form-control" placeholder="Entrer votre prénom" id="id-prenom">
                </div>
                
                <div class="form-group">
                    <label for="email">Email  :</label>
                    <input type="email" name="email" class="form-control" placeholder="Entrez votre adresse email" id="email">
                </div>
                <div class="form-group">
                    <label for="pwd">Mot de passe :</label>
                    <input type="password" name=pwd class="form-control" placeholder="Enter votre mot de passe" id="pwd">
                </div>
                <div class="form-group">
                    <label for="pwd2">Ressaisir le mot de passe :</label>
                    <input type="password" name="pwd2" class="form-control" placeholder="Confirmer votre mot de passe" id="pwd2">
                </div>
                
                <button type="submit" class="btn btn-primary">Soumettre</button>
            </form>


            <!-- footer -->


            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>   
    </body>
</html>
