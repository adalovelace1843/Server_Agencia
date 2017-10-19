<%-- 
    Document   : index
    Created on : 07/09/2017, 10:55:44 AM
    Author     : e299227
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet"></link>
        <title>Agencia</title>
    </head>
    <body>
            
        <div class="container" style="margin-top:40px">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <strong>Debe iniciar sesion</strong>
                        </div>
                        <div class="panel-body">
                            <form action="ServletLogin" method="POST">
                                <div class="row">
                                    <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-user"></i>
                                                </span> 
                                                <input class="form-control field" type="text" name="usuario" id="usuario" >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                        <i class="glyphicon glyphicon-lock"></i>
                                                </span>
                                                <input class="form-control field" type="password" name="clave" id="clave">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="panel-footer " style="text-align: center;font-family: inherit;">
                                Sitio oficial de la Agencia<br/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
         <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        
        
        
    </body>
</html>
