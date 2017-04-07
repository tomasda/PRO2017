package com.object;

/**
 * @author Tomás Delgado Acosta
 */
public abstract class Individuo {
    private int ID;
    private String Nombre;
    private String NombreProp;
    private Fecha FNacimiento;

    protected Individuo(int ID, String Nombre, String NombreProp, Fecha FNacimiento) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.NombreProp = NombreProp;
        this.FNacimiento = FNacimiento;
    }

    protected int getID() {
        return ID;
    }

    protected void setID(int ID) {
        this.ID = ID;
    }

    protected String getNombre() {
        return Nombre;
    }

    protected void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    protected String getNombreProp() {
        return NombreProp;
    }

    protected void setNombreProp(String NombreProp) {
        this.NombreProp = NombreProp;
    }

    protected Fecha getFNaciminento() {
        return FNacimiento;
    }

    protected void setFNaciminento(Fecha FNaciminento) {
        this.FNacimiento = FNaciminento;
    }
}
