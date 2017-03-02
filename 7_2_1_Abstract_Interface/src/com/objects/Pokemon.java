package com.objects;

import com.fecha.Fecha;

/**
 * @author Tomás Delgado Acosta
 */
public  abstract  class Pokemon {
    
    private String Nombre;
    private String Nivel;
    private String Partida;
    private Fecha Fecha;

    public Pokemon(){
        Fecha = new Fecha();
    }
    
    public Fecha getFecha() {
        return Fecha;
    }

    public void setFecha(Fecha Fecha) {
        this.Fecha = Fecha;
    }
    public void setFecha2(Fecha Fecha) {
        this.Fecha.setDia(Fecha.getDia());
        this.Fecha.setMes(Fecha.getMes());
        this.Fecha.setAnio(Fecha.getAnio());
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }

    public String getPartida() {
        return Partida;
    }

    public void setPartida(String Partida) {
        this.Partida = Partida;
    }
    
    public abstract void setNIC(String NIC);
    public abstract String getNIC();
}
