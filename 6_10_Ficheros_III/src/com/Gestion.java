package com;

import com.tools.files.Files;
import com.tools.files.FilesFunctions;
import com.tools.files.PropertiesFile;
import com.tools.functions.Functions;
import com.tools.inputs.KeysInputs;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
class Gestion {

    String rootFolder;
    String fileInUse;
    KeysInputs util;
    Functions funct;
    FilesFunctions ffunct;
    Files files;
    Menu menu;
    PropertiesFile propFile;

    public Gestion(String rF) {
        this.rootFolder = rF;
        this.util = new KeysInputs();
        this.funct = new Functions();
        this.ffunct = new FilesFunctions(rootFolder);
        this.menu = new Menu();
        this.fileInUse = null;
    }

    void run() {
        int a;
        int opt;
        do {
            /*
                Bienvenido y carga de fichero de trabajo.
             */
            funct.limpiarConsola();
            System.out.println(menu.Welcome());
            System.out.println(menu.Menu(fileInUse));
            a = util.leerInt("\t\tSeleccione una opción");
            switch (a) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    funct.limpiarConsola();
                    createBinariyFile();
                    break;
                case 2:
                    funct.limpiarConsola();
                    selectBinaryFile();
                    break;
                case 3:
                    funct.limpiarConsola();
                    editDataBinaryFile();
                    funct.limpiarConsola();
                    showBinaryDataContent(1);
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 4:
                    funct.limpiarConsola();
                    opt = 1;//showBinaryDataContentMode();
                    funct.limpiarConsola();
                    showBinaryDataContent(opt);
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 5:
                    funct.limpiarConsola();
                    eliminar(fileInUse);
                    break;
                case 6:
                    funct.limpiarConsola();

                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 7:
                    funct.limpiarConsola();
                    editLocalidades();
                    break;
            }
        } while (a != 0);
    }

    private void createBinariyFile() {
        this.ffunct = new FilesFunctions(rootFolder);
        this.files = new Files();
        String fileName;
        boolean exist = false;
        do {
            funct.limpiarConsola();
            if (exist) {
                System.out.println("\tEl fichero ya existe.\n");
            }
            fileName = util.leerString("\tIntroduce el nombre del fichero\n\tPulsa 0 para salir.");
            if (!fileName.equals("0")) {
                exist = ffunct.getFileExists(fileName);
            } else {
                exist = false;
            }
        } while (exist);
        if (!fileName.equals("0")) {
            files.createEmptyFile(rootFolder, fileName);
            fileInUse = fileName;
        }
    }

    private void selectBinaryFile() {
        this.ffunct = new FilesFunctions(rootFolder);
        fileInUse = ffunct.getFileName();
    }

    private void editDataBinaryFile() {
        if (null != fileInUse) {
            StringBuffer data = new StringBuffer();
            int optionMostrar = 1;//showBinaryDataContentMode();
            funct.limpiarConsola();
            showBinaryDataContent(optionMostrar);
            boolean option = false;
            /*
                    Seleccionar opcion
                    1 añadir registro
                    2 modificar registro
                    3 eliminar registro
             */
//            data.append("\tSeleccionar opción\n\t1 Añadir un registro.\n\t2 Modificar un registro.\n\t3 Eliminar un registro.");
//            int opt;
//            int lineTo;
//            boolean update;
//            do {
//                opt = util.leerInt(data.toString());
//            } while (opt > 3 || opt < 1);
//            switch (opt) {
//                case 1:
                    showBinaryAddDataToFile();
//                    break;
//                case 2:
//                    update = true;
//                    do {
//                        lineTo = showBinarylines();
//                        opt = util.leerInt("Selecciona la fila a editar.");
//                    } while (opt > lineTo && opt < 1);
//                    showBinaryUpdateFile(opt, update);
//                    break;
//                case 3:
//                    update = false;
//                    do {
//                        lineTo = showBinarylines();
//                        opt = util.leerInt("Selecciona la fila a eliminar.");
//                    } while (opt > lineTo - 1 && opt < 1);
//                    showBinaryUpdateFile(opt, update);
//                    break;
//            }

        } else {
            util.leerInput("\tNo se ha seleccionado un fichero de trabajo.\n\tPor favor cree uno nuevo o seleccione uno existente.");
        }
    }

    private int showBinarylines() {
        int id = 0;
        try {
            FileInputStream fis = new FileInputStream(rootFolder + fileInUse);
            DataInputStream dis = new DataInputStream(fis);
            while (1 < 2) {
                ++id;
                dis.readUTF();
                dis.readInt();
                dis.readDouble();
            }
        } catch (IOException e) {
            //TODO
        } finally {

        }
        return id;
    }

    private int showBinaryDataContentMode() {
        /*
                    Seleccionar opción
                    1 mostrar info fichero - Default
                    2 mostrar registros eliminados
                    3 mostrar todos los registros.
         */
        String data = "\tSeleccionar opción\n\t1 Mostrar info fichero\n\t2 Mostrar registros eliminados\n\t3 Mostrar todos los registros.";
        int optionMostrar;
        do {
            optionMostrar = util.leerInt(data);
        } while (optionMostrar > 3 || optionMostrar < 1);
        return optionMostrar;
    }

    private void showBinaryDataContent(int option) {
        StringBuffer data = new StringBuffer();
        /*2
       
            Seleccionar opción
            1 mostrar info fichero - Default
            2 mostrar registros eliminados
            3 mostrar todos los registros.
         */
        if (null != fileInUse) {
            data = new StringBuffer();
            data.append("\t  Población\t\tHora\tTemperatura\n").append("-------------------------------------------------------\n");
            String pob;
            int hor;
            double tem;
            int id = 0;
            try {
                FileInputStream fis = new FileInputStream(rootFolder + fileInUse);
                DataInputStream dis = new DataInputStream(fis);
                while (1 < 2) {
                    ++id;
                    pob = dis.readUTF();
                    hor = dis.readInt();
                    tem = dis.readDouble();
                    if ((!pob.equals("null") && option == 1) || (pob.equals("null") && option == 2) || option == 3) {
                        data.append("\t").append(id).append(" ").append(pob).append("\t");
                        if (pob.length() < 12) {
                            data.append("\t");
                            if (pob.length() < 6) {
                                data.append("\t");
                            }
                        }
                        data.append(hor).append("\t\t").append(tem).append("\n");
                    }
                }
            } catch (IOException e) {
                //TODO
            } finally {
                data.append("--------------------------------------------------");
                System.out.println(data);
            }
        } else {
            util.leerInput("\tNo se ha seleccionado un fichero de trabajo.\n\tPor favor cree uno nuevo o seleccione uno existente.");
        }
    }

    private void showBinaryAddDataToFile() {
        try {
            StringBuffer data = new StringBuffer();
            int optionMostrar = 1;//showBinaryDataContentMode();
//            funct.limpiarConsola();
//            showBinaryDataContent(optionMostrar);
            boolean option = false;
            String pob;
            int hor;
            double tem;
            File arch = new File(rootFolder + fileInUse);
            FileOutputStream fos = new FileOutputStream(arch, true);
            DataOutputStream dos = new DataOutputStream(fos);
            do {
                funct.limpiarConsola();
                showBinaryDataContent(optionMostrar);
                pob = selectLocalidad();
                hor = setHora();
                tem = setTemperatura();
                dos.writeUTF(pob);
                dos.writeInt(hor);
                dos.writeDouble(tem);
                option = util.leerBoolean("Desea añadir otro registro? S/N");
            } while (option);
            dos.close();
            fos.close();
        } catch (IOException e) {
            //TODO
        }
    }

    private void showBinaryUpdateFile(int opt, boolean update) {
        files = new Files();
        if (update) {//Actualizar Registro

        } else {//Eliminar Registro.
            StringBuffer data = new StringBuffer();
            String pob;
            int hor;
            double tem;
            int id = 0;
            try {
                FileInputStream fis = new FileInputStream(rootFolder + fileInUse);
                DataInputStream dis = new DataInputStream(fis);
                File arch = new File(rootFolder + fileInUse + "_new");
                FileOutputStream fosNew = new FileOutputStream(arch, false);
                DataOutputStream dosNew = new DataOutputStream(fosNew);
                while (id<100000000) {
                    ++id;
                    if (id != opt) {
                        dosNew.writeUTF(dis.readUTF());
                        dosNew.writeInt(dis.readInt());
                        dosNew.writeDouble(dis.readDouble());
                    }
                }
                dosNew.flush();
                dosNew.close();
                fosNew.close();
                
            } catch (IOException e) {
                //TODO
            }

            if (files.deleteFile(rootFolder, fileInUse)) {
                files.renameFile(rootFolder, fileInUse + "_new", fileInUse);
                files.deleteFile(rootFolder, fileInUse + "_new");
            } else {
                System.out.println("El Registro no se ha podido eliminar.");
            }
        }

    }

    private void editLocalidades() {
        LocalidadesBean locBean;
        StringBuffer data;
        ArrayList<String> locList;
        String loc;
        int option;
        do {
            locBean = editLocalidadesLoadData();
            data = locBean.getData();
            locList = locBean.getLocalidadesList();
            loc = locBean.getName();
            funct.limpiarConsola();
            System.out.println(menu.MenuLocalidadesList());
            System.out.println(data);
            System.out.println(menu.MenuLocalidades());
            do {
                option = util.leerInt("\tSeleccione una opción.");
            } while (option < 0 || option > 2);
            switch (option) {
                case 0:
                    break;
                case 1:
                    locList = editLocalidadesAddRemove(locList, true);
                    editLocalidadesSaveDada(locList);
                    break;
                case 2:
                    locList = editLocalidadesAddRemove(locList, false);
                    editLocalidadesSaveDada(locList);
                    break;
            }
        } while (option != 0);
    }

    private LocalidadesBean editLocalidadesLoadData() {
        StringBuffer data = new StringBuffer();
        ArrayList<String> locList = new ArrayList<>();
        String loc = "localidades";
        String tmp;
        propFile = new PropertiesFile("./configFiles/");
        int numLocalidades = Integer.parseInt(propFile.loadPropertie(loc, "localidades"));
        for (int i = 1; i < numLocalidades + 1; i++) {
            tmp = propFile.loadPropertie(loc, String.valueOf(i));
            locList.add(tmp);
            data.append("\t").append(i).append(" ").append(tmp).append("  ");
            if (i % 5 == 0) {
                data.append("\n");
            }
        }
        LocalidadesBean locBean = new LocalidadesBean(loc, data, locList);
        return locBean;
    }

    private void editLocalidadesSaveDada(ArrayList<String> locList) {
        locList = funct.ordenaArrayDeString(locList);
        propFile.saveListOfProperties("localidades", "localidades", locList);
    }

    private ArrayList<String> editLocalidadesAddRemove(ArrayList<String> locList, boolean addRemove) {
        editLocalidadesPrintList(locList);
        int regRemove;
        String regAdd;
        if (addRemove) { //Add
            regAdd = util.leerLineString("\tIntroduce la nueva Localidad");
            locList.add(regAdd);
        } else { //Remove
            regRemove = util.leerInt("\tSeleccione el registro a Eliminar.");
            locList.remove(regRemove - 1);
        }
        return locList;
    }

    private void editLocalidadesPrintList(ArrayList<String> locList) {
        StringBuffer data = new StringBuffer();
        int i = locList.size();
        for (int j = 0; j < i; j++) {
            data.append("\t").append(j + 1).append(":_").append(locList.get(j)).append("\n");
        }
        System.out.println(data);
    }

    private String eliminar(String file) {
        files = new Files();
        funct.limpiarConsola();
        String fileToDelete = ffunct.getFileName();
        if (null != fileToDelete) {
            System.out.println(menu.ficheroAEliminar(fileToDelete));
            if (util.leerBoolean("¿Está seguro de eliminar este fichero S/N?")) {
                files.deleteFile(rootFolder, fileToDelete);
                if (fileToDelete.equals(file)) {
                    funct.limpiarConsola();
                    file = ffunct.getFileName();
                }
            }
        } else {
            util.leerInput("\tNo se ha seleccionado un fichero válido para eliminar.");
        }
        return file;
    }

    private String selectLocalidad() {
        StringBuffer data = new StringBuffer();
        String loc = "localidades";
        propFile = new PropertiesFile("./configFiles/");
        int numLocalidades = Integer.parseInt(propFile.loadPropertie(loc, "localidades"));
        for (int i = 1; i < numLocalidades + 1; i++) {
            data.append("\t").append(i).append(" ").append(propFile.loadPropertie(loc, String.valueOf(i))).append("  ");
            if (i % 3 == 0) {
                data.append("\n");
            }
        }
        System.out.println(data);
        int option;
        do {
            option = util.leerInt("Selecciona una Localidad");
        } while (option < 1 || option > numLocalidades);
        return propFile.loadPropertie(loc, String.valueOf(option));
    }

    private int setHora() {
        int a;
        do {
            a = util.leerInt("Introduce hora.  0 <--> 23");
        } while (a < 0 || a > 23);
        return a;
    }

    private double setTemperatura() {
        double a;
        do {
            a = util.leerDouble("Introduce temperatura. -10 <--> 46");
        } while (a < -11 || a > 47);
        return a;
    }

}
