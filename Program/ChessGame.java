package Program;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Jogo.*;
import Tabuleiro.PecaXadrez;

public class ChessGame {

    public static void main(String[] args) {
        System.out.println("Começou a partida");
        Scanner sc = new Scanner(System.in);
        Partida partida = new Partida();
        List<PecaXadrez> capturadas = new ArrayList<>();

        while (true){
            try{
                UI.printPartida(partida, capturadas);
                System.out.println();
                System.out.println("Posição da peça que será mexida:");
                PosicaoXadrez pos = UI.lerPosicaoXadrez(sc);

                boolean[][] movimentosPossiveis = partida.movimentosPossiveis(pos);
                UI.limparTela();
                UI.printTabuleiro(partida.getPecas(), movimentosPossiveis); 
                
                System.out.println("Posição para onde a peça será mexida:");
                PosicaoXadrez posFutura = UI.lerPosicaoXadrez(sc);
                PecaXadrez capturada = partida.moverPeca(pos, posFutura);

                if (capturada != null){
                    capturadas.add(capturada);
                }
            }
            catch (XadrezException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            sc.nextLine();
            UI.limparTela();
            
        }   
    }
}