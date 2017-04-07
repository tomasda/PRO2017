package com.gestion.objects;

/**
 * @author Tomás Delgado Acosta
 */
public class AsignaturaBean {
    /* 
        Nombre de la asignatura
    */
    private String Nombre;
    /*  
        Notas de cada una de las evaluaciones.
        Navidades, Semana Santa, Junio y Septiembre
    */
//    private double[] notas;
    private double nota;



//    public AsignaturaBean(String Nombre, double[] notas) {
//        this.Nombre = Nombre;
//        this.notas = notas;
//    }

    public AsignaturaBean(String Nombre, double nota) {
        this.Nombre = Nombre;
        this.nota = nota;
    }

    public AsignaturaBean() {
    }

    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

//    public double[] getNotas() {
//        return notas;
//    }
//
//    public void setNotas(double[] notas) {
//        this.notas = notas;
//    }
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }    
}
