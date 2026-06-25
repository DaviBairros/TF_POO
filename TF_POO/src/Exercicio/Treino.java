package Exercicio;

import Enums.DiaSemana;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Treino implements Serializable {

    private DiaSemana dia;
    private String descricao;
    private List<Exercicio> exercicios;

    public Treino(DiaSemana dia,
                  String descricao) {

        this.dia = dia;
        this.descricao = descricao;
        exercicios = new ArrayList<>();
    }

    public void adicionarExercicio(Exercicio e) {
        exercicios.add(e);
    }

    public void removerExercicio(Exercicio e) {
        exercicios.remove(e);
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

        sb.append("Treino: ")
                .append(descricao)
                .append(" (")
                .append(dia)
                .append(")\n");

        for (Exercicio e : exercicios) {
            sb.append("   - ")
                    .append(e)
                    .append("\n");
        }

        return sb.toString();
    }
}