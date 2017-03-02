package com;

import com.object.Meses;

/**
 *
 * @author Tomas Delgado Acosta.
 */
public class Main {

    public static void main(String[] args) {
        Meses meses=new Meses();
        for (int i = 1; i<13; i++){
            System.out.println(meses.getMesName(i));
        }
    }
    
}
