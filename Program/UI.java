package Program;

import Jogo.Cor;
import Jogo.Partida;
import Jogo.PosicaoXadrez;

import Tabuleiro.PecaXadrez;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    public static void printPartida(Partida partida, List<PecaXadrez> capturadas){
        printTabuleiro(partida.getPecas());
        System.out.println();
        printPecasCapturadas(capturadas);
        System.out.println();
        if (!partida.getCheckmate()){
            System.out.println("Turno: "+partida.getTurno()+" | "+"Jogador: "+partida.getJogadorAtual());
            if (partida.getCheck() == true){
                System.out.println("Jogador, você está em CHECK.");
            }
        }
        else{
            System.out.println("CHEKCMATE!");
            System.out.println("O "+partida.getJogadorAtual()+" foi o vencedor");
        }
    }

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
            System.out.print(peca+ANSI_RESET);
        }
        System.out.print(" "+ANSI_RESET);
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

    private static void printPecasCapturadas(List<PecaXadrez> capturadas){
        List<PecaXadrez> pretas = capturadas.stream().filter(x -> x.getCor() == Cor.PRETO).collect(Collectors.toList());
        List<PecaXadrez> brancas = capturadas.stream().filter(x -> x.getCor() == Cor.BRANCO).collect(Collectors.toList());
        System.out.println("Pecas capturadas: ");
        System.out.print("Pretas: ");
        System.out.print(Arrays.toString(pretas.toArray()));
        System.out.println(TEXT_RESET);

        System.out.print("Brancas: ");
        System.out.print(TEXT_WHITE);
        System.out.print(Arrays.toString(brancas.toArray()));
        System.out.println(TEXT_RESET);
    }
}
