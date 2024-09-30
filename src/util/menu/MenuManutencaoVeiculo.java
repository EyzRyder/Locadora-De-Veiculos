package util.menu;

import controllers.RepositorioController;
import controllers.VeiculoController;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuManutencaoVeiculo implements Menu {
    public ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        String menuPrompt = "";

        do {
            menuPrompt += """
                    ╔══════════════════════════════════════════════╗
                    ║               MENU VEÍCULO                   ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Cadastrar Veiculo                     ║
                    ║  [2] ⇨ Alterar dados da Veiculo              ║
                    ║  [3] ⇨ Listar Veiculos                       ║
                    ║  [4] ⇨ Remover Veículo                       ║
                    ║  [0] ⇨ Voltar                                ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menuPrompt, scanner);

            switch (escolha) {
                case 1:
                    return ModoExibir.CADASTRARVEICULO;
                case 2:
                    return VeiculoController.alterarVeiculo(repositorioController);
                case 3:
                    return VeiculoController.listarVeiculo(repositorioController);
                case 4:
                    return VeiculoController.deletarVeiculo(repositorioController);
                case 0:
                    return ModoExibir.ADMIN;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
        return modo;
    }
}
