/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;



import exceptions.ExComunicacion;
import exceptions.ExPersistencia;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author f188315
 */
public class Threads extends Thread {
    private Servidor serv;

    
    
    public Threads() {
    }
    
    public void iniciar(Servidor serv){
        this.serv = serv;
    }
    
    @Override
    public void run(){
        
        try {
            /* VALIDO QUE EL USUARIO/CLAVE QUE VIENE SEA CORRECTO */
            serv.validarLogin();
            /* UNA VEZ AUTENTICADA LA TERMINAL INICIAMOS EL PROCESO DE INTERCAMBIO DE DATOS SEGUN OPCION */
            
            System.out.println("Comunicacion establecida . . . ");
            /* RECIBO LA PRIMER COMUNICACION QUE ME INDICA QUE ACCION TOMAR*/
            String comando = serv.obenerComando();
            
            while(!comando.equals("0")){
                switch(comando){
                    case "0":
                        serv.finalizarSesion();
                        break;
                    case "1":
                        serv.altaTicketServer();
                        break;
                    case "2":
                        serv.anularTicketServer();
                        break;
                    default:
                        break;
                }
                
                System.out.println("Esperando comunicacion . . . ");
                comando = serv.obenerComando();
                
                
            }   
        } catch (ExComunicacion ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExPersistencia ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
