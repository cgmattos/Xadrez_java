package Program;

import java.util.InputMismatchException;
import java.util.Scanner;

import Jogo.*;
import Tabuleiro.PecaXadrez;

public class ChessGame {

    public static void main(String[] args) {
        System.out.println("Começou a partida");
        Scanner sc = new Scanner(System.in);
        Partida partida = new Partida();

        while (true){
            try{
                UI.printTabuleiro(partida.getPecas());
                System.out.println();
                System.out.println("Posição da peça que será mexida:");
                PosicaoXadrez pos = UI.lerPosicaoXadrez(sc);
                
                System.out.println("Posição para onde a peça será mexida:");
                PosicaoXadrez posFutura = UI.lerPosicaoXadrez(sc);
                PecaXadrez capturada = partida.moverPeca(pos, posFutura);
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