package com.gestion;

/**
 *
 * @author Tomás Delgado Acosta.
 */
public class Menu {

    static String mensaje = "";

    public Menu() {
    }

    public void MostrarOpcionesMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("|                 MENU                          |");
        System.out.println("|                                               |");
        System.out.println("|   1. CREAR ARRAY DE ENTERO                    |");
        System.out.println("|   2. RELLENAR EL ARRAY CON 1 VALOR            |");
        System.out.println("|   3. RELLENAR EL ARRAY VALOR POR VALOR        |");
        System.out.println("|   4. RELLENAR EL ARRAY SIN REPETIR VALOR      |");
        System.out.println("|   5. CAMBIO DEL VALOR DE UNA POSICIÓN         |");
        System.out.println("|                                               |");
        System.out.println("|                                               |");
        System.out.println("|   10.MOSTRAR TODOS LOS VALORES DEL ARRAY      |");
        System.out.println("|   11.MOSTRAR EL VALOR DE 1 POSICIÓN           |");
        System.out.println("|   12.MOSTRAR EL NÚM MÁS GRANDE                |");
        System.out.println("|   13.MOSTRAR EL NÚM MÁS PEQUEÑO               |");
        System.out.println("|   14.MOSTRAR LA SUMA DE TODOS LOS VALORES     |");
        System.out.println("|   15.MOSTRAR EL NÚM DE VECES QUE SE REPITE    |");
        System.out.println("|   16.MOSTRAR EL ARRAY INVERTIDO               |");
        System.out.println("|                                               |");
        System.out.println("|   0. SALIR                                    |");
        System.out.println("|                                               |");
        System.out.println("------------------------------------------------");
    }

    public void cabecera() {
        System.out.println("------------------------------------------------");

    }

    void mostrarMensaje() {
        if (!mensaje.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("|                 MENSAJE                       |");
            System.out.println("| " + mensaje);
            mensaje = "";
        }
    }

    public void setMensaje(String mensaje_) {
        mensaje = mensaje_;
    }

    public String getMensaje() {
        return mensaje;
    }

}
