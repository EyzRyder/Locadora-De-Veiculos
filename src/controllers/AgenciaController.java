package controllers;

import entities.agencia.*;
import util.Input;
import util.ModoExibir;

import java.util.Scanner;

public class AgenciaController {
    public static ModoExibir cadastrarAgencia(RepositorioController repositorioController, TipoAgencia tipoAgencia) {

        String cnpj;
        String razaoSocial;
        String nomeFantasia;
        Agencia agencia;

        Scanner scanner = new Scanner(System.in);

        cnpj = Input.getString("Digite o CNPJ da Agencia: ", scanner);
        razaoSocial = Input.getString("Digite a Razão Social: ", scanner);
        nomeFantasia = Input.getString("Digite o Nome Fantasia: ", scanner);

        switch (tipoAgencia) {
            case PEQUENO_PORTE -> {
                agencia = new AgenciaPequenoPorte(cnpj, razaoSocial, nomeFantasia);
            }
            case MEDIO_PORTE -> {
                agencia = new AgenciaMedioPorte(cnpj, razaoSocial, nomeFantasia);
            }
            case GRANDE_PORTE -> {
                agencia = new AgenciaGrandePorte(cnpj, razaoSocial, nomeFantasia);

            }
            default -> agencia = null;
        }

        return repositorioController.adicionarAgencia(agencia);

    }

    public static ModoExibir alterarAgencia(RepositorioController repositorioController) {

        String cnpj;
        String razaoSocial;
        String nomeFantasia;
        Agencia agencia;
        Scanner scanner = new Scanner(System.in);

        cnpj = Input.getString("Digite o CNPJ do cliente: ", scanner);
        agencia = repositorioController.agencias.find(cnpj);
        if (agencia == null) {
            System.err.println("Agencia não encontrado, Enter para continuar...");
            scanner.nextLine();
            return ModoExibir.ADMIN;
        } else {
            razaoSocial = Input.getString("Digite a Razão Social: ", scanner);
            nomeFantasia = Input.getString("Digite o Nome Fantasia: ", scanner);

            agencia.setRazaoSocial(razaoSocial == null || razaoSocial.isEmpty() ? agencia.getRazaoSocial() : razaoSocial);
            agencia.setNomeFantasia(nomeFantasia == null || nomeFantasia.isEmpty() ? agencia.getNomeFantasia() : nomeFantasia);

            return repositorioController.alterarAgencia(agencia);
        }

    }

}
