package Jogo;

public class XadrezException extends RuntimeException {

    private static final long serialVersionUID = 2L;

    public XadrezException(String mensagem){
        super(mensagem);
    }
}
