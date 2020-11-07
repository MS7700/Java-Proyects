<%-- 
    Document   : add
    Created on : 25/09/2020, 01:32:45 PM
    Author     : Sebastián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Búsqueda de comentarios</title>
    </head>
    <body>
        <h1>Digite los datos que quiera buscar</h1>
        
        <form action="list.jsp">
            <table>
                <tr>
                    <td><label for='Nombre'>Nombre:</label></td><td><input type="text" id="Nombre" name="Nombre" ></td>
                </tr>
                <tr>
                    <td><label for='SNombre'>Segundo nombre:</label></td><td><input type="text" id="SNombre" name="SNombre" ></td>
                </tr>
                <tr>
                    <td><label for='Apellido'>Apellido:</label></td><td><input type="text" id="Apellido" name="Apellido" ></td>
                </tr>
                <tr>
                    <td><label for='Ciudad'>Ciudad:</label></td><td><input type="text" id="Ciudad" name="Ciudad" ></td>
                </tr>
                <tr>
                    <td><label for='Pais'>Pais:</label></td><td><input type="text" id="Pais" name="Pais" ></td>
                </tr>
                <tr>
                    <td><label for='Edad'>Edad:</label></td><td><input type="number" id="Edad" name="Edad" ></td>
                </tr>
                <tr>
                    <td><label for='Sexo'>Sexo:</label></td>
                    <td>
                        <input type="radio" id="Hombre" name="Sexo" Value="Hombre"><label for='Hombre'>Hombre</label>
                        <input type="radio" id="Mujer" name="Sexo" Value="Mujer"><label for='Mujer'>Mujer</label>
                        <input type="radio" id="Otro" name="Sexo" Value="Otro"><label for='Otro'>Otro</label>
                    </td>
                </tr>
                <tr>
                    <td><label for='Email'>Email:</label></td><td><input type="email" id="Email" name="Email" ></td>
                </tr>
                <tr>
                    <td><label for='Telefono'>Telefono:</label></td><td><input type="tel" id="Telefono" name="Telefono" ></td>
                </tr>
                <tr>
                    <td><label for='Comentario'>Comentario:</label></td>
                </tr>
                <tr>
                    <td rows='50' cols='50' colspan='5' ><textarea id="Comentario" name="Comentario" placeholder="Escriba tu comentario aqui." ></textarea></td>
                </tr>
                <tr>
                    <td><input type='submit' value="Buscar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
