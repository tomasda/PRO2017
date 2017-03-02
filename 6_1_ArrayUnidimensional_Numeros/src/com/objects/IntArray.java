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

    public int numMayor() {
        int data = intArray[intArray.length - 1];
        for (int a = 0; a < intArray.length; a++) {
            if (intArray[a] > data) {
                data = intArray[a];
            }
        }
        return data;
    }

    public int numMenor() {
        int data = intArray[intArray.length - 1];
        for (int a = 0; a < intArray.length; a++) {
            if (intArray[a] < data) {
                data = intArray[a];
            }
        }
        return data;
    }

    public int sumaValores() {
        int data = intArray[intArray.length - 1];
        for (int a = 0; a < intArray.length; a++) {
            data = data + intArray[a];
        }
        return data;
    }

    public int valorPosicion(int posicion) {
        return intArray[posicion];
    }

    public void setValorPosicion(int posicion, int valor) {
        intArray[posicion] = valor;
    }

    public int numVecesRepetido(int valor) {
        int data = 0;
        for (int a = 0; a < intArray.length; a++) {
            if (intArray[a] == valor) {
                data = data + 1;
            }
        }
        return data;
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

    public boolean verificarSiExisteHasta(int valor) {
        boolean data = false;
        int i=0;
        int len = this.intArray.length ;
            while (!data && i<len){
                if (intArray[i] == valor){
                    data = true;
                }
                i++;
            }
        return data;
    }
}
