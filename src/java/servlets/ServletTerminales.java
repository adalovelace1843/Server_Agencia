package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exceptions.ExPersistencia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import serverAgencia.InterfaceAgencia;
import serverAgencia.InterfaceAgenciaImpl;
import valueObjects.voUsuario;

/**
 *
 * @author f188315
 */
public class ServletTerminales extends HttpServlet {

    
    @Override
    public void init() throws ServletException {
       super.init();
       ArrayList lista = new ArrayList();
       
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     */
    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parametro=request.getParameter("tipo");
        InterfaceAgencia ia= new InterfaceAgenciaImpl();
        RequestDispatcher rd;
        rd=request.getRequestDispatcher("/mensaje.jsp");
        
        switch(parametro){
            case "ingresoTerminal": 
                try {
                    ia.altaTerminal(request.getParameter("terminal"));
                    String mensaje="Terminal ingresada correctamente!";
                    request.setAttribute("mensaje", mensaje);
                    rd.forward(request,response);
                } catch (ExPersistencia ex) {
                    request.setAttribute("mensaje", ex.getMessage());
                    rd.forward(request,response);
                }
       
                break;
            case "bajaTerminal":
                try {
                    ia.bajaTerminal(request.getParameter("terminalBaja"));
                    String mensaje="Terminal dada de baja correctamente!";
                    request.setAttribute("mensaje", mensaje);
                    rd.forward(request,response);
                } catch (ExPersistencia ex) {
                    request.setAttribute("mensaje", ex.getMessage());
                    rd.forward(request,response);
                }
                break;
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

}
