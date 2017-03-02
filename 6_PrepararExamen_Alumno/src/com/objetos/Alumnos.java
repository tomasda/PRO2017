package com.objetos;
public class Alumnos {
    private String Nombre;
    private static String[]Asignaturas;
    private int[] Notas;

    public Alumnos() {
        Asignaturas= new String[]{"BAE","PRO","LNT"};
        Notas = new int[3];
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public static String[] getAsignaturas() {
        return Asignaturas;
    }

    public static void setAsignaturas(String[] Asignaturas_) {
        for(int i=0;i<Asignaturas_.length;i++){
            Alumnos.Asignaturas[i]=Asignaturas_[i];
        }
    }

    public int[] getNotas() {
        return Notas;
    }
    public void setNota(String Asignatura_, int valor){
        int posicion=0;
        for (int i=0;i<Asignaturas.length;i++){
            if (Asignatura_.equals(Asignaturas[i])){
                posicion=i;
            }
        }
        Notas[posicion]=valor;
    }
    public void setNota(int Poscicion,int valor){
        Notas[Poscicion]=valor;
    }
    
    public void setNotas(int[] Notas_) {
        for(int i=0;i<Notas_.length;i++){
            Notas[i]=Notas_[i];
        }
    }
    public String toString(){
        String resultado="";
            for(int i=0;i<Asignaturas.length;i++){
                resultado = resultado+Asignaturas[i]+" "+Notas[i]+"\t";
            }
        return resultado;
    }
}
