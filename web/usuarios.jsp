<%-- 
    Document   : ingreso
    Created on : 26/07/2017, 08:21:51 AM
    Author     : f188315
--%>

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
        <input type="text" name="tipo" id="tipo" value="agregarTerminal" hidden>
        <table>
            <tr>
                <td><label>Usuario</label></td>
                <td><input type="text" name="usuario2" id="usuario2" required="true"></td>
            </tr>
            <tr>
                <td><label>Terminal</label></td>
                <td><input type="text" name="terminal2" id="terminal2" required="true"></td>
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
