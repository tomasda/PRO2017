package com.objects;

/**
 *
 * @author Tomas Delgado Acosta
 */
public class IntArray {

    int[] intArray;

    public IntArray(int size) {
        intArray = new int[size];
    }

    public IntArray() {
    }

    public int maxNumero() {
        int data = intArray[intArray.length - 1];
        for (int a = 0; a < intArray.length; a++) {
            if (intArray[a] > data) {
                data = intArray[a];
            }
        }
        return data;
    }

    public int minNumero() {
        int data = intArray[intArray.length - 1];
        for (int a = 0; a < intArray.length; a++) {
            if (intArray[a] < data) {
                data = intArray[a];
            }
        }
        return data;
    }
    
    public int sumaNumero() {
        int data = intArray[intArray.length - 1];
        for (int a = 0; a < intArray.length; a++) {
            data = data + intArray[a];
        }
        return data;
    }
    
    public boolean estaNumero(int valor) {
       boolean data = false;
        for (int i=0;i<10;i++){
            if (intArray[i] == valor){
                    data = true;
                }
            }
        return data;
    }
    
    public int vecesNumero(int valor) {
        int data = 0;
        for (int a = 0; a < intArray.length; a++) {
            if (intArray[a] == valor) {
                data = data + 1;
            }
        }
        return data;
    }
    
    public void setValorPosicion(int posicion, int valor) {
        intArray[posicion] = valor;
    }
    public int getValorPosicion(int posicion) {
        return intArray[posicion];
    }

    
    
    
    

/*
    public int valorPosicion(int posicion) {
        return intArray[posicion];
    }

    public void setValorPosicion(int posicion, int valor) {
        intArray[posicion] = valor;
    }

    

    public void rellenarTodosCon1Valor(int valor) {
        for (int a = 0; a < intArray.length; a++) {
            intArray[a] = valor;
        }
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }
    
    public int getSize(){
        return this.intArray.length;
    }

  */  
}
