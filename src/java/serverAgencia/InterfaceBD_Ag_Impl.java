/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import exceptions.ExPersistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import valueObjects.VoTicket;
import valueObjects.VoTicketAgencia;

/**
 *
 * @author e299227
 */
public class InterfaceBD_Ag_Impl implements InterfaceBD_Ag{
     private static Connection conn;
    private static InterfaceBD_Ag_Impl instancia;
    
    
    public static InterfaceBD_Ag_Impl getInstance() throws ExPersistencia{
        if(instancia == null){
            instancia = new InterfaceBD_Ag_Impl();
                instancia.conectarBD();

        }
        return instancia;
    }
    
    private void conectarBD() throws ExPersistencia {
         try {
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://10.36.6.110/bd_agencia?user=root&password=root");
            } catch (SQLException ex) {
                throw new ExPersistencia("Error en BD al obtener interfaz 2 (SA)");
            } catch (ClassNotFoundException ex) {
                throw new ExPersistencia("Error en BD al obtener interfaz 3 (SA)");
            }

    }
        
    /**
     * Funcion que permite persistir un ticket en bd_agencia
     * @param vo recibe un VoTicketCompleto
     * @return devuelve el numero de ticket o -1 si hubo algún error
     */
    @Override
    public void guardarTicketCompletoAg(VoTicketAgencia vo) throws ExPersistencia {
         try {
             String sql="INSERT INTO ventascompleto (numero,matricula,fecha_hora_venta,importe_Total, terminal_venta) values (?,?,?,?,?)";
             PreparedStatement inst2 = conn.prepareStatement(sql);
             inst2.setInt(1, vo.getNro_ticket());
             inst2.setString(2, vo.getMatricula());
             inst2.setString(3, vo.getFecha_hora_venta());
             inst2.setFloat(4, vo.getImporte_total());
             inst2.setString(5, vo.getTerminal_venta());
             inst2.executeUpdate();
                 
             inst2.close();
         } catch (SQLException ex) {
             throw new ExPersistencia("Error en BD al guardarTicket en agencia (SA)");
         }

    }

    @Override
    public boolean obtenerValidacionBD(String usuario, String clave) throws ExPersistencia{
        boolean resultado=false; 
        try {
             String sql="select * from usuarios where usuario=? and clave=?";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, usuario);
             ps.setString(2, clave);
             ResultSet rs =ps.executeQuery();
             if(rs.next()){
                 resultado=true;
             }
             rs.close();
             ps.close();
            
         } catch (SQLException ex) {
             throw new ExPersistencia("Error en BD al obtener validacion (SA)");
         }
        return resultado;
    }
}
