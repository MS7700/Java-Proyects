/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.General;

import java.io.Serializable;

/**
 *
 * @author Sebastián
 */
public class Rating implements Serializable {
    
    public Rating(){
        
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }
    String Source;
    String Value;
}
