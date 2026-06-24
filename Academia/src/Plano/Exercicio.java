package Plano;
import Enums.*;
import java.io.*;

public class Exercicio implements Serializable {

    private String nome;
    private GrupoMuscular grupo;
    private int series;
    private String repeticoes;

    public Exercicio (String nome, GrupoMuscular grupo, int series, String repeticoes){
        this.nome = nome;
        this.grupo = grupo;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public String getNome() {
        return nome;
    }

    public GrupoMuscular getGrupo() {
        return grupo;
    }

    public int getSeries() {
        return series;
    }

    public String getRepeticoes() {
        return repeticoes;
    }

    @Override
    public String toString() {
        return nome + " | " + grupo + " | " + series + " séries," + repeticoes;
    }
}
