package Classes;

public abstract class Funcionario extends Pessoa {

    protected double salarioBase;

    public Funcionario(String nome, int idade, String cpf, double salarioBase) {
        super(nome, idade, cpf);
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();
}