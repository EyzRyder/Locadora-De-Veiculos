package exception;

public class ObjetoNaoEncontradoException extends Exception {
    public ObjetoNaoEncontradoException(String mensagem) {
        super(mensagem + " não foi encontrado(a).");
    }
}
