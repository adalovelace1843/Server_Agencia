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
        try {
              // TODO code application logic here
              Servidor s = new Servidor();
              ServerSocket socket = new ServerSocket(1500);
              System.out.println("Esperando comunicacion . . . ");
              
              while(true){
                  Socket socketRecepcion = socket.accept();
                  Threads t = new Threads();
                  t.iniciar(s,socketRecepcion);
                  t.start();
              }
          }catch (ExComunicacion ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ExServidor ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
             Logger.getLogger(ServletServidor.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
}
