package Controller;

import Exercicio.*;
import Servicos.AcademiaServico;


public class AcademiaController {

    private AcademiaServico servico;

    public AcademiaController(AcademiaServico servico) {

        this.servico = servico;
    }

    public String listarPlano() {
        return servico.listarPlano();
    }

    public void adicionarTreino(Treino treino) {

        servico.adicionarTreino(treino);
    }

    public void removerTreino(Treino treino) {

        servico.removerTreino(treino);
    }
}