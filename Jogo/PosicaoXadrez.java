package Jogo;

import Tabuleiro.Posicao;

public class PosicaoXadrez {
    
    private char coluna; 
    private int linha;

    public PosicaoXadrez(int linha, char coluna){
        if (coluna<'a' || coluna>'h'||linha<1||linha>8){
            throw new XadrezException("A posição não existe.");
        }
        this.linha = linha;
        this.coluna = coluna;
    }

    public char getColuna(){
        return this.coluna;
    }

    public int getLinha(){
        return this.linha;
    }

    protected Posicao converterPosicao(){
        return new Posicao(8-this.linha, this.coluna - 'a');
    }

    public static PosicaoXadrez converterPosicaoXadrez(Posicao posicao){
        return new PosicaoXadrez(8 - posicao.getLinha(), (char)('a' + posicao.getColuna()));
    }

    @Override
    public String toString(){
        return "" + this.coluna + this.linha;
    }

}
