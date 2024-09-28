package util.menu;

import controllers.ClienteController;
import controllers.RepositorioController;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuManutencaoCliente {
    public static ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {

            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║                 MENU CLIENTE                 ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Cadastrar Cliente                     ║
                    ║  [2] ⇨ Alterar dados do Cliente              ║
                    ║  [3] ⇨ Listar Clientes                       ║
                    ║  [0] ⇨ Voltar                                ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);

            switch (escolha) {
                case 1:
                    return ModoExibir.CADASTRARCLIENTE;
                case 2:
                    return ClienteController.alterarCliente(repositorioController);
                case 3:
                    return ClienteController.listarClientes(repositorioController);
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
