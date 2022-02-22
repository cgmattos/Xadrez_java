package Jogo;

import Tabuleiro.PecaXadrez;
import Tabuleiro.Posicao;
import Tabuleiro.Tabuleiro;

public class Peao extends PecaXadrez {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    
    public Peao(Tabuleiro tabuleiro, Cor cor){
        super(tabuleiro, cor);
    }

    public String toString(){
        if (this.getCor()==Cor.PRETO){
            return ANSI_YELLOW+"P"+ANSI_RESET;
        }
        else{
            return "P";
        }
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] matriz = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];

        Posicao p = new Posicao(0, 0);

        if(getCor() == Cor.BRANCO){
            p.setValores(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() - 2, posicao.getColuna());
            Posicao aux = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p) && getTabuleiro().posicaoExiste(aux) && !getTabuleiro().temPeca(aux) && getContador() == 0){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
        
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
        
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
        }
        else{
            p.setValores(posicao.getLinha() + 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() + 2, posicao.getColuna());
            Posicao aux = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPeca(p) && getTabuleiro().posicaoExiste(aux) && !getTabuleiro().temPeca(aux) && getContador() == 0){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
        
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
        
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExiste(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
        }

        return matriz;
    }
}
