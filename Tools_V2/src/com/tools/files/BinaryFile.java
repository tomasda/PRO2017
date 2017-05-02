package com.tools.files;

import com.tools.functions.Functions;
import com.tools.inputs.KeysInputs;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomás Delgado Acosta
 */
public class BinaryFile {

    private String rootFolder;
    private File[] listOfFiles = null;
    private KeysInputs util;
    private Functions funct;
    private File file;
    private ArrayList<Object> arrayObjects;

    public BinaryFile(String rootFolder) {
        this.rootFolder = rootFolder;
        util = new KeysInputs();
        funct = new Functions();
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public String getFileName() {
        return selectFileName();
    }

    public String getNewFile() {
        return newFile();
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

    public boolean renameFile(String rootFolder, String fileStart, String fileEnd) {
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
    
    public ArrayList<Object> getArrayObjects(){
        ArrayList<Object> array = new ArrayList<>();
        array = readObjects(rootFolder);
        return array;
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

    private Deque fileList(String rootFolder) {
        Deque<String> dataFileList = new LinkedList();
        listOfFiles = new File(rootFolder).listFiles();
        if (listOfFiles.length > 0) {
            for (File file : listOfFiles) {
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
        createEmptyFile(rootFolder, fichero);
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

    public void createEmptyFile(String rootFolder, String fileName) {
        file = new File(rootFolder + fileName);
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

    private StringBuffer showListFiles(Deque list) {
        StringBuffer data = new StringBuffer();
        data.append("\n\t0- Nuevo").append("\n\t");
        int i = 0;
        while (!list.isEmpty()) {
            data.append(++i).append("- ").append(list.poll()).append("\n\t");
        }
        return data;
    }

    private void addObject(String fileName, Object newObject) {
        file = new File(rootFolder + fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            OwnObjectOutputStream oos = new OwnObjectOutputStream(fos);
            oos.writeObject(newObject);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            // TODO
        } catch (NullPointerException e) {
            System.out.println("Error,  No se ha podido guardar datos en el fichero.");
        }
    }

    private ArrayList<Object> readObjects(String fileName) {
        file = new File(rootFolder + fileName);
        arrayObjects = new ArrayList<>();
        Object object;
        StringBuffer data = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            while (null != object) {
//                if (object instanceof Book) {//1 = Libros
//                    if (type == 0 || type == 1) {
//                        object = (Book) object;
//                        data.append("\n\tLibro: ").append(((Book) object).getTitle()).append("\t").append(((Book) object).getOwner()).append("\t").append(((Book) object).getEditorial());
//                    }
//                } else if (object instanceof Disk) {//2 = Discos
//                    if (type == 0 || type == 2) {
//                        object = (Disk) object;
//                        data.append("\n\tDisco: ").append(((Disk) object).getTitle()).append("\t").append(((Disk) object).getOwner()).append("\t").append(((Disk) object).getLength());
//                    }
//                } else {
//                    // No se encuentra el tipo de objeto.
//                    //data.append("No se encuentra el tipo del objeto leido.");
//                }
                object = ois.readObject();
                arrayObjects.add(object);
            }
            ois.close();
        } catch (EOFException e) {
            //Fin del Fichero.
        } catch (IOException e) {
            //TODO
            data.append("IO Exception").append(e);
        } catch (ClassNotFoundException e) {
            //TODO
            data.append("Error ").append(e);
        }
        return arrayObjects;
    }

}
