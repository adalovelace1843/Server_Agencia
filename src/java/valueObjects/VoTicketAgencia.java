/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valueObjects;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author e299227
 */
public class VoTicketAgencia extends VoTicketBasico implements Serializable {
    private String matricula;
    private Date fecha_hora_venta;
    private String terminal_venta;

    public VoTicketAgencia() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFecha_hora_venta() {
        return fecha_hora_venta;
    }

    public void setFecha_hora_venta(Date fecha_hora_venta) {
        this.fecha_hora_venta = fecha_hora_venta;
    }

    public String getTerminal_venta() {
        return terminal_venta;
    }

    public void setTerminal_venta(String terminal_venta) {
        this.terminal_venta = terminal_venta;
    }
    
    
}
