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

    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(linha, coluna).converterPosicao());
    }

    public void removerPeca(char coluna, int linha){
        tabuleiro.removerPeca(new PosicaoXadrez(linha, coluna).converterPosicao());
    }

    private void iniciarPartida(){
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));

        colocarNovaPeca('e', 8, new Rainha(tabuleiro, Cor.PRETO));
        colocarNovaPeca('d', 1, new Rainha(tabuleiro, Cor.BRANCO));
    
        colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('h', 1, new Torre(tabuleiro, Cor.BRANCO));
    
        colocarNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.PRETO));
        colocarNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.PRETO));
        colocarNovaPeca('g', 1, new Cavalo(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('b', 1, new Cavalo(tabuleiro, Cor.BRANCO));
        
        colocarNovaPeca('f', 8, new Bispo(tabuleiro, Cor.PRETO));
        colocarNovaPeca('c', 8, new Bispo(tabuleiro, Cor.PRETO));
        colocarNovaPeca('f', 1, new Bispo(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('c', 1, new Bispo(tabuleiro, Cor.BRANCO));

        for(int peca = 0; peca < tabuleiro.getColuna(); peca++){
            tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.PRETO), new Posicao(1, peca));
            tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(6, peca));

        }

        
    }
}
