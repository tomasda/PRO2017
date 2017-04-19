package com.tools.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesFile {

    private String rootFolder;
    private File file;
    private Properties propData;

    public String getRootFolder() {
        return rootFolder;
    }

    public PropertiesFile(String rootFolder) {
        this.rootFolder = rootFolder;
    }

    public String loadPropertie(String fichero, String variable) {
        String data = null;
        //String propertyFile = System.getProperty("applications.properties.dir");
        //File file = new File(propertyFile+"/consola/"+fichero+".properties");
        file = new File(rootFolder + fichero + ".properties");
        propData = new Properties();
        try {
            propData.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("No se puede recuperar el fichero de configuración\n" + e);
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error\n" + e);
        }
        data = propData.getProperty(variable);
        return data;
    }

    public void savePropertie(String fichero, String variable, String valorStr) {
        file = new File(rootFolder + fichero + ".properties");
        propData = new Properties();
        OutputStream outputData = null;
        try {
            outputData = new FileOutputStream(rootFolder + fichero + ".properties", true);
            propData.setProperty(variable, valorStr);
            propData.store(outputData, null);
        } catch (FileNotFoundException e) {
            // TODO
        } catch (IOException e) {
            // TODO
        } finally {
            if (null != outputData) {
                try {
                    outputData.close();
                } catch (IOException e) {
                    // TODO
                }
            }
        }
    }

    public void saveListOfProperties(String fichero, String nombre, ArrayList<String> strList) {
        file = new File(rootFolder + fichero + ".properties");
        propData = new Properties();
        OutputStream outputData = null;
        int size = strList.size();
        try {
            outputData = new FileOutputStream(rootFolder + fichero + ".properties", false);
            propData.setProperty(nombre, Integer.toString(size));
            for (int i = 0; i < size; i++) {
                propData.setProperty(Integer.toString(i + 1), strList.get(i));
            }
            propData.store(outputData, null);
        } catch (FileNotFoundException e) {
            // TODO
        } catch (IOException e) {
            // TODO
        } finally {
            if (null != outputData) {
                try {
                    outputData.close();
                } catch (IOException e) {
                    // TODO
                }
            }
        }
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
}
