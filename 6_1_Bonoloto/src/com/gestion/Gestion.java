package com.gestion;

import com.objects.NumPrimitiva;
import com.utils.Utils;

/**
 *
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    NumPrimitiva numeros;
    NumPrimitiva numerosJugador;
    Utils util;

    public Gestion() {
        util = new Utils();
        numeros = new NumPrimitiva();
        numerosJugador = new NumPrimitiva();
        CargarValoresAleatorios();
    }

    public void RunAplicacion() {
        introducirValores();
        MostrarCombinacion();
    }

    private void CargarValoresAleatorios() {
        int valor;
        for (int i = 0; i < 6; i++) {
            do {
                valor = (int) Math.floor(Math.random() * (1 - 49) + 49);
            } while (numeros.estaNumero(valor));
            numeros.setNumerosPrimitiva(i, valor);
        }
    }

    private void introducirValores() {
        int valor;
        for (int i = 0; i < 6; i++) {
            do {
                do {
                    valor = util.leerInt("Introduce el " + (i+1) + " valor");
                } while (numerosJugador.estaNumero(valor));
            } while (valor < 1 || valor > 49);
            numerosJugador.setNumerosPrimitiva(i, valor);
        }
    }

    private void MostrarCombinacion() {
        String combinacion = "| ";
        System.out.println("| La combinación ganadora es: ");
        for (int i = 0; i < 6; i++) {
            combinacion = combinacion + numeros.getNumerosPrimitiva(i) + " ";
        }
        System.out.println(combinacion);
        System.out.println("| Y tu jugada fue: ");
        combinacion = "| ";
        for (int i = 0; i < 6; i++) {
            combinacion = combinacion + numerosJugador.getNumerosPrimitiva(i) + " ";
        }
        System.out.println(combinacion);
        combinacion = "| ";
        int cont=0;
        for (int i=0;i<6;i++){
            if (numerosJugador.estaNumero(numeros.getNumerosPrimitiva(i))){
                cont++;
            }
        }
        System.out.println("| Has acertado: "+cont+" numeros.");
    }
}
