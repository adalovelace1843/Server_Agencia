/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valueObjects;

/**
 *
 * @author e299227
 */
public class voUsuario {
    private String usuario;
    private String clave;
    private String terminal;
    private int web;

    public voUsuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }
    
    
}
