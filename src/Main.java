import util.ModoExibir;
import util.menu.MenuAdmin;
import util.menu.MenuCadastrarAgencia;
import util.menu.MenuCadastrarCliente;
import util.menu.MenuPrincipal;

public class Main {
    private static ModoExibir modo = ModoExibir.PRINCIPAL;

    public static void main(String[] args) {
        while (!modo.getDescricao().equals("exit") )
       modo = switch (modo) {
            case PRINCIPAL -> MenuPrincipal.exibirMenu(modo);
            case CADASTRARAGENCIA -> MenuCadastrarAgencia.exibirMenu(modo);
            case CADASTRARCLIENTE -> MenuCadastrarCliente.exibirMenu(modo);
            case ADMIN -> MenuAdmin.exibirMenu(modo);
           case EXIT -> ModoExibir.EXIT;
       };

    }
}