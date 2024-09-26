package entities.veiculo;

public class Caminhao extends Veiculo{

    private int capacidadeDeCarga; // Em toneladas.
    private int numeroDeEixos;

    public Caminhao (String modelo, String placa, int ano, String cor, int capacidadeDeCarga, int numeroDeEixos){
        super(modelo, placa, ano, cor);
        this.capacidadeDeCarga = capacidadeDeCarga;
        this.numeroDeEixos = numeroDeEixos;
    }

    public int getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public void setCapacidadeDeCarga(int capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public int getNumeroDeEixos() {
        return numeroDeEixos;
    }

    public void setNumeroDeEixos(int numeroDeEixos) {
        this.numeroDeEixos = numeroDeEixos;
    }

    @Override
    public String toString() {
        return "Caminhao{" + "Capacidade de Carga = " + capacidadeDeCarga +
                             "toneladas, Numero de Eixos = " + numeroDeEixos +'}';
    }


}
