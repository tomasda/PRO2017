package gestion;

import com.objects.IntArray;
import com.utils.Utils;

/**
 *
 * @author Tomás Delgado Acosta
 */
public class GestionArray {

    IntArray array;
    Utils util;

    public GestionArray() {
        array = new IntArray(10);
        util = new Utils();

    }

    public void RunAplicacion() {
        int opcion;
        do {
            MostrarOpcionesMenu();
            opcion = util.leerInt("Selecciona una opcion");
            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    LlenarDato();
                    break;
                case 2:
                    SinRepetirlos();
                    break;
                case 3:
                    MostrarDatos();
                    break;
                case 4:
                    MostrarDatosOrdenInverso();
                    break;
                case 5:
                    NumeroDeVeces();
                    break;
            }
        } while (opcion!=0);

    }

    public void LlenarDato() {
        //Solicitar datos del 1 al 100
        int valor;
        for (int i = 0; i < 10; i++) {
            do {
                valor = util.leerInt("Introduce el valor para la posición " + i);
                if (valor < 101 && valor > 0) {
                    array.setValorPosicion(i, valor);
                }
            } while (valor > 100 || valor < 0);
        }
    }

    public void MostrarDatos() {
        System.out.println("------------------------------------------------");
        System.out.println("|                 Resutado                      |");
        System.out.println("------------------------------------------------");
        System.out.println("|                 Datos                         |");
        for (int i = 0; i < 10; i++) {
            System.out.println("|  Dato:" + i + " = " + array.getValorPosicion(i));
        }
        System.out.println("------------------------------------------------");
        System.out.println("|                 Mayor                         |");
        System.out.println("|                 " + array.maxNumero());
        System.out.println("------------------------------------------------");
        System.out.println("|                 Menor                         |");
        System.out.println("|                 " + array.minNumero());
        System.out.println("------------------------------------------------");
        System.out.println("|                 Suma                          |");
        System.out.println("|                 " + array.sumaNumero());
        System.out.println("------------------------------------------------");
    }

    public void MostrarDatosOrdenInverso() {
        System.out.println("------------------------------------------------");
        System.out.println("|                 Datos                         |");
        for (int i = 0; i < 10; i++) {
            System.out.println("|  Dato:" + (9 - i) + " = " + array.getValorPosicion(9 - i));
        }
        System.out.println("------------------------------------------------");
    }

    public void SinRepetirlos() {
        //Solicitar datos del 1 al 100 sin que hayan números repetidos.
        //Solicitar datos del 1 al 100
        int valor;
        for (int i = 0; i < 10; i++) {
            do {
                do {
                    valor = util.leerInt("Introduce el valor para la posición " + i);
                } while (array.estaNumero(valor));
                array.setValorPosicion(i, valor);
            } while (valor > 100 || valor < 0);
        }
    }

    public void MostrarOpcionesMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("|                 MENU                          |");
        System.out.println("|                                               |");
        System.out.println("|   1. LLENAR DATOS                             |");
        System.out.println("|   2. LLENAR DATOS SIN REPETIR                 |");
        System.out.println("|   3. MOSTRAR DATOS                            |");
        System.out.println("|   4. MOSTRAR DATOS ORDEN INVERSO              |");
        System.out.println("|                                               |");
        System.out.println("|   5. MOSTRAR NUMERO DE VECES REPETIDO         |");
        System.out.println("|                                               |");
        System.out.println("|   0. SALIR                                    |");
        System.out.println("|                                               |");
        System.out.println("------------------------------------------------");
    }

    private void NumeroDeVeces() {
        int valor = util.leerInt("¿Que valor quieres saber si se repite?");
        System.out.println("------------------------------------------------");
        System.out.println("|   El "+valor+" se repite "+array.vecesNumero(valor));
        System.out.println("------------------------------------------------");
    }

}
