package arrays;

/**
 * @author Tomás Delgado Acosta
 */
public class MatrizJuego {

    Data[][] juego;

    public MatrizJuego(int x, int y) {
        juego = new Data[x][y];
    }

    void initMAtriz() {
        for (int x = 0; x < juego.length; x++) {
            for (int y = 0; y <juego[0].length; y++) {
                juego[x][y] = new Data();
                juego[x][y].setStorage(0);
            }
        }
    }

}
