/**
 * Javier Abell�n. 20 Marzo 2006
 * 
 * Ejemplo de escribir y leer objetos en un fichero.
 */
package objeto_fichero;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Crea y escribe en un fichero 10 objetos de la clase Persona. Luego los lee
 * y los muestra por pantalla.
 * @author Javier Abell�n
 */
public class EscribirYLeer
{

    /**
     * main del ejemplo. Escribe el fichero y lo lee.
     * @param args se ignoran
     */
    public static void main(String[] args)
    {
        EscribirYLeer eyl = new EscribirYLeer();
        //eyl.escribeFichero("./files/mascotas.dat");
        //eyl.anhadeFichero("./files/mascotas.dat");
        eyl.leeFichero("./files/mascotas.dat");
    }

    /**
     * Escribe en el fichero que se le pasa y empezandolo desde cero, 5 objetos
     * de la clase Persona.
     * @param fichero Path completo del fichero que se quiere escribir
     */
    public void escribeFichero(String fichero)
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fichero));
            for (int i = 0; i <5; i++)
            {
                // ojo, se hace un new por cada Persona. El new dentro
                // del bucle.
                Persona p = new Persona(i);
                oos.writeObject(p);
            }
            oos.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * A�ade al final del fichero que se le pasa 5 objetos de la clase Persona.
     * @param fichero Path completo del fichero
     */
    public void anhadeFichero (String fichero)
    {
        try
        {
            // Se usa un ObjectOutputStream que no escriba una cabecera en
            // el stream.
            MiObjectOutputStream oos = new MiObjectOutputStream(
                    new FileOutputStream(fichero,true));
            // Se hace el new fuera del bucle, s�lo hay una instancia de persona.
            // Se debe usar entonces writeUnshared().
            Persona p = new Persona(5);
            for (int i = 5; i < 10; i++)
            {
                p.setPersona(i);   // Se rellenan los datos de Persona.
                oos.writeUnshared(p);
            }
            oos.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    
    /**
     * Se leen todas las Persona en el fichero y se escriben por pantalla.
     * @param fichero El path completo del fichero que contiene las Persona.
     */
    public void leeFichero(String fichero)
    {
        try
        {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            
            // Se lee el primer objeto
            Object aux = ois.readObject();
            
            // Mientras haya objetos
            while (aux!=null)
            {
                if (aux instanceof Persona)
                    System.out.println(aux);
                aux = ois.readObject();
            }
            ois.close();
        }
        catch (EOFException e1)
        {
            System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    }
}
