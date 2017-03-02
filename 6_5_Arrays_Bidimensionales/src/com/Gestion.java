package com;

import com.tienda.Almacen;
import com.tienda.Caracteristica;
import com.tienda.ObjetoUnidad;
import com.utils.LoadProperties;
import java.io.IOException;

/**
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    private LoadProperties property;
    private Almacen almacen;
    private Almacen matrizNM;
    private ObjetoUnidad zapato;
    private ObjetoUnidad matr;
    private ObjetoUnidad[][] zapatos;
    private ObjetoUnidad[][] matriz;
    
    private StringBuffer data;
    
    private Caracteristica caracteristica;
    private Caracteristica[] color;
    private Caracteristica[] modelo;
    private Caracteristica[] moda;
    
    private int numCoincidentes = 0;
    int[] sumaColumna;

    public void run() {
        property = new LoadProperties();
        /*
        Zapatería.
        Creación del array, rellenar los datos y calcular la suma de fila, columna y total.
         */
        crearMatrizAlmacen();
        inicializaMatriz();
        inicializaModelosYColores();
        calculoDeDatosYReporte();
        /*
        Calcular la moda.
        Moda es el número que más se repite en la tabla, y no tiene que ver ni con modelos ni con colores.
         */
        calculaModa();
        //reporteModa(); // Método que muestra el array intermedio que obtiene los datos que hacen falta para calcular la moda.
        queNumEsModa();
        /*
        MatrizNM
         */
        crearMatrizNM();
        inicializaMatrizNM();
        operacionesNM();
    }

    /*
    MatrizNM
     */
    private String filaColumnaNumDetermiado(int numBuscar) {
        int x = matriz.length;
        int y = matriz[0].length;
        String valor = "-1,-1";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matriz[i][j].getCantidad() == numBuscar) {
                    valor = i + " / " + j;
                }
            }
        }
        return valor;
    }

    private String filaColumnaValorNumMayorMenor(String MayorMenor) {
        matriz = matrizNM.getZapatos();
        int valorPrevio = matriz[0][0].getCantidad();// Inicializo la variable con el valor de la posición 0,0 para que el bucle no se enfrente a un valor no existente en la tabla.
        String data = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int valorActual = (matriz[i][j].getCantidad());
                switch (MayorMenor) {
                    case "Mayor":
                        if (valorActual > valorPrevio) {
                            valorPrevio = valorActual;
                            data = i + " / " + j + " = " + valorPrevio;
                        }
                        break;
                    case "Menor":
                        if (valorActual < valorPrevio) {
                            valorPrevio = valorActual;
                            data = i + " / " + j + " = " + valorPrevio;
                        }
                        break;
                }
            }
        }
        return data;
    }

    private int columnaMayorValor() {
        int valor = 0;
        int columna = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (sumaColumna[i]>valor){
                valor = sumaColumna[i];
                columna = i ;
            }
        }
        return columna;
    }

    private String cantNumParesEImpares() {
        int numPares=0;
        int numImpares=0;
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[0].length; y++) {
                if ((matriz[x][y].getCantidad()%2)==0){
                    numPares++;
                }else{
                    numImpares++;
                }
            }
        }
        return numPares+" / "+numImpares;
    }

    private void crearMatrizNM() {
        int x = Integer.parseInt(property.loadPropertie("config", "modelos"));
        int y = Integer.parseInt(property.loadPropertie("config", "colores"));
        matrizNM = new Almacen(x, y);
    }

    private void inicializaMatrizNM() {
        int x = matrizNM.getX();
        int y = matrizNM.getY(0);
        int valor = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matr = new ObjetoUnidad();
                valor = obtenerValorNoRepetido();
                matr.setCantidad(valor);
                matrizNM.setZapatos(i, j, matr);
            }
        }
    }

    public void operacionesNM() {
        int a = Integer.parseInt(property.loadPropertie("config", "numBuscado"));
        data = new StringBuffer();
        data.append(calculoDeDatosYReporteNM());
        data.append("\n\tUbicación del número ").append(a).append(" es: ").append(filaColumnaNumDetermiado(a));
        data.append("\n\tUbicación del número Mayor es: ").append(filaColumnaValorNumMayorMenor("Mayor"));
        data.append("\n\tUbicación del número Menor es: ").append(filaColumnaValorNumMayorMenor("Menor"));
        data.append("\n\tLa columna con mayor valor es: ").append(columnaMayorValor());
        data.append("\n\tNumero Pares/Números Impares ").append(cantNumParesEImpares());
        System.out.println(data);
    }

    public int obtenerValorNoRepetido() {
        matriz = matrizNM.getZapatos();
        int valor;
        boolean existe;
        boolean check = false;
        do {
            existe = false;
            valor = (int) Math.floor(Math.random() * 100);
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j] != null){ // Comprueba si la posición del array está vacía.
                        if (matriz[i][j].getCantidad()==valor){
                            existe = true; // Sí el valor existe en el array vuelve a generar un valor nuevo.
                        }
                    }else{
                        check = true; // Si llega a la zona del array que no tiene datos habilita la salida del bucle
                    }
                }
            }
        } while (!existe && !check);
        return valor;
    }

    private StringBuffer calculoDeDatosYReporteNM() {
        matriz = matrizNM.getZapatos();
        data = new StringBuffer();
        sumaColumna = new int[matriz.length];
        sumaColumna[0]=0;
        data.append("\n\n\tMatriz NM\n\t\t");
        for (int i = 0; i < matriz[0].length; i++) { // Imprime la numeración de las filas.
            data.append(i).append("\t");
        }
        data.append("\n\n");
        for (int x = 0; x < matriz.length; x++) {
            data.append("\t").append(x).append("\t");
            for (int y = 0; y < matriz[x].length; y++) {
                int valor = matriz[x][y].getCantidad();
                sumaColumna[y]=sumaColumna[y]+valor;
                data.append(valor).append("\t");
            }
            data.append("\n");
        }
        data.append("\n\t\t");
        for (int i = 0; i < matriz[0].length; i++) {
            data.append(sumaColumna[i]).append("\t");
        }
        return data;
    }

    /*
    Almacen de Zapatos
     */
    private void crearMatrizAlmacen() {
        int x = Integer.parseInt(property.loadPropertie("config", "modelos"));
        int y = Integer.parseInt(property.loadPropertie("config", "colores"));
        almacen = new Almacen(x, y);
    }

    private void inicializaMatriz() {
        int x = almacen.getX();
        int y = almacen.getY(0);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                zapato = new ObjetoUnidad();
                zapato.setCantidad(i + x + j);
                almacen.setZapatos(i, j, zapato);
            }
        }
    }

    private void inicializaModelosYColores() {
        crearModelos();
        crearColores();
    }

    private void crearModelos() {
        /*
            Creo los Modelos
         */
        int cont = Integer.parseInt(property.loadPropertie("config", "modelos"));
        for (int i = 0; i < cont; i++) {
            caracteristica = new Caracteristica();
            caracteristica.setValor(property.loadPropertie("config", "modelo." + (i + 1)));
            almacen.setModelo(i, caracteristica);
        }
    }

    private void crearColores() {
        /*
            Creo los colores
         */
        int cont = Integer.parseInt(property.loadPropertie("config", "colores"));
        for (int i = 0; i < cont; i++) {
            caracteristica = new Caracteristica();
            caracteristica.setValor(property.loadPropertie("config", "color." + (i + 1)));
            caracteristica.setNombreColumna(property.loadPropertie("config", "colorC." + (i + 1)).charAt(0));
            almacen.setColor(i, caracteristica);
        }
    }

    private void calculoDeDatosYReporte() {
        color = almacen.getColor();
        modelo = almacen.getModelo();
        zapatos = almacen.getZapatos();
        data = new StringBuffer();
        int[] totalesModelos = new int[zapatos.length];
        int[] totalesColores = new int[zapatos[0].length];
        totalesModelos[0] = 0;
        totalesColores[0] = 0;
        int totalZapatosVendidos = 0;
        data.append("\t\t");
        for (int x = 0; x < color.length; x++) {
            data.append("\t").append(color[x].getNombreColumna());
        }
        data.append("\tTotal Modelos\n");
        for (int x = 0; x < zapatos.length; x++) {
            data.append("\t").append(modelo[x].getValor()).append("\t");
            if (modelo[x].getValor().length() < 8) {
                data.append("\t");
            }
            for (int y = 0; y < zapatos[x].length; y++) {
                int valor = zapatos[x][y].getCantidad();
                data.append(valor);
                data.append("\t");
                totalesColores[y] = (totalesColores[y] + valor);
                totalesModelos[x] = (totalesModelos[x] + valor);
                totalZapatosVendidos = totalZapatosVendidos + valor;
            }
            data.append(totalesModelos[x]).append("\n");
        }
        data.append("\n").append("\tTotal colores ");
        for (int i = 0; i < totalesColores.length; i++) {
            data.append("\t").append(totalesColores[i]);
        }
        data.append("\n\n").append("\t\t").append("Total de Zapatos Vendidos ").append(totalZapatosVendidos);
        System.out.println(data);
    }

    /*
    MODA
     */
    public void calculaModa() {
        zapatos = almacen.getZapatos();
        data = new StringBuffer();
        int x = zapatos.length;
        int y = zapatos[0].length;
        modelo = almacen.getModelo();
        /*
        En el peor caso, lo que nos puede suceder es que cada posición tenga un valor diferente.
        Entonces no habría moda y el array donde guardo las repeticiones podría desbordarse.
         */
        moda = almacen.getModa();
        /*
            En la cadena de texto guardo el valor y en el entero las veces que se repite.
         */
        int valor;
        boolean nuevoValor;
        for (int yZ = 0; yZ < y; yZ++) {
            for (int xZ = 0; xZ < x; xZ++) {
                nuevoValor = true;
                valor = zapatos[xZ][yZ].getCantidad();
                for (int i = 0; i < numCoincidentes; i++) {
                    if (moda[i].getNumLong() == (valor)) {
                        nuevoValor = false;
                        moda[i].setNumEntero(moda[i].getNumEntero() + 1);
                    }
                }
                if (nuevoValor) {
                    caracteristica = new Caracteristica();
                    caracteristica.setNumLong(valor);
                    caracteristica.setNumEntero(1);
                    caracteristica.setValor(modelo[xZ].getValor());
                    almacen.setModa(numCoincidentes, caracteristica);
                    numCoincidentes++;
                }
            }
        }
    }

    public void reporteModa() {
        data.append("\t");
        for (int i = 0; i < numCoincidentes; i++) {
            data.append("\n num ").append(moda[i].getNumLong()).append(" repeticiones en la tabla ").append(moda[i].getNumEntero());
        }
        System.out.println(data);
    }

    private void queNumEsModa() {
        data = new StringBuffer();
        int valor = 0;
        int esModa = 0;
        long val = 0;
        for (int i = 0; i < numCoincidentes; i++) {
            if (moda[i].getNumEntero() > valor) {
                valor = moda[i].getNumEntero();
                val = moda[i].getNumLong();
                esModa = 1;
            }
            if (moda[i].getNumEntero() == valor && moda[i].getNumLong() != val) {
                esModa++;
            }
        }
        data.append("\n\tSe entiende cómo Moda el número de la tabla que más se repite.");
        if (esModa == 1) {
            data.append("\n\tEn esta tabla la moda es: ").append(val).append(" y se repite ").append(valor).append(" veces.");
        } else {
            data.append("\n\tEn esta tabla no existe moda, ya que existe más de un número que se repite la misma cantidad de veces.");
        }
        System.out.println(data);
    }
}
