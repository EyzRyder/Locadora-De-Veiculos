package repository;

import entities.agencia.Agencia;
import exception.ObjetoNaoEncontradoException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositorio implements Repositorio<Agencia>{

    private final List<Agencia> agencias;
    private final String arquivo = "agencias.dat";

    public AgenciaRepositorio() {
        this.agencias = new ArrayList<>();
        loadData();
    }

    public void addAgencia(Agencia agencia) {
        add(agencia);
    }

    public void dropAgencia(Agencia agencia) throws ObjetoNaoEncontradoException {
        delete(agencia);
    }

    public List<Agencia> listAgencias() {
        return agencias;
    }

    public Agencia findAgenciaByCNPJ(String cnpj) {
        return find(cnpj);
    }

    public void updateAgencia(Agencia agenciaAtualizada) {
        update(agenciaAtualizada);

    }

    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(agencias);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            agencias.clear();
            agencias.addAll((List<Agencia>) ois.readObject());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }

    @Override
    public Agencia find(String key) {
        for (Agencia agencia : agencias) {
            if (agencia.getCnpj().equalsIgnoreCase(key)) {
                return agencia;
            }
        }
        return null;
    }

    @Override
    public void update(Agencia item) {
        int index = agencias.indexOf(item);
        agencias.set(index, item);
        saveData();
    }

    @Override
    public void add(Agencia item) {
        agencias.add(item);
        saveData();
    }

    @Override
    public void delete(Agencia item) {
        agencias.remove(item);
        saveData();
    }
}
