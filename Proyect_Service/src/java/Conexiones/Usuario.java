/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;



import java.sql.ResultSet;

/**
 *
 * @author Sebastián
 */
public class Usuario {

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getSNombre() {
        return SNombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public String getEdad() {
        return Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getComentario() {
        return Comentario;
    }
    public String ID;
    public String Nombre;
    public String SNombre;
    public String Apellido;
    public String Ciudad;
    public String Pais;
    public String Edad;
    public String Sexo;
    public String Email;
    public String Telefono;
    public String Comentario;
    
    public Usuario(String nombre, String sNombre, String apellido, String ciudad, String pais, String edad, String sexo, String email, String telefono, String comentario){
        Nombre = nombre;
        SNombre = sNombre;
        Apellido = apellido;
        Ciudad = ciudad;
        Pais = pais;
        Edad = edad;
        Sexo = sexo;
        Email = email;
        Telefono = telefono;
        Comentario = comentario;
    }
    
    public Usuario(String id, String nombre, String sNombre, String apellido, String ciudad, String pais, String edad, String sexo, String email, String telefono, String comentario){
        ID = id;
        Nombre = nombre;
        SNombre = sNombre;
        Apellido = apellido;
        Ciudad = ciudad;
        Pais = pais;
        Edad = edad;
        Sexo = sexo;
        Email = email;
        Telefono = telefono;
        Comentario = comentario;
    }
    
    public void AddUsuarioSQL(){
        String insertConsulta = "INSERT INTO Usuario(Nombre, SNombre, Apellido, Ciudad, Pais, Edad, Sexo, Email, Telefono, Comentario) Values('"
                +Nombre+"','"+SNombre+"','"+Apellido+"','"+Ciudad+"','"+Pais+"','"+Edad+"','"
                +Sexo+"','"+Email+"','"+Telefono+"','"+Comentario+"');";
        Conexion.Consulta(insertConsulta);
    }
    
    public static ResultSet getUsuariosSQL(){
        ResultSet rs = null;
        rs = Conexion.Consulta("SELECT * FROM Usuario");
        
        
        return rs;
    } 
    public static void deleteUsuarioSQL(String id){
        String deleteConsulta = "DELETE FROM Usuario WHERE ID =" + id + ";";
        Conexion.Consulta(deleteConsulta);
    }
    public static ResultSet getUsuarioSQL(String id){
        String getConsulta = "SELECT * FROM Usuario WHERE ID="+ id +";";
        ResultSet rs = Conexion.Consulta(getConsulta);
        
        return rs;
    }
    public void updateUsuarioSQL(){
        String updateConsulta = "UPDATE Usuario SET Nombre = '"
                +Nombre+"', SNombre = '"+SNombre+"', Apellido = '"+Apellido+"', Ciudad = '"+Ciudad+"', Pais = '"
                +Pais+"', Edad = '"+Edad+"', Sexo = '"+Sexo+"', Email = '"+Email+"', Telefono = '"
                +Telefono+"', Comentario = '"+Comentario+"' WHERE ID = " + ID + ";";
        Conexion.Consulta(updateConsulta);
    }
}
