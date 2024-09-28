package util.menu;

import controllers.RepositorioController;
import util.ModoExibir;

public interface Menu {
    ModoExibir exibirMenu(ModoExibir modo, RepositorioController repositorioController);
}
