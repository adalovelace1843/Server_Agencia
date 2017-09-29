/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import exceptions.ExComunicacion;
import exceptions.ExServidor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author e299227
 */
public class ServletServidor extends HttpServlet {
     @Override
    public void init() throws ServletException {
        super.init(); 
        iniciarServidor();
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    private void iniciarServidor(){
        InicioServidor i = new InicioServidor();
        i.start();

    }
}
