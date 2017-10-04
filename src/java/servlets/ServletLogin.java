/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import exceptions.ExPersistencia;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serverAgencia.InterfaceAgencia;
import serverAgencia.InterfaceAgenciaImpl;

/**
 *
 * @author e299227
 */
public class ServletLogin extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        try {
            String usuario=request.getParameter("usuario");
            String clave = request.getParameter("clave");
           
            
            InterfaceAgencia ia = new InterfaceAgenciaImpl();
            if(ia.obtenerValidacionAgencia(usuario,clave)){
                rd=request.getRequestDispatcher("/menu.jsp");
                rd.forward(request,response);
            }else{
                rd=request.getRequestDispatcher("/mensajeLogin.jsp");
                String mensaje="Usuario/contraseña incorrecto o no tiene acceso a la web.";
                request.setAttribute("mensaje", mensaje);
                rd.forward(request,response);
            }
        } catch (ExPersistencia ex) {
            rd=request.getRequestDispatcher("/mensajeLogin.jsp");
            request.setAttribute("mensaje", ex.getMessage());
            rd.forward(request,response);
        }
    }
}
