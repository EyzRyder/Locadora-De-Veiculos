package util;

public enum ModoExibir {

    PRINCIPAL("principal"),
    CADASTRARAGENCIA("cadastraragencia"),
    CADASTRARCLIENTE("cadastrarcliente"),
    ADMIN("admin"),
    EXIT("exit");

    private final String descricao;

    ModoExibir(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
