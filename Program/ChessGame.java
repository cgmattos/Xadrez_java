package Program;

import java.util.Scanner;

import Jogo.*;
import Tabuleiro.PecaXadrez;

public class ChessGame {

    public static void main(String[] args) {
        System.out.println("Começou a partida");
        Scanner sc = new Scanner(System.in);

        Partida partida = new Partida();
        while (true){
            UI.printTabuleiro(partida.getPecas());
            System.out.println();

            System.out.println("Posição da peça que será mexida: ");
            PosicaoXadrez pos = UI.lerPosicaoXadrez(sc);
            System.out.println(pos);
            
            System.out.println("Posição para onde a peça será mexida: ");
            PosicaoXadrez posFutura = UI.lerPosicaoXadrez(sc);
            System.out.println();

            PecaXadrez capturada = partida.moverPeca(pos, posFutura);
        }
    }
}