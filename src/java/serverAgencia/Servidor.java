/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import comunicacion.Comunicacion;
import exceptions.ExComunicacion;
import exceptions.ExPersistencia;
import exceptions.ExServidor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorimm.ServletIMM;
import servidorimm.ServletIMMService;
import servidorimm.VoTicketBasico;
import servidorimm.VoTicketCompleto;
import valueObjects.VoTicketAgencia;
import valueObjects.VoTicketTerminal;


/**
 *
 * @author f188315
 */
public class Servidor {
    private Comunicacion com;
    private InterfaceAgencia ia = new InterfaceAgenciaImpl();
    private String agencia_svr;

    public Servidor() throws ExComunicacion, ExServidor {
        com = new Comunicacion();
        com.crearComunicacion(1500);
        cargarAgencia();
    }
    
    private void cargarAgencia() throws ExServidor {
        try {
            //Obtengo los datos del archivo de configuracion
            Properties p = new Properties();
            String nomArch = "config/config.properties";
            p.load (new FileInputStream (nomArch));
            this.agencia_svr = p.getProperty("agencia");
        } catch (FileNotFoundException ex) {
            throw new ExServidor("Error el archivo de configuracion no se encuentra (SA)");
        } catch (IOException ex) {
            throw new ExServidor("Error al leer el archivo de configuracion (SA)");
        }
    }
     
    public void ejecutarServidor() throws ExComunicacion{
        com.esperandoComunicacion();

    }
   
    public void validarLogin() throws ExComunicacion, ExPersistencia{
        boolean validacion=false;
        while(!validacion){
            String dat = (String) com.reciboDatos();
            String usuario,clave;
            usuario=dat.substring(0, dat.indexOf(";"));
            clave=dat.substring(dat.indexOf(";")+1, dat.length());
            /* HAGO CONSULTA SI EL USUARIO Y CLAVE SON VALIDOS EN LA PERSISTENCIA*/
            validacion= ia.obtenerValidacion(usuario,clave);
            if(validacion){
                com.envioDatos("OK");
            }else{
                com.envioDatos("ERROR");
            }
        }
    }
    
    public String obenerComando() throws ExComunicacion{
        return (String) com.reciboDatos();
    }
    
    public void altaTicketServer() throws ExComunicacion{
        String respuesta = "ERROR ALTA TICKET";
        /* RECIBO LOS DATOS DEL TICKET DESDE UNA TERMINAL DE AGENCIA */
        VoTicketTerminal voTT = (VoTicketTerminal) com.reciboDatos();
        VoTicketCompleto voTC = new VoTicketCompleto();
        voTC.setMatricula(voTT.getMatricula());
        voTC.setAgenciaVenta(voTT.getAgencia());
        voTC.setFHVenta(voTT.getFecha_hora_venta());
        voTC.setFHInicio(voTT.getFecha_hora_inicio());
        voTC.setCantMin(voTT.getMin());
        String terminal = voTT.getTerminal();
        System.out.println("Datos recibidos correctamente");
        VoTicketBasico voTB = enviarTicketIMM(voTC);
        if(voTB.getNroTicket() == -1){
            com.envioDatos("Hubo un error en el envio hacia la IMM, se cancela transaccion.");
        }else{
            /* GENERO EL VO TICKET AGENCIA PARA PODER ENVIARLO A PERSISTIR EN BD DE AGENCIA*/
            VoTicketAgencia voTA = new VoTicketAgencia();
            voTA.setNro_ticket(voTB.getNroTicket());
            voTA.setImporte_total(voTB.getImporteTotal());
            voTA.setMatricula(voTC.getMatricula());
            voTA.setTerminal_venta(terminal);
            voTA.setFecha_hora_venta(voTC.getFHVenta());
            try {
                persistirBDAgencia(voTA);
                System.out.println("Iniciando envio de datos hacia terminal . . . ");
                com.envioDatos("Nro ticket: "+voTB.getNroTicket()+" importe: "+voTB.getImporteTotal());
            } catch (ExPersistencia ex) {
                com.envioDatos(ex.getMessage());
            }
        }
        
    }
    
    private VoTicketBasico enviarTicketIMM(VoTicketCompleto voTC){
        /* GENERO LAS CLASES QUE ME ASISTEN CON EL WS DE IMM*/
        ServletIMMService s = new ServletIMMService();
        ServletIMM server = s.getServletIMMPort();
        /* SE ENVIA EL TICKET HACIA LA IMM PARA SU TRATAMIENTO */
        VoTicketBasico voTB=server.altaTicketCompleto(voTC);
        return voTB;
    }
    
    private void persistirBDAgencia(VoTicketAgencia voTA) throws ExPersistencia{
        ia.ventaTicketCompletoAg(voTA);
    }
    
    public void finalizarSesion() throws ExComunicacion{
        com.Finalizar();
    }

    public void anularTicketServer(){
        
        
        try {
            int nroTicket= (int) com.reciboDatos();
            if(!ia.existeAnulacion(nroTicket)){
                if(ia.existeTicket(nroTicket)){
                    int transaccion=ia.anularTicket(nroTicket,this.agencia_svr);
                    if(transaccion == -1){
                        com.envioDatos("Hubo un error en el servidor de la IMM, no se pudo anular el ticket");
                    }else{
                        com.envioDatos("Ticket anulado correctamente, nro de transaccion: "+transaccion);           
                    }
                }else{
                    com.envioDatos("El ticket no está registrado en la agencia");
                }
            }else{
                com.envioDatos("Ya existe una anulación para el ticket");
            }
        } catch (ExComunicacion ex) {
            try { 
                com.envioDatos(ex.getMessage());
            } catch (ExComunicacion ex1) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (ExPersistencia ex) {
            try { 
                com.envioDatos(ex.getMessage());
            } catch (ExComunicacion ex1) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        
        
    }
}
