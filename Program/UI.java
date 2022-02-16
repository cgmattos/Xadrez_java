package Program;

import Jogo.PosicaoXadrez;
import Tabuleiro.PecaXadrez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    public static void printTabuleiro(PecaXadrez[][] pecas){
        System.out.println("    -----------------");
        for (int i = 0; i<pecas.length;i++){
            System.out.print((8-i)+" "+" | ");
            for (int j = 0;j<pecas.length;j++){
                printPeca(pecas[i][j], false);
            }
            System.out.print("| ");
            System.out.println();
        }
        System.out.println("    -----------------");
        System.out.println("     a b c d e f g h");
    }
    
    public static void printTabuleiro(PecaXadrez[][] pecas, boolean[][] movimentosPossiveis){
        System.out.println("    -----------------");
        for (int i = 0; i<pecas.length;i++){
            System.out.print((8-i)+" "+" | ");
            for (int j = 0;j<pecas.length;j++){
                printPeca(pecas[i][j], movimentosPossiveis[i][j]);
            }
            System.out.print("| ");
            System.out.println();
        }
        System.out.println("    -----------------");
        System.out.println("     a b c d e f g h");
    }

    private static void printPeca(PecaXadrez peca, boolean corFundo){
        if (corFundo){
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (peca == null){
            System.out.print("-"+ANSI_RESET);
        }
        else{
            System.out.print(peca);
        }
        System.out.print(" ");
    }

    public static PosicaoXadrez lerPosicaoXadrez(Scanner sc){
        try {
            String pos = sc.next();
            char coluna = pos.charAt(0);
            int linha = Integer.parseInt(pos.substring(1));
            return new PosicaoXadrez(linha, coluna);
        }
        catch(RuntimeException e){
            throw new InputMismatchException("Entrada de dados incorreta. Favor digitar no formato correto. ex: a1");
        }
    } 

    public static void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
