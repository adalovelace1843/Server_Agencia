<%-- 
    Document   : index
    Created on : 21/07/2017, 08:20:15 AM
    Author     : f188315
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet"></link>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>      
        <div class="row" style="background: #EEF2FC; margin-left: auto;">
            <h1> Sitio de la Agencia</h1>
  	</div>
        
        <div class="row">
            <div class="col-md-4"></div>
                <ul class="nav nav-tabs" style="background: #EEF2FC;">
                  <li class="active">
                    <a href="#">Home</a>
                  </li>
                  <li><a href="ServletMenu?opc=usuarios">Gestion de usuarios</a></li>
                  <li><a href="ServletMenu?opc=terminales">Gestion de terminales</a></li>
  	</div>
        
        <div class="row">
            <div class="col-md-6 col-md-offset-3">	
              
                <h4><strong>Sistema de Estacionamiento Tarifado</strong></h4>     
                <img src="img/abitab.jpg"/>
            </div>
  	</div>
        
         <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
