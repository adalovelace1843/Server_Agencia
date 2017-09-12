/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e299227
 */
public class main {
      public static void main(String[] args) {
          try {
              // TODO code application logic here
              Servidor s = new Servidor();
              ServerSocket socket;
              
              socket = new ServerSocket(1500);
              System.out.println("Esperando comunicacion . . . ");
              
              while(true){
                  Socket socketRecepcion = socket.accept();
                  Threads t = new Threads();
                  t.iniciar(socketRecepcion,s, socket);
                  t.run();
              }
          } catch (IOException ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          }

      }
}
