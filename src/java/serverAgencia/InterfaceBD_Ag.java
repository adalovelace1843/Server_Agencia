/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import java.sql.SQLException;
import servidorimm.VoTicketCompleto;
import valueObjects.VoTicket;
import valueObjects.VoTicketAgencia;

/**
 *
 * @author e299227
 */
public interface InterfaceBD_Ag {
    public void guardarTicketAg(VoTicket vo) throws SQLException;
    public void guardarTicketCompletoAg (VoTicketAgencia vo) throws SQLException;

    public boolean obtenerValidacionBD(String usuario, String clave) throws SQLException;
}
