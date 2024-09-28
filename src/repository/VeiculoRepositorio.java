package repository;

import entities.veiculo.Veiculo;

import java.io.*;
import java.util.ArrayList;

public class VeiculoRepositorio implements Repositorio<Veiculo> {
    private ArrayList<Veiculo> veiculos;
    private final String arquivo = "veiculos.dat";

    public VeiculoRepositorio() {
        veiculos = new ArrayList<>();
        loadData();
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

    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(veiculos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            veiculos = (ArrayList<Veiculo>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
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
        saveData();
    }

    @Override
    public void delete(Veiculo veiculo) {
        veiculos.remove(veiculo);
        saveData();
    }
}
