package repository;

import exception.InstanciaInvalidaException;

public abstract class Repositorio {

    public abstract Object getOne();
    public abstract Object getAll();
    public abstract Object add(Object item) throws InstanciaInvalidaException;
    public abstract Object delete(Object id);

}
