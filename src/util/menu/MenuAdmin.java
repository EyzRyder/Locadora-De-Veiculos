package util.menu;

import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuAdmin  {

    public static ModoExibir exibirMenu(ModoExibir modo) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║                 MENU ADMIN                   ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Cadastrar Cliente                     ║
                    ║  [2] ⇨ Cadastrar Agencia                     ║
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
                case 0:
                    return ModoExibir.PRINCIPAL;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
        return modo;
    }

}
