package Jogo;

import Tabuleiro.PecaXadrez;
import Tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    
    public Rei(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    public String toString(){
        if (this.getCor()==Cor.PRETO){
            return ANSI_YELLOW+"R"+ANSI_RESET;
        }
        else{
            return "R";
        }
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] matriz = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
        return matriz;
    }
}
