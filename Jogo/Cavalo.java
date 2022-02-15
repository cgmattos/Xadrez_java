package Jogo;

import Tabuleiro.PecaXadrez;
import Tabuleiro.Tabuleiro;

public class Cavalo extends PecaXadrez {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    
    public Cavalo(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
        if (this.getCor()==Cor.PRETO){
            return ANSI_YELLOW+"C"+ANSI_RESET;
        }
        else{
            return "C";
        }
    }
}
