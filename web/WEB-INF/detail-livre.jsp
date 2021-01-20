<%-- 
    Document   : detail-livre
    Created on : 20 janv. 2021, 13:59:46
    Author     : djtew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>livre</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>

        <c:import url="WEB-INF/menus/menus-main.jsp" />

        <div class="container mt-4">
            
            

            
            
            
            <h1>Livre: </h1>
            
            <c:if test="${empty requestScope.livre}">
                <p>Livre introuvable!</p>  
            </c:if>
                <c:if test="${not empty requestScope.livre}" >
                <img src='images/<c:out value="${livre.image}" />' alt='couverture <c:out value="${livre.titre}" />'>
                
                <br>
                <p>Titre: <c:out value="${requestScope.livre.titre}"/> </p>
                <p> Resumé: <c:out value="${requestScope.livre.resume}"/> </p>
                <p>Editeur: <c:out value="${requestScope.livre.editeur.nom}"/> </p>
                
                <p>Prix HT: <c:out value="${requestScope.livre.prixHT}"/> </p>
                <p>taux TVA: <c:out value="${requestScope.livre.tva.taux}"/> </p>
                <p>Prix TTC: <c:out value="${requestScope.livre.prixTTC}"/> </p>
                
                </c:if>
                    
              
        </div>


<!-- footer -->


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
