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
import javax.xml.ws.WebServiceException;
import servidorimm.ServletIMM;
import servidorimm.ServletIMMService;
import valueObjects.VoCheckbox;
import valueObjects.voUsuario;

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
    public boolean obtenerValidacion(String usuario, String clave, String terminal) throws ExPersistencia{
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerValidacionBD(usuario,clave, terminal);

    }

    @Override
    public boolean existeTicket(int nroTicket) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerValidacionTicketBD(nroTicket);
    }

    @Override
    public int anularTicket(int nroTicket, String agencia) throws ExPersistencia,ExWebServiceIMM {
        int respuesta=0;
        try{
            /* GENERO LAS CLASES QUE ME ASISTEN CON EL WS DE IMM*/
            ServletIMMService s = new ServletIMMService();
            ServletIMM server = s.getServletIMMPort();

            /* SE ENVIA EL Nro de ticket a anular HACIA LA IMM PARA SU TRATAMIENTO */
            respuesta = server.anularTicketIMM(nroTicket, agencia);
            if(respuesta > 0){
                InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
                in.anularTicketBD(nroTicket, respuesta);
            }
        }catch(WebServiceException ex){
            throw new ExWebServiceIMM("Error al conectarse con WS IMM, se interrumpio la transaccion");
        }
        return respuesta;
    }

    @Override
    public boolean existeAnulacion(int nroTicket) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.exsiteAnulacionBD(nroTicket);
    }

    @Override
    public boolean obtenerValidacionAgencia(String usuario, String clave) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerValidacionAgenciaBD(usuario,clave);
    }

    @Override
    public void altaUsuario(voUsuario vo) throws ExPersistencia {
       InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
       in.altaUsuarioBD(vo);
    }

    @Override
    public void agregarTerminalUsuario(String usuario, String[] terminal) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        in.agregarTerminalUsuarioBD(usuario,terminal);
    }

    @Override
    public void bajaUsuario(String parameter) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        in.bajaUsuarioBD(parameter);
    }

    @Override
    public void altaTerminal(String parameter) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        in.altaTerminalBD(parameter);
    }

    @Override
    public List<VoCheckbox> obtenerTerminales() throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerTerminalesBD();
    }

    @Override
    public void bajaTerminal(String parameter) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        in.bajaTerminalBD(parameter);
    }

    @Override
    public ArrayList obtenerUsuarios() throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerUsuariosBD();
    }

    @Override
    public List<VoCheckbox> obtenerTerminalesCheckbox(Object get) throws ExPersistencia {
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerTerminalesCheckboxBD(get);
    }
    
}
