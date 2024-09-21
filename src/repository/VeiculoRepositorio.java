package repository;

import entities.veiculo.Veiculo;
import exception.ObjetoNaoEncontradoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VeiculoRepositorio implements Repositorio<Veiculo> {

    private final Map<String, Veiculo> veiculos;

    public VeiculoRepositorio() {
        veiculos = new HashMap<>();
    }

    @Override
    public Veiculo[] getAll() {
        return veiculos.values().toArray(new Veiculo[veiculos.size()]);
    }

    @Override
    public Veiculo find(String placa) {
        return veiculos.get(placa);
    }

    @Override
    public Veiculo update(String placa,Veiculo veiculo) {
        return veiculos.put(placa,veiculo);
    }

    @Override
    public Veiculo add(Veiculo veiculo)   {
        return veiculos.put(veiculo.getPlaca(),veiculo);

    }

    @Override
    public Veiculo delete(Veiculo veiculo) throws ObjetoNaoEncontradoException {
        Veiculo veiculoRemovido;
        if (!veiculos.containsKey(veiculo.getPlaca())) {
            throw new ObjetoNaoEncontradoException();
        }
        veiculoRemovido = veiculos.remove(veiculo.getPlaca());
        return veiculoRemovido;
    }

}
