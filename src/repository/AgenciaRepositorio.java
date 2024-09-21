package repository;

import entities.agencia.Agencia;
import exception.InstanciaInvalidaException;
import exception.ObjetoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositorio implements Repositorio<Agencia> {

    private final List<Agencia> agencias;

    public AgenciaRepositorio() {
        this.agencias = new ArrayList<>();
    }

    @Override
    public Agencia[] getAll() {
        return agencias.toArray(new Agencia[agencias.size()]);
    }

    @Override
    public Agencia find(String key) {
        // TODO add try catch
        int index = Integer.parseInt(key);
        return agencias.get(index);
    }

    @Override
    public Agencia update(String key, Agencia agencia) {
        // TODO add try catch
        int index = Integer.parseInt(key);
        agencias.set(index, agencia);
        return agencia;
    }

    @Override
    public Agencia add(Agencia agencia) {
        agencias.add(agencia);
        return agencia;
    }

    @Override
    public Agencia delete(Agencia agencia) throws ObjetoNaoEncontradoException {
        if (!agencias.remove(agencia)) {
            throw new ObjetoNaoEncontradoException();
        }
        return agencia;
    }

}
