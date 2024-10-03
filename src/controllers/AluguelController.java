package controllers;

import entities.agencia.Agencia;
import entities.cliente.Cliente;
import entities.cliente.ClientePF;
import entities.cliente.ClientePJ;
import entities.movimentacao.Movimentacao;
import entities.movimentacao.TipoMovimentacao;
import entities.veiculo.Veiculo;
import entities.veiculo.TipoVeiculo;
import util.Input;
import util.ModoExibir;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AluguelController {

    public static ModoExibir alugarVeiculo(RepositorioController repositorioController) {

        int agenciaIndex;
        String agenciaListPrompt = "";
        List<Integer> agenciaIndexList = new ArrayList<>();

        int veiculoIndex;
        String veiculoListarPrompt = "";
        List<Integer> veiculoIndexList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        if (repositorioController.agencias.quantidadeAgencias() < 1) {
            System.err.println("Não tem agência cadastrada para colocar o veículo. Volte quando houver uma agência cadastrada.\nAperte Enter para continuar");
            scanner.nextLine();
            return ModoExibir.CLIENTE;
        }

        agenciaListPrompt = AgenciaController.promptListarAgencias(repositorioController, agenciaIndexList);

        agenciaIndex = Input.getInt(agenciaListPrompt, scanner, agenciaIndexList);
        Agencia agenciaSelecionada = repositorioController.agencias.find(agenciaIndex);

        List<Veiculo> veiculosFiltrados = repositorioController.veiculos.listarVeiculosPorCNPJAgencia(agenciaSelecionada.getCnpj());

        if (veiculosFiltrados.isEmpty()) {
            System.err.println("Essa agência não tem um veículo cadastrado. Tente outra opção.\nAperte Enter para continuar");
            scanner.nextLine();
            return ModoExibir.CLIENTE;
        }

        veiculoListarPrompt = VeiculoController.promptListarVeiculos(veiculosFiltrados, veiculoIndexList);

        veiculoIndex = Input.getInt(veiculoListarPrompt, scanner, veiculoIndexList);
        Veiculo veiculoSelecionado = veiculosFiltrados.get(veiculoIndex);

        if (!veiculoSelecionado.isDisponivel()) {
            System.err.println("Este veículo já está alugado. Escolha outro.\nAperte Enter para continuar");
            scanner.nextLine();
            return ModoExibir.CLIENTE;
        }

        veiculoSelecionado.setDisponivel(false);

        Movimentacao aluguelHistorico = new Movimentacao(
                TipoMovimentacao.ALUGUEL, "Alugou um veículo.",
                repositorioController.getUsuarioAtual().getEmail(),
                agenciaSelecionada.getCnpj(), veiculoSelecionado.getPlaca()
        );
        MovimentacaoController.inserirMovimentacao(repositorioController, aluguelHistorico);

        System.out.println("Veículo alugado com sucesso!\nAperte Enter para continuar");
        scanner.nextLine();
        return ModoExibir.CLIENTE;
    }

    public static ModoExibir devolverVeiculo(RepositorioController repositorioController) {

        Cliente clienteDevolucao = repositorioController.getUsuarioAtual();

        int agenciaIndex;
        String agenciaListPrompt = "";
        List<Integer> agenciaIndexList = new ArrayList<>();

        int veiculoIndex;
        String veiculoListarPrompt = "";
        List<Integer> veiculoIndexList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        agenciaListPrompt = AgenciaController.promptListarAgencias(repositorioController, agenciaIndexList);

        agenciaIndex = Input.getInt(agenciaListPrompt, scanner, agenciaIndexList);
        Agencia agenciaSelecionada = repositorioController.agencias.find(agenciaIndex);

        List<Veiculo> veiculosFiltrados = repositorioController.veiculos.listarVeiculosPorCNPJAgencia(agenciaSelecionada.getCnpj());

        veiculoListarPrompt = VeiculoController.promptListarVeiculos(veiculosFiltrados, veiculoIndexList);

        veiculoIndex = Input.getInt(veiculoListarPrompt, scanner, veiculoIndexList);
        Veiculo veiculoSelecionado = veiculosFiltrados.get(veiculoIndex);

        if (veiculoSelecionado.isDisponivel()) {
            System.err.println("Este veículo não está alugado.\nAperte Enter para continuar");
            scanner.nextLine();
            return ModoExibir.CLIENTE;
        }

        // Simula a devolução e cálculo de valor
        LocalDateTime dataAluguel = LocalDateTime.now().minusDays(7);  // Exemplo de 7 dias alugados
        LocalDateTime dataDevolucao = LocalDateTime.now();
        long diasAlugados = Duration.between(dataAluguel, dataDevolucao).toDays();
        double valorTotal = diasAlugados * veiculoSelecionado.getTipoVeiculo().getValorDiaria();
        double desconto = 0;

        if (diasAlugados > 5 && clienteDevolucao instanceof ClientePF) {
            desconto = 0.05;
        } else if (diasAlugados > 3 && clienteDevolucao instanceof ClientePJ) {
            desconto = 0.1;
        }

        valorTotal -= valorTotal * desconto;

        veiculoSelecionado.setDisponivel(true);
        Movimentacao devolucaoHistorico = new Movimentacao(
                TipoMovimentacao.DEVOLUCAO, "Devolveu um veículo.",
                clienteDevolucao.getEmail(),
                agenciaSelecionada.getCnpj(), veiculoSelecionado.getPlaca()
        );
        MovimentacaoController.inserirMovimentacao(repositorioController, devolucaoHistorico);

        System.out.println("Veículo devolvido com sucesso! Valor total: R$ " + valorTotal + " com desconto de " + (desconto * 100) + "%\nAperte Enter para continuar");
        scanner.nextLine();
        return ModoExibir.CLIENTE;
    }

    public static ModoExibir consultarTodoHistorico(RepositorioController repositorioController) {
        MovimentacaoController.listarTodasMovimentacoes(repositorioController);
        return ModoExibir.CLIENTE;
    }


    public static ModoExibir consultarHistoricoCliente(RepositorioController repositorioController) {
        MovimentacaoController.listarMovimentacoesCliente(repositorioController);
        return ModoExibir.CLIENTE;
    }
}
