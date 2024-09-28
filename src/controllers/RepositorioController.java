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

    public Cliente usuarioAtual;
    public ClienteRepositorio clientes;
    public AgenciaRepositorio agencias;
    public VeiculoRepositorio veiculos;

    public RepositorioController() {
        this.usuarioAtual = null;
        this.clientes = new ClienteRepositorio();
        this.agencias = new AgenciaRepositorio();
        this.veiculos = new VeiculoRepositorio();
    }

    //CLIENTE

    public void setUsuarioAtual(Cliente usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }

    public Cliente getUsuarioAtual() {
        return usuarioAtual;
    }

    public ModoExibir adicionarCliente(Cliente cliente) {
        if (cliente == null || clientes.find(cliente.getEmail()) != null) {
            System.out.println("Cliente ja existe.");
        } else {
            clientes.add(cliente);
        }
        return ModoExibir.CADASTRARCLIENTE;
    }

    public ModoExibir alterarCliente(Cliente cliente) {
        if (cliente == null || clientes.find(cliente.getEmail()) != null) {
            System.out.println("Cliente inexistente.");
        } else {
            clientes.update(cliente);
        }
        return ModoExibir.ADMIN;
    }

    //AGENCIA

    public ModoExibir adicionarAgencia(Agencia agencia) {
        if (agencia == null || agencias.findAgenciaByCNPJ(agencia.getCnpj()) != null) {
            System.out.println("Agência já existe.");
        } else {
            agencias.addAgencia(agencia);
            System.out.println("Agência adicionada com sucesso.");
        }
        return ModoExibir.ADMIN;
    }

    public ModoExibir removerAgencia(Agencia agencia) throws ObjetoNaoEncontradoException {
        agencias.dropAgencia(agencia);
        System.out.println("Agência removida com sucesso.");

        return ModoExibir.ADMIN;
    }

    public ModoExibir alterarAgencia(Agencia agencia)  {
        agencias.updateAgencia(agencia);
        System.out.println("Agência alterada com sucesso.");

        return ModoExibir.ADMIN;
    }

    //VEÍCULO

    public ModoExibir adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null || veiculos.findVeiculoByPlaca(veiculo.getPlaca()) != null) {
            System.out.println("Veículo já existe.");
        } else {
            veiculos.addVeiculo(veiculo);
            System.out.println("Veículo adicionado com sucesso.");
        }
        return ModoExibir.ADMIN;
    }

    public ModoExibir removerVeiculo(Veiculo veiculo) {
        veiculos.dropVeiculo(veiculo);
        System.out.println("Veículo removido com sucesso.");

        return ModoExibir.ADMIN;
    }

    public ModoExibir alterarVeiculo(Veiculo veiculo) {
        veiculos.updateVeiculo(veiculo);
        System.out.println("Veículo alterado com sucesso.");

        return ModoExibir.ADMIN;
    }
}
