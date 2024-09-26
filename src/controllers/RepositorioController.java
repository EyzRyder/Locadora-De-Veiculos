package controllers;

import entities.agencia.Agencia;
import entities.cliente.Cliente;
import entities.veiculo.Veiculo;
import exception.ObjetoNaoEncontradoException;
import repository.AgenciaRepositorio;
import repository.ClienteRepositorio;
import repository.VeiculoRepositorio;
import util.ModoExibir;

public class RepositorioController {

    public ClienteRepositorio clientes;
    public AgenciaRepositorio agencias;
    public VeiculoRepositorio veiculos;

    public RepositorioController() {
        this.clientes = new ClienteRepositorio();
        this.agencias = new AgenciaRepositorio();
        this.veiculos = new VeiculoRepositorio();
    }

    //CLIENTE

    public ModoExibir adicionarCliente(Cliente cliente) {
        if (cliente == null || clientes.find(cliente.getEmail()) != null) {
            System.out.println("Cliente ja existe.");
        } else {
            clientes.add(cliente);
        }
        return ModoExibir.PRINCIPAL;
    }

    public ModoExibir alterarCliente(Cliente cliente) {
        if (cliente == null || clientes.find(cliente.getEmail()) != null) {
            System.out.println("Cliente inexistente.");
        } else {
            clientes.update(cliente.getEmail(), cliente);
        }
        return ModoExibir.PRINCIPAL;
    }

    //AGENCIA

    public ModoExibir adicionarAgencia(Agencia agencia) {
        if (agencia == null || agencias.findAgenciaByCNPJ(agencia.getCnpj()) != null) {
            System.out.println("Agência já existe.");
        } else {
            agencias.addAgencia(agencia);
            System.out.println("Agência adicionada com sucesso.");
        }
        return ModoExibir.PRINCIPAL;
    }

    public ModoExibir removerAgencia(Agencia agencia) throws ObjetoNaoEncontradoException {
        agencias.dropAgencia(agencia.getCnpj());
        System.out.println("Agência removida com sucesso.");

        return ModoExibir.PRINCIPAL;
    }

    public ModoExibir alterarAgencia(Agencia agencia) throws ObjetoNaoEncontradoException {
        agencias.updateAgencia(agencia.getCnpj(), agencia);
        System.out.println("Agência alterada com sucesso.");

        return ModoExibir.PRINCIPAL;
    }

    //VEÍCULO

    public ModoExibir adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null || veiculos.findVeiculoByPlaca(veiculo.getPlaca()) != null) {
            System.out.println("Veículo já existe.");
        } else {
            veiculos.addVeiculo(veiculo);
            System.out.println("Veículo adicionado com sucesso.");
        }
        return ModoExibir.PRINCIPAL;
    }

    public ModoExibir removerVeículo(Veiculo veiculo) throws ObjetoNaoEncontradoException {
        veiculos.dropVeiculo(veiculo.getPlaca());
        System.out.println("Veículo removido com sucesso.");

        return ModoExibir.PRINCIPAL;
    }

    public ModoExibir alterarVeiculo(Veiculo veiculo) throws ObjetoNaoEncontradoException {
        veiculos.updateVeiculo(veiculo.getPlaca());
        System.out.println("Veículo alterado com sucesso.");

        return ModoExibir.PRINCIPAL;
    }
}
