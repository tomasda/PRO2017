package com.tools.functions;

import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
public class Functions {

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

    public void limpiarConsola() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public ArrayList<String> ordenaArrayDeString(ArrayList<String> a) {
        ArrayList<String> b = new ArrayList();
        int aSize = a.size();
        int bSize;
        boolean last = true;
        for (int i = 0; i < aSize; i++) {
            last = true;// Cada vez que tome un nuevo valor presupone que puede ir al final de la lista.
            /*
            Sí es el primer registro de la lista
             */
            bSize = b.size();
            if (bSize < 1) {
                b.add(a.get(i));
            } else {
                /*
                Sí el registro está entre la lista existente
                 */
                
                for (int ii = 0; ii < bSize; ii++) {
                    if ((a.get(i).compareTo(b.get(ii))) < 0 && last) {
                        b.add(ii, a.get(i));
                        /*
                    Sí el registro no es el último modifico la variable de control last
                    Además la utilizo para que no vuelva a entrar dentro del if durante la tramitación del for
                         */
                        last = false;
                    }
                }
                /*
                Sí el registro es el último de la lista
                 */
                if (last) {
                    b.add(a.get(i));
                }
            }
        }
        return b;
    }
}
