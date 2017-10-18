<%-- 
    Document   : ingreso
    Created on : 26/07/2017, 08:21:51 AM
    Author     : f188315
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<h1>Gestión de usuarios</h1>

<script type="text/javascript">
	function validar(){
		if(confirm('Confirmar los datos?')){
                    return alert("OK");
		}else{
                    return alert("CANCELADO");
		}
	}
</script>


<body>	
    <h3>Alta de usuarios</h3>
    <form action="ServletIngresoUsuarios" method="POST">
        <input type="text" name="tipo" id="tipo" value="ingresoUsuario" hidden>
        <table>
            <tr>
                <td><label>Usuario</label></td>
                <td><input type="text" name="usuario" id="usuario" required="true"  ></td>
            </tr>
            <tr>
                <td><label>Clave</label></td>
                <td><input type="text" name="clave" id="clave" required="true"></td>
            </tr>
            <tr>
                <td><label>Web</label></td>
                <td>
                    <select name="web" >
                        <option value="1" >SI</option>
                        <option value="0">NO</option>
                    </select><br>
                </td>
            </tr>
            <tr>
                <td><button type="submit" >Ingresar</button></td>
            </tr>
        </table>
    </form>
    <br>
    <h3>Agregar una terminal a usuario</h3>
    <form action="ServletIngresoUsuarios" method="POST">
        <input type="text" name="tipo" id="tipo" value="selectpicker" hidden>
        <table>
            <tr>
                <td><label>Usuario</label></td>
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
                <input type="text" name="usuarioTerminal" id="tipo" value="${usuarioTerminal}" hidden>
                <td><label>Terminales para usuario:</label><label > ${usuarioTerminal}</label></td>
                <!--<td><input type="text" name="terminal2" id="terminal2" required="true"></td>-->
                <c:forEach var="res" items="${listadoTerminales}"> 
                    <tr>
                        <td><input type="checkbox" name="chkBox" value="${res.terminal}" ${res.isChecked}>${res.terminal}</td>
                   </tr>
                 </c:forEach>
            </tr>
            
            <tr>
                <td><button type="submit">Agregar</button></td>
            </tr>
        </table>
    </form>
    
    
    <br>
    <h3>Baja de usuarios</h3>
    <form action="ServletIngresoUsuarios" method="POST">
        <input type="text" name="tipo" id="tipo" value="bajaUsuario" hidden>
        <table>
            <tr>
                <td><label>Usuario</label></td>
                <td><input type="text" name="usuario3" id="usuario3" required="true"></td>
            </tr>
            
            <tr>
                <td><button type="submit" id="btnBaja">Baja</button></td>
            </tr>
        </table>
    </form>
    <br>
</body>
 <a href="menu.jsp">Volver</a>
</html>
