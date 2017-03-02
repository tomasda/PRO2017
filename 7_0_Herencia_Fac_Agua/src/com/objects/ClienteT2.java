package com.objects;

import com.gestion.Gestion;

/**
 * @author Tomás Delgado Acosta
 * 
 * Las familias numerosas de tipo 2,
 * pagan todo el consumo del agua,
 * pero tienen un descuento del 75% en el Alcantarillado y del 50% en la Depuración,
 * con un máximo de descuento en cada uno de estos dos conceptos de 16€,
 * es decir no se les descuenta mas de 16€ en Alcantarillado,
 * el descuento en Depuración no puede ser mayor a 1€.
 */
public class ClienteT2 extends Clientes{
    public ClienteT2(){
        super();
    }
    @Override
    public double emitirAlcantarillado(double metrosCubicos){
        double valor = (metrosCubicos*Gestion.ALCANTARILLADO);
        double valorDescuento = (metrosCubicos*Gestion.ALCANTARILLADO)*.25;
        if ((valor-valorDescuento)>16){
         valor = valor-16;   
        }else{
            valor = valorDescuento;
        }
        return valor;
    }
    @Override
    public double emitirConsumo(double metrosCubicos){
        double valor = (metrosCubicos*Gestion.CONSUMO);
        return valor;
    }
    @Override
    public double emitirDepuracion(double metrosCubicos){
        double valor = (metrosCubicos*Gestion.DEPURACION);
        double valorDescuento = (metrosCubicos*Gestion.DEPURACION)*.5;
        if ((valor-valorDescuento)>1){
         valor = valor-1;   
        }else{
            valor = valorDescuento;
        }
        return valor;
    }
    
}
