/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import exceptions.ExPersistencia;
import servidorimm.ServletIMM;
import servidorimm.ServletIMMService;

/**
 *
 * @author e299227
 */
public class InterfaceAgenciaImpl implements InterfaceAgencia {
    
    @Override
    public void ventaTicketCompletoAg(valueObjects.VoTicketAgencia vo) throws ExPersistencia{
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        in.guardarTicketCompletoAg(vo);
    }

    @Override
    public boolean obtenerValidacion(String usuario, String clave) throws ExPersistencia{
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerValidacionBD(usuario,clave);

    }

    @Override
    public boolean existeTicket(int nroTicket) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerValidacionTicketBD(nroTicket);
    }

    @Override
    public int anularTicket(int nroTicket, String agencia_servidor) throws ExPersistencia {
        /* GENERO LAS CLASES QUE ME ASISTEN CON EL WS DE IMM*/
        ServletIMMService s = new ServletIMMService();
        ServletIMM server = s.getServletIMMPort();
        int respuesta=0;
        /* SE ENVIA EL Nro de ticket a anular HACIA LA IMM PARA SU TRATAMIENTO */
        respuesta = server.anularTicketIMM(nroTicket);

        if(respuesta > 0){
            InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
            in.anularTicketBD(nroTicket, respuesta);
        }
        return respuesta;
    }

    @Override
    public boolean existeAnulacion(int nroTicket) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.exsiteAnulacionBD(nroTicket);
    }
    
}
