package entities.cliente;

public class Admin extends Cliente {
    private String cargo;

    public Admin(String nome, String telefone, String email, String senha, String cargo) {
        super(nome, telefone, email, senha);
        this.cargo = cargo;
    }
}
