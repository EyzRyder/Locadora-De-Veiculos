package controllers;

import repository.AgenciaRepositorio;
import repository.ClienteRepositorio;
import repository.VeiculoRepositorio;

public class RepositorioController {

    public ClienteRepositorio clientes;
    public AgenciaRepositorio agencias;
    public VeiculoRepositorio veiculos;

    public RepositorioController() {
        this.clientes = new ClienteRepositorio();
        this.agencias = new AgenciaRepositorio();
        this.veiculos = new VeiculoRepositorio();
    }

}
