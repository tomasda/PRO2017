package com.gestion;

import java.util.ArrayList;

/**
 * @author Tomás Delgado Acosta
 */
public class Menu {
    
    public StringBuffer Menu(){
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
    
    public StringBuffer showAlumList(ArrayList<Alumno> alList) {
        StringBuffer data = new StringBuffer();
        for (Alumno a : alList) {
            data.append("\t").append(a.getNombre());
        }
        int arraySize = Alumno.getModulos().length;
        String[] modulos = new String[arraySize];
        modulos = Alumno.getModulos();
        double[] nota = new double[arraySize];
        for (int i = 0; i < modulos.length; i++) {
            data.append("\n").append(modulos[i].toString());
            for (Alumno a: alList){
                nota = a.getNota();
                data.append("\t").append(nota[i]);
            }
        }
        
        return data;
    }
    
}
