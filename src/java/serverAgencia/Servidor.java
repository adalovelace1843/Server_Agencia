/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import valueObjects.VoTicketTerminal;


/**
 *
 * @author f188315
 */
public class Servidor {

    public Servidor() {
    }
    
    public Object iniciarComunicacion(Socket socketRecepcion) throws ClassNotFoundException,IOException{

        Object s;
        ObjectInputStream lectura = new ObjectInputStream(socketRecepcion.getInputStream());
        s = lectura.readObject();
        System.out.println("Conectado con:"+socketRecepcion.getPort());
        return s;
    }
    

   
}
