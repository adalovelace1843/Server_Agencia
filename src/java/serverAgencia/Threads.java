/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;



import exceptions.ExComunicacion;
import exceptions.ExPersistencia;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author f188315
 */
public class Threads extends Thread {
    private Servidor serv;
    private Socket sock;
    
    public Threads() {
    }
    
    public void iniciar(Servidor serv, Socket sock){
        this.serv = serv;
        this.sock = sock;
    }
    
    @Override
    public void run(){
        
        try {
            /* VALIDO QUE EL USUARIO/CLAVE QUE VIENE SEA CORRECTO */
            serv.validarLogin(sock);
            /* UNA VEZ AUTENTICADA LA TERMINAL INICIAMOS EL PROCESO DE INTERCAMBIO DE DATOS SEGUN OPCION */
            
            System.out.println("Comunicacion establecida . . . ");
            /* RECIBO LA PRIMER COMUNICACION QUE ME INDICA QUE ACCION TOMAR*/
            String comando = serv.obenerComando(sock);
            
            while(!comando.equals("0")){
                switch(comando){
                    case "0":
                        serv.finalizarSesion(sock);
                        break;
                    case "1":
                        serv.altaTicketServer(sock);
                        break;
                    case "2":
                        serv.anularTicketServer(sock);
                        break;
                    default:
                        break;
                }
                System.out.println("Esperando comunicacion . . . ");
                comando = serv.obenerComando(sock);    
            } 
            
        } catch (ExComunicacion ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExPersistencia ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
