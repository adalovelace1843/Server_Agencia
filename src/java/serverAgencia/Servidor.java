/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f188315
 */
public class Servidor {

    public Servidor() {
    }
    
    public String iniciarComunicacion(Socket socketRecepcion){
        BufferedReader lectura;
        String s = "";
        try {
            lectura=new BufferedReader( new
            InputStreamReader(socketRecepcion.getInputStream()));
            s = lectura.readLine();
            System.out.println("Conectado con:"+socketRecepcion.getPort());
        } catch (IOException ex) {
            System.out.println("MENSAJE ERROR EN INICIAR COMUNICACION: "+ex.getMessage());
        }
        return s;
    }
    
}
