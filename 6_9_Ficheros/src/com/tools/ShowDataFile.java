package com.tools;

import com.utils.Utils;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Tomás Delgado Acosta
 */
public class ShowDataFile {

    CreateLoadtSave cls = null;
    Utils util = null;

    //Realizar un método que muestre por pantalla las N primeras líneas de un fichero de texto, las líneas deben aparecer numeradas.
    public void showNLines(String fichero, int numLineasAMostrar, boolean lineByLine, boolean firstLastLines) {
        util = new Utils();
        cls = new CreateLoadtSave();
        Queue linesList = new LinkedList();
        linesList = cls.getFileLines(fichero);
        int numlines = linesList.size();
        int i = 1;
        int lineaInicio = 0;
        int lineaFin = 0;
        if (numLineasAMostrar == -9999) {
            lineaInicio = 1;
            lineaFin = numlines;
        } else {
            if (firstLastLines) {
                lineaInicio = 1;
                lineaFin = numLineasAMostrar;
            } else {
                lineaInicio = numlines-(numLineasAMostrar-1);
                lineaFin = numlines;
            }
        }
        /*
        SI SE ESTABLECE EL NÚMERO DE LINEAS A MOSTRAR -9999 
        ES QUE VAMOS A MOSTRAR TODAS LAS LINEAS DEL FICHERO.
         */

        do {
            if (lineaInicio <= i && lineaFin >= i) {
                System.out.println("\n\t" + i + " " + linesList.poll());
            } else {
                linesList.poll();
            }
            ++i;
        } while (!linesList.isEmpty());

    }

    public void linesWordsChars(String fichero) {
        StringBuilder data = new StringBuilder();
        cls = new CreateLoadtSave();
        Queue linesList = new LinkedList();
        linesList = cls.getFileLines(fichero);
        int numlines = linesList.size();
        int numWords = 0;
        int numChars = 0;
        if (!linesList.isEmpty()) {
            String tmp;
            int i;
            char iChar;
            char controlLastChar;
            do {
                tmp = linesList.poll().toString();
                if (!tmp.isEmpty()) {
                    i = tmp.length();
                    numChars = numChars + i;
                    controlLastChar = tmp.charAt(0);
                    for (int j = 0; j < i; j++) {
                        iChar = tmp.charAt(j);
                        /*
            Sí el caracter encontrado es ,.:; -
                         */
                        if (iChar == (char) 44 || iChar == (char) 45 || iChar == (char) 46 || iChar == (char) 58 || iChar == (char) 59 || iChar == (char) 32 || iChar == (char) 95) {
                            --numChars;
                            /*
                Sí no es el pirmer caracter y es distinto a ,.:; -
                             */
                            if (controlLastChar != (char) 44 && controlLastChar != (char) 45 && controlLastChar != (char) 46 && controlLastChar != (char) 58 && controlLastChar != (char) 59 && controlLastChar != (char) 32 && controlLastChar != (char) 95) {
                                ++numWords;
                            }
                        }
                        controlLastChar = iChar;
                    }
                }
            } while (!linesList.isEmpty());

        }
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("# DETALLE DEL FICHERO  ").append(fichero);
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\tNúmero de Líneas = ").append(numlines).append("\n\tNúmero de Palabras = ").append(numWords).append("\n\tNúmero de Caracteres = ").append(numChars);
        System.out.println(data);
    }

    public void showEvenOddLines(String fichero, boolean even) {
        cls = new CreateLoadtSave();
        Queue linesList = new LinkedList();
        linesList = cls.getFileLines(fichero);
        int numlines = linesList.size();
        int i = 1;
        /*
        Si son pares  = true | Even=true
        Si no son impares Odd
         */
        while (i <= numlines) {
            if ((even && (i % 2 == 0)) || (!even && (i % 2 != 0))) {
                System.out.println("\n\t" + i + " " + linesList.poll());
            } else {
                linesList.poll();
            }
            ++i;
        }
    }

    public void showInvertedFile(String fichero) {
        cls = new CreateLoadtSave();
        Queue linesList = new LinkedList();
        Stack<String> linesInverted = new Stack();
        linesList = cls.getFileLines(fichero);
        int numlines = linesList.size();
        int i = 1;
        while (i <= numlines) {
            linesInverted.push(linesList.poll().toString());
            ++i;
        }
        numlines = linesInverted.size();
        i = 1;
        while (i <= numlines) {
            System.out.println("\n\t" + i + " " + linesInverted.pop());
            ++i;
        }
    }

    public void showPharsedJavaFile(String fichero) {
        /*
        método que muestre por pantalla el contenido de un fichero fuente de lenguaje JAVA,
        realizando una traducción a pseudocódigo sencilla, según la siguiente tabla de traducción:
        Lenguaje Java     Texto a mostrar por pantalla
            {                          	INICIO
            }                      		FIN
            while                		MIENTRAS
            for                    		PARA
            System.out.println             	MOSTRAR
            next			        LEE
         */
        Queue list = new LinkedList();
        cls = new CreateLoadtSave();
        list = cls.getFileLines(fichero);
        StringBuffer data = new StringBuffer();
        String tmp;
        char iChar;
        int iIntermedio;
        String tmpSalida;
        if (!list.isEmpty()) {
            do {
                iIntermedio = 0;
                tmpSalida = "";
                tmp = list.poll().toString();
                for (int i = 0; i < tmp.length(); i++) {
                    iChar = tmp.charAt(i);
                    if (iChar == (char) 123) { // {
                        tmpSalida = tmpSalida + tmp.substring(iIntermedio, i - 1) + " INICIO ";
                        iIntermedio = i + 1;
                    }
                    if (iChar == (char) 125) { // }
                        if (i == 0) {
                            tmpSalida = tmpSalida + tmp.substring(iIntermedio, i) + " FIN ";
                        } else {
                            tmpSalida = tmpSalida + tmp.substring(iIntermedio, i - 1) + " FIN ";
                        }
                        iIntermedio = i + 1;
                    }
                }
                // Hablo con Gonzalo y me indica que use replace
                tmpSalida = tmpSalida.replace("while", "MIENTRAS");
                tmpSalida = tmpSalida.replace("for", "PARA");
                tmpSalida = tmpSalida.replace("System.out.println", "MOSTRAR");
                tmpSalida = tmpSalida.replace("next", "LEE");
                tmpSalida = tmpSalida.replace("if", "SI");
                tmpSalida = tmpSalida.replace("do", "HAZ");
                data.append(tmpSalida).append("\n");
            } while (!list.isEmpty());
            System.out.println(data);
        }
    }
}
