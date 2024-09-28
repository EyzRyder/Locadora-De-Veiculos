package util.menu;

import controllers.ClienteController;
import controllers.RepositorioController;
import entities.cliente.TipoCliente;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuCadastrarCliente implements Menu  {

    public ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║              Cadastrar Cliente               ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Cliente PJ                            ║
                    ║  [2] ⇨ Cliente PF                            ║
                    ║  [3] ⇨ Admin                                 ║
                    ║  [0] ⇨ Voltar                                ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);

            switch (escolha) {
                case 1:
                    return ClienteController.cadastrarCliente(repositorioController, TipoCliente.CLIENTEPF);
                case 2:
                    return ClienteController.cadastrarCliente(repositorioController, TipoCliente.CLIENTEPJ);
                case 3:
                    return ClienteController.cadastrarCliente(repositorioController, TipoCliente.ADMIN);
                case 0:
                    return ModoExibir.CADASTRARCLIENTE;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (escolha != 0);

        scanner.close();

        return modo;
    }
}

