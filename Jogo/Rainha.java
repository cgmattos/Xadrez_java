package Jogo;

import Jogo.*;
import Tabuleiro.PecaXadrez;
import Tabuleiro.Tabuleiro;

public class Rainha extends PecaXadrez {
    
    public Rainha(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
        return "D";
    }
}
