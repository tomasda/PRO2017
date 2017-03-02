package com;

import com.utils.LoadProperties;

/**
 *
 * @author Tomás Delgado Acosta
 */
class Palabra {
    private String word;
    private int tema;
    private int cual;
    

    public String getWord() {
        return word;
    }
    public String getAleatoryWord(){
        LoadProperties load = new LoadProperties();
        int varTema = Integer.parseUnsignedInt(load.loadPropertie("config", "temas")); //Obtengo de fichero el número de temas 
        int varCual = Integer.parseUnsignedInt(load.loadPropertie("config", "palabrasPorTema")); // Y cuantas palabras hay por tema.
        tema = (int) Math.floor( Math.random()* (varTema)+1);// Random....
        cual = (int) Math.floor(Math.random() * (varCual)+1);
        word = load.loadPropertie("config", tema+"."+cual);// Recupero del fichero la palabra.
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
}
