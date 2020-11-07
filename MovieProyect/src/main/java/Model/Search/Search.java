/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Search;

import java.io.Serializable;

/**
 *
 * @author Sebastián
 */
public class Search implements Serializable {

    public Search(){
        
    }
    
    public Title[] getTitles() {
        return titles;
    }

    public void setTitles(Title[] titles) {
        this.titles = titles;
    }

    public Name[] getNames() {
        return names;
    }

    public void setNames(Name[] names) {
        this.names = names;
    }

    public Company[] getCompanies() {
        return companies;
    }

    public void setCompanies(Company[] companies) {
        this.companies = companies;
    }
    Title[] titles;
    Name[] names;
    Company[] companies;
}
