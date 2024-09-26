package controllers;

import entities.cliente.*;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class ClienteController {

    public static ModoExibir cadastrarCliente( RepositorioController repositorioController, TipoCliente tipoCliente) {

        String nome;
        String telefone;
        String email;
        String senha;
        Cliente cliente;
        Scanner scanner = new Scanner(System.in);

        nome = Input.getString("Digite o nome:", scanner);
        telefone = Input.getString("Digite o telefone:", scanner);
        email = Input.getString("Digite o email:", scanner);
        senha = Input.getString("Digite a senha:", scanner);

        switch (tipoCliente) {
            case CLIENTEPF -> {
                String cpf = Input.getString("Digite o cpf:", scanner);
                cliente = new ClientePF(nome, cpf, telefone, email, senha);
            }
            case CLIENTEPJ -> {
                String cnpj = Input.getString("Digite o cnpj:", scanner);
                cliente = new ClientePJ(nome, cnpj, telefone, email, senha);
            }
            case ADMIN -> {
                String cargo = Input.getString("Digite seu cargo:", scanner);
                cliente = new Admin(nome, telefone, email, senha, cargo);
            }
            default -> cliente = null;
        }

        return repositorioController.adicionarCliente(cliente);

    }

    public static ModoExibir alterarCliente(RepositorioController repositorioController) {

        String nome;
        String telefone;
        String email;
        Cliente cliente;
        Scanner scanner = new Scanner(System.in);

        email = Input.getString("Digite o email do cliente: ", scanner);
        cliente = repositorioController.clientes.find(email);

        if (cliente == null) {
            System.err.println("Cliente não encontrado, Enter para continuar...");
            scanner.nextLine();
            return ModoExibir.ADMIN;
        } else {
            nome = Input.getString("Digite o nome:", scanner);
            telefone = Input.getString("Digite o telefone", scanner);

            cliente.setNome(nome == null || nome.isEmpty() ? cliente.getNome() : nome);
            cliente.setTelefone(telefone == null || telefone.isEmpty() ? cliente.getTelefone() : telefone);

            return repositorioController.alterarCliente(cliente);
        }

    }

}
