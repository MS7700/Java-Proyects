/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sebastián
 */
public class Conexion {
    
    public static Connection Usuarios = null;
    
    public static Connection Conectar(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String serverName = "//DESKTOP-C7QREVA:1433";
            String databaseName="db_Usuarios";
            String userName = "MyServer";
            String password = "1234";
            String connectionURL = "jdbc:sqlserver:"+serverName+";databaseName="+databaseName+";user="+userName+";password="+password+";";
            Connection con = DriverManager.getConnection(connectionURL);
            System.out.println("Conectado");
            Usuarios = con;
        }
        catch (ClassNotFoundException ex){
            System.out.println("No se encuentra Class");
        }
        catch (SQLException ex){
            System.out.println("Error SQL");
        }
        return Usuarios;        
    }
    
    public static ResultSet Consulta(String consulta){
        Connection con = Conectar();
        Statement declaracion;
        try{
            declaracion = con.createStatement();
            ResultSet respuesta = declaracion.executeQuery(consulta);
            return respuesta;
        }
        catch (SQLException ex){
            System.out.println("Error SQL");
        }
        return null;
    }    
}
