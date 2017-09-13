/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import java.sql.SQLException;
import javax.naming.NamingException;
import valueObjects.VoTicket;
import valueObjects.VoTicketAgencia;

/**
 *
 * @author e299227
 */
public interface InterfaceAgencia {
    public String ventaTicketAg(VoTicket vo) throws NamingException,SQLException,ClassNotFoundException;
    public String ventaTicketCompletoAg(VoTicketAgencia vo) throws NamingException,SQLException,ClassNotFoundException;

    public boolean obtenerValidacion(String usuario, String clave) throws NamingException,SQLException,ClassNotFoundException;
}
