package com;

import com.object.Individuo;
import com.object.ListaVeterinario;
import com.object.Mamifero;
import com.object.Oviparo;
import com.object.Fecha;
import com.object.Menu;
import java.util.ArrayList;
import java.util.Date;
import com.utils.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    ListaVeterinario lista;
    Individuo anim;
    Utils util;
    Menu menu;

    public Gestion() {
        lista = new ListaVeterinario();
        util = new Utils();
        menu = new Menu();
    }

    public void run() {
        opciones();

//        lista.Alta_Animalito();
//        lista.MostrarAnimalito();
//        Fecha FNaciminento  = new Fecha (10,10,2017);
//        Individuo a = new Mamifero(lista.ID++, "Nombre", "NombreProp", FNaciminento, "Padre", "Madre");
//        lista.Alta_Animal(a);
//         lista.MostrarAnimalito();
    }

    public void opciones() {
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
                    insertAlumnomalito();
                    break;
                case 2:
                    util.limpiarConsola();
                    /*
                        Al pasar el valor -1 muestra todos los Individuos
                     */
                    menu.showMessage(lista.getVeterinario(), -1);
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 3:
                    util.limpiarConsola();
                    menu.mostraCantTipos(lista.cantTipo());
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 4:
                    util.limpiarConsola();
                    Queue lis =  new LinkedList();
                           lis = lista.cantTipo2();
                           while(!lis.isEmpty()){
                               System.out.println(lis.poll()+"\n");
                           }
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 5:
                    util.limpiarConsola();
                    //System.out.print(menu.showMessage(alList, 5));
                    util.leerInput("\n\tPulse una tecla para continuar");
                    break;
                case 6:
                    util.limpiarConsola();
//                    if (!alList.isEmpty()) {
//                        System.out.print(menu.solicitarAlumno(alList));
//                        b = util.leerInt("\n\tIntroduce el número del alumno:");
//                        util.limpiarConsola();
//                        System.out.println(menu.showAlum(alList, b));
//                        util.leerInput("\n\tPulse una tecla para continuar");
//                    } else {
//                        System.out.println("\n\tLa lista de usuarios está vacía.");
//                        util.leerInput("\n\tPulse una tecla para continuar!!");
//                    }
                    break;
                case 7:
//                    loadAlumnos();
                    util.leerInput("\n\tSe han cargado los datos de la BBDD.\n\t Pulse una tecla para continuar!!");
                    break;
            }
        } while (a != 0);
    }

    private void insertAlumnomalito() {
        util.limpiarConsola();
        int opt;
        int dia;
        int mes;
        int anio;
        do {
            opt = util.leerInt("Elije entre Mamifero = 1 o Oviparo = 2");
        } while (opt > 2 || opt < 1);
        String Nombre = util.leerString("Introduce el nombre de la mascota");
        String NombreProp = util.leerString("Introduce el nombre del Propietario");
        do {
            dia = util.leerInt("Introduce el día de nacimiento dd");
        } while (dia > 31 || dia < 0);
        do {
            mes = util.leerInt("Introduce el mes de nacimiento mm");
        } while (mes > 12 || mes < 0);
        do {
            anio = util.leerInt("Introduce el año de nacimiento aaaa");
        } while (anio > 9999 || anio < 2000);
        Fecha FNacimiento = new Fecha(dia, mes, anio);

        switch (opt) {
            case 1:
                String Padre = util.leerString("Introduce el nombre del Padre");
                String Madre = util.leerString("Introduce el nombre de la Madre");
                anim = new Mamifero(lista.ID++, Nombre, NombreProp, FNacimiento, Padre, Madre);
                break;
            case 2:
                int NumHermanos = util.leerInt("Introduce el número de Hermanos");
                anim = new Oviparo(lista.ID++, Nombre, NombreProp, FNacimiento, NumHermanos);
                break;
        }
            lista.Alta_Animal(anim);
    }   
}
