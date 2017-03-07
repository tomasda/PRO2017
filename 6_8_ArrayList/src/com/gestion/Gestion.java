package com.gestion;

import com.utils.Utils;
import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    private Alumno al;
    private ArrayList<Alumno> alList = new ArrayList();
    Utils util = new Utils();
    Menu menu = new Menu();

    public void run() {

        int mod = util.leerInt("Insertar el número de Módulos de cada Alumno");
        String[] modulos = new String[mod];
        int i = 0;
        do {
            modulos[i] = util.leerString("Inserte el nombre del Módulo " + i);
            i++;
        } while (mod > i);
        Alumno.setModulos(modulos);
        util.limpiarConsola();
        boolean otro;
        double[] notas;
        String nombre;
        do {
            nombre = (util.leerString("Inserta el nombre"));
            int ii = 0;
            notas = new double[mod];
            do {
                notas[ii] = util.leerDouble("Inserta la nota para " + modulos[ii].toString());
                ii++;
            } while (mod > ii);
            al = new Alumno(notas, nombre);
            compareAdd(al);
            util.limpiarConsola();
            System.out.print(menu.showAlumList(alList));
            otro = util.leerBoolean("Desea Continuar S/N");
        } while (otro);
        util.limpiarConsola();
        System.out.print(menu.showAlumList(alList));
    }

    private void compareAdd(Alumno a) {
        int size = alList.size();
        boolean last = true;
        /*
        Sí es el primer alumno de la lista
         */
        if (size < 1) {
            alList.add(al);
        } else {
            /*
            Sí el alumno está entre la lista existente
             */
            for (int i = 0; i < size; i++) {
                if ((a.getNombre().compareTo(alList.get(i).getNombre())) < 0 && last) {
                    alList.add(i, al);
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
                alList.add(al);
            }
        }
    }
}
