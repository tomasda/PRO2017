package javaapplication52;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Tomás Delgado Acosta
 */
public class JavaApplication52 {

    public static void main(String[] args) {
        //colas();
        //pilas();
    }
    
    private static void colas(){
        Queue<String> cola = new LinkedList();
        for (int i = 0; i < 10; i++) {
            cola.offer("COLA"+i);
        }
        System.out.println(cola.peek()+"\n");
        System.out.println(cola.poll()+"\n");
        while (!cola.isEmpty()){
            System.out.println(cola.poll()+"\n");
        }
    }
    
    private static void pilas(){
        //Stack<String> hola = new Stack();
        Deque<String> hola = new LinkedList();
        for (int i = 0; i < 10; i++) {
            hola.push("PILA"+i);
        }
        System.out.println(hola.peek()+"\n");
        System.out.println(hola.pop()+"\n");
        System.out.println(hola.peek()+"\n");
        
    }
}
