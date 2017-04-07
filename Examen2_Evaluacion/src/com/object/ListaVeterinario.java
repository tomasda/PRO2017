package com.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tomás Delgado Acosta
 */
public class ListaVeterinario {

    private ArrayList<Individuo> veterinario;
    public static int ID = 1;
    private Individuo anim;

    public ListaVeterinario() {
        this.veterinario = new ArrayList<>();
    }

    public ArrayList<Individuo> getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(ArrayList<Individuo> veterinario) {
        this.veterinario = veterinario;
    }

//    public void Alta_Animalito() {
//        
//        Fecha a = new Fecha(10, 10, 2007);
//        
//        anim = new Mamifero(ID++, "AA", "Carlos", a, "Padre", "Madre");
//        veterinario.add(anim);
//    }

//    public void MostrarAnimalito() {
//        for (int i = 0; i < veterinario.size(); i++) {
//            System.out.println(veterinario.get(i).getID());
//        }
//    }
    public Queue cantTipo2(){
        Queue data = new LinkedList();
        for (Individuo veterinario1 : veterinario) {
            data.add(veterinario1.getClass().getName());
        }
        //data.add(veterinario.get(ID).getClass().getName());
        
        return data;
    }
    
    public Queue cantTipo(){
        String valor;
        int M =0; int O=0;
        Queue<String> data = new LinkedList();
        for (int i = 0; i < veterinario.size(); i++) {
            if (veterinario.get(i)instanceof Mamifero){
                M++;
            }
            if (veterinario.get(i)instanceof Oviparo){
                O++;
            }
        }
            valor = "Mamiferos = "+M;
            data.offer(valor);
            valor = "Oviparos = "+O;
            data.offer(valor);
        return data;
    }
    
    public void cuantos() {
        int M = 0;
        int O = 0;
        for (int i = 0; i < veterinario.size(); i++) {
            if (i < 10) {
                M++;
            } else {
                O++;
            }
        }
    }

    public void Mostrar_mas_viejo() {
        Date date = new Date();
        Fecha init = new Fecha(10, 10, 2017);
        int IDTMP;
        for (int i = 0; i < veterinario.size(); i++) {

        }
    }

    public void Alta_Animal(Individuo a) {
        veterinario.add(a);
    }

}
