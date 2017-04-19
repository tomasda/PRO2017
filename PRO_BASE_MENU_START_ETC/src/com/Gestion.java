package com;


import com.tools.files.PropertiesFile;
import com.tools.functions.Functions;
import com.tools.inputs.KeysInputs;
import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
class Gestion {
    String rootFolder;
    KeysInputs util;
    Functions funct;
    Menu menu;
 

    public Gestion(String rF) {
        this.util = new KeysInputs();
        this.funct = new Functions();
        this.menu = new Menu();
        this.rootFolder = rF;
    }

    void run() {
        int a;
        int b;
        String msg = null;
        /*
        Bienvenido y carga de fichero de trabajo.
         */
        funct.limpiarConsola();
        System.out.println(menu.Welcome());

        do {
            funct.limpiarConsola();
            System.out.println(menu.Menu(msg));
            a = util.leerInt("\t\tSeleccione una opción");
            switch (a) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    funct.limpiarConsola();

                    break;
                case 2:
                    funct.limpiarConsola();

                    break;
                case 3:
                    funct.limpiarConsola();

                    break;
                case 4:
                    funct.limpiarConsola();

                    break;
                case 5:
                    funct.limpiarConsola();

                    break;
                case 6:
                    funct.limpiarConsola();

                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 7:
                    funct.limpiarConsola();

                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
            }
        } while (a != 0);


        
    }
    
//    private ArrayList Localidades(){
//        String loc = "localidades";
//        ArrayList<String> localidades = new ArrayList<>();
//        lP = new LoadProperties("./configFiles/");
//        int numLocalidades = Integer.parseInt(lP.loadPropertie(loc, "localidades"));
//        for (int i = 1; i < numLocalidades+1; i++) {
//          localidades.add(lP.loadPropertie(loc, String.valueOf(i)));  
//        }
//        return localidades;
//    }
}
