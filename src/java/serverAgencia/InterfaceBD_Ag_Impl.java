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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import valueObjects.VoTicketAgencia;
import valueObjects.voUsuario;

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
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource)initContext.lookup("java:jboss/datasources/MySqlDS2/");
            conn = ds.getConnection();
        } catch (NamingException ex) {
            throw new ExPersistencia("Error al intentar conectarse a la BD (SA)");
        } catch (SQLException ex) {
            throw new ExPersistencia("Error al conectarse con la BD (SA)");
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
    public boolean obtenerValidacionBD(String usuario, String clave, String terminal) throws ExPersistencia{
        boolean resultado=false; 
        try {
             String sql="select * from usuarios where usuario=? and clave=?";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, usuario);
             ps.setString(2, clave);
          
             ResultSet rs =ps.executeQuery();
             if(rs.next()){
                 String sql2="select * from usuario_terminal where usuario=? and terminal=?";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, usuario);
                ps2.setString(2, terminal);
                 
                ResultSet rs2 =ps2.executeQuery();
                if(rs2.next()){
                    resultado=true;
                }
                rs2.close();
                ps2.close();
             }
             rs.close();
             ps.close();
            
         } catch (SQLException ex) {
             throw new ExPersistencia("Error en BD al obtener validacion (SA)");
         }
        return resultado;
    }

    @Override
    public boolean obtenerValidacionTicketBD(int nroTicket) throws ExPersistencia {
        boolean resultado=false;
        try {
            String sql="select * from ventascompleto where numero=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nroTicket);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                 resultado=true;
             }
             rs.close();
             ps.close();
        } catch (SQLException ex) {
             throw new ExPersistencia("Error en BD al obtener validacion Ticket (SA)");
         }
        return resultado;
    }

    @Override
    public void anularTicketBD(int nroTicket, int respuesta) throws ExPersistencia {
        try {
            String sql="INSERT INTO anulaciones (transaccion,numero) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, respuesta);
            ps.setInt(2, nroTicket);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
             throw new ExPersistencia("Error en BD anular el ticket, favor contactar con soporte para anulacion manual en BD agencia");
         }
    }

    @Override
    public boolean exsiteAnulacionBD(int nroTicket) throws ExPersistencia {
         boolean resultado=false;
        try {
            String sql="select * from anulaciones where numero=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nroTicket);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                 resultado=true;
             }
             rs.close();
             ps.close();
        } catch (SQLException ex) {
             throw new ExPersistencia("Error en BD al obtener existencia de anulacion de Ticket (SA)");
         }
        return resultado;
    }

    @Override
    public boolean obtenerValidacionAgenciaBD(String usuario, String clave) throws ExPersistencia {
        boolean resultado=false; 
        try {
             String sql="select * from usuarios where usuario=? and clave=? and web=1";
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
             throw new ExPersistencia("Error en BD al obtener validacion de la Agencia (SA)");
         }
        return resultado;
    }

    @Override
    public void altaUsuarioBD(voUsuario vo) throws ExPersistencia {
        try {
            String sql="insert into usuarios (usuario, clave,web) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vo.getUsuario());
            ps.setString(2, vo.getClave());
            ps.setInt(3, vo.getWeb());
            ps.executeUpdate();
            ps.close();     
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 1062){
                throw new ExPersistencia("Error! Ya existe usuario.");
            }else{
                throw new ExPersistencia("No se pudo de dar de alta al usuario. Error: "+ex.getMessage());
            }
        }
    }

    @Override
    public void agregarTerminalUsuarioBD(String usuario, String terminal) throws ExPersistencia {
        try {
            String sql2="insert into usuario_terminal (usuario, terminal) values (?,?)";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, usuario);
            ps2.setString(2, terminal);
            ps2.executeUpdate();
            ps2.close();
              
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 1062){
                throw new ExPersistencia("Error! La terminal ya existe para ese usuario.");
            }else{
                if(ex.getErrorCode() == 1452){
                    throw new ExPersistencia("Error! El usuario ingresado no existe.");
                }else{
                    throw new ExPersistencia("No se pudo asignarle la terminal al usuario. Error: "+ex.getMessage());
                }
                
            }
        }
    }

    @Override
    public void bajaUsuarioBD(String parameter) throws ExPersistencia {
        try {
            String sql="delete from usuario_terminal where usuario=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, parameter);
            int i=ps.executeUpdate();
            if(i>0){
                String sql2="delete from usuarios where usuario=?";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, parameter);
                ps2.executeUpdate();
                ps2.close();
            }else{
                throw new ExPersistencia("No existe un usuario creado con ese nombre.");
            }
            ps.close();     
        } catch (SQLException ex) {
            throw new ExPersistencia("No se pudo eliminar al usuario. Error: "+ex.getMessage());
        }
    }

    @Override
    public void altaTerminalBD(String parameter) throws ExPersistencia {
        
        try {
            String query="insert into terminales (terminal) values (?)";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1, parameter);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
           throw new ExPersistencia("No se pudo insertar la terminal. Error: "+ex.getMessage());
        }
        
    }

    @Override
    public ArrayList obtenerTerminalesBD() throws ExPersistencia {
        ArrayList listado = new ArrayList();
        try {
           
            String query="select terminal from terminales";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listado.add(rs.getString("terminal"));
            }
            rs.close();
            ps.close();
           
        } catch (SQLException ex) {
            throw new ExPersistencia("Error al obtener listado de terminales. Error: "+ex.getMessage());
        }
         return listado;
    }

    @Override
    public void bajaTerminalBD(String parameter) throws ExPersistencia {
        try {
            String query="delete from terminales where terminal=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, parameter);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new ExPersistencia("Error al eliminar la terminal. Error: "+ex.getMessage());
        }
        
    }
}
