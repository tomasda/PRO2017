package com.object;

import com.utils.Utils;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author Tomás Delgado Acosta
 */
public class Menu {

    Utils util;

    public StringBuffer Menu() {
        StringBuffer data = new StringBuffer();
        data.append("\n\t").append("1. Insertar nuevo individuo a la lista del Veterinario.");
        data.append("\n\t").append("2. Listar todos los Individuos.");
        data.append("\n\t").append("3. Listar por Tipo.");
        data.append("\n\t").append("4. Mostrar el mayor de edad.");
        data.append("\n\t").append("5. .");
        data.append("\n\t").append("6. .");
        data.append("\n\t").append("#####################################################################################");
        data.append("\n\t").append("7. .");
        data.append("\n\t").append("---------");
        data.append("\n\t").append("0. Salir.");
        return data;
    }

    public void showMessage(ArrayList<Individuo> veterinario, int i) {
        StringBuffer data = new StringBuffer();
        if (i == -1) {
            for (int j = 0; j < veterinario.size(); j++) {
                data.append("\n\tNombre de la Mascota : ").append(veterinario.get(j).getNombre()).append("\tPropietario : ").append(veterinario.get(j).getNombreProp());
                data.append("\n\tFecha de Nacimiento : ").append(veterinario.get(j).getFNaciminento().toString());
                if (veterinario.get(j) instanceof Mamifero) {
                    data.append("\n\tPadre : ").append(((Mamifero) veterinario.get(j)).getPadre()).append("\tMadre : ").append(((Mamifero) veterinario.get(j)).getMadre());
                }
                if (veterinario.get(j) instanceof Oviparo) {
                    data.append("Numero de hermanos : ").append(((Oviparo) veterinario.get(j)).getNumHermanos());
                }
            }
        } else {
            if (i > veterinario.size()) {
                data.append("\n\tNombre de la Mascota : ").append(veterinario.get(i).getNombre()).append("\tPropietario : ").append(veterinario.get(i).getNombreProp());
                data.append("\n\tFecha de Nacimiento : ").append(veterinario.get(i).getFNaciminento().toString());
            }
        }
        System.out.println(data);
    }

    public void mostraCantTipos(Queue cantTipo) {
     StringBuffer data = new StringBuffer();
     while(!cantTipo.isEmpty()){
        data.append(cantTipo.poll()).append("\n");
     }
     System.out.println(data);
    }

}
