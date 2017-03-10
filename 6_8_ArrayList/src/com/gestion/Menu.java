package com.gestion;

import com.utils.Utils;
import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
public class Menu {

    Utils util;

    public StringBuffer Menu() {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("1. Insertar nuevo alumno, en el orden que alfabéticamente le corresponda.");
        data.append("\n\t").append("2. Listar todos los alumnos, con el nombre de los módulos y notas obtenidas.");
        data.append("\n\t").append("3. Alumno que aprueban todos los módulos.");
        data.append("\n\t").append("4. Nota media de las calificaciones de cada alumno.");
        data.append("\n\t").append("5. Alumnos que suspenden todos los módulos.");
        data.append("\n\t").append("6. Mostrar las calificaciones de un alumno.");
        data.append("\n\t").append("---------");
        data.append("\n\t").append("0. Salir.");
        return data;
    }

    public StringBuffer showMessage(ArrayList<Alumno> alList, int type) {
        StringBuffer data = new StringBuffer();
        int arraySize;
        int b;
        boolean aprobado;
        String[] modulos;
        double[] nota;
        if (alList.isEmpty()) {
            data.append("\n\tLA LISTA ESTÁ VACÍA");
        } else {
            switch (type) {
                /*
                2. Listar todos los alumnos, con el nombre de los módulos y notas obtenidas.
                 */
                case 2:
                    for (Alumno a : alList) {
                        data.append("\t").append(a.getNombre());
                    }
                    arraySize = Alumno.getModulos().length;
                    modulos = new String[arraySize];
                    modulos = Alumno.getModulos();
                    nota = new double[arraySize];
                    for (int i = 0; i < modulos.length; i++) {
                        data.append("\n").append(modulos[i]);
                        for (Alumno a : alList) {
                            nota = a.getNota();
                            data.append("\t").append(nota[i]);
                        }
                    }
                    break;
                /*
                3. Alumno que aprueban todos los módulos.
                 */
                case 3:
                    aprobado = true;
                    data = aprobados(alList, aprobado);
                    break;
                /*
                4. Nota media de las calificaciones de cada alumno.
                 */
                case 4:
                    for (Alumno a : alList) {
                        data.append("\t").append(a.getNombre());
                    }
                    arraySize = Alumno.getModulos().length;
                    modulos = new String[arraySize];
                    modulos = Alumno.getModulos();
                    nota = new double[arraySize];
                    double tmp;
                    data.append("\nMedia");
                    for (Alumno a : alList) {
                        nota = a.getNota();
                        tmp = 0;
                        for (int i = 0; i < modulos.length; i++) {
                            tmp = tmp + (nota[i]);
                        }
                        data.append("\t").append(tmp / modulos.length);
                    }
                    break;
                /*
                5. Alumnos que suspenden todos los módulos."
                 */
                case 5:
                    aprobado = false;
                    data = aprobados(alList, aprobado);
                    break;
            }

        }
        return data;
    }

    public StringBuffer showAlum(ArrayList<Alumno> alList, int b) {
        StringBuffer data = new StringBuffer();
        if (!alList.isEmpty()) {
            String[] modulos;
            int arraySize;
            double[] nota;
            arraySize = Alumno.getModulos().length;
            modulos = new String[arraySize];
            modulos = Alumno.getModulos();
            nota = new double[arraySize];
            int c = 1;
            boolean existe = false;
            data.append("\nAlumno");
            for (Alumno a : alList) {
                if (c == b) {
                    existe = true;
                    data.append("\n\t").append(a.getNombre());
                    nota = a.getNota();
                    for (int i = 0; i < modulos.length; i++) {
                        data.append("\n\t").append(modulos[i]).append("  ").append(nota[i]);
                    }
                }
                c++;
            }

            if (!existe) {
                data.append("\n\tNo se ha encontrado el Alumno.");
            }
        } else {
            data.append("\n\tLa lista de usuarios está vacía.");
        }
        return data;
    }

    private StringBuffer aprobados(ArrayList<Alumno> alList, boolean aprob) {
        StringBuffer data = new StringBuffer();
        if (!alList.isEmpty()) {
            int arraySize;
            String[] modulos;
            double[] nota;
            StringBuffer tmpA;
            arraySize = Alumno.getModulos().length;
            modulos = new String[arraySize];
            modulos = Alumno.getModulos();
            nota = new double[arraySize];
            boolean aprobado;
            if (aprob) {
                data.append("\nAprobados\n");
            } else {
                data.append("\nSuspendidos\n");
            }
            for (Alumno a : alList) {
                nota = a.getNota();
                if (aprob) {
                    aprobado = true;
                } else {
                    aprobado = false;
                }
                tmpA = new StringBuffer();
                tmpA.append("\t").append(a.getNombre());
                for (int i = 0; i < modulos.length; i++) {
                    tmpA.append(" ").append(modulos[i]).append(" ").append(nota[i]);
                    if (aprob) {
                        if (nota[i] < 5) {
                            aprobado = false;
                        }
                    } else {
                        if (nota[i] > 5) {
                            aprobado = true;
                        }
                    }
                }
                if (aprob) {
                    if (aprobado) {
                        data.append(tmpA).append("\n");
                    }
                } else {
                    if (!aprobado) {
                        data.append(tmpA).append("\n");
                    }
                }
            }
        } else {
            data.append("\n\tLa lista de usuarios está vacía.");
        }
        return data;
    }

    public StringBuffer solicitarAlumno(ArrayList<Alumno> alList) {
        StringBuffer data = new StringBuffer();
        int i = 1;
        data.append("\n\tSelecciones un alumno de la lista.\n");
        for (Alumno a : alList) {
            data.append("\t").append(i).append("\t").append(a.getNombre()).append("\n");
            i++;
        }
        return data;
    }

}
