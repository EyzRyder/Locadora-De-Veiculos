import controllers.MenuController;
import controllers.RepositorioController;
import util.ModoExibir;

public class Main {
    private static ModoExibir modo = ModoExibir.PRINCIPAL;
    public static void main(String[] args) {
        RepositorioController repositorioController = new RepositorioController();
        MenuController menuController = new MenuController();

        while (!modo.getDescricao().equals("exit"))
            modo = switch (modo) {
                case PRINCIPAL -> menuController.MenuPrincipal.exibirMenu(modo,repositorioController);
                case CLIENTE -> menuController.MenuCliente.exibirMenu(modo,repositorioController);
                case ADMIN -> menuController.MenuAdmin.exibirMenu(modo,repositorioController);
                case MENUMANUTENCAOCLIENTE -> menuController.MenuManutencaoCliente.exibirMenu(modo,repositorioController);
                case MENUMANUTENCAOAGENCIA -> menuController.MenuManutencaoAgencia.exibirMenu(modo,repositorioController);
                case MENUMANUTENCAOVEICULO -> menuController.MenuManutencaoVeiculo.exibirMenu(modo,repositorioController);
                case CADASTRARAGENCIA -> menuController.MenuCadastrarAgencia.exibirMenu(modo,repositorioController);
                case CADASTRARCLIENTE -> menuController.MenuCadastrarCliente.exibirMenu(modo,repositorioController);
                case CADASTRARVEICULO -> menuController.MenuCadastrarVeiculo.exibirMenu(modo,repositorioController);
                case EXIT -> ModoExibir.EXIT;
            };

    }
}