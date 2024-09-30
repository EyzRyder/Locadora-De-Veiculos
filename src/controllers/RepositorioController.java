package controllers;

import entities.agencia.Agencia;
import entities.cliente.Admin;
import entities.cliente.Cliente;
import entities.movimentacao.Movimentacao;
import entities.veiculo.Caminhao;
import entities.veiculo.Carro;
import entities.veiculo.Moto;
import entities.veiculo.Veiculo;
import exception.ObjetoNaoEncontradoException;
import repository.AgenciaRepositorio;
import repository.ClienteRepositorio;
import repository.MovimentacaoRepositorio;
import repository.VeiculoRepositorio;
import util.ModoExibir;

public class RepositorioController {

    public Cliente usuarioAtual;
    public ClienteRepositorio clientes;
    public AgenciaRepositorio agencias;
    public VeiculoRepositorio veiculos;
    public MovimentacaoRepositorio movimentacoes;

    public RepositorioController() {
        this.usuarioAtual = null;
        this.clientes = new ClienteRepositorio();
        this.agencias = new AgenciaRepositorio();
        this.veiculos = new VeiculoRepositorio();
        this.movimentacoes = new MovimentacaoRepositorio();
        carregarDados();
    }

    private void carregarDados() {
        /*
        Cliente adm = new Admin("ADM", "(11)69504-6351", "adm@ada.com", "123muitoforte", "DEV");
        clientes.add(adm);
        Agencia agenciaPrincipal = new Agencia("80.968.812/0001-64", "Santader Locadora Ltda", "Santader Locadora");
        agencias.add(agenciaPrincipal);
         */
        /*
        Veiculo carro1 = new Carro("Fiat Movi", "MOBI", 2024, "Vermelho", agenciaPrincipal.getCnpj(), 4);
        veiculos.add(carro1);
        Veiculo carro2 = new Carro("Fiat Uno", "DBZ-GT", 1969, "Vermelho", agenciaPrincipal.getCnpj(), 4);
        veiculos.add(carro2);
        Veiculo moto = new Moto("Vespa", "FLCL", 2000, "Amarela", agenciaPrincipal.getCnpj(), 2);
        veiculos.add(moto);
        Veiculo caminhao = new Caminhao("Mack do Relampago Marquines", "95", 2006, "Vermelho", agenciaPrincipal.getCnpj(), 10, 10);
        veiculos.add(caminhao);
        */
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

    public ModoExibir removerAgencia(Agencia agencia) {
        if (agencia == null || agencias.findAgenciaByCNPJ(agencia.getCnpj()) == null) {
            System.out.println("Agência não encontrada.");
            return ModoExibir.ADMIN;
        }
        try {
            agencias.dropAgencia(agencia);
            System.out.println("Agência removida com sucesso.");
        } catch (ObjetoNaoEncontradoException e) {
            System.out.println("Erro: Agência não encontrada para remoção.");
        }

        return ModoExibir.ADMIN;
    }

    public ModoExibir alterarAgencia(Agencia agencia) {
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

    //MOVIMENTACÕES

    public void adicionarMovimentacao(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
    }

}
