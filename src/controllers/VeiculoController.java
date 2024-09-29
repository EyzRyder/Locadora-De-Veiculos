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

        agenciaListPrompt = repositorioController.agencias.promptListarAgencias(agenciaIndexList);

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
        return ModoExibir.ADMIN;
    }

    public static ModoExibir listarVeiculo(RepositorioController repositorioController) {
        List<Veiculo> veiculos = repositorioController.veiculos.listVeiculos();
        for (Veiculo veiculo : veiculos) {
            System.out.printf("Placa: %s, Modelo: %s, Ano: %d, Cor: %s, CNPJ da Agencia: %s  %n", veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getCor(), veiculo.getAgenciaCNPJ());
        }
        return ModoExibir.ADMIN;
    }
}
