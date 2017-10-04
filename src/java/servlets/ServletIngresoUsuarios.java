package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exceptions.ExPersistencia;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
public class ServletIngresoUsuarios extends HttpServlet {

    
    @Override
    public void init()
            throws ServletException {
       super.init();
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
        switch(parametro){
            case "ingresoUsuario": 
                voUsuario vo = new voUsuario();
                vo.setUsuario(request.getParameter("usuario"));
                vo.setClave(request.getParameter("clave"));
                vo.setTerminal(request.getParameter("terminal"));
                vo.setWeb(Integer.parseInt(request.getParameter("web")));

                
                RequestDispatcher rd;
                try {
                    ia.altaUsuario(vo);
                    rd=request.getRequestDispatcher("/mensaje.jsp");
                    String mensaje="Usuario ingresado correctamente!";
                    request.setAttribute("mensaje", mensaje);
                    rd.forward(request,response);
                } catch (ExPersistencia ex) {
                    rd=request.getRequestDispatcher("/mensaje.jsp");
                    request.setAttribute("mensaje", ex.getMessage());
                    rd.forward(request,response);
                }
                break;
            case "agregarTerminal":
        {
            try {
                ia.agregarTerminalUsuario(request.getParameter("usuario2"),request.getParameter("terminal2"));
                rd=request.getRequestDispatcher("/mensaje.jsp");
                String mensaje="Terminal ingresada correctamente!";
                request.setAttribute("mensaje", mensaje);
                rd.forward(request,response);
            } catch (ExPersistencia ex) {
                rd=request.getRequestDispatcher("/mensaje.jsp");
                request.setAttribute("mensaje", ex.getMessage());
                rd.forward(request,response);
            }
        }
                break;
            case "bajaUsuario":
        {
            try {
                ia.bajaUsuario(request.getParameter("usuario3"));
                rd=request.getRequestDispatcher("/mensaje.jsp");
                String mensaje="Usuario eliminado correctamente!";
                request.setAttribute("mensaje", mensaje);
                rd.forward(request,response);
            } catch (ExPersistencia ex) {
                rd=request.getRequestDispatcher("/mensaje.jsp");
                request.setAttribute("mensaje", ex.getMessage());
                rd.forward(request,response);
            }
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
