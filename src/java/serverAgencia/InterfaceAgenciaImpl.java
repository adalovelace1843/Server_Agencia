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
    public String ventaTicketAg(valueObjects.VoTicket vo) throws SQLException {
        String respuesta = "ERROR EN GUARDAR TICKET EN SERVDOR AGENCIA";
        try {
            InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
            in.guardarTicketAg(vo);
            respuesta = "Venta guardada en Servidor Agencia";
        } catch (NamingException ex) {
            Logger.getLogger(InterfaceAgenciaImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfaceAgenciaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
}
