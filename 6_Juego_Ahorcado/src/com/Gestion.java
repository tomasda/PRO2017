package com;

/**
 *
 * @author Tomás Delgado Acosta
 */

import com.utils.Utils;

public class Gestion {
    private static String palabra;
    private static String option;
    public static void main(String[] args) {
        do{
        Palabra word = new Palabra();
        palabra = word.getAleatoryWord();
        Ahorcado ahorcado = new Ahorcado(palabra);
        ahorcado.juego();
        option  = volverAJugar();
        }while(option.toUpperCase().equals("S"));
    }

    private static String volverAJugar() {
        Utils utils = new Utils();
        System.out.println(titulo());
        String option = utils.leerCaracter("¿Quieres volver a Jugar S/N?");
        return option;
    }
    
    public static String titulo(){
        String data = "   ╔════════════════════════╗\n"
                +"   ║        JUEGO DEL AHORCADO            ║\n"
                +"   ╚════════════════════════╝";
        return data;
    }
    
}
