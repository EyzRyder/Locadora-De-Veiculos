package entities.veiculo;

import java.io.Serial;
import java.io.Serializable;

public class Veiculo  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String modelo;
    private String placa;
    private int ano;
    private String cor;
    private String agenciaCNPJ;
    protected TipoVeiculo tipoVeiculo;
    private boolean veiculoDisponivelParaLocacao = true;

    public Veiculo(String modelo, String placa, int ano, String cor, String agenciaCNPJ, TipoVeiculo tipoVeiculo) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.agenciaCNPJ = agenciaCNPJ;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Veiculo(String modelo, String placa, int ano, String cor, String agenciaCNPJ) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.agenciaCNPJ = agenciaCNPJ;
    }

    public boolean isDisponivel() {
        return veiculoDisponivelParaLocacao;
    }

    //get's


    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public String getAgenciaCNPJ() {
        return agenciaCNPJ;
    }

    public TipoVeiculo getTipoVeiculo() {return tipoVeiculo; }


    //set's

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAgenciaCNPJ(String agenciaCNPJ) {
        this.agenciaCNPJ = agenciaCNPJ;
    }

    public void setDisponivel(boolean veiculoDisponivelParaLocacao) { this.veiculoDisponivelParaLocacao = veiculoDisponivelParaLocacao; }

}
