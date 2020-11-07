/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package REST;



import Model.Especifico.Movie;
import Model.General.GMovie;
import Model.Search.Search;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.ProtocolException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Sebastián
 */
public class Connection {
    
    
    
    private final String[] keys = {"9347b1b1", "afc57443","e45f5bcb","56ca61c5"};
    private int keyNumber = 0;
    private String key = keys[keyNumber];
    String errorLimit = "{\"Response\":\"False\",\"Error\":\"Request limit reached!\"}";
    //Mode can be film or search
    
//    public Connection(){
//        keyNumber = 1;
//        key = keys[keyNumber];
//    }
    
    public HttpResponse<String> Connect(String mode, String search) throws ProtocolException, IOException, UnirestException{
         HttpResponse<String> response;
        //Unirest.config().enableCookieManagement(false);
        try{
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy() {
            public boolean isTrusted(X509Certificate[] chain, String authType) {
                return true;
            }
        }).build();
        HttpClient customHttpClient = HttpClients.custom().setSSLContext(sslContext)
                .setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        Unirest.config().httpClient(customHttpClient);
            response = Unirest.get("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/"+mode+"/"+search)
	.header("x-rapidapi-key", "64ca06f071msh260e966a9a934ddp1692a3jsn6291b5080750")
	.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
	.asString();
            return response;
        } catch(Exception e){
            System.out.println("==================REST CLIENT ERROR: "+e.getMessage());
        }
        
        return null;
        
    }
    
    public HttpResponse<String> Connect(String search) throws ProtocolException, IOException, UnirestException{
        //Unirest.config().enableCookieManagement(false);
        HttpResponse<String> response = Unirest.get("http://www.omdbapi.com/?apikey="+key+"&type=movie&i="+search)
	.asString();      
        //Unirest.config().reset();
        return response;
    }
    
    
    public Movie GetMovie(String movie) throws ProtocolException, IOException, UnirestException{
        Gson g = new Gson();
        Movie myMovie = new Movie();
        String Json = this.Connect("film",movie).getBody();
        //myMovie = g.fromJson(this.Connect("film", movie).getBody(), Movie.class);
        myMovie = g.fromJson(Json, Movie.class);
        System.out.println(Json);
        return myMovie;
    }
    
    public GMovie GetGMovie(String movie) throws ProtocolException, IOException, UnirestException, RequestLimitException{
        Gson g = new Gson();
        GMovie myGMovie = new GMovie();
        String Json = "";
        do{
        if(Json.equals(this.errorLimit)){
            throw new RequestLimitException();
        }
            Json = this.Connect(movie).getBody();
        }while(Json.equals(this.errorLimit));
        
        
//        myGMovie = g.fromJson(this.Connect(movie).getBody(), GMovie.class);
        myGMovie = g.fromJson(Json, GMovie.class);
        System.out.println(Json);
//        System.out.println(myGMovie.getType());
        return myGMovie;
    }
    
    public Search GetSearch(String movie)throws ProtocolException, IOException, UnirestException{
        Gson g = new Gson();
        Search mySearch = new Search();
        mySearch = g.fromJson(this.Connect("search", movie).getBody(), Search.class);
        return mySearch;
    }    
    
        public GMovie GetRandomMovie()throws ProtocolException, IOException, UnirestException, RequestLimitException{
        GMovie randomMovie = new GMovie();
        
        while(randomMovie.getType() == null || !randomMovie.getType().equals("movie") || randomMovie.getTitle().equals("#DUPE#") || randomMovie.getPoster().equals("N/A")){
                randomMovie = this.GetGMovie(this.RandomID());
        }
        return randomMovie;
    }
    
    
    public List<GMovie> GetListRandomMovie(int limit)throws ProtocolException, IOException, UnirestException, InterruptedException {
        List<Thread> threads = new ArrayList<Thread>();
        List<GMovie> list = new ArrayList<GMovie>();
        for(int i=0; i < limit;i++){
            Thread thread =  new Thread(() -> {
            try {
                list.add(this.GetRandomMovie());
            } catch (IOException | UnirestException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RequestLimitException ex) {
                    Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
            thread.start();
            threads.add(thread);
        }
            
        for(Thread t : threads){
            t.join();
        }
        return list;
    }

    
    private String RandomID(){
        String myID = "";
        Random rand = new Random();
        int randNumber = rand.nextInt(10000000);
        //System.out.println(randNumber);
        int zerosQuantity = (int) Math.log10(10000000) - (int) Math.ceil(Math.log10(randNumber));
        int zerosGenerator = zerosQuantity==0 ? 0 : 10^zerosQuantity;
        String zeros = String.valueOf(zerosGenerator).substring(1);
        myID = "tt"+ zeros + randNumber;
        //System.out.println(myID);
        return myID;
    }
    
    
    public static void main(String[] args) throws IOException, ProtocolException, UnirestException, InterruptedException{
//        Connection con = new Connection();
//        Unirest.config().enableCookieManagement(false);
//        List<GMovie> movies = new ArrayList<GMovie>();
//        movies = con.GetListRandomMovie(1);
//        for(GMovie movie : movies){
//            System.out.println(movie.getTitle());
//        }
//        Movie movie = con.GetMovie("tt0114709");
//        System.out.println(movie.getTitle());
//        System.out.println(movie.getLength());
//        System.out.println(movie.getPlot());
//        System.out.println(movie.getPoster());
//        System.out.println(movie.getYear());
//        System.out.println(movie.getTrailer().getLink());
//        System.out.println(movie.getRating_votes());
//        
        
        
//        Movie m = new Movie();
//        GMovie gm = new GMovie();
//        Search s = new Search();
//        m = con.GetMovie(con.RandomID());
//        gm = con.GetGMovie(con.RandomID());
//        s = con.GetSearch("Inception");
//        System.out.println(m.getTitle());
//        System.out.println(gm.getTitle());
//        System.out.println(con.Connect(con.RandomID()).getBody());
//        System.out.println(con.Connect(con.RandomID()).getBody());
//System.out.println(con.Connect(con.RandomID()).getBody());
//       
//        System.out.println(con.Connect("search","Inception").getBody());
//        System.out.println(s.getTitles()[0].getTitle());
//        System.out.println(con.RandomID());
//        for(int i = 1; i < 10; i++){
//            con.Connect("tt0"+i+"00000");
//        }
    }
    
}





//Prueba with Movie Especifico
//    public Movie GetRandomMovie()throws ProtocolException, IOException, UnirestException{
//        Movie randomMovie = new Movie();
//        
//        while(randomMovie.getTitle() == null || "".equals(randomMovie.getPoster())){
//                            randomMovie = this.GetMovie(this.RandomID());
//                            System.out.println(randomMovie.getPoster());
//                            System.out.println(randomMovie.getTitle());
//        }
//        
//        return randomMovie;
//    }
    

    
    
//    public GMovie GetRandomMovie()throws ProtocolException, IOException, UnirestException{
//        GMovie randomMovie = new GMovie();
//        Thread thread =  new Thread(() -> {
//            
//            try {
//                while(randomMovie.getType() == null || !randomMovie.getType().equals("movie")){
//                this.GetMovie(this.RandomID());
//            }
//            } catch (IOException ex) {
//                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (UnirestException ex) {
//                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//        thread.start();
//        
//        return randomMovie;
//    }
    
//    public List<GMovie> GetListRandomMovie(int limit)throws ProtocolException, IOException, UnirestException {
//        List<GMovie> list = new ArrayList<GMovie>();
//        GMovie gmovie = new GMovie();
//        for(int i=0; i < limit;i++){
//            gmovie = this.GetRandomMovie();
//            list.add(gmovie);
//        }
//        
//        return list;
//    }

    
//    public Movie GetRandomMovie()throws ProtocolException, IOException, UnirestException{
//        Movie randomMovie = this.GetMovie(this.RandomID());
//        return randomMovie;
//    
//    }