<%-- 
    Document   : ingreso
    Created on : 26/07/2017, 08:21:51 AM
    Author     : f188315
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<h1 style="font-family: verdana; color:  #035578;">Gestión de usuarios</h1>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"></link> 
</head>

<body>
     <div class="row">
        <div class="col-md-12">
            <h3 style="font-family: verdana; color:  #035578; font-size: large;padding-left: 10px;">Alta de usuarios</h3>

            <form action="ServletIngresoUsuarios" method="POST">
                <input type="text" name="tipo" id="tipo" value="ingresoUsuario" hidden>
                <table>
                    <tr>
                        <td><label style="padding-left: 30px;color: #035578;font-size: large;font-family: monospace;" >Usuario</label></td>
                        <td><input type="text" name="usuario" id="usuario" required="true"  ></td>
                    </tr>
                    <tr>
                        <td><label style="padding-left: 30px;color: #035578;font-size: large;font-family: monospace;">Clave</label></td>
                        <td><input type="text" name="clave" id="clave" required="true"></td>
                    </tr>
                    <tr>
                        <td><label style="padding-left: 30px;color: #035578;font-size: large;font-family: monospace;">Web</label></td>
                        <td>
                            <select name="web" >
                                <option value="1" >SI</option>
                                <option value="0">NO</option>
                            </select><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-left: 30px;"><button class="btn btn-md btn-primary btn-block" type="submit" >Ingresar</button></td>
                    </tr>
                </table>
                <br/>
                <br/>
            </form>
        </div>
    </div>
    <br>
    
    <div class="row">
        <div class="col-md-12">
            <h3 style="font-family: verdana; color:  #035578; font-size: large;padding-left: 10px;">Agregar una terminal a usuario</h3>

            <form action="ServletIngresoUsuarios" method="POST">
                <input type="text" name="tipo" id="tipo" value="selectpicker" hidden>
                <table>
                    <tr>
                        <td><label style="padding-left: 30px;color: #035578;font-size: large;font-family: monospace;">Usuario</label></td>
                        <td>
                            <select name="usuario2" onchange='this.form.submit()'>
                                <option value="NS" >Ninguo seleccionado</option>
                                <c:forEach items="${listadoUsuarios}" var="term">
                                    <option value="${term}" >${term}</option>
                                </c:forEach> 
                            </select><br>
                        </td>
                    </tr>
                    <tr>
                 </table>
            </form>
            <form action="ServletIngresoUsuarios" method="POST">
                <input type="text" name="tipo" id="tipo" value="agregarTerminal" hidden>
                <table>
                    <tr>
                        <input type="text" name="usuarioTerminal" id="tipo" value="${usuarioTerminal}" hidden>
                        <td>
                            <label style="padding-left: 30px;color: #035578;font-size: large;font-family: monospace;">Terminales para usuario:</label>
                            <label style="padding-left: 30px;color: #035578;font-size: large;font-family: monospace;"> ${usuarioTerminal}</label>
                        </td>
                    </tr>
                    <c:forEach var="res" items="${listadoTerminales}"> 
                    <tr>
                        <td style="padding-left: 30px;"><input type="checkbox" name="chkBox" value="${res.terminal}" ${res.isChecked}>${res.terminal}</td>
                    </tr>
                     </c:forEach>

                    <tr>
                        <td style="padding-left: 30px;"><button class="btn btn-md btn-primary btn-block" type="submit">Agregar</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <br>
     <br>
    <div class="row">
        <div class="col-md-12">
            <h3 style="font-family: verdana; color:  #035578; font-size: large;padding-left: 10px;">Baja de usuarios</h3>

            <form action="ServletIngresoUsuarios" method="POST">
                <input type="text" name="tipo" id="tipo" value="bajaUsuario" hidden>
                <table>
                    <tr>
                        <td><label style="padding-left: 30px;color: #035578;font-size: large;font-family: monospace;" >Usuario</label></td>
                        <td>
                            <select name="usuario3">
                                <option value="NS" >Ninguo seleccionado</option>
                                <c:forEach items="${listadoUsuarios}" var="term">
                                    <option value="${term}" >${term}</option>
                                </c:forEach> 
                            </select><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-left: 30px;"><button class="btn btn-md btn-primary btn-block" type="submit" id="btnBaja">Baja</button></td>
                    </tr>
                </table>
                <br/>
                <br/>
            </form>
        </div>
    </div>
   
    <br>
</body>

 <a href="menu.jsp" style="padding-left: 20px;">Volver</a>
</html>
