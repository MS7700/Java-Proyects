<%-- 
    Document   : delete
    Created on : 25/09/2020, 12:53:06 PM
    Author     : Sebastián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Conexiones.Usuario" %>

<% 
    Usuario.deleteUsuarioSQL(request.getParameter("id"));

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Comentario borrado.</h1>
        <a href='list.jsp'>Volver a ver los comentarios</a>
        <a href='add.jsp'>Agregar nuevo comentario</a>
    </body>
</html>
