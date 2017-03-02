package com.objects;
/**
 *
 * @author Tomás Delgado Acosta
 */
public class NumPrimitiva {
    int[] numerosPrimitiva;

    public int getNumerosPrimitiva(int posicion) {
        return numerosPrimitiva[posicion];
    }

    public void setNumerosPrimitiva(int posicion,int valor) {
        this.numerosPrimitiva[posicion] = valor;
    }

    public NumPrimitiva() {
        this.numerosPrimitiva = new int[6];
    }
    
    public boolean estaNumero(int valor) {
       boolean data = false;
        for (int i=0;i<6;i++){
            if (numerosPrimitiva[i] == valor){
                    data = true;
                }
            }
        return data;
    } 
}
