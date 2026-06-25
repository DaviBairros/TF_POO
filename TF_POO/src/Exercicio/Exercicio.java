package Exercicio;

import Enums.GrupoMuscular;
import java.io.Serializable;

public class Exercicio implements Serializable {

    private String nome;
    private GrupoMuscular grupoMuscular;
    private int series;
    private String repeticoes;

    public Exercicio(String nome,
                     GrupoMuscular grupoMuscular,
                     int series,
                     String repeticoes) {

        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public String getNome() {
        return nome;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public int getSeries() {
        return series;
    }

    public String getRepeticoes() {
        return repeticoes;
    }

    @Override
    public String toString() {
        return nome +
                " | " +
                grupoMuscular +
                " | " +
                series +
                " séries | " +
                repeticoes +
                " reps";
    }
}