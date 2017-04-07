package com.object;

/**
 * @author Tomás Delgado Acosta
 */
public class Mamifero extends Individuo {
    private String Padre;
    private String Madre;

    public Mamifero(int ID, String Nombre, String NombreProp, Fecha FNacimiento,String Padre, String Madre) {
        super(ID, Nombre,NombreProp,FNacimiento);
        this.Padre=Padre;
        this.Madre=Madre;
    }

    public String getPadre() {
        return Padre;
    }

    public void setPadre(String Padre) {
        this.Padre = Padre;
    }

    public String getMadre() {
        return Madre;
    }

    public void setMadre(String Madre) {
        this.Madre = Madre;
    }
    
    
}
