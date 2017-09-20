/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import exceptions.ExPersistencia;
import java.sql.SQLException;
import javax.naming.NamingException;
import valueObjects.VoTicket;
import valueObjects.VoTicketAgencia;

/**
 *
 * @author e299227
 */
public interface InterfaceAgencia {
    public void ventaTicketCompletoAg(VoTicketAgencia vo)throws ExPersistencia;
    public boolean obtenerValidacion(String usuario, String clave) throws ExPersistencia;
    public boolean existeTicket(int nroTicket) throws ExPersistencia;
    public int anularTicket(int nroTicket, String agencia_servidor) throws ExPersistencia;
    public boolean existeAnulacion(int nroTicket) throws ExPersistencia;
}
