package com.gestion;

/**
 * @author Tomás Delgado Acosta
 */
public class Gestion {
    private Alumno[] alumno;
    private Profesor[] profesor;
    
    public void run() {
        StringBuffer imprimir = new StringBuffer();
        alumno = new Alumno[5];
        profesor = new Profesor[5];
        initAlumno();
        initProfesor();
        imprimir = mostrarTodo();
        System.out.println(imprimir);
        imprimir = buscarGrupo("A_grupo3");
        System.out.println(imprimir);
        imprimir = buscarDpto("P_dpto2");
        System.out.println(imprimir);
    }
    
    private void initAlumno(){
        for (int i = 0; i < 5; i++) {
            alumno[i]= new Alumno("A_nombre"+i, "A_apellidos"+i, "A_dni"+i, "A_grupo"+i);
        }
    }
    private void initProfesor(){
        for (int i = 0; i < 5; i++) {
            profesor[i] = new Profesor("P_nombre"+i, "P_apellidos"+i, "P_dni"+i, "P_dpto"+i);
        }
    }
    private StringBuffer mostrarTodo(){
        StringBuffer data = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            data.append(" ").append(alumno[i].nombre).append(" ").append(alumno[i].apellidos).append(" ").append(alumno[i].dni).append(" ").append(alumno[i].grupo);
            data.append("\n");
            data.append(" ").append(profesor[i].nombre).append(" ").append(profesor[i].apellidos).append(" ").append(profesor[i].dni).append(" ").append(profesor[i].dpto);
            data.append("\n");
        }
        return data;
    }

    private StringBuffer buscarDpto(String dpto) {
        StringBuffer data = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            if (profesor[i].getDpto().equals(dpto)){
                data.append(" ").append(profesor[i].nombre).append(" ").append(profesor[i].apellidos).append(" ").append(profesor[i].dni).append(" ").append(profesor[i].dpto);
            }
        }
        return data;
    }

    private StringBuffer buscarGrupo(String a_grupo) {
        StringBuffer data = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            if (alumno[i].getGrupo().equals(a_grupo)){
                data.append(" ").append(alumno[i].nombre).append(" ").append(alumno[i].apellidos).append(" ").append(alumno[i].dni).append(" ").append(alumno[i].grupo);
            }
        }
        return data;
    }
    
}
