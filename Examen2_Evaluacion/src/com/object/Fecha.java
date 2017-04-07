package com.object;

/**
 * @author Tomás Delgado Acosta
 */
public class Fecha {
    
    int dia;
    int mes;
    int anio;
    
    public Fecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public Fecha(Fecha nueva){
        this.dia = nueva.dia;
        this.mes = nueva.mes;
        this.anio =  nueva.anio;
    }
    
    public int aaaammdd(){
        int salida = anio;
        salida = salida*100 + mes;
        salida = salida*100 + dia;
        return salida;
    }
    
    public String dd_mm_aa(){
        String salida = intToString(dia)+"/";
        salida = salida + intToString(mes)+"/";
        salida = salida + Integer.toString(anio%100);
        return salida;
    }
    
    public String intToString(int num){
        String salida;
            if(num < 10){
                salida = "0"+Integer.toString(num);
            }else{
                salida = Integer.toString(num);
            }
            return salida;
    }
}
