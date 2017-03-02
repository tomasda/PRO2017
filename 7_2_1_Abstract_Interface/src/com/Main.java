package com;

import com.fecha.Fecha;
import com.objects.UsuarioAgua;

/**
 * @author Tomás Delgado Acosta
 */
public class Main {
    public static void main(String[] args) {
        UsuarioAgua pepe = new UsuarioAgua();
        pepe.setNombre("Pepe");
        pepe.setNIC("Tormenta Men");
        System.out.println(pepe.Color);
        Fecha fech = new Fecha();
        fech.setDia(14);fech.setMes(02);fech.setAnio(2017);
        pepe.setFecha(fech);
        System.out.println("\nFecha = "+pepe.getFecha().getDia()+"-"+pepe.getFecha().getMes()+"-"+pepe.getFecha().getAnio());
        fech.setDia(01);fech.setMes(01);fech.setAnio(2017);
        System.out.println("\nFecha = "+pepe.getFecha().getDia()+"-"+pepe.getFecha().getMes()+"-"+pepe.getFecha().getAnio());
        Fecha miFecha = new Fecha();
               miFecha.setDia(pepe.getFecha().getDia());
        miFecha.setDia(22);
        System.out.println("\nFecha = "+pepe.getFecha().getDia()+"-"+pepe.getFecha().getMes()+"-"+pepe.getFecha().getAnio());
        System.out.println("\nFecha = "+miFecha.getDia()+"-"+miFecha.getMes()+"-"+miFecha.getAnio());
    }
}
