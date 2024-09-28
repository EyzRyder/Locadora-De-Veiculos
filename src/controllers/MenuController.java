package controllers;

import util.menu.*;

public class MenuController {

    public Menu MenuPrincipal;
    public Menu MenuAdmin;
    public Menu MenuCadastrarAgencia;
    public Menu MenuCadastrarCliente;
    public Menu MenuCadastrarVeiculo;
    public Menu MenuManutencaoAgencia;
    public Menu MenuManutencaoCliente;
    public Menu MenuManutencaoVeiculo;
    public Menu MenuCliente;

    public MenuController() {
        this.MenuPrincipal = new MenuPrincipal();
        this.MenuAdmin = new MenuAdmin();
        this.MenuCadastrarAgencia = new MenuCadastrarAgencia();
        this.MenuCadastrarCliente = new MenuCadastrarCliente();
        this.MenuCadastrarVeiculo = new MenuCadastrarVeiculo();
        this.MenuManutencaoAgencia = new MenuManutencaoAgencia();
        this.MenuManutencaoCliente = new MenuManutencaoCliente();
        this.MenuManutencaoVeiculo = new MenuManutencaoVeiculo();
        this.MenuCliente = new MenuCliente();
    }
}
