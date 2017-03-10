package com.utils;

import java.util.Scanner;

/**
 * @author asessin
 */
public class Utils {
    private Scanner teclado;

    public static int suma(int num1, int num2){
    int resultado = 0;
    // Sumamos lod dos números
    resultado = num1 + num2;

    //Retornamos el valor
    return resultado;
    }
    
    public static void sumaSinRetorno(int num1, int num2){
        int resultado = num1 + num2;
        System.out.println("El resultado de la suma fue: " +resultado);
    }
    
 

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
    public double leerDouble(String mensaje) {
        teclado = new Scanner(System.in);
        double opt = 0;
        boolean ok = true;
        System.out.println(" ");
        System.out.println(mensaje);
        while (ok) {
            ok = false;
            try {
                opt = teclado.nextDouble();
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

    public char leerCaracter(String mensaje) {
        teclado = new Scanner(System.in);
        char opt;
        String tmp = "";
        boolean ok = true;
        System.out.println(" ");
        System.out.println(mensaje);
        while (ok) {
            ok = false;
            try {
                tmp = teclado.next();
                if (tmp.length()>1){
                    ok=true;
                }
            } catch (Exception e) {
                ok = true;
                teclado.nextLine();
            }
        }
        opt= tmp.charAt(0);
        return opt;
    }

    public boolean leerBoolean(String mensaje) {
        teclado = new Scanner(System.in);
        boolean opt = false;
        String tmp = "";
        boolean ok = true;
        System.out.println(" ");
        System.out.println(mensaje);
        while (ok) {
            ok = false;
            try {
                tmp = teclado.next();
                if (tmp.equalsIgnoreCase("s")){
                    ok=false;
                    opt = true;
                }
            } catch (Exception e) {
                ok = true;
                teclado.nextLine();
            }
        }
        return opt;
    }
    
    public boolean leerInput(String mensaje) {
        teclado = new Scanner(System.in);
        boolean opt = true;
        System.out.println(" ");
        System.out.println(mensaje);
                teclado.nextLine();
        return opt;
    }
    
    public void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}

