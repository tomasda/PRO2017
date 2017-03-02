package com;

import arrays.Juego;
import com.utils.LoadProperties;
import com.utils.Utils;

/**
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    Utils utils = new Utils();
    LoadProperties property = new LoadProperties();

    public void run() {
        Juego partida;
        String jugada;
        int numJugadas;
        int ganador;
        String nuevaPartida;
        int opcion;
        do {
            utils.limpiarConsola();
            partida = new Juego();
            partida.partida();
            jugada = "";
            numJugadas = 9;
            ganador = 0;
            partida.tresEnRaya();
            opcion = partida.modoJuego();
            if (opcion == 1) {
                utils.limpiarConsola();
                partida.solicitarNombreJugador();
            }
            if (opcion == 2) {
                utils.limpiarConsola();
                partida.solicitarNombreJugadores();
            }
            do {
                utils.limpiarConsola();
                partida.showJugadores();
                partida.showPartida();
                do {
                    jugada = partida.solicitarJugada();
                } while (!partida.casillaDisponibleJugador(jugada));
                partida.intdoucirJugadaYCambioJugador(jugada);
                ganador = partida.validarGanador();
                if (ganador != 0) {
                    numJugadas = -1;
                }
                numJugadas--;
            } while (numJugadas > 0);
            utils.limpiarConsola();
            partida.ganador(ganador);
            partida.showPartida();
            nuevaPartida = partida.nuevaPartida();
        } while (nuevaPartida.equals("S"));
    }
}
