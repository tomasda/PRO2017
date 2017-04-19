package com.utils;

import com.objects.Cola;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tomás Delgado Acosta
 */
public class CreateLoadtSaveFILES {

    RWFile file;
    Utils util;
    Cola cl;
    String rootFolder;

    public CreateLoadtSaveFILES(String rootFolder) {
        file = new RWFile();
        util = new Utils();
        cl = new Cola();
        this.rootFolder = rootFolder;
    }

////////////////////////////////////////////////////////////////////////////////////////
    public String getFileName() {
        return selectFileName();
    }

    public Queue getFileLines(String file) {
        return this.file.loadFile(rootFolder, file);
    }

    public String getNewFile() {
        return newFile();
    }

    public void setFileData(Queue data, boolean add, String file) {
        this.file.createFile(data, rootFolder, file, add);
    }

    public void setUpperCopyFile(String file, String newFile) {
        upperAndCopyFile(file, newFile);
    }

    public boolean deleteFile(String fileToDelete) {
        return file.deleteFile(rootFolder, fileToDelete);
    }

////////////////////////////////////////////////////////////////////////////////////////    
    private String selectFileName() {
        Deque list = new LinkedList();
        list = file.fileList(rootFolder);
        int numFiles = list.size();
        String fichero = "";
        if (numFiles < 1) {
            fichero = newFile();
        } else {
            
            System.out.println(showListFiles(list));
            int numFichero = util.leerInt("\n\tSelecciona un fichero.");
            list = file.fileList(rootFolder);
            if (numFichero == 0) {
                /*
            Método que me devuelve el nombre de un fichero nuevo.
                 */
                fichero = newFile();
            } else if (numFichero >= 0 || numFichero <= numFiles) {
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
            }
        }
        return fichero;
    }

    private boolean fileExist(Deque list, String fichero) {
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

    private String newFile() {
        Deque list = new LinkedList();
        list = file.fileList(rootFolder);
        String fichero;
        util.limpiarConsola();
        boolean tmp = false;
        do {
            if (tmp) {
                System.out.println("\n\tEl fichero ya existe.");
            }
            fichero = util.leerString("\n\tIntroduce el nombre del fichero a crear");
            tmp = fileExist(list, fichero);
        } while (tmp);
        list.clear();
        file.createFile(list, rootFolder, fichero, true);
        return fichero;
    }

    private void upperAndCopyFile(String file, String newFile) {
        Queue list = new LinkedList();
        Queue newList = new LinkedList();
        list = this.file.loadFile(rootFolder, file);
        newList = this.file.loadFile(rootFolder, newFile);
        String tmp;
        if (list.size() > 0) {
            do {
                tmp = list.poll().toString().toUpperCase();
                newList.offer(tmp);
            } while (!list.isEmpty());
        }
        this.setFileData(newList, false, newFile);
    }
}
