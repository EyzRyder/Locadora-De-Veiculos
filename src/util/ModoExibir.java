package util;

public enum ModoExibir {

    PRINCIPAL("principal"),
    CLIENTE("cliente"),
    ADMIN("admin"),
    MENUMANUTENCAOCLIENTE("menumanutencaocliente"),
    MENUMANUTENCAOAGENCIA("menumanutencaoagencia"),
    MENUMANUTENCAOVEICULO("menumanutencaoveiculo"),
    CADASTRARAGENCIA("cadastraragencia"),
    CADASTRARCLIENTE("cadastrarcliente"),
    CADASTRARVEICULO("cadastarveiculo"),
    EXIT("exit");

    private final String descricao;

    ModoExibir(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
