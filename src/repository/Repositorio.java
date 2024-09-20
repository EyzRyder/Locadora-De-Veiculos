package repository;

import exception.InstanciaInvalidaException;
import exception.ObjetoNaoEncontradoException;

public abstract class Repositorio {

    public abstract Object getOne();
    public abstract Object getAll();
    public abstract Object add(Object item) throws InstanciaInvalidaException;
    public abstract Object delete(Object id) throws ObjetoNaoEncontradoException, InstanciaInvalidaException;

}
