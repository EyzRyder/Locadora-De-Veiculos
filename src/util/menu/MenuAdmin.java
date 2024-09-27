package util.menu;

import controllers.RepositorioController;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuAdmin {

    public static ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║                 MENU ADMIN                   ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Manutencao Cliente                    ║
                    ║  [2] ⇨ Manutencao Agencia                    ║
                    ║  [3] ⇨ Manutencao Veiculo                    ║
                    ║  [0] ⇨ Deslogar                              ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);

            switch (escolha) {
                case 1:
                    return ModoExibir.MENUMANUTENCAOCLIENTE;
                case 2:
                    return ModoExibir.MENUMANUTENCAOAGENCIA;
                case 3:
                    return ModoExibir.MENUMANUTENCAOVEICULO;
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
