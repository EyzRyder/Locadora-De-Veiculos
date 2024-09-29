package controllers;

import entities.cliente.Admin;
import entities.cliente.Cliente;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class PrincipalController {

    public static ModoExibir login(RepositorioController repositorioController) {
        String email;
        String senha;
        Cliente cliente;
        Scanner scanner = new Scanner(System.in);

        email = Input.getString("Digite seu email", scanner);
        senha = Input.getString("Digite seu senha", scanner);

        cliente = repositorioController.clientes.find(email);

        if (cliente == null ) {
            System.err.println("Não exite usuario com esse email\nAperte enter pra continuar");
            scanner.nextLine();
            return ModoExibir.PRINCIPAL;
        }

        if (!cliente.verificarSenha(senha)) {
            System.err.println("Senha incorreta\\nAperte enter pra continuar");
            scanner.nextLine();
            return ModoExibir.PRINCIPAL;
        }

        repositorioController.setUsuarioAtual(cliente);
        if (cliente instanceof Admin admin) {
            repositorioController.setUsuarioAtual(admin);
            if (Input.getBoolen("Deseja entrar na tela de Admin?", scanner)) {
                return ModoExibir.ADMIN;
            }
        }

        return ModoExibir.CLIENTE;
    }
}
