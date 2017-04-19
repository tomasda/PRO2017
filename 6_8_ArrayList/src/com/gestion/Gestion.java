package com.gestion;

import com.gestion.objects.AlumnoBean;
import com.gestion.objects.AsignaturaBean;
import com.utils.LoadProperties;
import com.utils.Utils;
import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    private AlumnoBean alumnoTmp;
    private final ArrayList<AlumnoBean> alList;
    private AsignaturaBean asignTmp;
    private ArrayList<AsignaturaBean> alAsign;
    Utils util;
    Menu menu;
    LoadProperties loadProp;

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
                case 7:
                    loadAlumnos();
                    util.leerInput("\n\tSe han cargado los datos de la BBDD.\n\t Pulse una tecla para continuar!!");
                    break;
            }
        } while (a != 0);
    }

    private void loadAlumnos() {
        loadProp = new LoadProperties("./files/");
        alumnoTmp = null;
//        cliente.T.5=2
//        cliente.N.5=Jose Juan Estevez
//        cliente.D.5=34534534A
//        cliente.M.5.1=BAE
//        cliente.M.5.1.nota=4.5
//        cliente.M.5.2=PRO
//        cliente.M.5.2.nota=4.5
//        if (alList.isEmpty()) {
            /*
            Obtengo el número de Alumnos contenidos en el fichero de configuración
             */
            int numAsignaturasAlumno = 0;
            for (int alu = 0; alu < Integer.parseInt(loadProp.loadPropertie("alumnosData", "Alumnos")); alu++) {
                alAsign = new ArrayList();
                /*
                Para cada Alumno cargo el listado de asignaturas.
                 */
                numAsignaturasAlumno = Integer.parseInt(loadProp.loadPropertie("alumnosData", "cliente.T." + alu));
                int i = 1;
                while (numAsignaturasAlumno >= i) {
                    String nombre = loadProp.loadPropertie("alumnosData", "cliente.M." + alu + "." + i);
                    String tmp = loadProp.loadPropertie("alumnosData", "cliente.M." + alu + "." + i + ".nota");
                    double nota = Double.parseDouble(tmp);
                    asignTmp = new AsignaturaBean(nombre, nota);
                    alAsign.add(asignTmp);
                    i++;
                }
                alumnoTmp = new AlumnoBean(alAsign, loadProp.loadPropertie("alumnosData", "cliente.N." + alu));
                compareAdd(alumnoTmp);
            }
//        }
    }

    public void insertAlumnos() {
        /*
        En este método contemplo tanto la creación cómo la incorporación de nuevos Alumnos
        
            CREACIÓN
            INCORPORACIÓN DE ALUMNOS
         */
        util.limpiarConsola();
        boolean continuaIncorporando;
//        double[] notas;
        double notaTmp;
        String AsignNombTmp;
        String nombre;
        do {
            alAsign = new ArrayList();
            nombre = (util.leerString("Inserta el nombre del Alumno"));
//            int cont = 0;
            do {
                AsignNombTmp = util.leerString("Inserta el nombre de la Asignatura");
                do {
                    notaTmp = util.leerDouble("Inserta la nota para la asignatura " + AsignNombTmp + " - (0->10)");
                } while (!validarNota(notaTmp));
//                cont++;
                asignTmp = new AsignaturaBean(AsignNombTmp, notaTmp);
                alAsign.add(asignTmp);
            } while (util.leerBoolean("\n\tQuiere añadir otra Asignatura?\n\t S | N"));
            alumnoTmp = new AlumnoBean(alAsign, nombre);
            compareAdd(alumnoTmp);
            util.limpiarConsola();
            System.out.print(menu.showMessage(alList, 2));
            continuaIncorporando = util.leerBoolean("\n\tDesea Continuar añadiendo Alumnos S/N");
        } while (continuaIncorporando);
    }

    private void compareAdd(AlumnoBean a) {
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
        if (notaTmp > 0 && notaTmp < 10) {
            return true;
        } else {
            return false;
        }
    }
}
