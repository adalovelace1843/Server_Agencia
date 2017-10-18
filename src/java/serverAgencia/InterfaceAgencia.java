/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import exceptions.ExPersistencia;
import exceptions.ExWebServiceIMM;
import java.util.ArrayList;
import java.util.List;
import valueObjects.VoCheckbox;
import valueObjects.VoTicketAgencia;
import valueObjects.voUsuario;

/**
 *
 * @author e299227
 */
public interface InterfaceAgencia {
    public void ventaTicketCompletoAg(VoTicketAgencia vo)throws ExPersistencia;
    public boolean obtenerValidacion(String usuario, String clave, String terminal) throws ExPersistencia;
    public boolean existeTicket(int nroTicket) throws ExPersistencia;
    public int anularTicket(int nroTicket, String agencia) throws ExPersistencia,ExWebServiceIMM;
    public boolean existeAnulacion(int nroTicket) throws ExPersistencia;
    public boolean obtenerValidacionAgencia(String usuario, String clave)  throws ExPersistencia;
    public void altaUsuario(voUsuario vo)  throws ExPersistencia;
    public void agregarTerminalUsuario(String usuario, String[] terminal)throws ExPersistencia;
    public void bajaUsuario(String parameter)throws ExPersistencia;
    public void altaTerminal(String parameter)throws ExPersistencia;
    public List<VoCheckbox> obtenerTerminales()throws ExPersistencia;
    public void bajaTerminal(String parameter)throws ExPersistencia;
    public ArrayList obtenerUsuarios()throws ExPersistencia;
    public List<VoCheckbox> obtenerTerminalesCheckbox(Object get)throws ExPersistencia;
}
