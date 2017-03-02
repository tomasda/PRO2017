package com.gestion;

import com.objects.IntArray;
import com.utils.Utils;

/**
 *
 * @author Tomás Delgado Acosta.
 */
public class Gestion {

    Menu menu;
    Utils util;
    Mostrar mostrar;
    boolean existeArray;
    IntArray array;

    public void aplicacion() {
        int opcion = 0;
        do {
            util.limpiarConsola();
            menu.MostrarOpcionesMenu();
            menu.mostrarMensaje();
            opcion = util.leerInt("Introduce una opción");
            seleccionaOperacion(opcion);
        } while (opcion != 0);

    }

    public Gestion() {
        menu = new Menu();
        util = new Utils();
        mostrar = new Mostrar();
        existeArray = false;

    }

    private void seleccionaOperacion(int opcion) {
        if (opcion > 0 && opcion < 10) {
            boolean validar = true;
            int len =0;
            int cont = 0;
            // Selecciona las opciones de Ingreso de Datos
            switch (opcion) {
                case 1: // Instancia el array con el número de celdas que va a tener
                    do {
                        util.limpiarConsola();
                        menu.cabecera();
                        int a = util.leerInt("| Introduce el número de celdas que va a tener el Array, entre (1-100)");
                        if (a > 1 && a < 100) {
                            setExisteArray(true);
                            validar = false;
                            crearArray(a);
                        }
                    } while (validar);
                    break;
                case 2: // Rellena el array con un valor en todas sus celdas
                    if (isExisteArray()) {
                        do {
                            util.limpiarConsola();
                            menu.cabecera();
                            int a = util.leerInt("| Introduce Valor que van a tomar todas las celdas del Array, entre (1-1000)");
                            if (a > 0 && a < 1000) {
                                validar = false;
                                array.rellenarTodosCon1Valor(a);
                            }
                        } while (validar);
                    } else {
                        menu.setMensaje("No has inicializado el Array");
                    }
                    break;
                case 3: // Rellena el array con un valor para cada celda
                    if (isExisteArray()) {
                        len = array.getSize();
                        cont = 0;
                        do {
                            util.limpiarConsola();
                            menu.cabecera();
                            int a = util.leerInt("| Introduce Valor de la celda " + cont + " del Array, entre (1-1000)");
                            if (a > 0 && a < 1000) {
                                array.setValorPosicion(cont, a);
                                cont++;
                            }
                        } while (cont < len);
                    } else {
                        menu.setMensaje("No has inicializado el Array");
                    }
                    break;
                case 4: // Rellena el array con un valor diferente para cada celda.
                    if (isExisteArray()) {
                        len = array.getSize();
                        cont = 0;
                        int valor = 0;
                        util.limpiarConsola();
                        menu.cabecera();
                        System.out.println("|  Ten en cuenta que el array ya puede contener datos ");
                        System.out.println("|  Si el valor que introduces existe, no lo podras utilizar ");
                        System.out.println("|  Crea un array nuevo si tienes este problema.  ");
                        do {
                            menu.cabecera();
                            valor = util.leerInt("| Introduce Valor de la celda " + cont + ", entre (1-1000)");
                            if (valor > 0 && valor < 1000) {
                                if (array.verificarSiExisteHasta(valor)) {
                                    // El valor existe
                                    System.out.println("|  El valor que has introducido ya está incluido en el array ");
                                } else {
                                    array.setValorPosicion(cont, valor);
                                    cont++;
                                    //valor = util.leerInt("| Introduce Valor de la celda " + cont + ", entre (1-1000)");
                                }
                            }
                        } while (cont < len);
                    } else {
                        menu.setMensaje("No has inicializado el Array");
                    }
                    break; 
                case 5: // Cambio del valor de una de las celdas.
                    if (isExisteArray()) {
                        menu.cabecera();
                        System.out.println("|  El array tiene un tamaño de " + array.getSize() + " celdas");
                        do {
                            int posicion = util.leerInt("| Que celda quieres cambiar :");
                            if (posicion > -1 && posicion < array.getSize()) {
                                validar = false;
                                int valor = util.leerInt("|   Introduce un valor: ");

                                array.setValorPosicion(posicion, valor);
                            } else {
                                System.out.println("|  Has introducido un valor fuera de rango");
                                System.out.println("|  Introduce un valor entre 0 y " + (array.getSize() - 1));
                            }
                        } while (validar);
                    } else {
                        menu.setMensaje("No has inicializado el Array");
                    }
                    break;
                case 6:
                    break;
            }
        } else if (opcion > 9 && opcion < 20) {
            // Selecciona las opciones a Mostrar
            if (isExisteArray()) {
                menu.setMensaje(mostrar.print(opcion, array));
            }
        }
    }

    private void crearArray(int size) {
        array = new IntArray(size);
    }

    public boolean isExisteArray() {
        return existeArray;
    }

    public void setExisteArray(boolean existeArray) {
        this.existeArray = existeArray;
    }

}
