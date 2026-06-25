package Exercicio;

import java.io.Serializable;

public class Aluno implements Serializable {

    private String nome;
    private int idade;
    private PlanoTreino plano;

    public Aluno(String nome, int idade, PlanoTreino plano) {
        this.nome = nome;
        this.idade = idade;
        this.plano = plano;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public PlanoTreino getPlano() {
        return plano;
    }

    @Override
    public String toString() {

        return "Aluno: " +
                nome +
                "\nIdade: " +
                idade +
                "\n\n" +
                plano;
    }
}