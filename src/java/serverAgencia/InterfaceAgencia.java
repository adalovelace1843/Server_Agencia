/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import java.sql.SQLException;
import valueObjects.VoTicket;
import valueObjects.VoTicketAgencia;

/**
 *
 * @author e299227
 */
public interface InterfaceAgencia {
    public String ventaTicketAg(VoTicket vo) throws SQLException;
    public String ventaTicketCompletoAg(VoTicketAgencia vo) throws SQLException;
}
