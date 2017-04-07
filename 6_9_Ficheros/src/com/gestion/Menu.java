package com.gestion;

import com.utils.Utils;

/**
 * @author Tomás Delgado Acosta
 */
public class Menu {

    Utils util;

    public StringBuffer Menu(String Fichero) {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#    FICHERO :  ").append(Fichero);
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#");
        data.append("\n\t").append("# 1. CARGA DE FICHERO / NUEVO.");
        data.append("\n\t").append("# 2. EDICIÓN DE FICHERO");
        data.append("\n\t").append("# 3. METODOS DE IMPRESIÓN POR PANTALLA");
        data.append("\n\t").append("# 4. ELIMINAR FICHERO");
        data.append("\n\t").append("# 5. COPIAR FICHERO");
        data.append("\n\t").append("# 6. DETALLES DEL FICHERO");
        data.append("\n\t").append("# 7. FICHERO JAVA");
        data.append("\n\t").append("#------------------------------------------------------------------------------------");
        data.append("\n\t").append("# 0. Salir.");
        data.append("\n\t").append("#####################################################################################");
        return data;
    }

    public StringBuffer Welcome() {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#        BIEN VENIDO A LA GESTIÓN DE FICHEROS                                       #");
        data.append("\n\t").append("#####################################################################################");
        return data;
    }

    public StringBuffer visualizarFichero(String file) {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("# FICHERO A MOSTRAR POR PANTALLA: ").append(file);
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("# 1. IMPRIME  TODO EL FICHERO");
        data.append("\n\t").append("# 2. IMPRIME  LAS PRIMERAS N LINEAS");
        data.append("\n\t").append("# 3. IMPRIME  LINEA A LINEA");
        data.append("\n\t").append("# 4. IMPRIME  LINEAS IMPARES");
        data.append("\n\t").append("# 5. IMPRIME  LINEAS PARES");
        data.append("\n\t").append("# 6. IMPRIME  LINEAS INVERTIDAS");
        data.append("\n\t").append("# ");
        data.append("\n\t").append("# 0. VOLVER");
        data.append("\n\t").append("#####################################################################################");
        return data;
    }

    public StringBuffer insetarDatosFichero(String file) {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("# EDICIÓN DEL FICHERO:  ").append(file);
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("# 1. INSERTAR FILAS\tBorra el contenido del fichero.");
        data.append("\n\t").append("# 2. INSERTAR FILAS AL FINAL DEL FICHERO");
        data.append("\n\t").append("# ");
        data.append("\n\t").append("# La edición del fichero termina con la palabra fin.");
        data.append("\n\t").append("# ");
        data.append("\n\t").append("# 0. VOLVER");
        data.append("\n\t").append("#####################################################################################");
        return data;
    }

    public StringBuffer ficheroAEliminar(String file) {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#  FICHERO A ELIMINAR: ").append(file);
        data.append("\n\t").append("#####################################################################################");
        return data;
    }
}
