/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Especifico;

import java.io.Serializable;

/**
 *
 * @author Sebastián
 */
public class Movie implements Serializable {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating_votes() {
        return rating_votes;
    }

    public void setRating_votes(String rating_votes) {
        this.rating_votes = rating_votes;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public Cast[] getCast() {
        return cast;
    }

    public void setCast(Cast[] cast) {
        this.cast = cast;
    }

    public String[][] getTechnical_specs() {
        return technical_specs;
    }

    public void setTechnical_specs(String[][] technical_specs) {
        this.technical_specs = technical_specs;
    }
    String id;
    String title;
    String year;
    String length;
    String rating;
    String rating_votes;
    String poster;
    String plot;
    Trailer trailer;
    Cast[] cast;
    String[][] technical_specs;
    
    public Movie(){
        
    }
}
