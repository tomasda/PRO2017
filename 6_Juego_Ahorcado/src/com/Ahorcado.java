package com;

import static com.Gestion.titulo;
import com.utils.Utils;
/**
 *
 * @author Tomás Delgado Acosta
 */
public class Ahorcado {
    final String[] palabra;
    final String[] resultado;
    Utils util;
    int tries;
    int numFallos;
    int numAciertos;
    int size = 0;
    
    public Ahorcado(String word) {
        size = word.length();
        tries = (size/2)+1;
        numFallos = 0;
        numAciertos = 0;
        palabra = new String[size];
        resultado = new String[size];
        for (int a = 0; a<size; a++){
            palabra[a]=word.substring(a, a+1);
            resultado[a]="*";
        }
        util = new Utils();
    }
    
    void juego() {
        boolean intentos = false;
        boolean asteriscos = false;
        String letra;
                
        while (!intentos && !asteriscos){
            util.limpiarConsola();
            mostrarPantallaJuego();
            letra = util.leerCaracter("Introduce una letra");
            if (letra.equals("0")){
                System.exit(0);
            }
            if (estaDentro(letra)){
               //Comprobar si quedan asteriscos 
               if (numAciertos==size){
                   asteriscos=true;
               }
            }else{
                //Comprobar Fallos.
                numFallos++;
                System.out.println(numFallos);
                if (numFallos==tries){
                    intentos=true;
                }
            }
            util.limpiarConsola();
            if (intentos){
                System.out.println(monigote());
                System.out.println("Has fallado\n"
                        + "La palabra que buscabas es: "+convertirAString(palabra));
                
            }else{
                System.out.println("Has ganado\n"
                + "La palabra es: "+convertirAString(palabra));
            }
        }
            
    }

    private boolean estaDentro(String letra) {
        boolean a = false;
        for (int i=0;i<size;i++){
            if (palabra[i].toUpperCase().equals(letra.toUpperCase())){ //Comparación de la letra de entrada con la buscada en mayúsculas.
                resultado[i]=palabra[i]; //Cómo las letras de la palabra puede estar en Mayúscula o minúscula, la obtengo del array y no de la variable.
                a=true;
                numAciertos++;
            }
        }
        return a;
    }

    private void mostrarPantallaJuego() {
        System.out.println(titulo());
        /*
            Palabra y Asteriscos
        */
        System.out.println("------------------------------------------------------");
        System.out.println("         Tienes "+tries+" Intentos");
        System.out.println("         Fallos: "+ numFallos);
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("                     PALABRA\n\n");
        System.out.println("            "+convertirAString(resultado)+"\n\n");
        /*
            Pintar El machango
        */
        System.out.println(monigote());
    }
    
    private String convertirAString(String[] a){
        int size_ = a.length;
        String data = "";
        for (int i=0;i<size_;i++){
            data = data + " " + a[i];
        }
        return data;
    }
    
    private String monigote(){
        // La visualizació se hace sacando una regla de 3 entre el tamaño de la palabra y los fallos.
        long porcentaje = (long)(100.00/tries)*numFallos;
        String data = "                    ╔════════╗\n";
        if (porcentaje>19){
            data = data + "                    |             ║\n";
        }else{
            data = data + "                                  ║\n";
        }
        if (porcentaje>39){
            data = data + "                   ( )            ║\n";
        }else{
            data = data + "                                  ║\n";
        }
        if (porcentaje>59){
            data = data + "                   /|\\            ║\n";
        }else{
            data = data + "                                  ║\n";
        }
        if (porcentaje>79){
            data = data + "                    |             ║\n";
        }else{
            data = data + "                                  ║\n";
        }
        if (porcentaje>99){ 
            data = data + "                   ┘└            ║\n";
        }else{
            data = data + "                                  ║\n";
        }
        data = data + "                                  ║\n"
                +"                  ══════════╝";
        return data;
    }
    
    
}
