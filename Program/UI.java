package Program;

import Tabuleiro.PecaXadrez;

public class UI {

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
                printPeca(pecas[i][j]);
            }
            System.out.print("| ");
            System.out.println();
        }
        System.out.println("    -----------------");
        System.out.println("     a b c d e f g h");
    }

    private static void printPeca(PecaXadrez peca){
        if (peca == null){
            System.out.print("-");
        }
        else{
            System.out.print(peca);
        }
        System.out.print(" ");
    }
}
