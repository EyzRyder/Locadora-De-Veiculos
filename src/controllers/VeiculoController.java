package controllers;

import entities.agencia.Agencia;
import entities.veiculo.*;
import util.Input;
import util.ModoExibir;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VeiculoController {

    public static ModoExibir cadastrarVeiculo(RepositorioController repositorioController, TipoVeiculo tipoVeiculo) {

        String modelo;
        String placa;
        int ano;
        String cor;
        Veiculo veiculo;

        int agenciaIndex;
        String agenciaListPrompt = "";
        List<Integer> agenciaIndexList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        if (repositorioController.agencias.quantidadeAgencias() < 1) {
            System.err.println("Não tem agencia cadastrada para colocar o veiculo, volte quando tiver alguma agencia cadastrada\nAperte Enter pra continuar");
            scanner.nextLine();
            return ModoExibir.ADMIN;
        }

        modelo = Input.getString("Digite o modelo:", scanner);
        placa = Input.getString("Digite o placa:", scanner);
        ano = Input.getInt("Digite o ano:", scanner);
        cor = Input.getString("Digite o cor:", scanner);

        agenciaListPrompt = AgenciaController.promptListarAgencias(repositorioController, agenciaIndexList);

        agenciaIndex = Input.getInt(agenciaListPrompt, scanner, agenciaIndexList);
        Agencia agenciaSelecionada = repositorioController.agencias.find(agenciaIndex);

        switch (tipoVeiculo) {
            case MOTO -> {
                int cilindradas = Input.getInt("Digite quantos cilindros:", scanner);
                veiculo = new Moto(modelo, placa, ano, cor, agenciaSelecionada.getCnpj(), cilindradas);
            }
            case CARRO -> {
                int capacidadeDoPortamalas = Input.getInt("Digite a capacidade do porta-malas:", scanner);
                int capacidadeDePessoas = Input.getInt("Digite a capacidade de pessoas:", scanner);
                veiculo = new Carro(modelo, placa, ano, cor, agenciaSelecionada.getCnpj(), capacidadeDoPortamalas);
            }
            case CAMINHAO -> {
                int capacidadeDeCarga = Input.getInt("Digite a capacidade da carga:", scanner);
                int numeroDeEixos = Input.getInt("Digite o numero de eixos:", scanner);
                veiculo = new Caminhao(modelo, placa, ano, cor, agenciaSelecionada.getCnpj(), capacidadeDeCarga, numeroDeEixos);
            }
            default -> veiculo = null;
        }

        return repositorioController.adicionarVeiculo(veiculo);
    }

    public static ModoExibir alterarVeiculo(RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> veiculoIndexList = new ArrayList<>();

        if (repositorioController.veiculos.quantidadeVeiculos() < 1) {
            System.err.println("Não há veículos cadastrados para alterar. Aperte Enter para continuar.");
            scanner.nextLine();
            return ModoExibir.ADMIN;
        }

        List<Veiculo> veiculos = repositorioController.veiculos.listVeiculos();
        String veiculoListPrompt = promptListarVeiculos(veiculos, veiculoIndexList);
        int veiculoIndex = Input.getInt(veiculoListPrompt, scanner, veiculoIndexList);
        Veiculo veiculoSelecionado = repositorioController.veiculos.find(veiculoIndex);

        System.out.printf("Você selecionou o veículo com a placa: %s, modelo: %s%n", veiculoSelecionado.getPlaca(), veiculoSelecionado.getModelo());

        String novoModelo = Input.getString("Digite o novo modelo (atual: " + veiculoSelecionado.getModelo() + "):", scanner);
        String novaPlaca = Input.getString("Digite a nova placa (atual: " + veiculoSelecionado.getPlaca() + "):", scanner);
        int novoAno = Input.getInt("Digite o novo ano (atual: " + veiculoSelecionado.getAno() + "):", scanner);
        String novaCor = Input.getString("Digite a nova cor (atual: " + veiculoSelecionado.getCor() + "):", scanner);

        veiculoSelecionado.setModelo(novoModelo);
        veiculoSelecionado.setPlaca(novaPlaca);
        veiculoSelecionado.setAno(novoAno);
        veiculoSelecionado.setCor(novaCor);

        repositorioController.veiculos.updateVeiculo(veiculoSelecionado);
        System.out.println("Veículo alterado com sucesso!");

        return ModoExibir.ADMIN;
    }

    public static ModoExibir deletarVeiculo(RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> veiculoIndexList = new ArrayList<>();

        if (repositorioController.veiculos.quantidadeVeiculos() < 1) {
            System.err.println("Não há veículos cadastrados para deletar. Aperte Enter para continuar.");
            scanner.nextLine();
            return ModoExibir.ADMIN;
        }

        List<Veiculo> veiculos = repositorioController.veiculos.listVeiculos();
        String veiculoListPrompt = promptListarVeiculos(veiculos, veiculoIndexList);
        int veiculoIndex = Input.getInt(veiculoListPrompt, scanner, veiculoIndexList);
        Veiculo veiculoSelecionado = repositorioController.veiculos.find(veiculoIndex);

        System.out.printf("Você selecionou o veículo com a placa: %s, modelo: %s%n", veiculoSelecionado.getPlaca(), veiculoSelecionado.getModelo());

        String confirmacao = Input.getString("Tem certeza que deseja deletar este veículo? Digite 'sim' para confirmar:", scanner);

        if (confirmacao.equalsIgnoreCase("sim")) {
            repositorioController.veiculos.dropVeiculo(veiculoSelecionado);
            System.out.println("Veículo deletado com sucesso!");
        } else {
            System.out.println("Operação cancelada.");
        }

        return ModoExibir.ADMIN;
    }

    public static ModoExibir listarVeiculo(RepositorioController repositorioController) {
        List<Veiculo> veiculos = repositorioController.veiculos.listVeiculos();
        for (Veiculo veiculo : veiculos) {
            System.out.printf("Placa: %s, Modelo: %s, Ano: %d, Cor: %s, CNPJ da Agencia: %s  %n", veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getCor(), veiculo.getAgenciaCNPJ());
        }
        return ModoExibir.ADMIN;
    }

    public static String promptListarVeiculos(List<Veiculo> veiculos, List<Integer> agenciaIndexList) {
        StringBuilder prompt = new StringBuilder();

        prompt.append("""
                    ╔══════════════════════════════════════════════╗
                    ║        Selecione o veiculo desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    
                """);

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            agenciaIndexList.add(i);
            prompt.append(String.format(" [%d] Placa: %s, Modelo: %s, Ano: %d, Cor: %s, CNPJ da Agencia: %s  %n", i, veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getCor(), veiculo.getAgenciaCNPJ()));
        }
        prompt.append("\n");

        return prompt.toString();
    }

}
