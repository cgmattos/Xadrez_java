package Jogo;

import Tabuleiro.PecaXadrez;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;

public class Rainha extends PecaXadrez {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    
    public Rainha(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
            if (this.getCor()==Cor.PRETO){
                return ANSI_YELLOW+"D"+ANSI_RESET;
            }
            else{
                return "D";
            }
        }

        @Override
        public boolean[][] movimentosPossiveis() {
            boolean[][] matriz = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
    
            Posicao p = new Posicao(0,0);
    
            p.setValores(posicao.getLinha()-1, posicao.getColuna());                    //Movimentos para cima
            while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
                p.setLinha(p.getLinha()-1);
            }
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
    
            p.setValores(posicao.getLinha()+1, posicao.getColuna());                    //Movimentos para baixo
            while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
                p.setLinha(p.getLinha()+1);
            }
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
    
            p.setValores(posicao.getLinha(), posicao.getColuna()-1);                    //Movimentos para esquerda
            while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
                p.setColuna(p.getColuna()-1);
            }
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
    
            p.setValores(posicao.getLinha(), posicao.getColuna()+1);                    //Movimentos para direita
            while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
                p.setColuna(p.getColuna()+1);
            }
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha()-1, posicao.getColuna()-1);                    //diagonal superior esquerda
            while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
                p.setValores(p.getLinha()-1, p.getColuna()-1);
            }
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha()-1, posicao.getColuna()+1);                    //diagonal superior direita
            while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
                p.setValores(p.getLinha()-1, p.getColuna()+1);
            }
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);                    //diagonal inferior esquerda
            while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
                p.setValores(p.getLinha()+1, p.getColuna()-1);
            }
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }

            p.setValores(posicao.getLinha()+1, posicao.getColuna()+1);                    //diagonal inferior direita
            while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
                p.setValores(p.getLinha()+1, p.getColuna()+1);
            }
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
    
            return matriz;
            
        }

}