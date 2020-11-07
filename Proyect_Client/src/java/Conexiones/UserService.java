/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.WebServiceRef;
import webservice.Usuario;
import webservice.UsuarioWebService_Service;


/**
 *
 * @author Sebastián
 */
public class UserService {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Proyect_Service/UsuarioWebService.wsdl")
    private UsuarioWebService_Service service = new UsuarioWebService_Service();
    
    

    private java.util.List<webservice.Usuario> searchUsuarioService(java.lang.String nombre, java.lang.String snombre, java.lang.String apellido, java.lang.String ciudad, java.lang.String pais, java.lang.String edad, java.lang.String sexo, java.lang.String email, java.lang.String telefono, java.lang.String comentario) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        
        webservice.UsuarioWebService port = service.getUsuarioWebServicePort();
        return port.searchUsuarioService(nombre, snombre, apellido, ciudad, pais, edad, sexo, email, telefono, comentario);
        
    }
    public List<Usuario> listaUsuario = new ArrayList<Usuario>();
    
    public UserService(java.lang.String nombre, java.lang.String snombre, java.lang.String apellido, java.lang.String ciudad, java.lang.String pais, java.lang.String edad, java.lang.String sexo, java.lang.String email, java.lang.String telefono, java.lang.String comentario){
        listaUsuario = searchUsuarioService(nombre, snombre, apellido, ciudad, pais, edad, sexo, email, telefono, comentario);
    }
}
