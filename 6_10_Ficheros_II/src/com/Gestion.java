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
                    showBinaryDataContent();
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 4:
                    funct.limpiarConsola();
                    showBinaryDataContent();
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
            try {
                boolean option = false;
                String pob;
                int hor;
                double tem;
                File arch = new File(rootFolder + fileInUse);
                FileOutputStream fos = new FileOutputStream(arch, true);
                DataOutputStream dos = new DataOutputStream(fos);
                do {
                    funct.limpiarConsola();
                    showBinaryDataContent();
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

        } else {
            util.leerInput("\tNo se ha seleccionado un fichero de trabajo.\n\tPor favor cree uno nuevo o seleccione uno existente.");
        }
    }

    private void showBinaryDataContent() {
        if (null != fileInUse) {
            StringBuffer data = new StringBuffer();
            data.append("\tPoblación\tHora\tTemperatura\n").append("--------------------------------------------------\n");
            String pob;
            int hor;
            double tem;
            try {
                FileInputStream fis = new FileInputStream(rootFolder + fileInUse);
                DataInputStream dis = new DataInputStream(fis);
                while (1 < 2) {
                    pob = dis.readUTF();
                    hor = dis.readInt();
                    tem = dis.readDouble();
                    data.append("\t").append(pob).append("\t");
                    if (pob.length() < 8) {
                        data.append("\t");
                    }
                    data.append(hor).append("\t\t").append(tem).append("\n");
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
    
    private void editLocalidadesSaveDada(ArrayList<String> locList){
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
