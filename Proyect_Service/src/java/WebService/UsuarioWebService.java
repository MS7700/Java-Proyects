/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Conexiones.Conexion;
import Conexiones.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author Sebastián
 */
@WebService(serviceName = "UsuarioWebService")
public class UsuarioWebService {

    private String ParametroIndividual(String parametroName, String parametro){
        String partialConsulta = "";
        if(!(("".equals(parametro)) || (parametro == null))){
            
            if(parametroName == "Edad" || parametroName == "Sexo" || parametroName == "Telefono" || parametroName == "Email"){
                partialConsulta = "( "+ parametroName+" = '" + parametro + "' ) AND ";
            }else{
                partialConsulta = "( "+ parametroName+" LIKE '%" + parametro + "%' ) AND ";
            }
            
        }
        
        return partialConsulta;
    }
    
    
    @WebMethod(operationName = "SearchUsuarioService")
    public List<Usuario> SearchUsuarioService(@WebParam(name = "nombre") String nombre, @WebParam(name = "snombre") String snombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "ciudad") String ciudad, @WebParam(name = "pais") String pais, @WebParam(name = "edad") String edad, @WebParam(name = "sexo") String sexo, @WebParam(name = "email") String email, @WebParam(name = "telefono") String telefono, @WebParam(name = "comentario") String comentario) {

        String SearchConsulta = "SELECT * FROM Usuario WHERE " 
                + ParametroIndividual("Nombre", nombre) 
                + ParametroIndividual("SNombre", snombre)
                + ParametroIndividual("Apellido", apellido)
                + ParametroIndividual("Ciudad", ciudad)
                + ParametroIndividual("Pais", pais)
                + ParametroIndividual("Edad", edad)
                + ParametroIndividual("Sexo", sexo)
                + ParametroIndividual("Email", email)
                + ParametroIndividual("Telefono", telefono)
                + ParametroIndividual("Comentario", comentario)
                + "''=''";
        
        System.out.println(SearchConsulta);
        
        List<Usuario> lista = new ArrayList<Usuario>();
        
        try {
            ResultSet rs = Conexion.Consulta(SearchConsulta);
            while(rs.next()){
                Usuario usuario = new Usuario(
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10),
                rs.getString(11)
                );
            lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
}










//        String SearchConsulta = "SELECT A.ID, A.Nombre, A.SNombre, A.Apellido, A.Ciudad, A.Pais, A.Edad, A.Sexo, A.Email, A.Telefono, A.Comentario FROM Usuario A LEFT JOIN "
//                + "(SELECT * FROM Usuario WHERE (((CASE WHEN '"+nombre+"'='' THEN NULL ELSE 1 END=1) AND NOT(Nombre LIKE '"+nombre+"')) OR ((CASE WHEN '"+snombre+"'='' THEN NULL ELSE 1 END=1) AND NOT(SNombre LIKE '"+snombre+"')) OR ((CASE WHEN '"+apellido+"'='' THEN NULL ELSE 1 END=1) AND NOT(Apellido LIKE '"+apellido+"')) OR ((CASE WHEN '"+ciudad+"'='' THEN NULL ELSE 1 END=1) AND NOT(Ciudad LIKE '"+ciudad+"')) OR ((CASE WHEN '"+pais+"'='' THEN NULL ELSE 1 END=1) AND NOT(Pais LIKE '"+pais+"')) OR ((CASE WHEN '"+edad+"'='' THEN NULL ELSE 1 END=1) AND NOT(Edad='"+edad+"')) OR ((CASE WHEN '"+sexo+"'='' THEN NULL ELSE 1 END=1) AND NOT(Sexo='"+sexo+"')) OR ((CASE WHEN '"+email+"'='' THEN NULL ELSE 1 END=1) AND NOT(Email='"+email+"')) OR ((CASE WHEN '"+telefono+"'='' THEN NULL ELSE 1 END=1) AND NOT(Telefono='"+telefono+"')) OR ((CASE WHEN '"+comentario+"'='' THEN NULL ELSE 1 END=1) AND (Comentario LIKE '"+comentario+"')))) "
//                + "AS B ON A.ID = B.ID WHERE B.ID IS NULL AND NOT(((CASE WHEN '"+nombre+"'='' THEN NULL ELSE 1 END=1) AND NOT(A.Nombre LIKE '"+nombre+"')) AND ((CASE WHEN '"+snombre+"'='' THEN NULL ELSE 1 END=1) AND NOT(A.SNombre LIKE '"+snombre+"')) AND ((CASE WHEN '"+apellido+"'='' THEN NULL ELSE 1 END=1) AND NOT(A.Apellido LIKE '"+apellido+"')) AND ((CASE WHEN '"+ciudad+"'='' THEN NULL ELSE 1 END=1) AND NOT(A.Ciudad LIKE '"+ciudad+"')) AND ((CASE WHEN '"+pais+"'='' THEN NULL ELSE 1 END=1) AND NOT(A.Pais LIKE '"+pais+"')) AND ((CASE WHEN '"+edad+"'='' THEN NULL ELSE 1 END=1) AND NOT(A.Edad='"+edad+"')) AND ((CASE WHEN '"+sexo+"'='' THEN NULL ELSE 1 END=1) AND NOT(A.Sexo='"+sexo+"')) AND ((CASE WHEN '"+email+"'='' THEN NULL ELSE 1 END=1) AND NOT(A.Email='"+email+"')) AND ((CASE WHEN '"+telefono+"'='' THEN NULL ELSE 1 END=1) AND NOT(A.Telefono='"+telefono+"')) AND ((CASE WHEN '"+comentario+"'='' THEN NULL ELSE 1 END=1) OR (A.Comentario LIKE '"+comentario+"')));";

//        String SearchConsulta = "(SELECT * FROM Usuario WHERE (((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(Nombre LIKE '" +
//                "SELECT A.ID, A.Nombre, A.SNombre, A.Apellido, A.Ciudad, A.Pais, A.Edad, A.Sexo, A.Email, A.Telefono, A.Comentario FROM Usuario A LEFT JOIN "+nombre+"')) OR ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(SNombre LIKE '"+snombre+"')) OR ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(Apellido LIKE '"+apellido+"')) OR ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(Ciudad LIKE '"+ciudad+"')) OR ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(Pais LIKE '"+pais+"')) OR ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(Edad='"+edad+"')) OR ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(Sexo='"+sexo+"')) OR ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(Email='"+email+"')) OR ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(Telefono='"+telefono+"')) OR ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(Comentario LIKE '"+comentario+"'))))" +
//" AS B ON A.ID = B.ID" +
//"WHERE B.ID IS NULL AND NOT(((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.Nombre LIKE '"+nombre+"')) AND ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.SNombre LIKE '"+snombre+"')) AND ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.Apellido LIKE '"+apellido+"')) AND ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.Ciudad LIKE '"+ciudad+"')) AND ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.Pais LIKE '"+pais+"')) AND ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.Edad='"+edad+"')) AND ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.Sexo='"+sexo+"')) AND ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.Email='"+email+"')) AND ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.Telefono='"+telefono+"')) AND ((CASE WHEN ''='' THEN NULL ELSE 1 END=1) AND NOT(A.Comentario LIKE '"+comentario+"')));";
//        //String insertConsulta = "SELECT * FROM Usuario WHERE (Nombre = '"+nombre+"'), SNombre = '"+snombre+"', Apellido = '"+apellido+"', Ciudad = '"+ciudad+"', Pais = '"+pais+"', Edad = '"+edad+"', Sexo = '"+sexo+"', Email = '"+email+"', Telefono = '"+telefono+"', Comentario = '"+comentario+"';";
        //Usuario prueba = new Usuario(nombre, snombre, apellido, ciudad, pais, edad, sexo, email, telefono, comentario);
        //prueba.AddUsuarioSQL();
        //lista.add(prueba);
