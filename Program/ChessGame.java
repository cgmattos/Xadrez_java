package Program;

import Jogo.*;

public class ChessGame {

    public static void main(String[] args) {
        Partida partida = new Partida();
        UI.printTabuleiro(partida.getPecas());
    }

}