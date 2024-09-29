package entities.movimentacao;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Movimentacao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    final private LocalDateTime dataHoraMovimentacao;
    final private TipoMovimentacao tipoMovimentacao;
    final private String descricao;
    final private String emailCliente;
    final private String cnpjAgencia;
    final private String placaVeiculo;

    public Movimentacao (
            TipoMovimentacao tipoMovimentacao, String descricao, String emailCliente,
            String cnpjAgencia, String placaVeiculo
    ) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.descricao = descricao;
        this.emailCliente = emailCliente;
        this.cnpjAgencia = cnpjAgencia;
        this.placaVeiculo = placaVeiculo;
        this.dataHoraMovimentacao = LocalDateTime.now();
    }

    public LocalDateTime getDataHoraMovimentacao() {
        return dataHoraMovimentacao;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getCnpjAgencia() {
        return cnpjAgencia;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "dataHoraMovimentacao=" + dataHoraMovimentacao +
                ", tipoMovimentacao=" + tipoMovimentacao +
                ", descricao='" + descricao + '\'' +
                ", emailCliente='" + emailCliente + '\'' +
                ", cnpjAgencia='" + cnpjAgencia + '\'' +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                '}';
    }

}
