package entities.cliente;

public class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(String nome, String cnpj, String telefone, String email, String senha) {
        super(nome, telefone, email, senha);
        this.cnpj = cnpj;
    }
}
