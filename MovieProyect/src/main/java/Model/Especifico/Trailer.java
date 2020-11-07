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
public class Trailer implements Serializable {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        String NewLink = "";
        if(link.length()>1){
            String linkID = link.substring(link.lastIndexOf("v"));
            NewLink = "http://www.imdb.com/video/imdb/" + linkID + "/imdb/embed?autoplay=false&width=480";
            System.out.println(NewLink);
            return NewLink;
        }else{
            link = null;
        }
        System.out.println(link);
        return link;
    }

    public void setLink(String link) {
        
        
        this.link = link;
    }
    String id;
    String link;
    
    public Trailer(){
        
    }
    //tt1879043
}
