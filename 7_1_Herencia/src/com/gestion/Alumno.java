package com.gestion;
/**
 * @author Tomás Delgado Acosta
 */
public class Alumno extends Persona {
    protected String grupo;
    
    public Alumno(String nombre, String apellidos, String dni, String grupo) {
        super(nombre, apellidos, dni);
        this.grupo = grupo;
    }
    
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
