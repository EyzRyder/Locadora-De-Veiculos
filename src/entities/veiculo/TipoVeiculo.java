package entities.veiculo;

public enum TipoVeiculo {
    MOTO(100.00),
    CARRO(150.00),
    CAMINHAO(200.00);

    private final double valorDiaria;

    TipoVeiculo(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}
