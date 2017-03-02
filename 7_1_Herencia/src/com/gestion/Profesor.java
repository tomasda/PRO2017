package com.gestion;
/**
 * @author Tomás Delgado Acosta
 */
public class Profesor extends Persona{
    protected String dpto;

    public Profesor(String nombre, String apellidos, String dni, String dpto) {
        super(nombre, apellidos, dni);
        this.dpto = dpto;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }
    
     
    
}
