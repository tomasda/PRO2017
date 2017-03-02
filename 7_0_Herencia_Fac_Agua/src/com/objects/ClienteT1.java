package com.objects;

import com.gestion.Gestion;

/**
 * @author Tomás Delgado Acosta
 * Las familias numerosas de tipo 1,
 * que pagan todo el consumo pero tienen un descuento del 25% en el saneamiento y la depuración.
 */
public class ClienteT1 extends Clientes{

    public ClienteT1() {
        super();
    }
    
    @Override
    public double emitirAlcantarillado(double metrosCubicos){
        double valor = (metrosCubicos*Gestion.ALCANTARILLADO)*.75;
        return valor;
    }
    @Override
    public double emitirConsumo(double metrosCubicos){
        double valor = metrosCubicos*Gestion.CONSUMO;
        return valor;
    }
    @Override
    public double emitirDepuracion(double metrosCubicos){
        double valor = (metrosCubicos*Gestion.DEPURACION)*.75;
        return valor;
    }
}
