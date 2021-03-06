package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadProperties {

    public final String rootFolder;
     File file;

    public String getRootFolder() {
        return rootFolder;
    }

    public LoadProperties(String rootFolder) {
        this.rootFolder = rootFolder;
    }

    public String loadPropertie(String fichero, String variable) {
        String data = null;
        //String propertyFile = System.getProperty("applications.properties.dir");
        //File file = new File(propertyFile+"/consola/"+fichero+".properties");
        file = new File(rootFolder + fichero + ".properties");
        Properties configuration = new Properties();
        try {
            configuration.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("No se puede recuperar el fichero de configuración\n" + e);
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error\n" + e);
        }
        data = configuration.getProperty(variable);
        return data;
    }

    public void savePropertie(String fichero, String variable, int valorInt, String valorStr, double valorDo, char valorChr) {

    }

//    public Queue loadFile(String rootDir, String file) {
//        Queue<String> list = new LinkedList();
//        if (null != file) {
//            try {
//                fl = new File(rootDir + file);
//                fr = new FileReader(fl);
//                br = new BufferedReader(fr);
//                String linea = br.readLine();
//                while (null != linea) {
//                    list.offer(linea);
//                    linea = br.readLine();
//                }
//            } catch (FileNotFoundException e) {
//                System.out.println("Fichero no encontrado \n" + e);
//
//            } catch (FileSystemAlreadyExistsException e) {
//                System.out.println("El Fichero ya existe. \n" + e);
//            } catch (IOException e) {
//                System.out.println("Error al abrir el fichero " + file + " \n" + e);
//            }
//        }
//        return list;
//    }

    public void createPropertieFile(String rootFolder, String fileName) {
        this.file = new File(rootFolder + fileName);

    }

}
