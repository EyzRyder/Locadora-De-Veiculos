package repository;

import entities.cliente.Cliente;
import entities.movimentacao.Movimentacao;
import exception.ObjetoNaoAlteravelException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MovimentacaoRepositorio implements Repositorio<Movimentacao> {

    private final List<Movimentacao> movimentacoes;
    private final String arquivo = "movimentacoes.dat";

    public MovimentacaoRepositorio() {
        movimentacoes = new ArrayList<>();
        loadData(arquivo, movimentacoes);
    }

    public Collection<Movimentacao> getAll() {
        return movimentacoes;
    }

    @Override
    public Movimentacao find(String key) {
        return null;
    }

    @Override
    public void update(Movimentacao item) throws ObjetoNaoAlteravelException {
        throw new ObjetoNaoAlteravelException();
    }

    @Override
    public void add(Movimentacao item) {
        movimentacoes.add(item);
        saveData(arquivo, movimentacoes);
    }

    @Override
    public void delete(Movimentacao item) {

    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }


    public List<Movimentacao> getMovimentacoesPorEmailCliente(String email) {
        List<Movimentacao> movimentacoes = new ArrayList<>();
        for (Movimentacao movimentacao : this.movimentacoes) {
            if (movimentacao.getEmailCliente().equals(email)) {
                movimentacoes.add(movimentacao);
            }
        }
        return movimentacoes;
    }

    public List<Movimentacao> getMovimentacoesPorAgencia(String cnpjAgencia) {
        List<Movimentacao> movimentacoes = new ArrayList<>();
        for (Movimentacao movimentacao : this.movimentacoes) {
            if (movimentacao.getCnpjAgencia().equals(cnpjAgencia)) {
                movimentacoes.add(movimentacao);
            }
        }
        return movimentacoes;
    }

}
