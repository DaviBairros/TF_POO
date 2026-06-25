package Servicos;

import Exercicio.*;

public class AcademiaServico {

    private PlanoTreino plano;

    public AcademiaServico(PlanoTreino plano) {

        this.plano = plano;
    }

    public void adicionarTreino(Treino treino) {

        plano.adicionarTreino(treino);
    }

    public void removerTreino(Treino treino) {

        plano.removerTreino(treino);
    }

    public String listarPlano() {
        return plano.toString();
    }
}