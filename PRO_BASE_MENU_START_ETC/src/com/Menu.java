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
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#    FICHERO :  ").append(msg);
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("#");
        data.append("\n\t").append("# 1. ");
        data.append("\n\t").append("# 2. ");
        data.append("\n\t").append("# 3. ");
        data.append("\n\t").append("# 4. ");
        data.append("\n\t").append("# 5. ");
        data.append("\n\t").append("# 6. ");
        data.append("\n\t").append("# 7. ");
        data.append("\n\t").append("#------------------------------------------------------------------------------------");
        data.append("\n\t").append("# 0. Salir.");
        data.append("\n\t").append("#####################################################################################");
        return data;
    }

}
