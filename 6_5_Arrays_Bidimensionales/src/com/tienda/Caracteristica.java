package com.tienda;
/**
 * @author Tomás Delgado Acosta
 */
public class Caracteristica {
    private String valor;
    private char nombreColumna;
    private int numEntero;
    private long numLong;

    public Caracteristica() {
    }
    public char getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(char nombreColumna) {
        this.nombreColumna = nombreColumna;
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getNumEntero() {
        return numEntero;
    }

    public void setNumEntero(int numEntero) {
        this.numEntero = numEntero;
    }

    public long getNumLong() {
        return numLong;
    }

    public void setNumLong(long numLong) {
        this.numLong = numLong;
    }
}
