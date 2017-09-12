/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;


import java.net.Socket;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorimm.ServletIMM;
import servidorimm.ServletIMMService;
import servidorimm.VoTicket;
import servidorimm.VoTicketBasico;
import servidorimm.VoTicketCompleto;
import valueObjects.VoTicketAgencia;

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
        //do{
       /*    dat = this.serv.iniciarComunicacion(this.socket);
            System.out.println("Datos recibidos: "+dat.toUpperCase());
            VoTicket vo= new VoTicket();
            vo.setNombre(dat);
            ServletIMMService s = new ServletIMMService();
            ServletIMM server = s.getServletIMMPort();
            String resultado=server.altaTicket(vo);
            System.out.println("Respuesta Servidor IMM: "+resultado);
            
           
        try {
            InterfaceAgencia ia = new InterfaceAgenciaImpl();
            valueObjects.VoTicket vo2= new valueObjects.VoTicket();
            vo2.setNombre(dat);
            resultado=ia.ventaTicketAg(vo2);
            System.out.println("Respuesta Servidor Agencia: "+resultado);
        } catch (SQLException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
        //}while(!"quit".equals(dat)); 
        
        System.out.println("Comunicacion establecida . . . ");
        String dat;
        int i=0;
        
        VoTicketCompleto voTC = new VoTicketCompleto();
        String terminal="";
        while(i<6){
            dat = this.serv.iniciarComunicacion(this.socket);
            System.out.println("Datos recibidos: "+dat);
            switch(i){
                case 0: 
                    voTC.setMatricula(dat);
                    break;
                case 1: 
                    voTC.setAgenciaVenta(dat);
                    break;
                case 2: 
                    voTC.setFHVenta(null);
                    break;
                case 3: 
                    voTC.setFHInicio(null);
                    break;
                case 4: 
                    voTC.setCantMin(Integer.parseInt(dat));
                    break;
                case 5: 
                    terminal=dat;
                    break;
                }
            i++;
        }

        ServletIMMService s = new ServletIMMService();
        ServletIMM server = s.getServletIMMPort();
        VoTicketBasico voTB=server.altaTicketCompleto(voTC);
        System.out.println("Respuesta Servidor IMM, nro ticket: "+voTB.getNroTicket()+" importe:"+voTB.getImporteTotal());
        VoTicketAgencia voTA = new VoTicketAgencia();
        voTA.setNro_ticket(voTB.getNroTicket());
        voTA.setImporte_total(voTB.getImporteTotal());
        voTA.setMatricula(voTC.getMatricula());
        voTA.setTerminal_venta(terminal);
        voTA.setFecha_hora_venta(null);

        try {
            InterfaceAgencia ia = new InterfaceAgenciaImpl();
            String resp=ia.ventaTicketCompletoAg(voTA);
            System.out.println("Respuesta Servidor Agencia: "+resp);
        } catch (SQLException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
