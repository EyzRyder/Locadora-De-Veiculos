package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAdmin extends Menu {

    @Override
    public void exibirMenu() {
    Scanner input = new Scanner(System.in);
    int escolha = -1;

    do {
        try {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║                 MENU ADMIN                   ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  [1] ⇨ Cadastrar Cliente                     ║");
            System.out.println("║  [2] ⇨ Cadastrar Agencia                     ║");
            System.out.println("║  [0] ⇨ Sair                                  ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║         Selecione a tarefa desejada...       ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print(">>> Input: ");

            escolha = input.nextInt();
            input.nextLine();

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
            input.nextLine();
        }
    } while (escolha != 0);

    input.close();
    }

}
