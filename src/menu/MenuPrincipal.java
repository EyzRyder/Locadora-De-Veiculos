package menu;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuPrincipal extends Menu {

    @Override
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            try {
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