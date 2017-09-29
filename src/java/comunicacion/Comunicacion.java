/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

import exceptions.ExComunicacion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author f188315
 */
public class Comunicacion {
    

    public Comunicacion() {
        
    }
    
    
    public void envioDatos(Object objeto, Socket sock) throws ExComunicacion{
        try {
            ObjectOutputStream escritura = new ObjectOutputStream(sock.getOutputStream());
            System.out.println("EN ENVIO DATOS: PUERTO "+sock.getPort());
            escritura.writeObject(objeto);
           
        } catch (IOException ex) {
            throw new ExComunicacion("Error al enviar datos (TA)["+ex.getMessage()+"]");
        }    
    }
    
    public Object reciboDatos(Socket sock) throws ExComunicacion {
        Object s;
        try {
            ObjectInputStream lectura = new ObjectInputStream(sock.getInputStream());
            System.out.println("EN RECIBO DATOS: PUERTO "+sock.getPort());
            s =  lectura.readObject();
            
        } catch (IOException ex) {
            throw new ExComunicacion("Error al recibir datos desde Servidor Agencia (I/O) (SA)["+ex.getMessage()+"]");
        } catch (ClassNotFoundException ex) {
            throw new ExComunicacion("Error al recibir datos desde Servidor Agencia (SA)["+ex.getMessage()+"]");
        }
        return s;
    }
    
    public void Finalizar(Socket sock) throws ExComunicacion{
        try {
            envioDatos("0", sock);
            sock.close();
        } catch (IOException ex) {
            throw new ExComunicacion("Error finalizar la conexion (SA)["+ex.getMessage()+"]");
        }
    }
    
    
}
