package repository;

import entities.veiculo.Veiculo;

import java.io.*;
import java.util.ArrayList;

public class VeiculoRepositorio implements Repositorio<Veiculo> {
    private ArrayList<Veiculo> veiculos;
    private final String arquivo = "veiculos.dat";

    public VeiculoRepositorio() {
        veiculos = new ArrayList<>();
        loadData(arquivo, veiculos);
    }

    public void addVeiculo(Veiculo veiculo) {
        add(veiculo);
    }

    public void dropVeiculo(Veiculo veiculo) {
        delete(veiculo);
    }

    public ArrayList<Veiculo> listVeiculos() {
        return veiculos;
    }

    public Veiculo findVeiculoByPlaca(String placa) {
        return find(placa);
    }

    public void updateVeiculo(Veiculo veiculo) {
        update(veiculo);
    }

    @Override
    public Veiculo find(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    //TODO fazer o updateVeiculo
    @Override
    public void update(Veiculo veiculo) {

    }

    @Override
    public void add(Veiculo veiculo) {
        veiculos.add(veiculo);
        saveData(arquivo, veiculos);
    }

    @Override
    public void delete(Veiculo veiculo) {
        veiculos.remove(veiculo);
        saveData(arquivo, veiculos);
    }
}
