/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

/**
 *
 * @author Sebastián
 */
public class RequestLimitException extends Exception {
    public RequestLimitException(){
        super("Actualiza el key");
    }
}
