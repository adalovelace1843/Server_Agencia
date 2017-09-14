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
        
        
        /* ESTA SECCION SE ENCARGA DE VALIDAR LAS PETICIONES DE AUTENTICACION
        DESDE LAS DIFERENTES TERMINALES */
        String linea="ERROR";
        while(linea.equals("ERROR")){
            PrintWriter escritura = null; 
            try {
                escritura=new PrintWriter(this.socket.getOutputStream(),true);
                if(validarLogin()){
                    linea="OK";
                }    
            } catch (NamingException ex) {
                linea="error_interno_sa";
            } catch (SQLException ex) {
                linea="error_bd";
            } catch (ClassNotFoundException ex) {
                linea="error_interno_sa";
            } catch (IOException ex) {
                linea="error_interno_sa";
            }
            escritura.println(linea);
        }
        /* FIN */
        
        /* UNA VEZ AUTENTICADA LA TERMINAL INICIAMOS EL PROCESO DE INTERCAMBIO DE DATOS SEGUN OPCION */
        
        System.out.println("Comunicacion establecida . . . ");
        String dat;
        
        /* RECIBO LA PRIMER COMUNICACION QUE ME INDICA SI INICIO LA ESCUCHA DE DATOS 
        O FINALIZO LA COMUNICACION*/
        dat = this.serv.iniciarComunicacion(this.socket);
        while(!dat.equals("0")){
            
            int i=0;
            VoTicketCompleto voTC = new VoTicketCompleto();
            String terminal="";
            
            /* RECIBO LOS DATOS DEL TICKET DESDE UNA TERMINAL DE AGENCIA */
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

            /* GENERO LAS CLASES QUE ME ASISTEN CON EL WS DE IMM*/
            ServletIMMService s = new ServletIMMService();
            ServletIMM server = s.getServletIMMPort();
            /* SE ENVIA EL TICKET HACIA LA IMM PARA SU TRATAMIENTO */
            VoTicketBasico voTB=server.altaTicketCompleto(voTC);
            System.out.println("Respuesta Servidor IMM, nro ticket: "+voTB.getNroTicket()+" importe:"+voTB.getImporteTotal());
            
            /* SI HUBO ALGUN ERROR EN LA IMM SE DEVUELVE NRO TICKET -1 */
            if(voTB.getNroTicket() == -1){
                System.out.println("HUBO ERROR EN RESPUESTA IMM ESTA PARTE NO ESTA IMPLEMENTADA AUN");
            }
            
            /* GENERO EL VO TICKET AGENCIA PARA PODER ENVIARLO A PERSISTIR EN BD DE AGENCIA*/
            VoTicketAgencia voTA = new VoTicketAgencia();
            voTA.setNro_ticket(voTB.getNroTicket());
            voTA.setImporte_total(voTB.getImporteTotal());
            voTA.setMatricula(voTC.getMatricula());
            voTA.setTerminal_venta(terminal);
            voTA.setFecha_hora_venta(voTC.getFHVenta());

            /* SE GUARDA EL TICKET EN EL SERVIDOR DE AGENCIA */
            String resp;
            try {
                resp=ia.ventaTicketCompletoAg(voTA);
                System.out.println("Respuesta Servidor Agencia: "+resp);
            } catch (SQLException ex) {
                resp="error_bd";
            } catch (NamingException ex) {
                resp="error_interno_sa";
            } catch (ClassNotFoundException ex) {
                resp="error_interno_sa";
            }

            /* ENVIO LOS DATOS HACIA LA TERMINAL DE LA AGENCIA */
            try {
                PrintWriter escritura;
                System.out.println("Iniciando envio de datos hacia terminal . . . ");
                escritura=new PrintWriter(this.socket.getOutputStream(),true);
                /* VALIDO QUE NO HAYAN HABIDO ERRORES AL PERSISTIR TICKET EN SA */
                if("error_bd".equals(resp) || "error_interno_sa".equals(resp)){
                    linea=resp;
                }else{
                    linea="Ticket:"+voTA.getNro_ticket()+" Importe:"+voTA.getImporte_total();
                }
                escritura.println(linea);        
            } catch (IOException ex) {
                System.out.println("ERROR DE IO: "+ex.getMessage());
            }

            System.out.println("Esperando comunicacion . . . ");
            
            dat = this.serv.iniciarComunicacion(this.socket);
        }   
        
        try {
            System.out.println("Sesion desconectada . . ." + this.socket.getPort());
            this.socket.close();
        } catch (IOException ex) {
            System.out.println("ERROR DE IO: "+ex.getMessage());
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
