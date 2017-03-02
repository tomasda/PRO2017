package com.tarjetas;

/**
 *
 * @author Tomás Delgado Acosta
 */
public class Tarjetas {
    int[][] tarjetas;

    public Tarjetas() {
        tarjetas = new int[][]{{1,3,5,7,9,11,13,15},{2,3,6,7,10,11,14,15},{4,5,6,7,12,13,14,15},{8,9,10,11,12,13,14,15}};
    }
    
    public void MostrarTarjeta(int cual){
        for(int a=0;a<8;a++){
                System.out.println(tarjetas[cual][a]+" ");
            }
    }
    public int RecuperarValor(int cual){
        return tarjetas[cual][0];
    }
    /* CODIGO POCO OPTIMO...
    public void Tarjeta_01() {
        System.out.println("1  3  5  7  9  11  13  15");
        //for (int i=0;i<4;i++){
            for(int a=0;a<8;a++){
                System.out.println(tarjetas[0][a]+" ");
            }
            
        //}
    }

    public void Tarjeta_02() {
        System.out.println("2  3  6  7  10  11  14  15");
    }

    public void Tarjeta_03() {
        System.out.println("4  5  6  7  12  13  14  15");
    }

    public void Tarjeta_04() {
        System.out.println("8  9  10  11  12  13  14  15");
    }*/
}
