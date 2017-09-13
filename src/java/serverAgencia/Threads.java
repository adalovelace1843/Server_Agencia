/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import servidorimm.ServletIMM;
import servidorimm.ServletIMMService;
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
    private ServerSocket svrsock;
    private InterfaceAgencia ia = new InterfaceAgenciaImpl();
    
    
    public Threads() {
    }
    
    public void iniciar(Socket s, Servidor serv, ServerSocket svrSock){
        this.socket = s ;
        this.serv = serv;
        this. svrsock = svrSock;
    }
    
    @Override
    public void run(){
        
        String linea="ERROR";
        while(linea.equals("ERROR")){
            try {
                PrintWriter escritura;

                escritura=new PrintWriter(this.socket.getOutputStream(),true);
                if(validarLogin()){
                    linea="OK";
                }
                 escritura.println(linea);
            } catch (NamingException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        System.out.println("Comunicacion establecida . . . ");
        String dat;

        
        dat = this.serv.iniciarComunicacion(this.socket);
        while(!dat.equals("0")){
            
            int i=0;
            /* RECIBO LOS DATOS DEL TICKET DESDE UNA TERMINAL DE AGENCIA */
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
                        voTC.setFHVenta(dat);
                        break;
                    case 3: 
                        voTC.setFHInicio(dat);
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
            /* SE ENVIA EL TICKET HACIA LA IMM PARA SU TRATAMIENTO */
            VoTicketBasico voTB=server.altaTicketCompleto(voTC);
            System.out.println("Respuesta Servidor IMM, nro ticket: "+voTB.getNroTicket()+" importe:"+voTB.getImporteTotal());
            VoTicketAgencia voTA = new VoTicketAgencia();
            voTA.setNro_ticket(voTB.getNroTicket());
            voTA.setImporte_total(voTB.getImporteTotal());
            voTA.setMatricula(voTC.getMatricula());
            voTA.setTerminal_venta(terminal);
            voTA.setFecha_hora_venta(voTC.getFHVenta());

            /* SE GUARDA EL TICKET EN EL SERVIDOR DE AGENCIA */
            try {
                String resp=ia.ventaTicketCompletoAg(voTA);
                System.out.println("Respuesta Servidor Agencia: "+resp);
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NamingException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }

            /* ENVIO LOS DATOS HACIA LA TERMINAL DE LA AGENCIA */
            try {
                PrintWriter escritura;
                System.out.println("Iniciando envio de datos . . . ");
                escritura=new PrintWriter(this.socket.getOutputStream(),true);
                linea="Ticket:"+voTA.getNro_ticket()+" Importe:"+voTA.getImporte_total();
                escritura.println(linea);

                
            } catch (IOException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Esperando comunicacion . . . ");
            
            dat = this.serv.iniciarComunicacion(this.socket);
        }   
        
        
        try {
            System.out.println("Sesion desconectada . . ." + this.socket.getPort());
            this.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private boolean validarLogin() throws NamingException, SQLException, ClassNotFoundException{
        String dat = this.serv.iniciarComunicacion(this.socket);
        String usuario,clave;
        usuario=dat.substring(0, dat.indexOf(";"));
        clave=dat.substring(dat.indexOf(";")+1, dat.length());
        System.out.println("usuario: "+usuario+" clave:"+clave);
        return ia.obtenerValidacion(usuario,clave);
    }
    
}
