<%-- 
    Document   : page01
    Created on : 12 janv. 2021, 10:59:05
    Author     : djtew
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>page 01</title>
        <link href="css/style01.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <p> vers <a href="index.jsp"> index</a></p>
        <h1>page 01</h1>
        
        
        
        <% 
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        // dd/MM/YYYY
        //  /*server glassfish*/
        String nowStr = sdf.format(now);
        String nowStr2 = sdf.format(now);
        %>
        <p>Bienvenue, nous sommes le <%= nowStr %> </p>
        <p>Bienvenue, nous sommes le <%= nowStr2 %> </p>
        <img src="images/img1.png" alt="example d'img"/>
            
    </body>
</html>
