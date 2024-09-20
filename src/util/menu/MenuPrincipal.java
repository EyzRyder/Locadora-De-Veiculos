package util.menu;

import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuPrincipal  {

    public static ModoExibir exibirMenu(ModoExibir modo) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║                MENU PRINCIPAL                ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Fazer Login                           ║
                    ║  [2] ⇨ Cadastrar Conta                       ║
                    ║  [0] ⇨ Sair                                  ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);

            switch (escolha) {
                case 1:
                     return ModoExibir.ADMIN;
                case 2:
                    break;
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