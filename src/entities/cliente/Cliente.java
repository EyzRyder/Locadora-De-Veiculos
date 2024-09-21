package entities.cliente;

public class Cliente {
    protected String nome;
    protected String telefone;
    protected String email;
    protected String senha;

    public Cliente(String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email.toLowerCase();
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }
}
