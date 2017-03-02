package batalla;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tomás Delgado Acosta
 */
public class Ejercito {
    Queue<Soldado> ejercito;
    String nombre;

    public Ejercito() {
        ejercito = new LinkedList();
        nombre="";
    }

    public Ejercito(int num, String nombre){
        ejercito = new LinkedList();
        this.nombre = nombre;
        Soldado sol;
        int rand;
        for (int i = 0; i < num; i++) {
            rand = (int)Math.round(Math.random()*10);
            sol = new Soldado(i,rand);
            ejercito.offer(sol);
        }
    }
    
    public Ejercito(int num, String nombre, int vida){
        ejercito = new LinkedList();
        this.nombre = nombre;
        Soldado sol;
        int rand;
        for (int i = 0; i < num; i++) {
            rand = (int)Math.round(Math.random()*vida);
            sol = new Soldado(i,rand);
            ejercito.offer(sol);
        }
    }
    
    public void crearSoldado(int id, int vida){
        Soldado e = new Soldado(id,vida);
        this.ejercito.offer(e);
    }
    public Soldado llamarABatalla(){
        return ejercito.poll();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
