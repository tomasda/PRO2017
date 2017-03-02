package com.objects;

/**
 * @author Tomás Delgado Acosta
 */
public interface Tierra {
    public static final String Tipo="Arena";
    public String Cavar(int cantidad);
    public void Terremoto();
    public int Desmonte(String lugar);
}
