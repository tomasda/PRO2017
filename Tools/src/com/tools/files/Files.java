package com.tools.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomás Delgado Acosta
 *
 * Clase encargada de realizar operaciones con Ficheros.
 */
public class Files {

    File[] lfl = null;
    File fl = null;
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fw = null;
    BufferedWriter bw = null;

    public Files() {
        

    }

    public Deque fileList(String rootFolder) {
        Deque<String> dataFileList = new LinkedList();
        lfl = new File(rootFolder).listFiles();
        if (lfl.length > 0) {
            for (File file : lfl) {
                dataFileList.offer(file.getName());
            }
        }
        return dataFileList;
    }

    public Queue loadTextDataFile(String rootFolder, String file) {
        Queue<String> dataList = new LinkedList();
        if (null != file) {
            try {
                fl = new File(rootFolder + file);
                fr = new FileReader(fl);
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
                System.out.println("Error al abrir el fichero " + file + " \n" + e);
            }
        }
        return dataList;
    }

    public void createEmptyFile(String rootFolder, String fileName) {
       try {
            fw = new FileWriter(rootFolder + fileName);
            bw = new BufferedWriter(fw);
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void saveTextDataFile(Queue quData, String rootFolder, String file, boolean addAtEnd) {
        try {
            fw = new FileWriter(rootFolder + file, addAtEnd);
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

    public boolean deleteFile(String rootFolder, String file) {
        boolean confirm = true;
        try {
            fl = new File(rootFolder + file);
            fl.delete();
        } catch (Exception e) {
            System.out.println("Error al borrar el fichero, No se ha podido Eliminar \n" + e);
            confirm = false;
        }
        return confirm;
    }
}
