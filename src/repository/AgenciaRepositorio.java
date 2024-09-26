package repository;

import entities.agencia.Agencia;
import exception.ObjetoNaoEncontradoException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositorio {

    private final List<Agencia> agencias;
    private final String arquivo = "agencias.dat";

    public AgenciaRepositorio() {
        this.agencias = new ArrayList<>();
        loadData();
    }

    public void addAgencia(Agencia agencia) {
        agencias.add(agencia);
        saveData();
    }

    public void dropAgencia(String cnpj) throws ObjetoNaoEncontradoException {
        Agencia agencia = findAgenciaByCNPJ(cnpj);
        if (agencia == null) {
            throw new ObjetoNaoEncontradoException("Agência não encontrada.");
        }
        agencias.remove(agencia);
        saveData();
    }

    public List<Agencia> listAgencias() {
        return agencias;
    }

    public Agencia findAgenciaByCNPJ(String cnpj) {
        for (Agencia agencia : agencias) {
            if (agencia.getCnpj().equalsIgnoreCase(cnpj)) {
                return agencia;
            }
        }
        return null;
    }

    public void updateAgencia(String cnpj, Agencia agenciaAtualizada) throws ObjetoNaoEncontradoException {
        Agencia agenciaExistente = findAgenciaByCNPJ(cnpj);
        if (agenciaExistente == null) {
            throw new ObjetoNaoEncontradoException("Agencia");
        }
        int index = agencias.indexOf(agenciaExistente);
        agencias.set(index, agenciaAtualizada);
        saveData();
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
}
