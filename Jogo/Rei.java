package Jogo;

import Jogo.*;
import Tabuleiro.PecaXadrez;
import Tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez {
    
    public Rei(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
        return "R";
    }
}
