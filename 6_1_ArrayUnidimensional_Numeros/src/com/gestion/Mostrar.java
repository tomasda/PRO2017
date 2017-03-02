package com.gestion;

import com.objects.IntArray;
import com.utils.Utils;

/**
 *
 * @author Tomás Delgado Acosta
 */
public class Mostrar {

    public Mostrar() {
    }

    public String print(int Opcion, IntArray a) {
        String mensaje = "";
        Utils util = new Utils();
        int cont = 0;
        int posicion = 0;
        int len = a.getSize();
        switch (Opcion) {
            case 10: // Mostrar Todos los Valores.
                mensaje = mostrarTodos(a);
                break;
            case 11: // Mostrar Valor y su Posición.
                posicion = util.leerInt("| De que posición quieres el valor");
                if (posicion < len && posicion > -1) {
                    mensaje = "| El valor es: " + a.valorPosicion(posicion);
                } else {
                    mensaje = "Valor fuera de rango";
                }
                break;

            case 12: // Mostrar Número más Grande.
                mensaje = "Mayor = " + a.numMayor();
                break;
            case 13: // Mostrar Número más Pequeño.
                mensaje = "Menor = " + a.numMenor();
                break;
            case 14: // Mostrar la Suma de todos los valores del Array.
                mensaje = "Suma de todos los valores = " + a.sumaValores();
                break;
            case 15: // Mostrar el Número de veces que se repite un Número y sus posiciones.
                int valor = util.leerInt("|  ¿Que número quiere ver si se repite?");
                cont = 0;
                String posiciones = "|  ";
                for (int z = 0; z < len; z++) {
                    if (valor == a.valorPosicion(z)) {
                        cont++;
                        posiciones = posiciones + " P" + z;
                    }
                }
                mensaje = "Número de veces que se repite el " + valor + " = " + a.numVecesRepetido(valor);
                if (cont > 0) {
                    mensaje = mensaje + "\n  y en las posiciones" + posiciones;
                }
                break;
            case 16:
                int invert=len-1;
                for (int z=0; z<len; z++){
                    mensaje = mensaje + " P"+invert+"= "+a.valorPosicion(invert);
                    invert--;
                }
                break;
        }
        return mensaje;

    }

    private String mostrarTodos(IntArray a) {
        int[] datos = a.getIntArray();
        String mensaje = "";
        for (int i = 0; i < datos.length; i++) {
            mensaje = mensaje + " P" + i + "= " + datos[i];
        }
        return mensaje;
    }
}
