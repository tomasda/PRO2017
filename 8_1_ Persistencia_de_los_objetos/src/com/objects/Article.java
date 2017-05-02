package com.objects;

import java.io.Serializable;

/**
 * @author Tomás Delgado Acosta
 */
public class Article implements Serializable{
    private String title;
    private String owner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
}
