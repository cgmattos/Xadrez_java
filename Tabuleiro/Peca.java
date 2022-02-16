package Tabuleiro;

public abstract class Peca {
    
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        this.posicao = null;
    }

    protected Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }

    public abstract boolean[][] movimentosPossiveis();

    public boolean possivelMovimento(Posicao posicao){
        return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
    }

    public boolean existeAlgumMovimento(){
        boolean[][] matriz = movimentosPossiveis();
        for (int i = 0; i<matriz.length;i++){
            for (int j = 0; j<matriz[0].length;j++){
                if (matriz[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "tabuleiro: "+this.tabuleiro+" Posição "+this.posicao;
    }
}
