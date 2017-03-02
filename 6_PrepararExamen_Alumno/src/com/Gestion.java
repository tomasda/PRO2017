package com;

import com.objetos.Alumnos;

public class Gestion {
    private Alumnos alum_01;
    private Alumnos alum_02;
    private Alumnos alum_03;
    private int[]NotasTmp;
    
    public Gestion() {
        alum_01 = new Alumnos();
        alum_01.setNombre("Pepe");
        alum_01.setNota(0,5);
        alum_01.setNota("PRO", 6);
        alum_01.setNota(2, 7);
        System.out.println(alum_01.toString());
        
    }

    
}
