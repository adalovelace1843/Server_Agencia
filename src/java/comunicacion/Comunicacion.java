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
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import valueObjects.VoTicketTerminal;

/**
 *
 * @author f188315
 */
public class Comunicacion {
    Socket sock;
    ServerSocket svrSock;

    public Comunicacion() {
        
    }
    
    public void crearComunicacion(int puerto) throws ExComunicacion{
        try {
            this.svrSock = new ServerSocket(puerto);
        } catch (IOException ex) {
            throw new ExComunicacion("Error al crear comunicacion (TA)["+ex.getMessage()+"]");
        }
    }
    
    
    public void envioDatos(Object objeto) throws ExComunicacion{
        try {
            ObjectOutputStream escritura = new ObjectOutputStream(sock.getOutputStream());
            escritura.writeObject(objeto);
            
        } catch (IOException ex) {
            throw new ExComunicacion("Error al enviar datos (TA)["+ex.getMessage()+"]");
        }    
    }
    
    public Object reciboDatos() throws ExComunicacion {
        Object s;
        try {
            ObjectInputStream lectura = new ObjectInputStream(sock.getInputStream());
            s =  lectura.readObject();
        } catch (IOException ex) {
            throw new ExComunicacion("Error al recibir datos desde Servidor Agencia (I/O) (SA)["+ex.getMessage()+"]");
        } catch (ClassNotFoundException ex) {
            throw new ExComunicacion("Error al recibir datos desde Servidor Agencia (SA)["+ex.getMessage()+"]");
        }
        return s;
    }
    
    public void Finalizar() throws ExComunicacion{
        try {
            envioDatos("0");
            this.sock.close();
        } catch (IOException ex) {
            throw new ExComunicacion("Error finalizar la conexion (SA)["+ex.getMessage()+"]");
        }
    }
    
    public void esperandoComunicacion() throws ExComunicacion{
        try {
            this.sock = svrSock.accept();
        } catch (IOException ex) {
            throw new ExComunicacion("Error esperando comunicacion (SA) ["+ex.getMessage()+"]");
        }
    }
}
