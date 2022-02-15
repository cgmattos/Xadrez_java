package Jogo;

import Tabuleiro.*;

public class Partida {
    
    private Tabuleiro tabuleiro;

    public Partida(){
        this.tabuleiro = new Tabuleiro(8, 8);
        iniciarPartida();
    }

    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] aux = new PecaXadrez[this.tabuleiro.getLinha()][this.tabuleiro.getColuna()];
        for (int i = 0; i < this.tabuleiro.getLinha();i++){
            for (int j = 0; j<this.tabuleiro.getColuna();j++){
                aux[i][j] = (PecaXadrez) this.tabuleiro.peca(i,j);
            }
        }
        return aux;
    }

    private void iniciarPartida(){
        tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
        tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 3));

        tabuleiro.colocarPeca(new Rainha(tabuleiro, Cor.PRETO), new Posicao(0, 3));
        tabuleiro.colocarPeca(new Rainha(tabuleiro, Cor.BRANCO), new Posicao(7, 4));
    
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.PRETO), new Posicao(0, 7));
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.PRETO), new Posicao(0, 0));
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(7, 0));
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(7, 7));
    
        tabuleiro.colocarPeca(new Cavalo(tabuleiro, Cor.PRETO), new Posicao(0, 6));
        tabuleiro.colocarPeca(new Cavalo(tabuleiro, Cor.PRETO), new Posicao(0, 1));
        tabuleiro.colocarPeca(new Cavalo(tabuleiro, Cor.BRANCO), new Posicao(7, 1));
        tabuleiro.colocarPeca(new Cavalo(tabuleiro, Cor.BRANCO), new Posicao(7, 6));
        
        tabuleiro.colocarPeca(new Bispo(tabuleiro, Cor.PRETO), new Posicao(0, 5));
        tabuleiro.colocarPeca(new Bispo(tabuleiro, Cor.PRETO), new Posicao(0, 2));
        tabuleiro.colocarPeca(new Bispo(tabuleiro, Cor.BRANCO), new Posicao(7, 5));
        tabuleiro.colocarPeca(new Bispo(tabuleiro, Cor.BRANCO), new Posicao(7, 2));

        
    }
}
