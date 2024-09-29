package util.menu;

import controllers.AgenciaController;
import controllers.RepositorioController;
import entities.agencia.TipoAgencia;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuManutencaoAgencia implements Menu {
    public ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        String menuPrompt = "";

        do {
            menuPrompt += """
                    ╔══════════════════════════════════════════════╗
                    ║                 MENU AGÊNCIA                 ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Cadastrar Agencia                     ║
                    ║  [2] ⇨ Alterar dados da Agencia              ║
                    ║  [3] ⇨ Listar Agencias                       ║
                    ║  [0] ⇨ Voltar                                ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menuPrompt, scanner);

            switch (escolha) {
                case 1:
                    return AgenciaController.cadastrarAgencia(repositorioController, TipoAgencia.MEDIO_PORTE);
                //return ModoExibir.CADASTRARAGENCIA; // possivel futuro implementação
                case 2:
                    return AgenciaController.alterarAgencia(repositorioController);
                case 3:
                    return AgenciaController.listarAgencias(repositorioController);
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
