<%-- 
    Document   : info
    Created on : 05/11/2020, 10:21:54 PM
    Author     : Sebastián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="REST.DAOMovie" %>
<%@page import="Model.General.GMovie" %>
<%@page import="java.util.List" %>
<%@page import="Model.Especifico.Movie" %>
<%@page import="Model.Especifico.Cast" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<meta http-equiv="X-Frame-Options" content="allow">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% 
            String id = request.getParameter("id");
            DAOMovie dao = new DAOMovie();
            
            Movie movie = dao.getMovie(id);
           
            GMovie gmovie =  dao.getGMovie(id);;
        %>
        <title><%=gmovie.getTitle() %></title>
        
    </head>
    
    <body class="bg-light">
        <div class="container mt-5 mb-5">
            <div class="row">
            <div class="col-sm">
                <a href="index.jsp" >
                <button type="button" class="btn btn-warning">Go back</button>
                </a>
            </div>
            <div class="col-sm">
                <h1><%=gmovie.getTitle() %>
                <small class="text-muted">(<%=gmovie.getYear() %>)</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-sm">
                <img src="<%=gmovie.getPoster() %>" class="rounded mt-2" height="auto" width="100%" />
            </div>
            <div class="col-sm mt-2">
                <h6>Directed by: <%=gmovie.getDirector() %> 
                </h6>
                <% if(movie.getLength() == null || movie.getLength().equals("")){%>
                    <h6 class="text-muted"><%=gmovie.getRuntime() %></h6>
                <% }else{ %>
                <h6 class="text-muted"><%=movie.getLength() %></h6>
                    <% } %>
                
                <h6 class="text-muted"><%=gmovie.getGenre() %></h6>
                <h4>Plot</h4>
                <% if(movie.getPlot() == null || movie.getPlot().equals("")){%>
                    <p><%=gmovie.getPlot() %></p>
                <% }else{ %>
                <p><%=movie.getPlot() %></p>
                    <% } %>
                <h4>Cast</h4>
                <% if(movie.getCast() == null || movie.getCast().equals("")){%>
                    <p><%=gmovie.getActors() %></p>
                <% }else{ %>
                <ul>
                        <%
                        for(Cast cast : movie.getCast()){    
                        %>
                        <li><%=cast.getActor() %> as <%=cast.getCharacter() %></li>
                        <%
                            }  
                        %>
                    </ul>
                    <% } %>
                    
                    <% if(movie.getTrailer().getLink() == null){%>
                    <h4>Rating: 
                    <small class="text-muted"><%=gmovie.getImdbRating() %></small>
                    </h4>
                <% }else{ %>
                <h4>Trailer</h4>
                        
                        <iframe src="<%=movie.getTrailer().getLink() %>" width="480" height="270" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true" frameborder="no" scrolling="no"></iframe>
                        
                    <% } %>
                    
            </div>
        </div>
            
        </div>
        
    </body>
</html>
