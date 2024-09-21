package controllers;

import repository.ClienteRepositorio;

public class RepositorioController {
    public ClienteRepositorio clientes;

    public RepositorioController() {
        this.clientes = new ClienteRepositorio();
    }
}
