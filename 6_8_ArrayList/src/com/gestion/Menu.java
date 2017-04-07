package com.gestion;

import com.gestion.objects.AlumnoBean;
import com.gestion.objects.AsignaturaBean;
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
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("7. Carga de Alumnos.");
        data.append("\n\t").append("---------");
        data.append("\n\t").append("0. Salir.");
        return data;
    }

    public StringBuffer showMessage(ArrayList<AlumnoBean> alList, int type) {
        StringBuffer data = new StringBuffer();
        ArrayList<AsignaturaBean> alAsign;
        AsignaturaBean asignTmp;

        int arraySize;
        boolean aprobadosSuspendidos;
//        String[] modulos;
//        double[] nota;
        if (alList.isEmpty()) {
            data.append("\n\tLa lista de usuarios está vacía.");
        } else {
            switch (type) {
                /*
                2. Listar todos los alumnos, con el nombre de los módulos y notas obtenidas.
                 */
                case 2:
                    for (AlumnoBean a : alList) {
                        data.append("\n\t").append(a.getNombre()).append("\t\t");
                        alAsign = new ArrayList();
                        alAsign = a.getAsignaturas();
                        asignTmp = new AsignaturaBean();
                        for (AsignaturaBean b : alAsign) {
                            data.append(b.getNombre()).append("\t").append(b.getNota()).append("\t");
                        }
                    }
                    break;
                /*
                3. AlumnoBean que aprueban todos los módulos.
                 */
                case 3:
                    /*
                    Si aprobadosSuspendidos es true me devuelve los aprobados
                     */
                    aprobadosSuspendidos = true;
                    data = aprobados(alList, aprobadosSuspendidos);
                    break;
                /*
                4. Nota media de las calificaciones de cada alumno.
                 */
                case 4:
                    int i;
                    double tmp;
                    for (AlumnoBean a : alList) {
                        data.append("\n\t").append(a.getNombre()).append("\t\t");
                        alAsign = new ArrayList();
                        alAsign = a.getAsignaturas();
                        i = 0;
                        tmp = 0.0;
                        for (AsignaturaBean b : alAsign) {
                            i++;
                            tmp = tmp + b.getNota();
                        }
                        data.append("\t").append(tmp / i);
                    }
                    break;
                /*
                5. Alumnos que suspenden todos los módulos."
                 */
                case 5:
                    /*
                    Y si aprobadosSuspendidos es false me devuelve los Suspedidos
                     */
                    aprobadosSuspendidos = false;
                    data = aprobados(alList, aprobadosSuspendidos);
                    break;
            }

        }
        return data;
    }

    public StringBuffer showAlum(ArrayList<AlumnoBean> alList, int busqueda) {
        StringBuffer data = new StringBuffer();
        ArrayList<AsignaturaBean> alAsign;
        if (!alList.isEmpty()) {
            int cont = 1;
            boolean existe = false;
            data.append("\nAlumno");
            for (AlumnoBean a : alList) {
                if (cont == busqueda) {
                    existe = true;
                    data.append("\n\t").append(a.getNombre()).append("\t\t");
                    alAsign = new ArrayList();
                    alAsign = a.getAsignaturas();
                    for (AsignaturaBean b : alAsign) {
                        data.append(b.getNombre()).append("\t").append(b.getNota()).append("\t");
                    }
                }
                cont++;
            }
            if (!existe) {
                data.append("\n\tNo se ha encontrado el Alumno.");
            }
        } else {
            data.append("\n\tLa lista de usuarios está vacía.");
        }
        return data;
    }

    /*
    Aprobados o suspendidos en todas las asignaturas que cursa
     */
    private StringBuffer aprobados(ArrayList<AlumnoBean> alList, boolean tipo) {
        StringBuffer data = new StringBuffer();
        ArrayList<AsignaturaBean> alAsign;
        AsignaturaBean asignTmp;
        if (!alList.isEmpty()) {
            StringBuffer tmpData;
            boolean aprobado;
            if (tipo) {
                data.append("\n\tAPROBADOS\n\n");
            } else {
                data.append("\n\nSUSPENDIDOS\n\n");
            }
            for (AlumnoBean a : alList) {
                if (tipo) {
                    aprobado = true;
                } else {
                    aprobado = false;
                }
                alAsign = new ArrayList();
                alAsign = a.getAsignaturas();
                asignTmp = new AsignaturaBean();
                tmpData = new StringBuffer();
                tmpData.append("\t").append(a.getNombre());

                for (AsignaturaBean b : alAsign) {
                    tmpData.append("\t\t").append(b.getNombre()).append("\t").append(b.getNota());
                    if (tipo) {
                        if (b.getNota() < 5) {
                            aprobado = false;
                        }
                    } else {
                        if (b.getNota() > 5) {
                            aprobado = true;
                        }
                    }

                }
                /*
                SI EL ALUNO TIENE TODAS LAS NOTAS APROBADAS O SUSPENDIDAS AÑADO LA CADENA TEMPORAL
                A LA CADENA QUE DEVUELVO
                 */
                if (tipo) {
                    if (aprobado) {
                        data.append(tmpData).append("\n");
                    }
                } else {
                    if (!aprobado) {
                        data.append(tmpData).append("\n");
                    }
                }
            }
        } else {
            data.append("\n\tLa lista de usuarios está vacía.");
        }
        return data;
    }

    public StringBuffer solicitarAlumno(ArrayList<AlumnoBean> alList) {
        StringBuffer data = new StringBuffer();
        int i = 1;
        data.append("\n\tSelecciones un alumno de la lista.\n");
        for (AlumnoBean a : alList) {
            data.append("\t").append(i).append("\t").append(a.getNombre()).append("\n");
            i++;
        }
        return data;
    }

}
