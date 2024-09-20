package entities.veiculo;

public class Veiculo {

    private String modelo;
    private String placa;
    private int ano;
    private String cor; // Dá pra fazer um ENUM

    public Veiculo (String modelo, String placa, int ano, String cor) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
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
}
