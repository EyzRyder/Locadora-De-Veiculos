package repository;

import entities.veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepositorio implements Repositorio<Veiculo> {
    private final List<Veiculo> veiculos;
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

    public List<Veiculo> listVeiculos() {
        return veiculos;
    }

    public Veiculo findVeiculoByPlaca(String placa) {
        return find(placa);
    }

    public void updateVeiculo(Veiculo veiculo) {
        update(veiculo);
    }

    public int quantidadeVeiculos() {
        return veiculos.size();
    }

    public Veiculo find(int index) {
        return veiculos.get(index);
    }

    public List<Veiculo> listarVeiculosPorCNPJAgencia(String cnpj){
        List<Veiculo> veiculosFiltrado = new ArrayList<>();
        for(Veiculo veiculo: veiculos){
            if (veiculo.getAgenciaCNPJ().equalsIgnoreCase(cnpj)){
                veiculosFiltrado.add(veiculo);
            }
        }
        return veiculosFiltrado;
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
        saveData(arquivo, veiculos);
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
