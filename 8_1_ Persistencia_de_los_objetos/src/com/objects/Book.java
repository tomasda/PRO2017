
package com.objects;

import java.io.Serializable;

/**
 *
 * @author Tomás Delgado Acosta
 */
public class Book extends Article implements Serializable{
    private String editorial;

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
