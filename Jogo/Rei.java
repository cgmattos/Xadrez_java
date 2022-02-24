package Jogo;

import Tabuleiro.PecaXadrez;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private Partida partida;
    
    public Rei(Tabuleiro tabuleiro, Cor cor, Partida partida){
        super(tabuleiro, cor);
        this.partida = partida;
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

    private boolean torreApta(Posicao pos){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(pos);
        if (p != null && p instanceof Torre && p.getCor() == this.getCor() && p.getContador() == 0){
            return true;
        }
        else{
            return false;
        }
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

        if(getContador() == 0 && !partida.getCheck()){
            Posicao t1 = new Posicao(this.posicao.getLinha(), this.posicao.getColuna()+3);
            if (torreApta(t1)){
                Posicao p1 = new Posicao(this.posicao.getLinha(), this.posicao.getColuna()+1);
                Posicao p2 = new Posicao(this.posicao.getLinha(), this.posicao.getColuna()+2);
                if (this.getTabuleiro().peca(p1) == null && this.getTabuleiro().peca(p2) == null){
                    matriz[this.posicao.getLinha()][this.posicao.getColuna()+3] = true;
                }
            }
        }
        
        if(getContador() == 0 && !partida.getCheck()){
            Posicao t2 = new Posicao(this.posicao.getLinha(), this.posicao.getColuna()-4);
            if (torreApta(t2)){
                Posicao p1 = new Posicao(this.posicao.getLinha(), this.posicao.getColuna()-1);
                Posicao p2 = new Posicao(this.posicao.getLinha(), this.posicao.getColuna()-2);
                Posicao p3 = new Posicao(this.posicao.getLinha(), this.posicao.getColuna()-3);
                if (this.getTabuleiro().peca(p1) == null && this.getTabuleiro().peca(p2) == null && this.getTabuleiro().peca(p3) == null){
                    matriz[this.posicao.getLinha()][this.posicao.getColuna()-2] = true;
                }
            }
        }

        return matriz;
    }
}
