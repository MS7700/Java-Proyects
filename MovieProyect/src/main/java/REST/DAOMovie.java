/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Model.Especifico.Movie;
import Model.General.GMovie;
import Model.Search.Title;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import kong.unirest.UnirestException;

/**
 *
 * @author Sebastián
 */
public class DAOMovie {
    Connection con = new Connection();
    
    public List<GMovie> getGMovieList(int cantidad) throws IOException, ProtocolException, UnirestException, InterruptedException{
        return con.GetListRandomMovie(cantidad);
    }
    
    public GMovie getGMovie(String id) throws IOException, ProtocolException, UnirestException, InterruptedException, RequestLimitException{
        GMovie movie = con.GetGMovie(id);
        return movie;
    }
    public Movie getMovie(String id) throws IOException, ProtocolException, UnirestException, InterruptedException{
        Movie movie = con.GetMovie(id);
        return movie;
    }
    public List<GMovie> SearchMovie(String name) throws IOException, ProtocolException, UnirestException, InterruptedException, RequestLimitException{
        List<GMovie> search = new ArrayList<GMovie>();
        Title[] movie = con.GetSearch(name).getTitles();
        for(int i=0; i<movie.length; i++){
            GMovie m = con.GetGMovie(movie[i].getId());
            if(m.getType() != null && m.getType().equals("movie") && !m.getTitle().equals("#DUPE#") && !m.getPoster().equals("N/A")){
                search.add(m);
            }
        }
        return search;
    }
    
    public String test = "Hola";
    
    public static void main(String[] args) throws IOException, ProtocolException, UnirestException, InterruptedException{
        DAOMovie dao = new DAOMovie();
        Movie movie = dao.getMovie("tt0114709");
        System.out.println(movie.getPlot());
    }
    //http://localhost:8080/MovieProyect/info.jsp/?id=tt7784604
    
}
