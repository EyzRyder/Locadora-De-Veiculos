import controllers.RepositorioController;
import util.ModoExibir;
import util.menu.MenuAdmin;
import util.menu.MenuCadastrarAgencia;
import util.menu.MenuCadastrarCliente;
import util.menu.MenuPrincipal;

public class Main {
    private static ModoExibir modo = ModoExibir.PRINCIPAL;
    public static void main(String[] args) {
        RepositorioController repositorioController = new RepositorioController();

        while (!modo.getDescricao().equals("exit"))
            modo = switch (modo) {
                case PRINCIPAL -> MenuPrincipal.exibirMenu(modo,repositorioController);
                case CADASTRARAGENCIA -> MenuCadastrarAgencia.exibirMenu(modo,repositorioController);
                case CADASTRARCLIENTE -> MenuCadastrarCliente.exibirMenu(modo,repositorioController);
                case ADMIN -> MenuAdmin.exibirMenu(modo,repositorioController);
                case EXIT -> ModoExibir.EXIT;
            };

    }
}