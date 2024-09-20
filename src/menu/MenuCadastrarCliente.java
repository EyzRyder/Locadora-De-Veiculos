package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCadastrarCliente extends Menu {

    @Override
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            try {
                String menu = """
                        ╔══════════════════════════════════════════════╗
                        ║              Cadastrar Cliente               ║
                        ╠══════════════════════════════════════════════╣
                        ║  [1] ⇨ Cliente PJ                            ║
                        ║  [2] ⇨ Cliente PF                            ║
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

