package controllers;

import entities.agencia.*;
import util.Input;
import util.ModoExibir;

import java.util.List;
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

        agencia = switch (tipoAgencia) {
            case PEQUENO_PORTE -> new AgenciaPequenoPorte(cnpj, razaoSocial, nomeFantasia);
            case MEDIO_PORTE -> new AgenciaMedioPorte(cnpj, razaoSocial, nomeFantasia);
            case GRANDE_PORTE -> new AgenciaGrandePorte(cnpj, razaoSocial, nomeFantasia);
        };

        return repositorioController.adicionarAgencia(agencia);

    }

    public static ModoExibir alterarAgencia(RepositorioController repositorioController) {

        String cnpj;
        String razaoSocial;
        String nomeFantasia;
        Agencia agencia;
        Scanner scanner = new Scanner(System.in);

        cnpj = Input.getString("Digite o CNPJ do cliente: ", scanner);

        agencia = repositorioController.agencias.findAgenciaByCNPJ(cnpj);

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

    public static ModoExibir listarAgencias(RepositorioController repositorioController) {
        List<Agencia> agencias = repositorioController.agencias.listAgencias();
        for (Agencia agencia : agencias) {
            System.out.printf("CNPJ: %s, Nome: %s, Razao Social: %s %n", agencia.getCnpj(),agencia.getNomeFantasia(), agencia.getRazaoSocial());
        }
        return ModoExibir.ADMIN;
    }

}
