/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverAgencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import servidorimm.VoTicketCompleto;
import valueObjects.VoTicket;

/**
 *
 * @author e299227
 */
public class InterfaceBD_Ag_Impl implements InterfaceBD_Ag{
     private static Connection conn;
    private static InterfaceBD_Ag_Impl instancia;
    
    
    public static InterfaceBD_Ag_Impl getInstance() throws NamingException, SQLException{
        if(instancia == null){
            instancia = new InterfaceBD_Ag_Impl();
            instancia.conectarBD();
        }
        return instancia;
    }
    
    private void conectarBD() throws NamingException, SQLException{
        InitialContext initContext2 = new InitialContext();
        DataSource ds2 = (DataSource)initContext2.lookup("java:jboss/datasources/MySqlDS2");
        conn = ds2.getConnection();
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
    public int guardarTicketCompletoAg(VoTicketCompleto vo) throws SQLException {
        /*String sql="SELECT numero+1 from secuencia where tipo = 'ticket'";
        PreparedStatement inst;
        inst = conn.prepareStatement(sql);
        ResultSet rs = inst.executeQuery(sql);
        int numero = -1;
        if(rs.next()){
            numero = rs.getInt("numero");
            sql="INSERT INTO ventascompleto (numero,agencia,matricula,fecha_hora_venta,fecha_hora_inicio,hora_inicio,minutos,importe_Total) values (?,?,?,?,?,?,?)";
            PreparedStatement inst2 = conn.prepareStatement(sql);
            inst2.setInt(1, numero);
            inst2.setString(2, vo.getAgencia_venta());
            inst2.setString(3, vo.getMatricula());
            inst2.setDate(4, vo.getF_h_venta());
            inst2.setDate(5, vo.getF_h_inicio());
            inst2.setInt(6, vo.getCant_min());
            inst2.setFloat(7, vo.getImporte_total());
            if(inst2.executeUpdate(sql) == 1){
                sql="UPDATE FROM secuencia SET numero=numero+1 where tipo = 'ticket'";
                PreparedStatement inst3 = conn.prepareStatement(sql);
                if(inst3.executeUpdate(sql) != 1){
                    numero=-1;
                }
                inst3.close();
            }
            inst2.close();
        }
        rs.close();
        inst.close();    
        return numero;   */
        return 0;
    }
}
