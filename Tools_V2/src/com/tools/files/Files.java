package com.tools.files;

import com.tools.functions.Functions;
import com.tools.inputs.KeysInputs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomás Delgado Acosta
 */
public class Files {

    File[] lfl = null;
    File file;
    KeysInputs util;
    Functions funct;
    String rootFolder;
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fw = null;
    BufferedWriter bw = null;

    public Files(String rootFolder) {
        util = new KeysInputs();
        funct = new Functions();
        this.rootFolder = rootFolder;
    }

////////////////////////////////////////////////////////////////////////////////////////
    public String getFileName() {
        return selectFileName();
    }


    public String getNewFile() {
        return newFile();
    }

    public void setUpperCopyFile(String file, String newFile) {
        upperAndCopyFile(file, newFile);
    }

    public boolean getFileExists(String fileName) {
        Deque list = new LinkedList();
        list = fileList(rootFolder);
        return fileExists(list, fileName);
    }
    
        public boolean deleteFile(String rootFolder, String fileName) {
        boolean confirm = true;
        try {
            file = new File(rootFolder + fileName);
            file.delete();
        } catch (Exception e) {
            System.out.println("Error al borrar el fichero, No se ha podido Eliminar \n" + e);
            confirm = false;
        }
        return confirm;
    }
    
    public boolean renameFile(String rootFolder, String fileStart, String fileEnd){
             boolean confirm = true;
        try {
            file = new File(rootFolder + fileStart);
            File flD = new File(rootFolder + fileEnd);
            file.renameTo(flD);
        } catch (Exception e) {
            System.out.println("Error al borrar el fichero, No se ha podido Renombrar \n" + e);
            confirm = false;
        }
        return confirm;
    }
    public void saveTextDataFile(Queue quData, String rootFolder, String fileName, boolean addAtEnd) {
        try {
            fw = new FileWriter(rootFolder + fileName, addAtEnd);
            bw = new BufferedWriter(fw);
            if (addAtEnd) {
                bw.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            while (!quData.isEmpty()) {
                try {
                    while (!quData.isEmpty()) {
                        bw.append(quData.poll().toString());
                        if (quData.size() > 0) {
                            bw.newLine();
                        }
                    }
                    bw.flush();
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public Queue loadTextDataFile(String rootFolder, String fileName) {
        Queue<String> dataList = new LinkedList();
        if (null != fileName) {
            try {
                file = new File(rootFolder + fileName);
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                String linea = br.readLine();
                while (null != linea) {
                    dataList.offer(linea);
                    linea = br.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Fichero no encontrado \n" + e);
            } catch (FileSystemAlreadyExistsException e) {
                System.out.println("El Fichero ya existe. \n" + e);
            } catch (IOException e) {
                System.out.println("Error al abrir el fichero " + fileName + " \n" + e);
            }
        }
        return dataList;
    }
////////////////////////////////////////////////////////////////////////////////////////    
    private String selectFileName() {
        Deque list = new LinkedList();
        list = fileList(rootFolder);
        int numFiles = list.size();
        String fichero = "";
        if (numFiles < 1) {// Si la lista está vacía, crea uno nuevo por defecto.
            fichero = newFile();
        } else {
            System.out.println(showListFiles(list));
            int numFichero = util.leerInt("\n\tSelecciona un fichero.");
            list = fileList(rootFolder);
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

  

    private boolean fileExists(Deque list, String fichero) {
        boolean a = false;
        list = fileList(rootFolder);
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
    
    private void createEmptyFile(String rootFolder, String fileName) {
        File file = new File(rootFolder + fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            /*
               Creo el fichero sin Objetos (vacío)
             */
            oos.flush();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    private Deque fileList(String rootFolder) {
        Deque<String> dataFileList = new LinkedList();
        lfl = new File(rootFolder).listFiles();
        if (lfl.length > 0) {
            for (File file : lfl) {
                dataFileList.offer(file.getName());
            }
        }
        return dataFileList;
    }

    private String newFile() {
        Deque flList = new LinkedList();
        flList = fileList(rootFolder);
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
        createEmptyFile(rootFolder, fichero);
        return fichero;
    }

    private void upperAndCopyFile(String file, String newFile) {
        Queue dataList = new LinkedList();
        Queue newDataList = new LinkedList();
        dataList = loadTextDataFile(rootFolder, file);
        newDataList = loadTextDataFile(rootFolder, newFile);
        String tmp;
        if (dataList.size() > 0) {
            do {
                tmp = dataList.poll().toString().toUpperCase();
                newDataList.offer(tmp);
            } while (!dataList.isEmpty());
        }
        saveTextDataFile(newDataList, rootFolder, newFile, false);
    }
}
