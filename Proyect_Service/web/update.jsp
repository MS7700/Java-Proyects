<%-- 
    Document   : update
    Created on : 25/09/2020, 03:29:27 PM
    Author     : Sebastián
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexiones.Conexion" %>
<%@page import="Conexiones.Usuario" %>
<%@page import="java.sql.ResultSet" %>

<% 
    ResultSet rs = Usuario.getUsuarioSQL(request.getParameter("id"));

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de comentario</title>
    </head>
    <body>
        <h1>Actualizar comentario</h1>
        <%  while(rs.next()){%>
        <form action="list.jsp">
            <input type='text' id="id" name="id" value='<%= request.getParameter("id")%>' hidden>
            <table>
                <tr>
                    <td><label for='Nombre'>Nombre:</label></td><td><input type="text" id="Nombre" name="Nombre" value='<%= rs.getString(2)%>' required></td>
                </tr>
                <tr>
                    <td><label for='SNombre'>Segundo nombre:</label></td><td><input type="text" id="SNombre" name="SNombre" value='<%= rs.getString(3)%>' ></td>
                </tr>
                <tr>
                    <td><label for='Apellido'>Apellido:</label></td><td><input type="text" id="Apellido" name="Apellido" value='<%= rs.getString(4)%>' required></td>
                </tr>
                <tr>
                    <td><label for='Ciudad'>Ciudad:</label></td><td><input type="text" id="Ciudad" name="Ciudad" value='<%= rs.getString(5)%>' required></td>
                </tr>
                <tr>
                    <td><label for='Pais'>Pais:</label></td><td><input type="text" id="Pais" name="Pais" value='<%= rs.getString(6)%>' required></td>
                </tr>
                <tr>
                    <td><label for='Edad'>Edad:</label></td><td><input type="number" id="Edad" name="Edad" value='<%= rs.getString(7)%>' required></td>
                </tr>
                <tr>
                    <td><label for='Sexo'>Sexo: </label></td>
                    <td>                        
                        <input type="radio" id="Hombre" name="Sexo" Value="Hombre" <%=(rs.getString(8).equals("Hombre") ? "checked":"")%> ><label for='Hombre'>Hombre</label>
                        <input type="radio" id="Mujer" name="Sexo" Value="Mujer"<%=(rs.getString(8).equals("Mujer") ? "checked":"")%> ><label for='Mujer'>Mujer</label>
                        <input type="radio" id="Otro" name="Sexo" Value="Otro" <%=(rs.getString(8).equals("Otro") ? "checked":"")%> ><label for='Otro'>Otro</label>                         
                    </td>
                </tr>
                <tr>
                    <td><label for='Email'>Email:</label></td><td><input type="email" id="Email" name="Email" value='<%= rs.getString(9)%>' required></td>
                </tr>
                <tr>
                    <td><label for='Telefono'>Telefono:</label></td><td><input type="tel" id="Telefono" name="Telefono" value='<%= rs.getString(10)%>' required></td>
                </tr>
                <tr>
                    <td><label for='Comentario'>Comentario:</label></td>
                </tr>
                <tr>
                    <td rows='50' cols='50' colspan='5' ><textarea id="Comentario" name="Comentario" placeholder="Escriba tu comentario aqui." required><%= rs.getString(11)%></textarea></td>
                </tr>
                <tr>
                    <td><input type='submit' value="Actualizar"></td>
                </tr>
            </table>
        </form>
           <%  }%>
    </body>
</html>

