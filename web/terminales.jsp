<%-- 
    Document   : ingreso
    Created on : 26/07/2017, 08:21:51 AM
    Author     : f188315
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<h1>Gestión de terminales</h1>


<body>	
    <h3>Alta de terminal</h3>
    <form action="ServletTerminales" method="POST">
        <input type="text" name="tipo" id="tipo" value="ingresoTerminal" hidden>
        <table>
            <tr>
                <td><label>Terminal</label></td>
                <td><input type="text" name="terminal" id="terminal" required="true"  ></td>
            </tr>
            <tr>
                <td><button type="submit" >Ingresar</button></td>
            </tr>
        </table>
    </form>
    <br>    
    
    <br>
    <h3>Baja de usuarios</h3>
    <form action="ServletTerminales" method="POST">
        <input type="text" name="tipo" id="tipo" value="bajaTerminal" hidden>
        <table>
             <tr>
                <td><label>Terminal</label></td>
                <td>
                    <select name="terminalBaja" >
                        <c:forEach items="${listadoTerminales}" var="term">
                            <option value="${term.terminal}" >${term.terminal}</option>
                        </c:forEach>  
                    </select><br>   
                </td>
            </tr>
            <tr>
                <td><button type="submit">Baja</button></td>
            </tr>
        </table>
    </form>
    <br>
</body>
 <a href="menu.jsp">Volver</a>
</html>
