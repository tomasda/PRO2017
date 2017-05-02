package com;

/**
 * @author Tomás Delgado Acosta
 */
public class Menu {

    public StringBuffer Welcome() {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#        BIEN VENIDO A LA GESTIÓN DE FICHEROS III (objetos)                         #");
        data.append("\n\t").append("#####################################################################################");
        return data;
    }
    
        public StringBuffer Menu(String msg) {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#    FICHERO :  ").append(msg);
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#");
        data.append("\n\t").append("# 1. Almacenar Disco o Libro");
        data.append("\n\t").append("# 2. Buscar por el título (Disco / Libro)");
        data.append("\n\t").append("# 3. Mostrar los Libros");
        data.append("\n\t").append("# 4. Mostrar los Discos");
        data.append("\n\t").append("# 5. Mostrar todo el contenido del fichero.");
        data.append("\n\t").append("# 6. Nuevo Fichero / Seleccionar Fichero");
        data.append("\n\t").append("# 7. Borrar Fichero / Seleccionar Fichero");
        data.append("\n\t").append("#------------------------------------------------------------------------------------");
        data.append("\n\t").append("# 0. Salir.");
        data.append("\n\t").append("#####################################################################################");
        return data;
    }

}
