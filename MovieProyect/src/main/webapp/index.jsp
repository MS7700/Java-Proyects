<%-- 
    Document   : index
    Created on : 04/11/2020, 07:49:09 PM
    Author     : Sebastián
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="REST.DAOMovie" %>
<%@page import="Model.General.GMovie" %>
<%@page import="java.util.List" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Random Movie Generator</title>
    </head>
    <body class="bg-light">
        <div class="container mt-5 mb-5">
            <div class="row">
                <div class="col-sm">
                    <h1 class="mx-center text-center">Random Movie Generator</h1>
                </div>
                <div class="col-sm">
                    <form action="search.jsp" class="form-inline justify-content-end">
                        <input class="form-control m-2" id="search" name="search" placeholder="Search">
                        <button type="submit" class="btn btn-primary m-2">Search</button>
                    </form>
                </div>
            </div>
            <div class="row" height="250">
                <% 
                    DAOMovie dao = new DAOMovie();
                    List<GMovie> movies = dao.getGMovieList(5);
                    //for(GMovie movie : movies){
                    //GMovie movie = dao.getGMovie("tt1979376");
                    //List<GMovie> movies = new ArrayList<GMovie>();
                    //movies.add(dao.getGMovie("tt1979376"));
                    //movies.add(dao.getGMovie("tt1979375"));
                    //movies.add(dao.getGMovie("tt1979348"));
                    //movies.add(dao.getGMovie("tt1979339"));
                    //movies.add(dao.getGMovie("tt1979311"));
                    for(GMovie movie : movies){
                %>
                <div class="col-sm">
                    <a href="info.jsp?id=<%=movie.getImdbID() %>">
                    <div class="card text-center">
                        <img class="card-img-top" src="<%=movie.getPoster() %>" height="100%" widht="auto"/>
                    </div>
                    <div class="card-body text-center text-info">
                        <h5 class="card-title"><%=movie.getTitle() %></h5>
                        <p class="card-text">(<%=movie.getYear() %>)</p
                        <p class="card-text"><%=movie.getGenre() %></p>
                    </div>
                    </a>
                    
                    
                </div>
                <% 
                    }
                %>
            </div>
            <div class="row">
                <a href="index.jsp" class="mx-auto">
                    <button type="button" class="btn btn-danger">Generate movies</button>
                </a>
            </div>
        </div>
    </body>
</html>
