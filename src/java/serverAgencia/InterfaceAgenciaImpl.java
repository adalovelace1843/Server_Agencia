/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import exceptions.ExPersistencia;

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
    public boolean obtenerValidacion(String usuario, String clave) throws ExPersistencia{
        InterfaceBD_Ag in = InterfaceBD_Ag_Impl.getInstance();
        return in.obtenerValidacionBD(usuario,clave);

    }
    
}
