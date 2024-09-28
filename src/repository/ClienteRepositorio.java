package repository;

import entities.cliente.Admin;
import entities.cliente.Cliente;

import java.util.*;

public class ClienteRepositorio implements Repositorio<Cliente> {

    private final Map<String, Cliente> clientes;

    public ClienteRepositorio() {
        Cliente admin = new Admin("ADM", "(11)69504-6351", "adm@ada.com", "123muitoforte", "DEV");
        Map<String, Cliente> tempClienteList = new HashMap<>();
        tempClienteList.put(admin.getEmail(), admin);
        this.clientes = tempClienteList;
    }

    public Collection<Cliente> getAll() {
        return clientes.values();
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
    public void update(Cliente cliente) {
        clientes.put(cliente.getEmail(), cliente);
    }

    @Override
    public void add(Cliente cliente) {
        clientes.put(cliente.getEmail(), cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clientes.remove(cliente.getEmail());
    }

}
