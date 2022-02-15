package Jogo;

import Tabuleiro.TabuleiroException;

public class XadrezException extends TabuleiroException {

    private static final long serialVersionUID = 2L;

    public XadrezException(String mensagem){
        super(mensagem);
    }
}
