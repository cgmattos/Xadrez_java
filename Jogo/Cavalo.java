package Jogo;

import Jogo.*;
import Tabuleiro.PecaXadrez;
import Tabuleiro.Tabuleiro;

public class Cavalo extends PecaXadrez {
    
    public Cavalo(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
        return "C";
    }
}
