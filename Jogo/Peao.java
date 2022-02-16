package Jogo;

import Tabuleiro.PecaXadrez;
import Tabuleiro.Tabuleiro;

public class Peao extends PecaXadrez {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    
    public Peao(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    public String toString(){
        if (this.getCor()==Cor.PRETO){
            return ANSI_YELLOW+"P"+ANSI_RESET;
        }
        else{
            return "P";
        }
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] matriz = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
        return matriz;
    }
}
