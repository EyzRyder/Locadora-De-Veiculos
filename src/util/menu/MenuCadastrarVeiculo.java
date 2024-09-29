package util.menu;

import controllers.RepositorioController;
import controllers.VeiculoController;
import entities.veiculo.TipoVeiculo;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuCadastrarVeiculo implements Menu {
    public ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        String menuPrompt = "";

        do {
            menuPrompt += """
                    ╔══════════════════════════════════════════════╗
                    ║              Cadastrar Veículo               ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Carro                                 ║
                    ║  [2] ⇨ Moto                                  ║
                    ║  [3] ⇨ Caminhão                              ║
                    ║  [0] ⇨ Voltar                                ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menuPrompt, scanner);

            switch (escolha) {
                case 1:
                    return VeiculoController.cadastrarVeiculo(repositorioController, TipoVeiculo.CARRO);
                case 2:
                    return VeiculoController.cadastrarVeiculo(repositorioController, TipoVeiculo.MOTO);
                case 3:
                    return VeiculoController.cadastrarVeiculo(repositorioController, TipoVeiculo.CAMINHAO);
                case 0:
                    return ModoExibir.MENUMANUTENCAOVEICULO;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (escolha != 0);

        scanner.close();

        return modo;
    }
}
