package com.utils;

import com.utils.LoadProperties;
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
public class RWFile {

    File[] lfl = null;
    File fl = null;
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fw = null;
    BufferedWriter bw = null;

    public RWFile() {

    }

    public Deque fileList(String rootDir) {
        Deque<String> data = new LinkedList();
        lfl = new File(rootDir).listFiles();
        if (lfl.length > 0) {
            for (File file : lfl) {
                data.offer(file.getName());
            }
        }
        return data;
    }

    public Queue loadFile(String rootDir, String file) {
        Queue<String> list = new LinkedList();
        if (null != file) {
            try {
                fl = new File(rootDir + file);
                fr = new FileReader(fl);
                br = new BufferedReader(fr);
                String linea = br.readLine();
                while (null != linea) {
                    list.offer(linea);
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
        return list;
    }

    public void createFile(Queue quFile, String rootDir, String file, boolean addAtEnd) {
        try {
            fw = new FileWriter(rootDir + file, addAtEnd);
            bw = new BufferedWriter(fw);
            if (addAtEnd) {
                bw.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(RWFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            while (!quFile.isEmpty()) {
                try {
                    while (!quFile.isEmpty()) {
                        bw.append(quFile.poll().toString());
                        if (quFile.size() > 0) {
                            bw.newLine();
                        }
                    }
                    bw.flush();
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(RWFile.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

    public boolean deleteFile(String rootDir, String file) {
        boolean confirm = true;
        try {
            fl = new File(rootDir + file);
            fl.delete();
        } catch (Exception e) {
            System.out.println("Error al borrar el fichero, No se ha podido Eliminar \n" + e);
            confirm = false;
        }
        return confirm;
    }
}
