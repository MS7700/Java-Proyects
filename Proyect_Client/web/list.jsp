<%-- 
    Document   : Result
    Created on : 24/09/2020, 10:03:39 PM
    Author     : Sebastián
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@page import="java.util.List" %>
<%@page import="webservice.Usuario" %>
<%@page import="Conexiones.UserService" %>

<% 
        UserService usuarioService = new UserService(
        request.getParameter("Nombre"),
        request.getParameter("SNombre"),
        request.getParameter("Apellido"),
        request.getParameter("Ciudad"),
        request.getParameter("Pais"),
        request.getParameter("Edad"),
        request.getParameter("Sexo"),
        request.getParameter("Email"),
        request.getParameter("Telefono"),
        request.getParameter("Comentario"));
    
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Comentarios</h1>
        
        
        <% 
            
            if(usuarioService.listaUsuario.isEmpty()){ %>
        <p>No hay comentarios disponibles</p>
           
        <% }else{
            for(Usuario user : usuarioService.listaUsuario){
        %>
        <table>
                <tr>
                    <td><%= user.getNombre()%> <%= user.getSNombre()%> <%= user.getApellido()%></td>
                </tr>
                <tr>
                    <td>Ciudad: <%= user.getCiudad()%> Pais: <%= user.getPais()%></td>
                </tr>
                <tr>
                    <td>Edad: <%= user.getEdad()%> Sexo: <%= user.getSexo()%></td>
                </tr>
                <tr>
                    <td>Email: <%= user.getEmail()%> Telefono: <%= user.getTelefono()%></td>
                </tr>
                <tr>
                    <td>Comentario:</td>
                </tr>
                <tr>
                    <td><%= user.getComentario()%></td>
                </tr>
                <tr>
                    <td>--------------------------------------------------------------------</td>
                </tr>
            </table>
        <% }%>
        
        <% } %>
            
            
        <a href='index.jsp'>Volver a buscar </a>
           
            
            
    </body>
</html>
