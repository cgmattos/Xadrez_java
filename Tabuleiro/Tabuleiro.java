package Tabuleiro;
import Tabuleiro.Peca;

public class Tabuleiro {
    
    private int linha;
    private int coluna;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas){
        this.linha = linhas;
        this.coluna = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinha(){
        return this.linha;
    }

    public int getColuna(){
        return this.coluna;
    }

    public void setLinha(int linha){
        this.linha = linha;
    }

    public void setColuna(int coluna){
        this.coluna = coluna;
    }

    public Peca peca(int linha, int coluna){
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao){
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }
}
