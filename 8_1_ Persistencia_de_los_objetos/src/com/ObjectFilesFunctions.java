package com;

import com.tools.functions.Functions;
import com.tools.inputs.KeysInputs;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Tomás Delgado Acosta
 */
public class ObjectFilesFunctions {

    ObjectFiles file;
    KeysInputs util;
    Functions funct;
    String rootFolder;

    public ObjectFilesFunctions(String rootFolder) {
        file = new ObjectFiles();
        util = new KeysInputs();
        funct = new Functions();
        this.rootFolder = rootFolder;
    }

////////////////////////////////////////////////////////////////////////////////////////
    public String getFileName() {
        return selectFileName();
    }
//    public String getFileNameNoNew(){
//        return selectFileNameWhitOutNew();
//    }

    public String getNewFile() {
        return newFile();
    }

//    public void setUpperCopyFile(String file, String newFile) {
//        upperAndCopyFile(file, newFile);
//    }

    public boolean getFileExists(String fileName) {
        Deque list = new LinkedList();
        list = file.fileList(rootFolder);
        return fileExists(list, fileName);
    }

////////////////////////////////////////////////////////////////////////////////////////    
    private String selectFileName() {
        Deque list = new LinkedList();
        list = file.fileList(rootFolder);
        int numFiles = list.size();
        String fichero = "";
        if (numFiles < 1) {// Si la lista está vacía, crea uno nuevo por defecto.
            fichero = newFile();
        } else {
            System.out.println(showListFiles(list));
            int numFichero = util.leerInt("\n\tSelecciona un fichero.");
            list = file.fileList(rootFolder);
            if (numFichero == 0) { // Si se selecciona crear un fichero nuevo.
                fichero = newFile();
            } else if (numFichero > 0 && numFichero <= numFiles) { // Si el fichero está en la lista.
                int i = 0;
                while (!list.isEmpty()) {
                    ++i;
                    if (numFichero == i) {
                        fichero = list.poll().toString();
                        if (!list.isEmpty()) {
                            list.removeLast();
                        }
                    } else {
                        list.poll();
                    }
                }
            } else {//En caso de no haber seleccionado la creación de uno nuevo ni uno existente
                fichero = null;
            }
        }
        return fichero;
    }

//    private String selectFileNameWhitOutNew() {
//        Deque list = new LinkedList();
//        list = file.fileList(rootFolder);
//        int numFiles = list.size();
//        String fichero = "";
//        if (numFiles < 1) {// Si la lista está vacía, crea uno nuevo por defecto.
//            fichero = newFile();
//        } else {
//            System.out.println(showListFilesWhithOutNew(list));
//            int numFichero = util.leerInt("\n\tSelecciona un fichero.");
//            list = file.fileList(rootFolder);
//             if (numFichero > 1 && numFichero <= numFiles) { // Si el fichero está en la lista.
//                int i = 0;
//                while (!list.isEmpty()) {
//                    ++i;
//                    if (numFichero == i) {
//                        fichero = list.poll().toString();
//                        if (!list.isEmpty()) {
//                            list.removeLast();
//                        }
//                    } else {
//                        list.poll();
//                    }
//                }
//            } else {//En caso de no haber seleccionado la creación de uno nuevo ni uno existente
//                fichero = null;
//            }
//        }
//        return fichero;
//    }
//
    private boolean fileExists(Deque list, String fichero) {
        boolean a = false;
        list = file.fileList(rootFolder);
        while (!list.isEmpty()) {
            if (fichero.equals(list.poll().toString())) {
                a = true;
            }
        }
        return a;
    }

    private StringBuffer showListFiles(Deque list) {
        StringBuffer data = new StringBuffer();
        data.append("\n\t0- Nuevo").append("\n\t");
        int i = 0;
        while (!list.isEmpty()) {
            data.append(++i).append("- ").append(list.poll()).append("\n\t");
        }
        return data;
    }

//    private StringBuffer showListFilesWhithOutNew(Deque list) {
//        StringBuffer data = new StringBuffer();
//        data.append("\n\t");
//        int i = 0;
//        while (!list.isEmpty()) {
//            data.append(++i).append("- ").append(list.poll()).append("\n\t");
//        }
//        return data;
//    }

    private String newFile() {
        Deque flList = new LinkedList();
        flList = file.fileList(rootFolder);
        String fichero;
        funct.limpiarConsola();
        boolean tmp = false;
        do {
            if (tmp) {
                System.out.println("\n\tEl fichero ya existe.");
            }
            fichero = util.leerString("\n\tIntroduce el nombre del fichero a crear");
            tmp = fileExists(flList, fichero);
        } while (tmp);
        //list.clear();
        //file.saveTextDataFile(list, rootFolder, fichero, true);
        file.createEmptyFile(rootFolder, fichero);
        return fichero;
    }

//    private void upperAndCopyFile(String file, String newFile) {
//        Queue dataList = new LinkedList();
//        Queue newDataList = new LinkedList();
//        dataList = this.file.loadTextDataFile(rootFolder, file);
//        newDataList = this.file.loadTextDataFile(rootFolder, newFile);
//        String tmp;
//        if (dataList.size() > 0) {
//            do {
//                tmp = dataList.poll().toString().toUpperCase();
//                newDataList.offer(tmp);
//            } while (!dataList.isEmpty());
//        }
//        this.file.saveTextDataFile(newDataList, rootFolder, newFile, false);
//    }
}
