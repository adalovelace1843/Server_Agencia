/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import exceptions.ExPersistencia;
import valueObjects.VoTicketAgencia;

/**
 *
 * @author e299227
 */
public interface InterfaceBD_Ag {
    public void guardarTicketCompletoAg (VoTicketAgencia vo) throws ExPersistencia;
    public boolean obtenerValidacionBD(String usuario, String clave) throws ExPersistencia;
    public boolean obtenerValidacionTicketBD(int nroTicket) throws ExPersistencia;
    public void anularTicketBD(int nroTicket, int respuesta) throws ExPersistencia;
    public boolean exsiteAnulacionBD(int nroTicket) throws ExPersistencia;
}
