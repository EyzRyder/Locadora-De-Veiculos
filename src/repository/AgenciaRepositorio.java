package repository;

import entities.agencia.Agencia;
import exception.InstanciaInvalidaException;
import exception.ObjetoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositorio extends Repositorio {

    private final List<Agencia> agencias;

    public AgenciaRepositorio() {
        this.agencias = new ArrayList<>();
    }

    @Override
    public Agencia getOne() {
        return agencias.getFirst();
    }

    @Override
    public List<Agencia> getAll() {
        return agencias;
    }

    @Override
    public Agencia add(Object objeto) throws InstanciaInvalidaException {
        if (objeto instanceof Agencia agencia) {
            agencias.add(agencia);
            return agencia;
        }
        throw new InstanciaInvalidaException("Instancia invalida, necessário uma agencia.");
    }

    @Override
    public Agencia delete(Object objeto) throws InstanciaInvalidaException, ObjetoNaoEncontradoException {
        if (objeto instanceof Agencia agencia) {
            if(!agencias.remove(agencia)) {
                throw new ObjetoNaoEncontradoException();
            }
            return agencia;
        }
        throw new InstanciaInvalidaException("Instancia invalida, necessário uma agencia.");
    }

}
