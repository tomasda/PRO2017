package com.gestion;

import com.tarjetas.Tarjetas;
import com.utils.Utils;

/**
 *
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    Utils util;
    Menu menu;
    Tarjetas tarjeta;

    public Gestion() {
        menu = new Menu();
        util = new Utils();
        tarjeta = new Tarjetas();
    }

    public void RunAplicacion() {
        int opcion;
        int valor;
        do {
            menu.Menu();
            opcion = util.leerInt("Seleccione una opción");
            if (opcion == 1) {
                valor = Juego2();
                opcion = Mostrar(valor);
            }
        } while (opcion != 0);

    }

    private int Juego2() {
        int valor = 0;
        int contTarjeta = 0;
        String opcion;
        do {
            util.limpiarConsola();
            tarjeta.MostrarTarjeta(contTarjeta);
            opcion = pregunta();
            if (opcion.equals("S") || opcion.equals("s")) {
                valor = valor + tarjeta.RecuperarValor(contTarjeta);
            }
            contTarjeta++;
        } while (contTarjeta < 4);
        return valor;
    }
    /* CODIGO POCO OPTIMO   ===  CASTAÑA
    private int Juego() {
        int valor = 0;
        String opcion;
        util.limpiarConsola();
        tarjeta.Tarjeta_01();
        opcion = pregunta();
        if (opcion.equals("S") || opcion.equals("s")) {
            valor = valor + 1;
        }
        util.limpiarConsola();
        tarjeta.Tarjeta_02();
        opcion = pregunta();
        if (opcion.equals("S") || opcion.equals("s")) {
            valor = valor + 2;
        }
        util.limpiarConsola();
        tarjeta.Tarjeta_03();
        opcion = pregunta();
        if (opcion.equals("S") || opcion.equals("s")) {
            valor = valor + 4;
        }
        util.limpiarConsola();
        tarjeta.Tarjeta_04();
        opcion = pregunta();
        if (opcion.equals("S") || opcion.equals("s")) {
            valor = valor + 8;
        }
        return valor;
    }*/

    private String pregunta() {
        String opcion;
        do {
            opcion = util.leerString("Tu número está en esta Tarjeta? S/N");
        } while (!opcion.equals("s") && !opcion.equals("S") && !opcion.equals("n") && !opcion.equals("N"));
        return opcion;
    }

    private int Mostrar(int valor) {
        String opcion;
        int opt = 0;
        util.limpiarConsola();
        System.out.println("Tu número es el " + valor);
        do {
            opcion = util.leerString("Quieres volver a intentarlo? S/N");
        } while (!opcion.equals("s") && !opcion.equals("S") && !opcion.equals("n") && !opcion.equals("N"));
        if (opcion.equals("s") || opcion.equals("S")) {
            opt = 1;
        }
        return opt;
    }

}
