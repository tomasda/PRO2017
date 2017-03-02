package com.object;

/**
 *
 * @author Tomás Delgado Acosta    
 */
public class Meses {
    String[] meses;

    public Meses() {
        meses = new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    }
    public String getMesName(int num){
        return meses[num-1];
    }
    
}
