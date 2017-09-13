/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import valueObjects.VoTicket;

/**
 *
 * @author e299227
 */
public class InterfaceAgenciaImpl implements InterfaceAgencia {

    @Override
    public String ventaTicketAg(valueObjects.VoTicket vo) throws NamingException,SQLException,ClassNotFoundException{
        String respuesta = "ERROR EN GUARDAR TICKET EN SERVDOR AGENCIA";
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        in.guardarTicketAg(vo);
        respuesta = "Venta guardada en Servidor Agencia";

        return respuesta;
    }
    
    @Override
    public String ventaTicketCompletoAg(valueObjects.VoTicketAgencia vo) throws NamingException,SQLException,ClassNotFoundException {
        String respuesta = "ERROR EN GUARDAR TICKET EN SERVDOR AGENCIA";
      
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        in.guardarTicketCompletoAg(vo);
        respuesta = "Venta guardada en Servidor Agencia";

        return respuesta;
    }

    @Override
    public boolean obtenerValidacion(String usuario, String clave) throws NamingException,SQLException,ClassNotFoundException{
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerValidacionBD(usuario,clave);
    }
    
}
