package com.gestion;

import com.tools.CreateLoadtSave;
import com.objects.Pila;
import com.objects.RWFile;
import com.tools.ShowDataFile;
import com.utils.Utils;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    Utils util;
    Menu menu;
    BufferedReader br;
    RWFile files;
    Pila pl;
    public final static String ROOTDIR = "files/";
    CreateLoadtSave cls;
    ShowDataFile show;

    public Gestion() {
        util = new Utils();
        menu = new Menu();
        cls = new CreateLoadtSave();
        show = new ShowDataFile();
    }

    public void run() {
        int a;
        int b;
        String file = null;
        /*
        Bienvenido y carga de fichero de trabajo.
         */
        util.limpiarConsola();
        System.out.println(menu.Welcome());
        file = cls.getFileName();
        do {
            util.limpiarConsola();
            System.out.println(menu.Menu(file));
            a = util.leerInt("\t\tSeleccione una opción");
            switch (a) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    util.limpiarConsola();
                    file = cls.getFileName();
                    break;
                case 2:
                    util.limpiarConsola();
                    edicion(file);
                    break;
                case 3:
                    util.limpiarConsola();
                    impresionPantalla(file);
                    break;
                case 4:
                    util.limpiarConsola();
                    file = eliminar(file);
                    //util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 5:
                    util.limpiarConsola();
                    copiar(file);
                    util.leerInput("\n\tSe ha realizado la copia\n\tPulse una tecla para continuar");
                    break;
                case 6:
                    util.limpiarConsola();
                    show.linesWordsChars(file);
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 7:
                    util.limpiarConsola();
                    show.showPharsedJavaFile(file);
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
            }
        } while (a != 0);
    }

    private void edicion(String file) {
        this.util.limpiarConsola();
        System.out.println(this.menu.insetarDatosFichero(file));
        int opt;
        do {
            opt = util.leerInt("Seleccione una opción");
        } while (opt > 2 || opt < 0);
        switch (opt) {
            case 0:
                break;
            case 1:
                //true  =  añadir al final del fichero.
                cls.setFileData(insertFiles(), false, file);
                break;
            case 2:
                //true  =  añadir al final del fichero.
                util.limpiarConsola();
                show.showNLines(file, -9999, false,true);
                cls.setFileData(insertFiles(), true, file);
                break;
        }

    }

    private void impresionPantalla(String file) {
        this.util.limpiarConsola();
        System.out.println(this.menu.visualizarFichero(file));
        int opt;
        int iLines;
        do {
            opt = util.leerInt("Seleccione una opción");
        } while (opt > 7 || opt < 0);
        switch (opt) {
            case 0:
                break;
            case 1:
                /*
                Muestra el fichero por pantalla
                 */
                util.limpiarConsola();
                show.showNLines(file, -9999, false,true);
                util.leerInput("\n\tFin del fichero.\n\tPulse una tecla para continuar");
                break;
            case 2:
                /*
                Muestra N filas del fichero por pantalla
                 */
                iLines = util.leerInt("\n\tIntroducde el número de líneas a mostrar.");
                util.limpiarConsola();
                show.showNLines(file, iLines, false,true);
                util.leerInput("\n\tPulse una tecla para continuar");
                break;
            case 3:
                /*
                Muestra LAS ÚLTIMAS N filas del fichero por pantalla
                 */
                iLines = util.leerInt("\n\tIntroducde el número de líneas a mostrar.");
                util.limpiarConsola();
                show.showNLines(file, iLines, false,false);
                util.leerInput("\n\tPulse una tecla para continuar");
                break;
            case 4:
                /*
                Muestra el fichero linea a linea por pantalla
                 */
                util.limpiarConsola();
                show.showNLines(file, -9999, true,true);
                util.leerInput("\n\tFin del fichero.\n\tPulse una tecla para continuar");
                break;
            case 5:
                /*
                Muestra lineas impares del fichero por pantalla
                 */
                util.limpiarConsola();
                show.showEvenOddLines(file, false);
                util.leerInput("\n\tFin del fichero.\n\tPulse una tecla para continuar");
                break;
            case 6:
                /*
                
                Muestra lineas pares del fichero por pantalla
                 */
                util.limpiarConsola();
                show.showEvenOddLines(file, true);
                util.leerInput("\n\tFin del fichero.\n\tPulse una tecla para continuar");
                break;
            case 7:
                /*
                Muestra lineas invertidas del fichero por pantalla
                 */
                util.limpiarConsola();
                show.showInvertedFile(file);
                util.leerInput("\n\tFin del fichero.\n\tPulse una tecla para continuar");
                break;
        }
    }

    private Queue insertFiles() {
        Queue<String> data = new LinkedList();
        boolean addNewLine = true;
        String linea;
        do {
            linea = util.leerLineString("");
            if (!linea.equals("fin")) {
                data.offer(linea);
            } else {
                addNewLine = false;
            }
        } while (addNewLine);
        return data;
    }

    private void copiar(String file) {
        //\n\tmétodo que permita copiar cualquier tipo de fichero de texto, convirtiendo todas las letras a mayúsculas en el nuevo fichero..
        util.limpiarConsola();
        String newFile = cls.getNewFile();
        cls.setUpperCopyFile(file, newFile);
    }

    private String eliminar(String file) {
        util.limpiarConsola();
        String fileToDelete = cls.getFileName();
        /*
        Si el fichero se elimina
         */
        System.out.println(menu.ficheroAEliminar(file));

        if (util.leerBoolean("¿Está seguro de eliminar este fichero S/N?")) {
            cls.deleteFile(fileToDelete);
            if (fileToDelete.equals(file)) {
                util.limpiarConsola();
                file = cls.getFileName();
            }
        }
        return file;
    }

}
