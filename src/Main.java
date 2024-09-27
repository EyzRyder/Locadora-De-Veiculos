import controllers.RepositorioController;
import util.ModoExibir;
import util.menu.*;

public class Main {
    private static ModoExibir modo = ModoExibir.PRINCIPAL;
    public static void main(String[] args) {
        RepositorioController repositorioController = new RepositorioController();

        while (!modo.getDescricao().equals("exit"))
            modo = switch (modo) {
                case PRINCIPAL -> MenuPrincipal.exibirMenu(modo,repositorioController);
                case CLIENTE -> MenuCliente.exibirMenu(modo,repositorioController);
                case ADMIN -> MenuAdmin.exibirMenu(modo,repositorioController);
                case MENUMANUTENCAOCLIENTE -> MenuManutencaoCliente.exibirMenu(modo,repositorioController);
                case MENUMANUTENCAOAGENCIA -> MenuManutencaoAgencia.exibirMenu(modo,repositorioController);
                case MENUMANUTENCAOVEICULO -> MenuManutencaoVeiculo.exibirMenu(modo,repositorioController);
                case CADASTRARAGENCIA -> MenuCadastrarAgencia.exibirMenu(modo,repositorioController);
                case CADASTRARCLIENTE -> MenuCadastrarCliente.exibirMenu(modo,repositorioController);
                case CADASTRARVEICULO -> MenuCadastrarVeiculo.exibirMenu(modo,repositorioController);
                case EXIT -> ModoExibir.EXIT;
            };

    }
}