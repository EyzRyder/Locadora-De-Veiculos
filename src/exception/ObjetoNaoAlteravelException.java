package exception;

public class ObjetoNaoAlteravelException extends Exception {
    public ObjetoNaoAlteravelException() {
        super("Não é possível alterar esse objeto.");
    }
}
