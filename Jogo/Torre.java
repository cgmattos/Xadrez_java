package Jogo;

import Tabuleiro.PecaXadrez;
import Tabuleiro.Tabuleiro;

public class Torre extends PecaXadrez {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    
    public Torre(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
        if (this.getCor()==Cor.PRETO){
            return ANSI_YELLOW+"T"+ANSI_RESET;
        }
        else{
            return "T";
        }
    }
}
