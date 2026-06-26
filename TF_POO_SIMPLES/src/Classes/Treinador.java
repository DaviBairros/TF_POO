package Classes;

public class Treinador extends Funcionario {

    private int horasTrabalhadas;
    private double valorHora;

    public Treinador(String nome, int idade, String cpf, double salarioBase,
                     int horasTrabalhadas, double valorHora) {
        super(nome, idade, cpf, salarioBase);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }
}