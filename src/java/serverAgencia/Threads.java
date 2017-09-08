/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;


import java.net.Socket;
import servidorimm.ServletIMM;
import servidorimm.ServletIMMService;
import servidorimm.VoTicket;
import servidorimm.VoTicketCompleto;

/**
 *
 * @author f188315
 */
public class Threads extends Thread {
    private Socket socket;
    private Servidor serv;

    public Threads() {
    }
    
    public void iniciar(Socket s, Servidor serv){
        this.socket = s ;
        this.serv = serv;
    }
    
    @Override
    public void run(){
        System.out.println("Comunicacion establecida . . . ");
        String dat;
        /*do{
            dat = this.serv.iniciarComunicacion(this.socket);
            System.out.println("Datos recibidos: "+dat.toUpperCase());
            VoTicket vo= new VoTicket();
            vo.setNombre(dat);
            ServletIMMService s = new ServletIMMService();
            ServletIMM server = s.getServletIMMPort();
            String resultado=server.altaTicket(vo);
            System.out.println("Respuesta Servidor IMM: "+resultado);
        }while(!"quit".equals(dat)); */
        do{
            dat = this.serv.iniciarComunicacion(this.socket);
            System.out.println("Datos recibidos: "+dat);
            /*VoTicketCompleto voTC = new VoTicketCompleto();
            voTC.setMatricula(dat);
            ServletIMMService s = new ServletIMMService();
            ServletIMM server = s.getServletIMMPort();
            String resultado="";
            System.out.println("Respuesta Servidor IMM: "+resultado);*/
        }while(!"quit".equals(dat)); 
        
    }
}
