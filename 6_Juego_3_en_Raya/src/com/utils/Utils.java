package com.utils;

import java.util.Scanner;

/**
 *
 * @author Tomás Delgado Acosta
 */
public class Utils {

    private Scanner teclado;

    public boolean esPrimo(int number) {
        int var = 2;
        boolean result = true;
        while (var <= number / 2) {
            if (number % var == 0) {
                result = false;
            }
            var++;
        }
        return result;
    }

    public int leerInt(String mensaje) {
        teclado = new Scanner(System.in);
        int opt = 0;
        boolean ok = true;
        System.out.println(" ");
        System.out.println(mensaje);
        while (ok) {
            ok = false;
            try {
                opt = teclado.nextInt();
            } catch (Exception e) {
                ok = true;
                teclado.nextLine();
            }
        }
        return opt;
    }

    public String leerString(String mensaje) {
        teclado = new Scanner(System.in);
        String opt = "";
        boolean ok = true;
        System.out.println(" ");
        System.out.println(mensaje);
        while (ok) {
            ok = false;
            try {
                opt = teclado.next();
            } catch (Exception e) {
                ok = true;
                teclado.nextLine();
            }
        }
        return opt;
    }

    public String leerCaracter(String mensaje) {
        teclado = new Scanner(System.in);
        String opt = "";
        boolean ok = true;
        System.out.println(" ");
        System.out.println(mensaje);
        while (ok) {
            ok = false;
            try {
                opt = teclado.next();
                if (opt.length()>1){
                    ok=true;
                }
            } catch (Exception e) {
                ok = true;
                teclado.nextLine();
            }
        }
        return opt;
    }
    
    public void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}
