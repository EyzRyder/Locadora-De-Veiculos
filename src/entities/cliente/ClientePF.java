package entities.cliente;

public class ClientePF extends Cliente {

    private String cpf;

    public ClientePF(String nome, String cpf, String telefone, String email, String senha) {
        super(nome, telefone, email, senha);
        this.cpf = cpf;
    }
}
