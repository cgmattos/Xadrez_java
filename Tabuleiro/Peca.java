package Tabuleiro;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;

public class Peca {
    
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        this.posicao = null;
    }

    protected Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }
}
