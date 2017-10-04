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
        <title>Agencia</title>
    </head>
    <body>
        <h3>Ingreso de usuarios</h3>
        <form action="ServletLogin" method="POST">
            <table>
                <tr>
                    <td><label>Usuario</label></td>
                    <td><input type="text" name="usuario" id="usuario" ></td>
                </tr>
                <tr>
                    <td><label>Clave</label></td>
                    <td><input type="password" name="clave" id="clave"></td>
                </tr>

                <tr>
                    <td><button type="submit">Ingresar</button></td>
                </tr>

            </table>

	</form>
    </body>
</html>
