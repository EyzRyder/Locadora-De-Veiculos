package repository;

import entities.cliente.Admin;
import entities.cliente.Cliente;
import exception.InstanciaInvalidaException;
import exception.ObjetoNaoEncontradoException;

import java.util.*;

public class ClienteRepositorio implements Repositorio<Cliente> {

    private final Map<String, Cliente> clientes;

    public ClienteRepositorio() {
        Cliente admi = new Admin("ADM", "(11)69504-6351", "adm@ada.com", "123", "DEV");
        Map<String, Cliente> tempClienteList = new HashMap<>();
        tempClienteList.put(admi.getEmail(), admi);
        this.clientes = tempClienteList;
    }

    @Override
    public Cliente[] getAll() {
        return clientes.values().toArray(new Cliente[clientes.size()]);
    }

    @Override
    public Cliente find(String email) {
        email = email.toLowerCase();
        if (!clientes.containsKey(email)) {
            return null;
        }

        return clientes.get(email);
    }

    @Override
    public Cliente update(String email, Cliente cliente) {
        return clientes.put(email, cliente);
    }

    @Override
    public Cliente add(Cliente cliente) {
        return clientes.put(cliente.getEmail(), cliente);
    }

    @Override
    public Cliente delete(Cliente cliente) throws ObjetoNaoEncontradoException {
        Cliente clienteRemovido;
        if (!clientes.containsKey(cliente.getEmail())) {
            throw new ObjetoNaoEncontradoException();
        }
        clienteRemovido = clientes.remove(cliente.getEmail());
        return clienteRemovido;
    }

}
