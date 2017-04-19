package com;

/**
 * @author Tomás Delgado Acosta
 */
public class Menu {

    public StringBuffer Welcome() {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#        BIEN VENIDO A LA GESTIÓN DE FICHEROS II (binarios, properties)             #");
        data.append("\n\t").append("#####################################################################################");
        return data;
    }

    public StringBuffer Menu(String msg) {
        StringBuffer data = new StringBuffer();
        if (null == msg) {
            msg = "";
        }
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#    FICHERO EN USO :  ").append(msg);
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#");
        data.append("\n\t").append("# 1. CREAR FICHERO DE TOMA DE TEMPERATURAS");
        data.append("\n\t").append("# 2. SELECCIONAR FICHERO");
        data.append("\n\t").append("# 3. EDICIÓN DE DATOS");
        data.append("\n\t").append("# 4. MOSTRAR EN PANTALLA");
        data.append("\n\t").append("# 5. BORRAR FICHERO");
        data.append("\n\t").append("# 6. ");
        data.append("\n\t").append("# 7. GESTION LOCALIDADES");
        data.append("\n\t").append("#------------------------------------------------------------------------------------");
        data.append("\n\t").append("# 0. Salir.");
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
    
    public StringBuffer MenuLocalidadesList() {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#  LOCALIDADES");
        data.append("\n\t").append("#------------------------------------------------------------------------------------");
        return data;
    }
    public StringBuffer MenuLocalidades() {
        StringBuffer data = new StringBuffer();
        data.append("\t").append("#------------------------------------------------------------------------------------");
        data.append("\n\t").append("#");
        data.append("\n\t").append("# 1. AÑADIR LOCALIDAD");
        data.append("\n\t").append("# 2. QUITAR LOCALIDAD");
        data.append("\n\t").append("#------------------------------------------------------------------------------------");
        data.append("\n\t").append("# 0. Salir.");
        data.append("\n\t").append("#####################################################################################");
        return data;
    }
}
