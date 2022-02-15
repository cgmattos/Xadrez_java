package Jogo;

import Jogo.*;
import Tabuleiro.PecaXadrez;
import Tabuleiro.Tabuleiro;

public class Bispo extends PecaXadrez {
    
    public Bispo(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
        return "B";
    }
}
