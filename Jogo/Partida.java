package Jogo;

import Tabuleiro.*;

public class Partida {
    
    private Tabuleiro tabuleiro;

    public Partida(){
        this.tabuleiro = new Tabuleiro(8, 8);
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
}
