package com.gestion.objects;

import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
public class AlumnoBean {
    private ArrayList<AsignaturaBean> Asignaturas;
    private String nombre;

    public AlumnoBean() {
    }

    public AlumnoBean(ArrayList<AsignaturaBean> Asignaturas, String nombre) {
        this.Asignaturas = Asignaturas;
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<AsignaturaBean> getAsignaturas() {
        return Asignaturas;
    }

    public void setAsignaturas(ArrayList<AsignaturaBean> Asignaturas) {
        this.Asignaturas = Asignaturas;
    }    
}
