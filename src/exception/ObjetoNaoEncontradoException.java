package exception;

public class ObjetoNaoEncontradoException extends Exception {
    public ObjetoNaoEncontradoException() {
        super("Objeto não foi encontrado.");
    }
}
