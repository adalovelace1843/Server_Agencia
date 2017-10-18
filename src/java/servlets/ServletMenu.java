/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import exceptions.ExPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import valueObjects.VoCheckbox;

/**
 *
 * @author f188315
 */
public class ServletMenu extends HttpServlet {



    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opc");
        RequestDispatcher rd;
        InterfaceAgencia ia= new InterfaceAgenciaImpl(); 
        switch(opcion){
            case "usuarios":
                try {
                    ArrayList listaUsuarios=ia.obtenerUsuarios();
                    request.setAttribute("listadoUsuarios",listaUsuarios);
                    
                    List<VoCheckbox> listaTerminales=ia.obtenerTerminales();
                    request.setAttribute("listadoTerminales", listaTerminales);
                    
                    rd=request.getRequestDispatcher("/usuarios.jsp");
                    rd.forward(request,response);
                } catch (ExPersistencia ex) {
                    rd=request.getRequestDispatcher("/mensaje.jsp");      
                    request.setAttribute("mensaje", ex.getMessage());
                    rd.forward(request,response);
                }
                    
                break;
            case "terminales":
                try {
                    List<VoCheckbox> listaTerminales=ia.obtenerTerminales();
                    request.setAttribute("listadoTerminales", listaTerminales);
                    rd=request.getRequestDispatcher("/terminales.jsp");     
                    rd.forward(request,response);
                } catch (ExPersistencia ex) {
                    rd=request.getRequestDispatcher("/mensaje.jsp");      
                    request.setAttribute("mensaje", ex.getMessage());
                    rd.forward(request,response);
                }
                break;
            case "listado":
                rd=request.getRequestDispatcher("/listado.jsp");
                rd.forward(request,response);
                break;
      
     
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String opcion = request.getParameter("opc");
        RequestDispatcher rd;
        switch(opcion){
            case "altaJ":
                rd=request.getRequestDispatcher("/ingreso.jsp");
                rd.forward(request,response);
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
