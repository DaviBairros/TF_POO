package poo.tf.Classes;

import poo.tf.Interfaces.Quantificavel;

public class FuncionarioAdministrativo extends Funcionario implements Quantificavel {

    private double percentualComissao = 0.04;
    private double comissaoAcumulada = 0;

    public FuncionarioAdministrativo(
            String nome,
            int idade,
            String cpf,
            double salarioBase) {

        super(nome, idade, cpf, salarioBase);
    }

    public void registrarVenda(double valorVenda) {
        comissaoAcumulada += valorVenda * percentualComissao;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + comissaoAcumulada;
    }

    @Override
    public double getValorEstatistico() {
        return comissaoAcumulada;
    }
}