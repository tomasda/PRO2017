package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    public LoadProperties() {
    }

    public String loadPropertie(String fichero, String variable) {
        String data = null;
        //String propertyFile = System.getProperty("applications.properties.dir");
        //File file = new File(propertyFile+"/consola/"+fichero+".properties");
        File file = new File("./files/" + fichero + ".properties");
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
}
