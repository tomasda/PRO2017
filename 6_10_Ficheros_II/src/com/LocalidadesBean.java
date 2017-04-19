package com;

import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
public class LocalidadesBean {
    String name;
    StringBuffer data;
    ArrayList<String> localidadesList;

    public LocalidadesBean(String name, StringBuffer data, ArrayList<String> localidadesList) {
        this.name = name;
        this.data = data;
        this.localidadesList = localidadesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StringBuffer getData() {
        return data;
    }

    public void setData(StringBuffer data) {
        this.data = data;
    }

    public ArrayList<String> getLocalidadesList() {
        return localidadesList;
    }

    public void setLocalidadesList(ArrayList<String> localidadesList) {
        this.localidadesList = localidadesList;
    }
    
    
}
