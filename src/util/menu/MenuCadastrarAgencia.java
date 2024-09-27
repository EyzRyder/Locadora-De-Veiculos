package util.menu;

import controllers.AgenciaController;
import controllers.RepositorioController;
import entities.agencia.TipoAgencia;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuCadastrarAgencia {

    public static ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║              Cadastrar Agencia               ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Pequeno Porte                         ║
                    ║  [2] ⇨ Medio Porte                           ║
                    ║  [2] ⇨ Grande Porte                          ║
                    ║  [0] ⇨ Voltar                                ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);


            switch (escolha) {
                case 1:
                    return AgenciaController.cadastrarAgencia(repositorioController, TipoAgencia.PEQUENO_PORTE);
                case 2:
                    return AgenciaController.cadastrarAgencia(repositorioController, TipoAgencia.MEDIO_PORTE);
                case 3:
                    return AgenciaController.cadastrarAgencia(repositorioController, TipoAgencia.GRANDE_PORTE);
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
