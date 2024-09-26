package controllers;

import entities.veiculo.*;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class VeiculoController {

    public static ModoExibir cadastrarVeiculo(RepositorioController repositorioController, TipoVeiculo tipoVeiculo) {

        String modelo;
        String placa;
        int ano;
        String cor;
        Veiculo veiculo;
        Scanner scanner = new Scanner(System.in);

        modelo = Input.getString("Digite o modelo:", scanner);
        placa = Input.getString("Digite o placa:", scanner);
        ano = Input.getInt("Digite o ano:", scanner);
        cor = Input.getString("Digite o cor:", scanner);

        switch (tipoVeiculo) {
            case MOTO -> {
                int cilindradas = Input.getInt("Digite quantos cilindros:", scanner);
                veiculo = new Moto(modelo, placa, ano, cor, cilindradas);
            }
            case CARRO -> {
                int capacidadeDoPortamalas = Input.getInt("Digite a capacidade do porta-malas:", scanner);
                int capacidadeDePessoas = Input.getInt("Digite a capacidade de pessoas:", scanner);
                veiculo = new Carro(modelo, placa, ano, cor, capacidadeDoPortamalas);
            }
            case CAMINHAO -> {
                int capacidadeDeCarga = Input.getInt("Digite a capacidade da carga:", scanner);
                int numeroDeEixos = Input.getInt("Digite o numero de eixos:", scanner);
                veiculo = new Caminhao(modelo, placa, ano, cor, capacidadeDeCarga, numeroDeEixos);
            }
            default -> veiculo = null;
        }

        return repositorioController.adicionarVeiculo(veiculo);
    }
}
