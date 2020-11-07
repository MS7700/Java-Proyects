<%-- 
    Document   : Result
    Created on : 24/09/2020, 10:03:39 PM
    Author     : Sebastián
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="Conexiones.Conexion" %>
<%@page import="Conexiones.Usuario" %>
<%@page import="java.sql.ResultSet" %>

<% 
    if(request.getParameter("id")!=null){
        Usuario usuario = new Usuario(
        request.getParameter("id"),
        request.getParameter("Nombre"),
        request.getParameter("SNombre"),
        request.getParameter("Apellido"),
        request.getParameter("Ciudad"),
        request.getParameter("Pais"),
        request.getParameter("Edad"),
        request.getParameter("Sexo"),
        request.getParameter("Email"),
        request.getParameter("Telefono"),
        request.getParameter("Comentario")
        );
        
        usuario.updateUsuarioSQL();
        
    }else if(request.getParameter("Nombre") != null){
        Usuario usuario = new Usuario(
        request.getParameter("Nombre"),
        request.getParameter("SNombre"),
        request.getParameter("Apellido"),
        request.getParameter("Ciudad"),
        request.getParameter("Pais"),
        request.getParameter("Edad"),
        request.getParameter("Sexo"),
        request.getParameter("Email"),
        request.getParameter("Telefono"),
        request.getParameter("Comentario")
        );
        usuario.AddUsuarioSQL();
        
    }
    
    ResultSet rs = Usuario.getUsuariosSQL();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Comentarios</h1>
        
        <% if(rs.next() == false){ %>
        <p>No hay comentarios disponibles</p>
           
        <% }else{
            do{
        %>
        <table style=" width:  500px">
                <tr>
                    <td><%= rs.getString(2)%> <%= rs.getString(3)%> <%= rs.getString(4)%></td>
                </tr>
                <tr>
                    <td>Ciudad: <%= rs.getString(5)%> Pais: <%= rs.getString(6)%></td>
                </tr>
                <tr>
                    <td>Edad: <%= rs.getString(7)%> Sexo: <%= rs.getString(8)%></td>
                </tr>
                <tr>
                    <td>Email: <%= rs.getString(9)%> Telefono: <%= rs.getString(10)%></td>
                </tr>
                <tr>
                    <td>Comentario:</td>
                </tr>
                <tr>
                    <td style="border: 1px solid black;"><%= rs.getString(11)%></td>
                </tr>
                <tr>
                    <td><a href='delete.jsp?id=<%= rs.getString(1)%>'><button type='button'>Delete comment</button></a><a href='update.jsp?id=<%= rs.getString(1)%>'><button type='button'>Update comment</button></a></td>
                </tr>
                <tr>
                    <td>---------------------------------------------------------------------------------------------</td>
                </tr>
            </table>
        <% }while(rs.next());%>
        
        <% } %>
            
            
        <a href='add.jsp'>Agregue un comentario aqui </a>
            
            
            
    </body>
</html>
