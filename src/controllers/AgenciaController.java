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
            System.err.println("Agencia não encontrada, Enter para continuar...");
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
            System.out.printf("CNPJ: %s, Nome: %s, Razao Social: %s %n", agencia.getCnpj(), agencia.getNomeFantasia(), agencia.getRazaoSocial());
        }
        return ModoExibir.ADMIN;
    }

    public static String promptListarAgencias(RepositorioController repositorioController, List<Integer> agenciaIndexList) {
        List<Agencia> agencias = repositorioController.agencias.listAgencias();
        StringBuilder prompt = new StringBuilder();

        prompt.append("""
                    ╔══════════════════════════════════════════════╗
                    ║        Selecione a agencia desejada...       ║
                    ╚══════════════════════════════════════════════╝
                    
                """);

        for (int i = 0; i < agencias.size(); i++) {
            Agencia agencia = agencias.get(i);
            agenciaIndexList.add(i);
            prompt.append(String.format("[%d] CNPJ: %s - Nome: %s %n", i, agencia.getCnpj(), agencia.getNomeFantasia()));
        }
        prompt.append("\n");

        return prompt.toString();
    }

    public static ModoExibir removerAgencia(RepositorioController repositorioController, List<Integer> agenciaIndexList) {
        Scanner scanner = new Scanner(System.in);
        String inputIndex = Input.getString("Digite o índice da agência a ser removida: ", scanner);

        try {
            int index = Integer.parseInt(inputIndex);

            if (index < 0 || index >= agenciaIndexList.size()) {
                System.err.println("Índice inválido. Operação cancelada.");
                return ModoExibir.ADMIN;
            }

            Agencia agencia = repositorioController.agencias.listAgencias().get(agenciaIndexList.get(index));

            System.out.println("Tem certeza que deseja remover a agência " + agencia.getNomeFantasia() + "? (S/N)");
            String confirmacao = scanner.nextLine().toUpperCase();

            if (confirmacao.equals("S")) {
                repositorioController.removerAgencia(agencia);
                System.out.println("Agência removida com sucesso.");
            } else {
                System.out.println("Remoção cancelada.");
            }

        } catch (NumberFormatException e) {
            System.err.println("Entrada inválida. Por favor, insira um número.");
        } catch (Exception e) {
            System.err.println("Erro ao remover agência: " + e.getMessage());
        }

        return ModoExibir.ADMIN;
    }
}
