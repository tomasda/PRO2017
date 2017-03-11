package com.gestion;

import com.utils.Utils;
import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    private Alumno alumnoTmp;
    private final ArrayList<Alumno> alList;
    Utils util;
    Menu menu;

    public Gestion() {
        alList = new ArrayList();
        util = new Utils();
        menu = new Menu();
    }

    public void run() {

        int a;
        int b;
        do {
            util.limpiarConsola();
            System.out.println(menu.Menu());
            a = util.leerInt("\t\tSeleccione una opción");
            switch (a) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    util.limpiarConsola();
                    insertAlumnos();
                    break;
                case 2:
                    util.limpiarConsola();
                    System.out.print(menu.showMessage(alList, 2));
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 3:
                    util.limpiarConsola();
                    System.out.print(menu.showMessage(alList, 3));
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 4:
                    util.limpiarConsola();
                    System.out.print(menu.showMessage(alList, 4));
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 5:
                    util.limpiarConsola();
                    System.out.print(menu.showMessage(alList, 5));
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 6:
                    util.limpiarConsola();
                    if (!alList.isEmpty()) {
                        System.out.print(menu.solicitarAlumno(alList));
                        b = util.leerInt("\n\tIntroduce el número del alumno:");
                        util.limpiarConsola();
                        System.out.println(menu.showAlum(alList, b));
                        util.leerInput("\n\tPulse una tecla para continuar");
                    } else {
                        System.out.println("\n\tLa lista de usuarios está vacía.");
                        util.leerInput("\n\tPulse una tecla para continuar!!");
                    }
                    break;
            }
        } while (a != 0);
    }

    public void insertAlumnos() {
        int mod;
        String[] modulos;
        /*
        En este método contemplo tanto la creación cómo la incorporación de nuevos Alumnos
        
            CREACIÓN
         */
        if (alList.isEmpty()) {
            mod = util.leerInt("Insertar la cantidad de Asignaturas que tiene este curso.");
            modulos = new String[mod];
            int i = 0;
            do {
                modulos[i] = util.leerString("Inserte el nombre de la Asignatura " + i).toUpperCase();
                i++;
            } while (mod > i);
            Alumno.setModulos(modulos);
        } else {
            modulos = Alumno.getModulos();
            mod = modulos.length;
        }
        /*
            INCORPORACIÓN DE ALUMNOS
         */
        util.limpiarConsola();
        boolean continuaIncorporando;
        double[] notas;
        double notaTmp;
        String nombre;
        do {
            nombre = (util.leerString("Inserta el nombre del Alumno"));
            int cont = 0;
            notas = new double[mod];
            do {
                do{
                    notaTmp = util.leerDouble("Inserta la nota para la asignatura " + modulos[cont] + " - (0->10)");
                    notas[cont] = notaTmp;
                }while (!validarNota(notaTmp));
                cont++;
            } while (mod > cont);
            alumnoTmp = new Alumno(notas, nombre);
            compareAdd(alumnoTmp);
            util.limpiarConsola();
            System.out.print(menu.showMessage(alList, 2));
            continuaIncorporando = util.leerBoolean("\n\tDesea Continuar S/N");
        } while (continuaIncorporando);
    }

    private void compareAdd(Alumno a) {
        int size = alList.size();
        boolean last = true;
        /*
        Sí es el primer alumno de la lista
         */
        if (size < 1) {
            alList.add(alumnoTmp);
        } else {
            /*
            Sí el alumno está entre la lista existente
             */
            for (int i = 0; i < size; i++) {
                if ((a.getNombre().compareTo(alList.get(i).getNombre())) < 0 && last) {
                    alList.add(i, alumnoTmp);
                    /*
                    Sí el alumno no es el último modifico la variable de control last
                    Además la utilizo para que no vuelva a entrar dentro del if durante la tramitación del for
                     */
                    last = false;
                }
            }
            /*
            Sí el alumno es el último de la lista
             */
            if (last) {
                alList.add(alumnoTmp);
            }
        }
    }

    private boolean validarNota(double notaTmp) {
           if (notaTmp>0 && notaTmp<10){
               return true;
           }else{
               return false;
           }
    }
}
