package repository;

import exception.InstanciaInvalidaException;
import exception.ObjetoNaoEncontradoException;

import java.util.List;
import java.util.Map;

public interface Repositorio<T> {

    T[] getAll();

    T find(String key);

    T update(String key, T item);

    T add(T item);

    T delete(T item) throws ObjetoNaoEncontradoException;

}
