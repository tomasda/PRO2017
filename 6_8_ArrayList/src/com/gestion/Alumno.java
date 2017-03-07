package com.gestion;

/**
 * @author Tomás Delgado Acosta
 */
public class Alumno {
    private static String[] modulos;
    private double[] nota;
    private String nombre;

    public Alumno(double[] nota, String nombre) {
        this.nota = nota;
        this.nombre = nombre;
    }

    public static String[] getModulos() {
        return modulos;
    }

    public static void setModulos(String[] modulos) {
        Alumno.modulos = modulos;
    }

    public double[] getNota() {
        return nota;
    }

    public void setNota(double[] nota) {
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
