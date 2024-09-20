package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAdmin extends Menu {

    @Override
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            try {
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
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            }
        } while (escolha != 0);

        scanner.close();
    }

}
