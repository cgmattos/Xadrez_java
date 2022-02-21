package Tabuleiro;

import Jogo.PosicaoXadrez;
import Jogo.*;

public abstract class PecaXadrez extends Peca {

    private Cor cor;
    private int contador;
    
    public PecaXadrez(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor(){
        return this.cor;
    }

    public int getContador(){
        return this.contador;
    }

    public void aumentarContador(){
        this.contador++;
    }

    public void diminuirContador(){
        this.contador--;
    }

    public void setCor(Cor cor){
        this.cor = cor;
    }

    protected boolean existePecaOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p != null && p.getCor() != this.cor;
    }

    public PosicaoXadrez getPosicaoXadrez(){
        System.out.println(this.posicao);
        return PosicaoXadrez.converterPosicaoXadrez(this.posicao);
    }
}
