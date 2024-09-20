package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCadastrarAgencia extends Menu {

    @Override
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            try {
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
            } catch (InputMismatchException e) {
                System.err.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            }
        } while (escolha != 0);

        scanner.close();
    }
}
