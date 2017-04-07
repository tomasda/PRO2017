package com.objects;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tomás Delgado Acosta
 */
public class Pila {

    Queue<String> pl;

    public Pila(){
        pl = new LinkedList();
    }

    public Queue<String> getPl() {
        return pl;
    }

    public void setPl(Queue<String> pl) {
        this.pl = pl;
    }

}
