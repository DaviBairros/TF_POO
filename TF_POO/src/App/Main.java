package App;

import Controller.AcademiaController;
import Enums.*;
import InterfaceGrafica.TelaPrincipal;
import Exercicio.*;
import Servicos.AcademiaServico;

public class Main {

    public static void main(String[] args) {

        PlanoTreino plano = new PlanoTreino("Hipertrofia");

        Treino treinoA = new Treino(DiaSemana.SEGUNDA, "Peito e Triceps");

        treinoA.adicionarExercicio(new Exercicio("Supino Reto",
                        GrupoMuscular.PEITO,
                        4,
                        "10-12"
                )
        );

        treinoA.adicionarExercicio(
                new Exercicio(
                        "Triceps Pulley",
                        GrupoMuscular.TRICEPS,
                        3,
                        "12"
                )
        );

        plano.adicionarTreino(treinoA);

        Treino treinoB =
                new Treino(
                        DiaSemana.QUARTA,
                        "Costas e Biceps"
                );

        treinoB.adicionarExercicio(
                new Exercicio(
                        "Puxada Frontal",
                        GrupoMuscular.COSTAS,
                        4,
                        "10"
                )
        );

        treinoB.adicionarExercicio(
                new Exercicio(
                        "Rosca Direta",
                        GrupoMuscular.BICEPS,
                        3,
                        "12"
                )
        );

        plano.adicionarTreino(
                treinoB
        );

        AcademiaServico service = new AcademiaServico(plano);

        AcademiaController controller = new AcademiaController(service);

        javax.swing.SwingUtilities.invokeLater(
                () -> {

                    new TelaPrincipal(
                            controller
                    ).setVisible(true);

                }
        );
    }
}