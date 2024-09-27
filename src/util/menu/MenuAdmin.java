package util.menu;

import controllers.AgenciaController;
import controllers.ClienteController;
import controllers.RepositorioController;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class MenuAdmin {

    public static ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            // Sujestão pra não ficar grande, criar manutenção cliente, manuntenção agencia e manuntenção veiculos

            String menu = """
                    ╔══════════════════════════════════════════════╗
                    ║                 MENU ADMIN                   ║
                    ╠══════════════════════════════════════════════╣
                    ║  [1] ⇨ Cadastrar Cliente                     ║
                    ║  [2] ⇨ Alterar dados do Cliente              ║
                    ║  [3] ⇨ Listar Clientes                       ║
                    ║  [4] ⇨ Cadastrar Agencia                     ║
                    ║  [5] ⇨ Alterar dados da Agencia              ║
                    ║  [6] ⇨ Listar Agencias                       ║
                    ║  [7] ⇨ Cadastrar Veiculo                     ║
                    ║  [8] ⇨ Alterar dados da Veiculo              ║
                    ║  [9] ⇨ Listar Veiculos                       ║
                    ║  [0] ⇨ Deslogar                              ║
                    ╚══════════════════════════════════════════════╝
                    ╔══════════════════════════════════════════════╗
                    ║         Selecione a tarefa desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    """;

            escolha = Input.getInt(menu, scanner);

            switch (escolha) {
                case 1:
                    return ModoExibir.CADASTRARCLIENTE;
                case 2:
                    return ClienteController.alterarCliente(repositorioController);
                case 3:
                    return ClienteController.listarClientes(repositorioController);
                case 4:
                    return ModoExibir.CADASTRARAGENCIA;
                case 5:
                    return AgenciaController.alterarAgencia(repositorioController);
                case 6:
                    return AgenciaController.listarAgencias(repositorioController);
                case 0:
                    repositorioController.setUsuarioAtual(null);
                    return ModoExibir.PRINCIPAL;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
        return modo;
    }

}
