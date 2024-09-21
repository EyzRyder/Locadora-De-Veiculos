package controllers;

import entities.cliente.Cliente;
import repository.AgenciaRepositorio;
import repository.ClienteRepositorio;
import repository.VeiculoRepositorio;
import util.ModoExibir;

public class RepositorioController {

    public ClienteRepositorio clientes;
    public AgenciaRepositorio agencias;
    public VeiculoRepositorio veiculos;

    public RepositorioController() {
        this.clientes = new ClienteRepositorio();
        this.agencias = new AgenciaRepositorio();
        this.veiculos = new VeiculoRepositorio();
    }

    public ModoExibir adicionarCliente(Cliente cliente) {
        if (cliente == null || clientes.find(cliente.getEmail()) != null) {
            System.out.println("Cliente ja existe.");
        } else {
            clientes.add(cliente);
        }
        return ModoExibir.PRINCIPAL;
    }

    public ModoExibir alterarCliente(Cliente cliente) {
        if (cliente == null || clientes.find(cliente.getEmail()) != null) {
            System.out.println("Cliente inexistente.");
        } else {
            clientes.update(cliente.getEmail(), cliente);
        }
        return ModoExibir.PRINCIPAL;
    }

}
