package com.object;

/**
 * @author Tomás Delgado Acosta
 */
public class Oviparo extends Individuo {
    private int NumHermanos;

    public Oviparo(int ID, String Nombre, String NombreProp, Fecha FNacimiento,int NumHermanos) {
        super(ID, Nombre, NombreProp, FNacimiento);
        this.NumHermanos = NumHermanos;
    }
    
    

    public int getNumHermanos() {
        return NumHermanos;
    }

    public void setNumHermanos(int NumHermanos) {
        this.NumHermanos = NumHermanos;
    }
    
}
