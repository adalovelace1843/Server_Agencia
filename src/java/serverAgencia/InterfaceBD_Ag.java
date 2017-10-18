/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import exceptions.ExPersistencia;
import java.util.ArrayList;
import java.util.List;
import valueObjects.VoCheckbox;
import valueObjects.VoTicketAgencia;
import valueObjects.voUsuario;

/**
 *
 * @author e299227
 */
public interface InterfaceBD_Ag {
    public void guardarTicketCompletoAg (VoTicketAgencia vo) throws ExPersistencia;
    public boolean obtenerValidacionBD(String usuario, String clave,String terminal) throws ExPersistencia;
    public boolean obtenerValidacionTicketBD(int nroTicket) throws ExPersistencia;
    public void anularTicketBD(int nroTicket, int respuesta) throws ExPersistencia;
    public boolean exsiteAnulacionBD(int nroTicket) throws ExPersistencia;
    public boolean obtenerValidacionAgenciaBD(String usuario, String clave)throws ExPersistencia;
    public void altaUsuarioBD(voUsuario vo)throws ExPersistencia;
    public void agregarTerminalUsuarioBD(String usuario, String[] terminal)throws ExPersistencia;
    public void bajaUsuarioBD(String parameter)throws ExPersistencia;
    public void altaTerminalBD(String parameter)throws ExPersistencia;
    public List<VoCheckbox> obtenerTerminalesBD()throws ExPersistencia;
    public void bajaTerminalBD(String parameter)throws ExPersistencia;
    public ArrayList obtenerUsuariosBD()throws ExPersistencia;

    public List<VoCheckbox> obtenerTerminalesCheckboxBD(Object get)throws ExPersistencia;

}
