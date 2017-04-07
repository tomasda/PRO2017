package com.objects;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Tomás Delgado Acosta
 */
public class Cola {
        Deque<String> cl;
        
        public Cola(){
            cl = new LinkedList();
        }

    public Deque<String> getCl() {
        return cl;
    }

    public void setCl(Deque<String> cl) {
        this.cl = cl;
    }
}
