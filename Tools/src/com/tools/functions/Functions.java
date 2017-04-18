package com.tools.functions;

import com.tools.inputs.*;
import java.util.Scanner;

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
}

