package entities.cliente;

public class Cliente {
    protected String nome;
    protected String telefone;
    protected String email;
    protected String senha;


    public Cliente(String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }
}
