package Tabuleiro;

public class Tabuleiro {
    
    private int linha;
    private int coluna;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas){
        if (linhas < 1 || colunas < 0){
            throw new TabuleiroException("O tabuleiro precisa de pelo menos uma linha e coluna");
        }
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

    public Peca peca(int linha, int coluna){
        if (!posicaoExiste(linha, coluna)){
            throw new TabuleiroException("Posição fora do tabuleiro.");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição fora do tabuleiro.");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao){
        if(temPeca(posicao)){
            throw new TabuleiroException("Já existe uma peça na posição."+" "+posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public void removerPeca(Posicao posicao){
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
    }

    private boolean posicaoExiste(int linha, int coluna){
        if (linha >=0 && linha < this.linha && coluna >=0 && coluna < this.coluna){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }

    public boolean temPeca(Posicao posicao){
        if (posicaoExiste(posicao)){
            if (this.pecas[posicao.getLinha()][posicao.getColuna()] == null){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            throw new TabuleiroException("A posição não existe.");
        }
    }
}
