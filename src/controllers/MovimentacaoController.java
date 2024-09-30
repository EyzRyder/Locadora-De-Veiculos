package controllers;

import entities.movimentacao.Movimentacao;

import java.util.List;

public class MovimentacaoController {

    public static void inserirMovimentacao(RepositorioController repositorioController, Movimentacao movimentacao) {
        repositorioController.adicionarMovimentacao(movimentacao);
    }

    public static void listarMovimentacao (Movimentacao movimentacao) {
        System.out.println(
                "dataHoraMovimentacao=" + movimentacao.getDataHoraMovimentacao() +
                ", tipoMovimentacao=" + movimentacao.getTipoMovimentacao() +
                ", descricao='" + movimentacao.getDescricao() + '\'' +
                ", emailCliente='" + movimentacao.getEmailCliente() + '\'' +
                ", cnpjAgencia='" + movimentacao.getCnpjAgencia() + '\'' +
                ", placaVeiculo='" + movimentacao.getPlacaVeiculo() + '\''
        );
    }

    public static void listarTodasMovimentacoes(RepositorioController repositorioController) {
        List<Movimentacao> movimentacoes =  repositorioController.movimentacoes.getMovimentacoes();
        for (Movimentacao movimentacao : movimentacoes){
            listarMovimentacao(movimentacao);
        }
    }

    public static void listarMovimentacoesAgencia(RepositorioController repositorioController, String cnpjAgencia) {
        List<Movimentacao> movimentacoes =  repositorioController.movimentacoes.getMovimentacoesPorAgencia(cnpjAgencia);
        for (Movimentacao movimentacao : movimentacoes){
            listarMovimentacao(movimentacao);
        }
    }

    public static void listarMovimentacoesCliente(RepositorioController repositorioController) {
        List<Movimentacao> movimentacoes =  repositorioController.movimentacoes.getMovimentacoesPorAgencia(repositorioController.usuarioAtual.getEmail());
        for (Movimentacao movimentacao : movimentacoes){
            listarMovimentacao(movimentacao);
        }
    }

}
