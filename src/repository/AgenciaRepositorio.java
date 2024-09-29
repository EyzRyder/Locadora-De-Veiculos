package repository;

import entities.agencia.Agencia;
import exception.ObjetoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRepositorio implements Repositorio<Agencia> {

    private final List<Agencia> agencias;
    private final String arquivo = "agencias.dat";

    public AgenciaRepositorio() {
        this.agencias = new ArrayList<>();
        loadData(arquivo, agencias);
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

    public int quantidadeAgencias() {
        return agencias.size();
    }

    public Agencia find(int index) {
        return agencias.get(index);
    }

    @Override
    public Agencia find(String cnpj) {
        for (Agencia agencia : agencias) {
            if (agencia.getCnpj().equalsIgnoreCase(cnpj)) {
                return agencia;
            }
        }
        return null;
    }

    @Override
    public void update(Agencia item) {
        int index = agencias.indexOf(item);
        agencias.set(index, item);
        saveData(arquivo, agencias);
    }

    @Override
    public void add(Agencia item) {
        agencias.add(item);
        saveData(arquivo, agencias);
    }

    @Override
    public void delete(Agencia item) {
        agencias.remove(item);
        saveData(arquivo, agencias);
    }
}
