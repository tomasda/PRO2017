package arrays;

import com.utils.Utils;

/**
 * @author Tomás Delgado Acosta
 */
public class Juego {

    Utils utils = new Utils();
    MatrizJuego partida;
    StringBuffer data;
    String Jugador1 = "ALFREDO DIESTEFANO";
    String Jugador2 = "RUTH";
    boolean turno = true;

    public void partida() {
        partida = new MatrizJuego(3, 3);
        partida.initMAtriz();
    }

    public void tresEnRaya() {
        data = new StringBuffer();
        data.append("\t╔═══════════════=══╗\n");
        data.append("\t║       TRES EN RAYA         ║\n");
        data.append("\t╚════════════════=═╝\n");
        System.out.println(data);
    }

    public void showPartida() {
        data = new StringBuffer();
        data.append("\t   ╔═╦═╦═╗\n");
        data.append("\t   ║1║2 ║3 ║\n");
        data.append("\t╔=╬═╬═╬═╣\n");
        for (int x = 0; x < partida.juego.length; x++) {
            data.append("\t║").append(ficha(10 + x)).append("║");
            for (int y = 0; y < partida.juego[0].length; y++) {
                data.append(ficha(partida.juego[x][y].getStorage())).append("║");
            }
            if (x < (partida.juego.length - 1)) {
                data.append("\n\t╠=╬═╬═╬═╣\n");
            }
        }
        data.append("\n\t╚=╩═╩═╩═╝\n");
        System.out.println(data);
    }

    private StringBuffer ficha(int i) {
        StringBuffer data = new StringBuffer();
        switch (i) {
            case 0:
                data.append((char) 27).append("[0;0m░").append((char) 27).append("[0;0m");
                break;
            case 1:
                data.append((char) 27).append("[31;31m█").append((char) 27).append("[0;0m");
                break;
            case 2:
                data.append((char) 27).append("[32;32m█").append((char) 27).append("[0;0m");
                break;
            case 10:
                data.append("A");
                break;
            case 11:
                data.append("B");
                break;
            case 12:
                data.append("C");
                break;
            default:
                data.append((char) 27).append("[0;0m░").append((char) 27).append("[0;0m");
        }
        return data;
    }

    public void showJugadores() {
        StringBuffer data = new StringBuffer();
        data.append("\t╔═══════════════=══╗\n");
        data.append("\t║       TRES EN RAYA       █║\n");
        data.append("\t║                          █║\n");
        data.append("\t║   J1 ").append(Jugador1);
        for (int i = 0; i < 19 - Jugador1.length(); i++) {
            data.append(" ");
        }
        data.append((char) 27).append("[31;31m█").append((char) 27).append("[0;0m ");
        data.append("║\n");
        data.append("\t║   J2 ").append(Jugador2);
        for (int i = 0; i < 19 - Jugador2.length(); i++) {
            data.append(" ");
        }
        data.append((char) 27).append("[32;32m█").append((char) 27).append("[0;0m ");
        data.append("║\n");
        data.append("\t║                          █║\n");
        data.append("\t╚════════════════=═╝\n");
        System.out.println(data);
    }

    public void solicitarNombreJugadores() {
        tresEnRaya();
        Jugador1 = utils.leerString("Introduce el nombre del Jugador1").toUpperCase();
        Jugador2 = utils.leerString("Introduce el nombre del Jugador2").toUpperCase();
    }

    public void solicitarNombreJugador() {
        tresEnRaya();
        Jugador1 = "PC";
        Jugador2 = utils.leerString("Introduce el nombre del Jugador2").toUpperCase();
    }

    public String solicitarJugada() {
        String jugada;
        String X;
        String Y;
        if (jugador().equals("PC")) {
            // ¿Puedo Ganar? 1 = PC
            jugada = puedoGanarPerder(1);
            if (jugada.equals("NONE")) {
                // ¿Puedo Perder?
                jugada = puedoGanarPerder(2);
                if (jugada.equals("NONE")) {
                    jugada = jugadaRandom();
                }
                //System.out.println(jugada);
            }
            // Verifica que la casilla no esté ocupada
            while (!casillaDisponibleJugador(jugada)) {
                // ¿Puedo Perder?
                jugada = puedoGanarPerder(2);
                if (jugada.equals("NONE")) {
                    jugada = jugadaRandom();
                }
            }
        } else {
            do {
                jugada = utils.leerString("Introduce tu jugada (A1) " + jugador());
                X = jugada.substring(0, 1).toUpperCase();
                Y = jugada.substring(1, 2).toUpperCase();
            } while (!((X.equals("A") || X.equals("B") || X.equals("C")) && (Y.equals("1") || Y.equals("2") || Y.equals("3"))));
        }
        return jugada;
    }

    public String jugador() {
        if (turno) {
            return Jugador1;
        } else {
            return Jugador2;
        }
    }

    public boolean casillaDisponibleJugador(String jugada) {
        String X = jugada.substring(0, 1).toUpperCase();
        int Xi = parsearX(X);
        int Y = Integer.parseInt(jugada.substring(1, 2).toUpperCase()) - 1;
        return casillaDisponiblePC(Xi, Y);
    }

    public boolean casillaDisponiblePC(int Xi, int Y) {
        boolean datas = true;
        if (partida.juego[Xi][Y].getStorage() != 0) {
            datas = false;
        }
        return datas;
    }

    private int parsearX(String X) {
        int Xi = 0;
        switch (X) {
            case "A":
                Xi = 0;
                break;
            case "B":
                Xi = 1;
                break;
            case "C":
                Xi = 2;
                break;
        }
        return Xi;
    }

    public void intdoucirJugadaYCambioJugador(String jugada) {
        String X = jugada.substring(0, 1).toUpperCase();
        int Xi = parsearX(X.toUpperCase());
        int Y = Integer.parseInt(jugada.substring(1, 2).toUpperCase()) - 1;
        if (turno) {
            partida.juego[Xi][Y].setStorage(1);
            turno = false;
        } else {
            partida.juego[Xi][Y].setStorage(2);
            turno = true;
        }
    }

    public int validarGanador() {
        boolean existeGanador = false;
        int ganador = 0;
        int control = 0;
        if (!existeGanador) {
            // Validar eje X
            int X = 0;
            for (int Y = 0; Y < 3; Y++) {
                X = 0;
                control = 0;
                for (int i = 0; i < 3; i++) {
                    if (partida.juego[i][Y].getStorage() != 0) {
                        if (i == 0) {
                            X = partida.juego[i][Y].getStorage();
                        }
                        if (partida.juego[i][Y].getStorage() == X) {
                            control++;
                            if (control > 2) {
                                existeGanador = true;
                                ganador = X;
                            }
                        }
                    }
                }
            }
        }
        if (!existeGanador) {
            // Validar eje Y
            int Y;
            for (int X = 0; X < 3; X++) {
                Y = 0;
                control = 0;
                for (int i = 0; i < 3; i++) {
                    if (partida.juego[X][i].getStorage() != 0) {
                        if (i == 0) {
                            Y = partida.juego[X][i].getStorage();
                        }
                        if (partida.juego[X][i].getStorage() == Y) {
                            control++;
                            if (control > 2) {
                                existeGanador = true;
                                ganador = Y;
                            }
                        }
                    }
                }
            }
        }
        if (!existeGanador) {
            // Validar diagonales.
            control = 0;
            int XY = 0;
            for (int i = 0; i < 3; i++) {
                if (partida.juego[i][i].getStorage() != 0) {
                    if (i == 0) {
                        XY = partida.juego[i][i].getStorage();
                    }
                    if (partida.juego[i][i].getStorage() == XY) {
                        control++;
                        if (control > 2) {
                            existeGanador = true;
                            ganador = XY;
                        }
                    }
                }
            }
        }
        if (!existeGanador) {
            control = 0;
            int XY = 0;
            for (int i = 0; i < 3; i++) {
                if (partida.juego[2 - i][i].getStorage() != 0) {
                    if (i == 0) {
                        XY = partida.juego[2 - i][i].getStorage();
                    }
                    if (partida.juego[2 - i][i].getStorage() == XY) {
                        control++;
                        if (control > 2) {
                            existeGanador = true;
                            ganador = XY;
                        }
                    }
                }
            }
        }
        return ganador;
    }

    public void ganador(int ganador) {
        data = new StringBuffer();
        String ganador_;
        if (ganador == 1) {
            ganador_ = Jugador1;
        } else {
            ganador_ = Jugador2;
        }
        if (ganador == 0) {
            data.append("\t╔═══════════════=══╗\n");
            data.append("\t║       TRES EN RAYA         ║\n");
            data.append("\t║                            ║\n");
            data.append("\t║           ESTA             ║\n");
            data.append("\t║       PARTIDA HA SIDO      ║\n");
            data.append("\t║           EMPATE           ║\n");
            data.append("\t║                            ║\n");
            data.append("\t╚════════════════=═╝\n");
        } else {
            data.append("\t╔═══════════════=══╗\n");
            data.append("\t║       TRES EN RAYA         ║\n");
            data.append("\t║                            ║\n");
            data.append("\t║     EL GANADOR DE ESTA     ║\n");
            data.append("\t║       PARTIDA HA SIDO      ║\n");
            data.append("\t║                            ║\n");
            data.append("\t║    ").append(ganador_);
            for (int i = 0; i < 23 - ganador_.length(); i++) {
                data.append(" ");
            }
            data.append(" ║\n");
            data.append("\t║                            ║\n");
            data.append("\t╚════════════════=═╝\n");
        }
        System.out.println(data);
    }

    public String nuevaPartida() {
        String volverAJugar;
        do {
            volverAJugar = utils.leerString("¿NUEVA PARTIDA? S/N").toUpperCase();
            volverAJugar = volverAJugar.substring(0, 1).toUpperCase();
        } while ((!volverAJugar.equals("S") && !volverAJugar.equals("N")));
        return volverAJugar;
    }

    public int modoJuego() {
        int opcion;
        data = new StringBuffer();
        data.append("\t╔═══════════════=══╗\n");
        data.append("\t║    1 Jugador - PC          ║\n");
        data.append("\t║    2 Jugador - Jugador     ║\n");
        data.append("\t╚════════════════=═╝\n");
        System.out.println(data);
        do {
            opcion = utils.leerInt("Selecciones una opción ");
        } while (opcion != 1 && opcion != 2);
        return opcion;
    }

    private String puedoGanarPerder(int jugador) {
        //Tanto para el caso de Ganar como Perder se devuelve una posición del tablero.
        //En caso de no existin ninguna de las dos se devuelve NONE
        String ganar = posicionX(jugador);
        if (!ganar.equals("NONE")) {
            //1222 X Y  0 - 2
            /*
            Para calcular la posición donde hacer la próxima jugada uso la siguente técnica.
            Pido al método posición que me devuelva las posiciones que actualmente tengo ocupadas 
            en caso que tener posobilidades de ganar.
            Este método me devuelve por ejemplo las posiciones 0111 - que corresponden a A1 B1
            El método que uso para descifrar la posicion que falta es sencialla.
            Al total máximo que es 3 resto la suma de las casillas que ya tengo rellenas y el resultado es el valor de la que falta.
             */
            ganar = parsearGanar(ganar);
            //Verifica si la casilla para ganar está ocupada.
            //Si es así, busca libera la jugada y busca otra opción para ganar.
            if (!casillaDisponibleJugador(ganar)) {
                ganar = "NONE";
            }
        }
        //Eje Y
        if (ganar.equals("NONE")) {
            ganar = posicionY(jugador);
            if (!ganar.equals("NONE")) {
                ganar = parsearGanar(ganar);
                if (!casillaDisponibleJugador(ganar)) {
                    ganar = "NONE";
                }
            }
        }
        //Diagonal 1
        if (ganar.equals("NONE")) {
            ganar = posicionD1(jugador);
            if (!ganar.equals("NONE")) {
                ganar = parsearGanar(ganar);
                if (!casillaDisponibleJugador(ganar)) {
                    ganar = "NONE";
                }
            }
        }
        //Diagonal 2
        if (ganar.equals("NONE")) {
            ganar = posicionD2(jugador);
            if (!ganar.equals("NONE")) {
                ganar = parsearGanar(ganar);
                if (!casillaDisponibleJugador(ganar)) {
                    ganar = "NONE";
                }
            }
        }
        return ganar;

    }

    private String posicionX(int jugador) {
        boolean puedoGanar = false;
        String jugadaGanadora = "";
        int control = 0;
        String posicionesOcupadas = "";
        // Validar eje X
        for (int Y = 0; Y < 3; Y++) {
            posicionesOcupadas = "";
            control = 0;
            for (int X = 0; X < 3; X++) {
                if (partida.juego[X][Y].getStorage() == jugador) {
                    posicionesOcupadas = posicionesOcupadas + X + Y;
                    control++;
                    if (control > 1) {
                        puedoGanar = true;
                        jugadaGanadora = posicionesOcupadas;
                    }
                }
            }
        }

        if (puedoGanar) {
            return jugadaGanadora;
        } else {
            return "NONE";
        }
    }

    private String posicionY(int jugador) {
        boolean puedoGanar = false;
        String jugadaGanadora = "";
        int control = 0;
        String posicionesOcupadas = "";
        // Validar eje Y
        for (int X = 0; X < 3; X++) {
            posicionesOcupadas = "";
            control = 0;
            for (int Y = 0; Y < 3; Y++) {
                if (partida.juego[X][Y].getStorage() == jugador) {
                    posicionesOcupadas = posicionesOcupadas + X + Y;
                    control++;
                    if (control > 1) {
                        puedoGanar = true;
                        jugadaGanadora = posicionesOcupadas;
                    }
                }
            }
        }
        if (puedoGanar) {
            return jugadaGanadora;
        } else {
            return "NONE";
        }
    }

    private String posicionD1(int jugador) {
        boolean puedoGanar = false;
        String jugadaGanadora = "";
        int control = 0;
        String posicionesOcupadas = "";
        // Validar diagonales.
        control = 0;
        posicionesOcupadas = "";
        for (int XY = 0; XY < 3; XY++) {
            if (partida.juego[XY][XY].getStorage() == jugador) {
                posicionesOcupadas = posicionesOcupadas + XY + XY;
                control++;
                if (control > 1) {
                    puedoGanar = true;
                    jugadaGanadora = posicionesOcupadas;
                }
            }

        }
        if (puedoGanar) {
            return jugadaGanadora;
        } else {
            return "NONE";
        }
    }

    private String posicionD2(int jugador) {
        boolean puedoGanar = false;
        String jugadaGanadora = "";
        int control = 0;
        String posicionesOcupadas = "";
        control = 0;
        posicionesOcupadas = "";
        for (int XY = 0; XY < 3; XY++) {
            if (partida.juego[2 - XY][XY].getStorage() == jugador) {
                posicionesOcupadas = posicionesOcupadas + (2 - XY) + XY;
                control++;
                if (control > 1) {
                    puedoGanar = true;
                    jugadaGanadora = posicionesOcupadas;
                }
            }

        }
        if (puedoGanar) {
            return jugadaGanadora;
        } else {
            return "NONE";
        }
    }

    private String parsearGanar(String ganar) {
        int x1 = Integer.parseInt(ganar.substring(0, 1));
        int y1 = Integer.parseInt(ganar.substring(1, 2));
        int x2 = Integer.parseInt(ganar.substring(2, 3));
        int y2 = Integer.parseInt(ganar.substring(3, 4));
        int x;
        int y;
        if (x1 == x2) {// Si corresponden al EjeX
            x = 10 + x1;
        } else {
            x = 10 + (3 - (x1 + x2));
        }
        if (y1 == y2) {// Si corresponden al EjeY
            y = y1;
        } else {
            y = 3 - (y1 + y2);
        }

        return ficha(x).toString() + (y + 1);
    }

    private String jugadaRandom() {
        boolean jugadaOK;
        int PCX;
        int PCY;
        do {
            PCX = (int) Math.floor(Math.random() * 3);
            PCY = (int) Math.floor(Math.random() * 3);
            jugadaOK = casillaDisponiblePC(PCX, PCY);
        } while (!jugadaOK);
        return ficha(PCX + 10).toString() + (PCY + 1);
    }
}
