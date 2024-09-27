package util.menu;

import controllers.RepositorioController;
import controllers.VeiculoController;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuManutencaoVeiculo {
    public static ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║                 MENU ADMIN                   ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Cadastrar Veiculo                     ║
                    ║  [2] ⇨ Alterar dados da Veiculo              ║
                    ║  [3] ⇨ Listar Veiculos                       ║
                    ║  [0] ⇨ Voltar                                ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);

            switch (escolha) {
                case 1:
                    return ModoExibir.CADASTRARAGENCIA;
                case 2:
                    return VeiculoController.alterarVeiculo(repositorioController);
                case 3:
                    return VeiculoController.listarVeiculo(repositorioController);
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