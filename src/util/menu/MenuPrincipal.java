package util.menu;

import controllers.PrincipalController;
import controllers.RepositorioController;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuPrincipal implements Menu {

    public ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║                MENU PRINCIPAL                ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Fazer Login                           ║
                    ║  [0] ⇨ Sair                                  ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);

            switch (escolha) {
                case 1:
                    return PrincipalController.login(repositorioController);
                case 0:
                    return ModoExibir.EXIT;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
        return modo;
    }


}