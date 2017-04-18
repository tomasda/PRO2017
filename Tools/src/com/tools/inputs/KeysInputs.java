package com.tools.inputs;

import java.util.Scanner;

/**
 * @author Tomás Delgado Acosta
 */
public class KeysInputs {
    private Scanner teclado;
 
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
    
    public String leerLineString(String mensaje){
        teclado = new Scanner(System.in);
        String opt = new String();
        boolean ok = true;
        System.out.println(" ");
        System.out.println(mensaje);
        while (ok) {
            ok = false;
            try {
                opt = teclado.nextLine();
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
        boolean resutlt=true;
        String tmp = "";
        boolean controlBucle = true;
        System.out.println(" ");
        System.out.println(mensaje);
        while (controlBucle) {
            controlBucle = false;
            try {
                tmp = teclado.next();
                if (tmp.equalsIgnoreCase("s")){
                    controlBucle=false;
                    resutlt = true;
                }
                if (tmp.equalsIgnoreCase("n")){
                    controlBucle=false;
                    resutlt = false;
                }
            } catch (Exception e) {
                //ok = true;
                teclado.nextLine();
            }
        }
        return resutlt;
    }
    
    public boolean leerInput(String mensaje) {
        teclado = new Scanner(System.in);
        boolean opt = true;
        System.out.println(" ");
        System.out.println(mensaje);
                teclado.nextLine();
        return opt;
    }

}

