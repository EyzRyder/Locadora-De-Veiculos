package repository;

import entities.cliente.Cliente;

import java.io.*;
import java.util.*;

public class ClienteRepositorio implements Repositorio<Cliente> {

    private final Map<String, Cliente> clientes;
    private final String arquivo = "clientes.dat";

    public ClienteRepositorio() {
        this.clientes = new HashMap<>();
        loadData(arquivo, clientes);
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
        saveData(arquivo, clientes);
    }

    @Override
    public void add(Cliente cliente) {
        clientes.put(cliente.getEmail(), cliente);
        saveData(arquivo, clientes);
    }

    @Override
    public void delete(Cliente cliente) {
        clientes.remove(cliente.getEmail());
        saveData(arquivo, clientes);
    }

    private void saveData(String arquivo, Map<String, Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData(String arquivo, Map<String, Cliente> clientes) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            Map<String, Cliente> loadedClientes = (Map<String, Cliente>) ois.readObject();
            clientes.putAll(loadedClientes);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de clientes não encontrado, criando novo...");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
