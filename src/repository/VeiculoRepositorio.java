package repository;

import entities.veiculo.Veiculo;
import exception.InstanciaInvalidaException;
import exception.ObjetoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepositorio extends Repositorio {

    private final List<Veiculo> veiculos;

    public VeiculoRepositorio() {
        veiculos = new ArrayList<>();
    }

    @Override
    public Veiculo getOne() {
        return veiculos.getFirst();
    }

    @Override
    public List<Veiculo> getAll() {
        return veiculos;
    }

    @Override
    public Veiculo add(Object objeto) throws InstanciaInvalidaException {
        if (objeto instanceof Veiculo veiculo) {
            veiculos.add(veiculo);
            return veiculo;
        }
        throw new InstanciaInvalidaException("Instancia invalida, necessário um veiculo.");
    }

    @Override
    public Veiculo delete(Object objeto) throws ObjetoNaoEncontradoException, InstanciaInvalidaException {
        if (objeto instanceof Veiculo veiculo) {
            if (!veiculos.remove(veiculo)) {
                throw new ObjetoNaoEncontradoException();
            }
            return veiculo;
        }
        throw new InstanciaInvalidaException("Instancia invalida, necessário um veiculo.");
    }

}
