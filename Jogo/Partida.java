package Jogo;

import java.util.ArrayList;
import Tabuleiro.*;
import java.util.List;
import java.util.stream.Collectors;

public class Partida {
    
    private Tabuleiro tabuleiro;
    private int turno;
    private Cor jogadorAtual;
    private boolean check;
    private boolean checkmate;

    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();


    public Partida(){
        this.turno = 1;
        this.tabuleiro = new Tabuleiro(8, 8);
        this.jogadorAtual = Cor.BRANCO;
        iniciarPartida();
    }

    public int getTurno(){
        return this.turno;
    }

    public boolean getCheckmate(){
        return this.checkmate;
    }

    public Cor getJogadorAtual(){
        return this.jogadorAtual;
    }

    public boolean getCheck(){
        return check;
    }

    private void proximoTurno(){
        this.turno ++;
        if (this.jogadorAtual == Cor.BRANCO){
            this.jogadorAtual = Cor.PRETO;
        }
        else{
            this.jogadorAtual = Cor.BRANCO;
        }
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

    public boolean[][] movimentosPossiveis(PosicaoXadrez posOrigem){
        Posicao posicao = posOrigem.converterPosicao();
        validarPosicaoAtual(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }

    public PecaXadrez moverPeca(PosicaoXadrez posicaoAtual, PosicaoXadrez posicaoFutura){
        Posicao posAtual = posicaoAtual.converterPosicao();
        Posicao posFutura = posicaoFutura.converterPosicao();
        validarPosicaoAtual(posAtual);
        validarPosicaoDestino(posAtual, posFutura);
        Peca pecaCapturada = fazerMovimento(posAtual, posFutura);
        
        if(estadoDeCheck(jogadorAtual) == true){
            desfazerMovimento(posAtual, posFutura, pecaCapturada);
            throw new XadrezException("Jogada inválida. O jogador está se colocando em check.");
        }

        if (estadoDeCheck(oponente(jogadorAtual))){
            this.check = true;
        }
        else{
            this.check = false;
        }

        if (testarCheckmate(oponente(jogadorAtual))){
            checkmate =  true;
        }
        else{
            proximoTurno();
        }
        
        return (PecaXadrez)pecaCapturada;
    }

    private Peca fazerMovimento(Posicao posicaoAtual, Posicao posicaoFutura){
        PecaXadrez p = (PecaXadrez)tabuleiro.removerPeca(posicaoAtual);
        p.aumentarContador();
        Peca capturada = tabuleiro.removerPeca(posicaoFutura);
        tabuleiro.colocarPeca(p, posicaoFutura);
        if (capturada != null){
            pecasNoTabuleiro.remove(capturada);
            pecasCapturadas.add(capturada);
        }
        return capturada;
    }

    private void desfazerMovimento(Posicao origem, Posicao destino, Peca capturada){
        PecaXadrez p = (PecaXadrez)tabuleiro.removerPeca(destino);
        p.diminuirContador();
        tabuleiro.colocarPeca(p, origem);
        if (capturada != null){
            tabuleiro.colocarPeca(capturada, destino);
            pecasCapturadas.remove(capturada);
            pecasNoTabuleiro.add(capturada);
        }
    }

    private void validarPosicaoAtual(Posicao posicao){
        if(!tabuleiro.temPeca(posicao)){
            throw new XadrezException("Não há uma peça nessa posição");
        }
        if(jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCor()){
            throw new XadrezException("O jogador está tentando mover uma peça que não o pertence");
        }
        if(!tabuleiro.peca(posicao).existeAlgumMovimento()){
            throw new XadrezException("A peça não possui movimentos possíveis");
        }
    }

    private void validarPosicaoDestino(Posicao inicial, Posicao destino){
        if(!tabuleiro.peca(inicial).possivelMovimento(destino)){
            throw new XadrezException("A peça escolhida não pode se mover para a posição de destino");
        }
    }

    private boolean estadoDeCheck(Cor cor){
        Posicao posRei = procurarRei(cor).getPosicaoXadrez().converterPosicao();
        List<Peca> pecasOponente = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
        for (Peca p : pecasOponente){
            boolean[][] matriz = p.movimentosPossiveis();
            if (matriz[posRei.getLinha()][posRei.getColuna()] == true){
                return true;
            }
        }
        return false;
    }

    private Cor oponente(Cor cor){
        if (cor == Cor.PRETO){
            return Cor.BRANCO;
        }
        else{
            return Cor.PRETO;
        }
    }

    private PecaXadrez procurarRei(Cor cor){
        List<Peca> lista = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
        for (Peca p : lista) {
            if (p instanceof Rei){
                return (PecaXadrez)p;
            }
        }
        throw new IllegalStateException("O Rei "+cor+" já foi eliminado.");
    }
    
    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(linha, coluna).converterPosicao());
        pecasNoTabuleiro.add(peca);
    }

    public void removerPeca(char coluna, int linha){
        tabuleiro.removerPeca(new PosicaoXadrez(linha, coluna).converterPosicao());
    }

    private boolean testarCheckmate(Cor cor){
        if(!estadoDeCheck(cor)){
            return false;
        }
        List<Peca> lista = pecasNoTabuleiro.stream().filter(x ->((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
        for(Peca p:lista){
            boolean[][] matriz = p.movimentosPossiveis();
            for (int i = 0; i < matriz.length; i++){
                for (int j = 0; j<matriz.length; j++){
                    if (matriz[i][j]){
                        Posicao origem = ((PecaXadrez)p).getPosicaoXadrez().converterPosicao();
                        Posicao destino = new Posicao(i, j);
                        Peca capturada = fazerMovimento(origem, destino);
                        boolean var = estadoDeCheck(cor);
                        desfazerMovimento(origem, destino, capturada);
                        if (var == false){
                            return false;
                        }
                    }
                }
            }
            
        }
        return true;
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

        /*for(int peca = 0; peca < tabuleiro.getColuna(); peca++){
            tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.PRETO), new Posicao(1, peca));
            tabuleiro.colocarPeca(new Peao(tabuleiro, Cor.BRANCO), new Posicao(6, peca));
        }*/
 
    }
}
