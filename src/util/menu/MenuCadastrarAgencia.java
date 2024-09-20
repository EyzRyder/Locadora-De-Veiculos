package util.menu;

import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuCadastrarAgencia {

    public static ModoExibir exibirMenu(ModoExibir modo) {
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
                    ║  [0] ⇨ Sair                                  ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);


            switch (escolha) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (escolha != 0);

        scanner.close();

        return modo;
    }
}
