<%-- 
    Document   : ingreso
    Created on : 26/07/2017, 08:21:51 AM
    Author     : f188315
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet"></link> 
</head>

<h1 style="font-family: verdana; color:  #035578;">Gestión de terminales</h1>


<body>
    <div class="row">
        <div class="col-md-12">
            <h3 style="font-family: verdana; color:  #035578; font-size: large;padding-left: 10px;">Alta de terminal</h3>

            <form action="ServletTerminales" method="POST">
                <input type="text" name="tipo" id="tipo" value="ingresoTerminal" hidden>
                <table>
                    <tr>
                        <td><label style="padding-left: 30px;color: #035578;font-size: large;font-family: monospace;" >Terminal</label></td>
                        <td><input type="text" name="terminal" id="terminal" required="true"  ></td>
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
            <h3 style="font-family: verdana; color:  #035578; font-size: large;padding-left: 10px;">Baja de terminal</h3>

            <form action="ServletTerminales" method="POST">
                <input type="text" name="tipo" id="tipo" value="bajaTerminal" hidden>
                <table>
                    <tr>
                        <td><label style="padding-left: 30px;color: #035578;font-size: large;font-family: monospace;" >Terminal</label></td>
                        <td>
                            <select name="terminalBaja" >
                                <c:forEach items="${listadoTerminales}" var="term">
                                    <option value="${term.terminal}" >${term.terminal}</option>
                                </c:forEach>  
                            </select><br>   
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-left: 30px;"><button class="btn btn-md btn-primary btn-block" type="submit" >Baja</button></td>
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
