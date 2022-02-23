package Jogo;

import Tabuleiro.PecaXadrez;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;

public class Cavalo extends PecaXadrez {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    
    public Cavalo(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
        if (this.getCor()==Cor.PRETO){
            return ANSI_YELLOW+"C"+ANSI_RESET;
        }
        else{
            return "C";
        }
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] matriz = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];

        Posicao p = new Posicao(0,0);

        p.setValores(posicao.getLinha()-2, posicao.getColuna()-1);                    
        if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha()-2, p.getColuna()-1);
        }
        
        p.setValores(posicao.getLinha()-2, posicao.getColuna()+1);                    //Movimentos para baixo
        if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha()-2, p.getColuna()+1);
        }

        p.setValores(posicao.getLinha()+2, posicao.getColuna()+1);                    //Movimentos para baixo
        if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha()+2, p.getColuna()+1);
        }

        p.setValores(posicao.getLinha()+2, posicao.getColuna()-1);                    //Movimentos para baixo
        if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha()+2, p.getColuna()-1);
        }

        p.setValores(posicao.getLinha()-1, posicao.getColuna()-2);                    //Movimentos para baixo
        if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha()-1, p.getColuna()-2);
        }

        p.setValores(posicao.getLinha()-1, posicao.getColuna()+2);                    //Movimentos para baixo
        if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha()-1, p.getColuna()+2);
        }

        p.setValores(posicao.getLinha()+1, posicao.getColuna()+2);                    //Movimentos para baixo
        if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha()+1, p.getColuna()+2);
        }

        p.setValores(posicao.getLinha()+1, posicao.getColuna()-2);                    //Movimentos para baixo
        if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha()+1, p.getColuna()-2);
        }

        return matriz;
        
    }
}
