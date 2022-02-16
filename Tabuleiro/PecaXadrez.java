package Tabuleiro;

import Jogo.*;

public abstract class PecaXadrez extends Peca {

    private Cor cor;
    
    public PecaXadrez(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor(){
        return this.cor;
    }

    public void setCor(Cor cor){
        this.cor = cor;
    }
}
