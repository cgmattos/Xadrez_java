package Jogo;

import Tabuleiro.PecaXadrez;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    
    public Rei(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    public String toString(){
        if (this.getCor()==Cor.PRETO){
            return ANSI_YELLOW+"R"+ANSI_RESET;
        }
        else{
            return "R";
        }
    }

    private boolean podeMover(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p == null || p.getCor() != getCor();
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] matriz = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
        Posicao p = new Posicao(0, 0);

        p.setValores(posicao.getLinha()-1, posicao.getColuna());                    //Movimento para cima
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }

        p.setValores(posicao.getLinha()+1, posicao.getColuna());                    //Movimento para baixo
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }

        p.setValores(posicao.getLinha(), posicao.getColuna()-1);                    //Movimento para esquerda
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }

        p.setValores(posicao.getLinha(), posicao.getColuna()+1);                    //Movimento para direita
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }

        p.setValores(posicao.getLinha()-1, posicao.getColuna()+1);                    //Movimento diagonal superior direita
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }

        p.setValores(posicao.getLinha()-1, posicao.getColuna()-1);                    //Movimento diagonal superior esquerda
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }

        p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);                    //Movimento diagonal inferior esquerda
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }

        p.setValores(posicao.getLinha()+1, posicao.getColuna()+1);                    //Movimento diagonal inferior esquerda
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }

        return matriz;
    }
}
