/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valueObjects;

import java.io.Serializable;

/**
 *
 * @author e299227
 */
public class VoCheckbox implements Serializable{
    private String terminal;
    private String isChecked;

    public VoCheckbox(String terminal, String isChecked) {
        this.terminal = terminal;
        this.isChecked = isChecked;
    }

    public String getTerminal() {
        return terminal;
    }

    public String getIsChecked() {
        return isChecked;
    }
    
    
}
