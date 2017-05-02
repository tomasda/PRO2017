package com;

import com.objects.Book;
import com.objects.Disk;
import com.tools.functions.Functions;
import com.tools.inputs.KeysInputs;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Tomás Delgado Acosta
 */
class Gestion implements Serializable {

    String rootFolder;
    KeysInputs keyUtils;
    Functions functions;
    ObjectFilesFunctions filesTools;
    ObjectFiles filesObjectTools;
    Menu menu;
    //File file;

    public Gestion(String rF) {
        this.keyUtils = new KeysInputs();
        this.functions = new Functions();
        this.menu = new Menu();
        this.rootFolder = rF;
        this.filesTools = new ObjectFilesFunctions(rootFolder);
        this.filesObjectTools = new ObjectFiles();

    }

    void run() {
        int a;
        String fileName = null;
        /*
        Bienvenido y carga de fichero de trabajo.
         */
        functions.limpiarConsola();
        System.out.println(menu.Welcome());
        if (null == fileName) {
            do {
                functions.limpiarConsola();
                fileName = filesTools.getFileName();
            } while (null == fileName);
        }
        do {
            functions.limpiarConsola();
            System.out.println(menu.Menu(fileName));
            a = keyUtils.leerInt("\t\tSeleccione una opción");
            switch (a) {
                case 0:
                    System.exit(0);
                    break;
                case 1:// Almacenar Disco o Libro
                    functions.limpiarConsola();
                    almacenar(fileName);
                    break;
                case 2://Buscar por el título (Disco / Libro)
                    functions.limpiarConsola();
                    buscar(fileName);
                    keyUtils.leerInput("Pulsa una tecla para continuar.");
                    break;
                case 3://Mostrar Libros
                    functions.limpiarConsola();
                    readObjects(fileName, 1);// 1 = Libros
                    keyUtils.leerInput("Pulsa una tecla para continuar.");
                    break;
                case 4://Mostrar Discos
                    functions.limpiarConsola();
                    readObjects(fileName, 2);// 2 = Discos
                    keyUtils.leerInput("Pulsa una tecla para continuar.");
                    break;
                case 5://Mostrar todo el contenido del fichero
                    functions.limpiarConsola();
                    readObjects(fileName, 0);// 0 = Todos los tipos
                    keyUtils.leerInput("Pulsa una tecla para continuar.");
                    break;
                case 6:
                    functions.limpiarConsola();
                    fileName = filesTools.getFileName();
                    //keyUtils.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 7:// Nuevo Fichero
                    functions.limpiarConsola();
                    if (keyUtils.leerBoolean("\t¿Está seguro de eliminar el fichero?")) {
                        filesObjectTools.deleteFile(rootFolder, fileName);
                        fileName = filesTools.getFileName();
                    }
                    //createFile(fileName);
                    //keyUtils.leerInput("\n\tPulse una tecla para continuar");
                    break;

            }
        } while (a != 0);
    }

    private void almacenar(String fileName) {
        int option;
        do {
            option = keyUtils.leerInt("\tSelecciona una opción\n\t1. Libro\n\t2. Disco");
        } while (option > 2 || option < 1);
        addObject(fileName, option);
    }

    private void buscar(String fileName) {
        String search =  keyUtils.leerString("\tIntroduce un creterio de búsqueda.");
        readSearchObjects(fileName, search);
    }

//    private void createFile(String fileName) {
//        File file = new File(rootFolder + fileName);
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            /*
//               Creo el fichero sin Objetos (vacío)
//             */
//            oos.flush();
//            fos.close();
//        } catch (IOException e) {
//            //TODO
//        }
//    }

    /*
        METODO QUE AÑADE LOS OBJETOS AL FICHERO SEGÚN SU TIPO.
     */
    private void addObject(String fileName, int type) {
        File file = new File(rootFolder + fileName);
        Object object = new Object();
        switch (type) {
            case 1:// Book
                object = (Book) new Book();
                ((Book) object).setTitle(keyUtils.leerLineString("Introduce Título del Libro."));
                ((Book) object).setOwner(keyUtils.leerLineString("Introduce el Autor del Libro."));
                ((Book) object).setEditorial(keyUtils.leerString("Introduce la editorial."));
                break;
            case 2:// Disk
                object = (Disk) new Disk();
                ((Disk) object).setTitle(keyUtils.leerLineString("Introduce el Título del Disco."));
                ((Disk) object).setOwner(keyUtils.leerLineString("Introduce el Cantante del Disco."));
                ((Disk) object).setLength(keyUtils.leerInt("Introduce la Duración del Disco."));
                break;
        }
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            OwnObjectOutputStream oos = new OwnObjectOutputStream(fos);
            oos.writeObject(object);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            // TODO
        } catch (NullPointerException e) {
            System.out.println("Error,  No se ha podido guardar datos en el fichero.");
        }
    }

    /*
        METODO QUE MUESTRA EL LISTADO DE OBJETOS - PERMITE SELECCIONAR POR TIPO.
     */
    private void readObjects(String fileName, int type) {
        File file = new File(rootFolder + fileName);
        Object object;
        StringBuffer data = new StringBuffer();
        data.append("\tImpresión por pantalla del contenido del fichero.\n");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            while (null != object) {
                if (object instanceof Book) {//1 = Libros
                    if (type == 0 || type == 1) {
                        object = (Book) object;
                        data.append("\n\tLibro: ").append(((Book) object).getTitle()).append("\t").append(((Book) object).getOwner()).append("\t").append(((Book) object).getEditorial());
                    }
                } else if (object instanceof Disk) {//2 = Discos
                    if (type == 0 || type == 2) {
                        object = (Disk) object;
                        data.append("\n\tDisco: ").append(((Disk) object).getTitle()).append("\t").append(((Disk) object).getOwner()).append("\t").append(((Disk) object).getLength());
                    }
                } else {
                    // No se encuentra el tipo de objeto.
                    //data.append("No se encuentra el tipo del objeto leido.");
                }
                object = ois.readObject();
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
        System.out.println(data);
    }

    private void readSearchObjects(String fileName, String query) {
        File file = new File(rootFolder + fileName);
        int numResult = 0;
        Object object;
        StringBuffer data = new StringBuffer();
        data.append("\tImpresión por pantalla del contenido del fichero.\t");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            while (null != object) {
                if (object instanceof Book) {//1 = Libros
                    object = (Book) object;
                    if (((Book) object).getTitle().contains(query)) {
                        ++numResult;
                        data.append("\n\tLibro: ").append(((Book) object).getTitle()).append("\t").append(((Book) object).getOwner()).append("\t").append(((Book) object).getEditorial());
                    }
                } else if (object instanceof Disk) {//2 = Discos
                    object = (Disk) object;
                    if (((Disk)object).getTitle().contains(query)) {
                        ++numResult;
                        data.append("\n\tDisco: ").append(((Disk) object).getTitle()).append("\t").append(((Disk) object).getOwner()).append("\t").append(((Disk) object).getLength());
                    }
                } else {
                    // No se encuentra el tipo de objeto.
                    //data.append("No se encuentra el tipo del objeto leido.");
                }
                object = ois.readObject();
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
        System.out.println("\tSe han encontrado "+ numResult+ " resultados.");
        System.out.println(data);
    }

}
