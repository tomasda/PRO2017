package com.objects;

import com.gestion.Gestion;

/**
 * @author Tomás Delgado Acosta
 */
public class Clientes {

    private String DNI;
    private String Nombre;
    private double MetrosCubicosConsumidos;
    private double Consumo;
    private double Saneamiento;
    private double Residuales;
    private double MantenimientoContador;
    

    public Clientes() {
    }
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public double getMetrosCubicosConsumidos() {
        return MetrosCubicosConsumidos;
    }

    public void setMetrosCubicosConsumidos(double MetrosCubicosConsumidos) {
        this.MetrosCubicosConsumidos = MetrosCubicosConsumidos;
        setConsumo(MetrosCubicosConsumidos);
        setResiduales(MetrosCubicosConsumidos);
        setSaneamiento(MetrosCubicosConsumidos);
    }
    
    public double getConsumo() {
        return Consumo;
    }

    public void setConsumo(double metrosCubicos) {
        this.Consumo = emitirConsumo(metrosCubicos);
    }

    public double getSaneamiento() {
        return Saneamiento;
    }

    public void setSaneamiento(double metrosCubicos) {
        this.Saneamiento = emitirAlcantarillado(metrosCubicos);
    }

    public double getResiduales() {
        return Residuales;
    }

    public void setResiduales(double metrosCubicos) {
        this.Residuales = emitirDepuracion(metrosCubicos);
    }

    public double getMantenimientoContador() {
        return MantenimientoContador;
    }

    public void setMantenimientoContador(double MantenimientoContador) {
        this.MantenimientoContador = MantenimientoContador;
    }
    
    public double emitirAlcantarillado(double metrosCubicos){
        double valor = metrosCubicos*Gestion.ALCANTARILLADO;
        return valor;
    }
    
    public double emitirConsumo(double metrosCubicos){
        double valor = metrosCubicos*Gestion.CONSUMO;
        return valor;
    }
    public double emitirDepuracion(double metrosCubicos){
        double valor = metrosCubicos*Gestion.DEPURACION;
        return valor;
    }
    
}
