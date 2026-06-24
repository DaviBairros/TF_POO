package Plano;
import Enums.*;
import java.io.*;
import java.util.*;

public class Treino implements Serializable {

    private DiaSemana dia;
    private String descricao;
    private List<Exercicio> exercicios = new ArrayList<>();

    public Treino(DiaSemana dia, String descricao) {
        this.dia = dia;
        this.descricao = descricao;
        this.exercicios = new ArrayList<>();
    }

    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
    }

    public DiaSemana getDia() {
        return dia;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(descricao).append("\n");
        for (Exercicio e : exercicios) {
            sb.append(" ").append(e).append("\n");
        }
        return sb.toString();
    }

    public String toStringTxt() {
        StringBuilder sb = new StringBuilder();
        sb.append(descricao).append("\n");
        for (Exercicio e : exercicios) {
            sb.append(" ").append(e.toString()).append("\n");
        }
        return sb.toString();
    }
}