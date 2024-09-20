package repository;

import entities.cliente.Cliente;
import exception.InstanciaInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio extends Repositorio {

    private final List<Cliente> clientes;

    public ClienteRepositorio() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public Cliente getOne() {
        return clientes.getFirst();
    }

    @Override
    public List<Cliente> getAll() {
        return clientes;
    }

    @Override
    public Cliente add(Object object) throws InstanciaInvalidaException {
        if (object instanceof Cliente cliente) {
            clientes.add(cliente);
            return cliente;
        }
        throw new InstanciaInvalidaException("Instancia invalida, necessário um cliente.");
    }

    @Override
    public Object delete(Object id) {
        return null;
    }

}
