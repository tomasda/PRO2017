package com;

import com.tools.files.FilesFunctions;
import com.tools.functions.Functions;
import com.tools.inputs.KeysInputs;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomás Delgado Acosta
 */
public class GestionII {

    String rootFolder;
    File fichero;
    File fichero2;

    public GestionII(String rF) {
        this.rootFolder = rF;

    }

    public void run() {
        try {
            fichero = new File(rootFolder + "18-04-2017");
            fichero2 = new File(rootFolder + "24-04-2017");
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");
            RandomAccessFile file2 = new RandomAccessFile(fichero2, "rw");
            long tamanio = file.length();
            System.out.println("\nEl tamaño del fichero es " + tamanio);
            tamanio = file2.length();
            System.out.println("\nEl tamaño del fichero 2 es " + tamanio);
            //newFile(file);
            file.seek(0);
            printFile(file);

            file2 = copyFile(file, file2);
            file2.seek(0);
            printFile(file2);
            file2.close();
            file.close();

        } catch (FileNotFoundException e) {
            //TODO
            //Logger.getLogger(GestionII.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            //TODO
        }

    }

    private void printFile(RandomAccessFile fileToPrint) {
        long tmp;
        String cadena;
        int entero;
        double doble;
        
        try {
            fileToPrint.seek(0);
            while (true) {
                tmp = fileToPrint.getFilePointer();
                cadena = fileToPrint.readUTF();
                entero = fileToPrint.readInt();
                doble = fileToPrint.readDouble();
                System.out.println("Pos" + tmp + "  " + cadena +" "+ entero + " " + doble);
            }
        } catch (IOException ex) {
            // Logger.getLogger(GestionII.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fin del fichero.");
        }
    }

    private void newFile(RandomAccessFile file) {
        String cadena = "Hala";

        try {
            file.seek(0);
            for (int i = 0; i < 10; i++) {
                cadena = spaces(cadena, 25);
                file.writeUTF(cadena);
                file.writeInt(12);
                file.writeDouble(14.5);
            }
        } catch (IOException e) {
            //TODO
        }
    }

    //Return the number of spaces as a string
    private String spaces(String cadena, int numberOfSpaces) {
        //String builder is efficient at concatenating strings together
        StringBuilder sb = new StringBuilder();
        sb.append(cadena);
        //Loop as many times as specified; each time add a space to the string
        for (int i = 0; i < numberOfSpaces - cadena.length(); i++) {
            sb.append(" ");
        }

        //Return the string
        return sb.toString();
    }

    private RandomAccessFile copyFile(RandomAccessFile file, RandomAccessFile file2) {
        String cadena;
        try {
            while (true) {
                cadena = file.readUTF();
                cadena = spaces(cadena, 25);
                file2.writeUTF(cadena);
                file2.writeInt(file.readInt());
                file2.writeDouble(file.readDouble());
            }

        } catch (IOException e) {
            //TODO
        }
        return file2;
    }
}
