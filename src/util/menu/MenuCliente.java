package util.menu;

import controllers.RepositorioController;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuCliente {
    public static ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║                 MENU Cliente                 ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Alugar carro                          ║
                    ║  [2] ⇨ Devolver Carro                        ║
                    ║  [3] ⇨ Historico                             ║
                    ║  [0] ⇨ Deslogar                              ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);

            switch (escolha) {
                case 1:
                    return ModoExibir.PRINCIPAL;
                case 2:
                    return ModoExibir.PRINCIPAL;
                case 3:
                    return ModoExibir.PRINCIPAL;
                case 0:
                    repositorioController.setUsuarioAtual(null);
                    return ModoExibir.PRINCIPAL;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
        return modo;
    }
}
