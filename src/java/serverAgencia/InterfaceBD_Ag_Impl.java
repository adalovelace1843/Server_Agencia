/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import valueObjects.VoTicket;
import valueObjects.VoTicketAgencia;

/**
 *
 * @author e299227
 */
public class InterfaceBD_Ag_Impl implements InterfaceBD_Ag{
     private static Connection conn;
    private static InterfaceBD_Ag_Impl instancia;
    
    
    public static InterfaceBD_Ag_Impl getInstance() throws NamingException, SQLException, ClassNotFoundException{
        if(instancia == null){
            instancia = new InterfaceBD_Ag_Impl();
            instancia.conectarBD();
        }
        return instancia;
    }
    
    private void conectarBD() throws NamingException, SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://10.36.6.110/bd_agencia?user=root&password=root");

    }
    

    @Override
    public void guardarTicketAg(VoTicket vo) throws SQLException {
        String sql2="INSERT into ventas (comentario) values (?)";
        PreparedStatement instruccion2;
        instruccion2 = conn.prepareStatement(sql2);
        
        instruccion2.setString(1, vo.getNombre());
        instruccion2.execute();

        instruccion2.close();
    }

    
    /**
     * Funcion que permite persistir un ticket en bd_agencia
     * @param vo recibe un VoTicketCompleto
     * @return devuelve el numero de ticket o -1 si hubo algún error
     */
    @Override
    public void guardarTicketCompletoAg(VoTicketAgencia vo) throws SQLException {
        String sql="INSERT INTO ventascompleto (numero,matricula,fecha_hora_venta,importe_Total, terminal_venta) values (?,?,?,?,?)";
        PreparedStatement inst2 = conn.prepareStatement(sql);
        inst2.setInt(1, vo.getNro_ticket());
        inst2.setString(2, vo.getMatricula());
        inst2.setString(3, vo.getFecha_hora_venta());
        inst2.setFloat(4, vo.getImporte_total());
        inst2.setString(5, vo.getTerminal_venta());
        inst2.executeUpdate();

        inst2.close();    

    }
}
