package entities.veiculo;

public class Carro extends Veiculo {

    private int capacidadeDePessoas;
    private int capacidadeDoPortaMalas;

    public Carro(String modelo, String placa, int ano, String cor, String agenciaCNPJ, int capacidadeDoPortaMalas) {
        super(modelo, placa, ano, cor, agenciaCNPJ);
        this.capacidadeDoPortaMalas = capacidadeDoPortaMalas;
    }

    public int getCapacidadeDoPortaMalas() {
        return capacidadeDoPortaMalas;
    }

    public void setCapacidadeDoPortaMalas(int capacidadeDoPortaMalas) {
        this.capacidadeDoPortaMalas = capacidadeDoPortaMalas;
    }

    @Override
    public String toString() {
        return "Carro{" + "Capacidade do Portamalas = " + capacidadeDoPortaMalas +
                "Capacidade de Pessoas = " + capacidadeDePessoas + '}';
    }
}
