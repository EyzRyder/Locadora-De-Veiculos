package controllers;

import entities.agencia.Agencia;
import entities.veiculo.Veiculo;
import util.Input;
import util.ModoExibir;

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
            System.err.println("Não tem agencia cadastrada para colocar o veiculo, volte quando tiver alguma agencia cadastrada\nAperte Enter pra continuar");
            scanner.nextLine();
            return ModoExibir.CLIENTE;
        }

        agenciaListPrompt = AgenciaController.promptListarAgencias(repositorioController,agenciaIndexList);

        agenciaIndex = Input.getInt(agenciaListPrompt, scanner, agenciaIndexList);
        Agencia agenciaSelecionada = repositorioController.agencias.find(agenciaIndex);

        List<Veiculo> veiculosFiltrados = repositorioController.veiculos.listarVeiculosPorCNPJAgencia(agenciaSelecionada.getCnpj());

        if(veiculosFiltrados.isEmpty()){
            System.err.println("Essa agencia não tem um veiculo cadastrada, tente outro opçõa\nAperte Enter pra continuar");
            scanner.nextLine();
            return ModoExibir.CLIENTE;
        }

        veiculoListarPrompt = VeiculoController.promptListarVeiculos(veiculosFiltrados,veiculoIndexList);

        veiculoIndex = Input.getInt(veiculoListarPrompt, scanner, veiculoIndexList);
        Veiculo veiculoSelecionada = repositorioController.veiculos.find(veiculoIndex);

        return ModoExibir.CLIENTE;
    }

    public static ModoExibir devolverVeiculo(RepositorioController repositorioController) {
        return ModoExibir.CLIENTE;
    }

    public static ModoExibir consultarHistorico(RepositorioController repositorioController) {
        return ModoExibir.CLIENTE;
    }
}
