package com;

import com.utils.Utils;
import hexadecimal.HexadecimalConverter;

/**
 *
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    Utils util;
    HexadecimalConverter hex;

    public Gestion() {
        util = new Utils();
        hex = new HexadecimalConverter();
    }

    public void RunAplicacion() {
        int opcion;
        int valorI;
        String valorS;
        Menu();
        do {
            do {
                opcion = util.leerInt("Seleccione la opción a Realizar");

            } while (opcion < 0 || opcion > 2);
            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    valorS=hex.DecToHex(util.leerInt("Introduce el valor Decimal"));
                    System.out.println("| El valor Decimal es: "+valorS);
                    break;
                case 2:
                    valorI=hex.HexToDec(util.leerString("Introduce el valor Hexadecimal"));
                    System.out.println("| El valor Decimal es: "+valorI);
                    break;
            }
        } while (opcion != 0);
    }

    private void Menu() {
        System.out.println("-------------------------------");
        System.out.println("|  1 Decimal a Hexadecimal ");
        System.out.println("|  2 Hexadecimal a Decimal");
        System.out.println("|  0 Salir");
        System.out.println("-------------------------------");
    }

}
