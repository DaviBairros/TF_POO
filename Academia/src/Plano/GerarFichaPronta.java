package Plano;
import Enums.*;

public class GerarFichaPronta {

    public static PlanoTreino gerarPlano(String nome, FichaPronta ficha){

        PlanoTreino plano = new PlanoTreino(nome);

        switch (ficha){

            case FULL_BODY -> criarFullBody(plano);
            case PPL -> criarPPL(plano);
            case UPPER_LOWER -> criarUpperLower(plano);
            case ARNOLD_SPLIT -> criarArnoldSplit(plano);
            case PPL_UPPER_LOWER -> criarPPLUpperLower(plano);
            case ARNOLD_SPLIT_UPPER_LOWER -> criarArnoldSplitUpperLower(plano);
        }
        return plano;
    }

    private static Treino criarFullBody() {

        Treino t = new Treino(null, "Full Body");

        t.adicionarExercicio(new Exercicio("Supino reto",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Puxada frontal",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Elevação lateral",
                GrupoMuscular.OMBRO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Rosca direta",
                GrupoMuscular.BICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Tríceps corda",
                GrupoMuscular.TRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Agachamento Pêndulo",
                GrupoMuscular.QUADRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Mesa flexora",
                GrupoMuscular.POSTERIOR_DE_COXA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Panturrilha em pé",
                GrupoMuscular.PANTURILHA, 3, "até a falha"));

        return t;
    }

    private static Treino criarPush() {

        Treino t = new Treino(null, "Push");

        t.adicionarExercicio(new Exercicio("Supino reto",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Supino inclinado",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Supino declinado",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Desenvolvimento com halter",
                GrupoMuscular.OMBRO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Elevação lateral",
                GrupoMuscular.OMBRO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Tríceps francês (polia)",
                GrupoMuscular.TRICEPS, 3, "até a falha"));

        return t;
    }

    private static Treino criarPull() {

        Treino t = new Treino(null, "Pull");

        t.adicionarExercicio(new Exercicio("Puxada frontal aberta",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Puxada frontal fechada (triângulo)",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Barra fixa (Graviton)",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Remada curvada com barra",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Remada baixa",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Serrote",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Hiperextenssão de lombar (banco romano)",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Rosca direta (barra W)",
                GrupoMuscular.BICEPS, 3, "até a falha"));

        return t;
    }

    private static Treino criarLegs(){

        Treino t = new Treino(null, "Legs");

        t.adicionarExercicio(new Exercicio("Cadeira extensora",
                GrupoMuscular.QUADRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Agachamento hack",
                GrupoMuscular.QUADRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Leg press",
                GrupoMuscular.QUADRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Mesa flexora",
                GrupoMuscular.POSTERIOR_DE_COXA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Cadeira flexora",
                GrupoMuscular.POSTERIOR_DE_COXA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Panturrilha em pé",
                GrupoMuscular.PANTURILHA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Panturrilha sentado",
                GrupoMuscular.PANTURILHA, 3, "até a falha"));

       return t;
    }

    private static Treino criarUpper() {

        Treino t = new Treino(null, "Upper");

        t.adicionarExercicio(new Exercicio("Supino reto",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Supino inclinado",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Puxada frontal",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Remada curvada",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Desenvolvimento militar",
                GrupoMuscular.OMBRO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Elevaçao lateral",
                GrupoMuscular.OMBRO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Rosca direta",
                GrupoMuscular.BICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Tríceps testa (polia)",
                GrupoMuscular.TRICEPS, 3, "até a falha"));

        return t;
    }

    private static Treino criarLower(){

        Treino t = new Treino(null, "Lower");

        t.adicionarExercicio(new Exercicio("Cadeira extensora",
                GrupoMuscular.QUADRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Agachamento livre",
                GrupoMuscular.QUADRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Mesa flexora",
                GrupoMuscular.POSTERIOR_DE_COXA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Stiff",
                GrupoMuscular.POSTERIOR_DE_COXA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Panturrilha em pé",
                GrupoMuscular.PANTURILHA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Panturrilha sentado",
                GrupoMuscular.PANTURILHA, 3, "até a falha"));

        return t;
    }

    private static Treino criarPeitoCostas() {

        Treino t = new Treino(null, "Peito + Costas");

        t.adicionarExercicio(new Exercicio("Supino reto",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Supino inclinado",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Crucifixo",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Crossover",
                GrupoMuscular.PEITO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Puxada frontal",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Remada curvada",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Remada baixa",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Pulldown",
                GrupoMuscular.COSTAS, 3, "até a falha"));

        return t;
    }

    private static Treino criarPernas() {

        Treino t = new Treino(null, "Perna");

        t.adicionarExercicio(new Exercicio("Agachamento Smith",
                GrupoMuscular.QUADRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Leg press",
                GrupoMuscular.QUADRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Cadeira extensora",
                GrupoMuscular.QUADRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Mesa flexora",
                GrupoMuscular.POSTERIOR_DE_COXA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Stiff",
                GrupoMuscular.POSTERIOR_DE_COXA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Levantamento terra",
                GrupoMuscular.POSTERIOR_DE_COXA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Panturrilha em pé",
                GrupoMuscular.PANTURILHA, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Panturrilha sentado",
                GrupoMuscular.PANTURILHA, 3, "até a falha"));

        return t;
    }

    private static Treino criarOmbroBraco(){

        Treino t = new Treino(null, "Ombro + Braço");

        t.adicionarExercicio(new Exercicio("Desenvolvimento",
                GrupoMuscular.OMBRO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Elevação lateral",
                GrupoMuscular.OMBRO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Elevação frontal (polia)",
                GrupoMuscular.OMBRO, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Rosca Scott",
                GrupoMuscular.BICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Rosca alternada",
                GrupoMuscular.BICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Rosca concentrada",
                GrupoMuscular.BICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Tríceps pulley",
                GrupoMuscular.TRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Tríceps testa (polia)",
                GrupoMuscular.TRICEPS, 3, "até a falha"));

        t.adicionarExercicio(new Exercicio("Tríceps francês (polia)",
                GrupoMuscular.TRICEPS, 3, "até a falha"));

        return t;
    }

    private static void criarFullBody(PlanoTreino plano){
        plano.adicionarTreino(DiaSemana.SEGUNDA, criarFullBody());
        plano.adicionarTreino(DiaSemana.QUARTA, criarFullBody());
        plano.adicionarTreino(DiaSemana.SEXTA, criarFullBody());
    }

    private static void criarPPL(PlanoTreino plano){
        plano.adicionarTreino(DiaSemana.SEGUNDA, criarPush());
        plano.adicionarTreino(DiaSemana.TERCA, criarPull());
        plano.adicionarTreino(DiaSemana.QUARTA, criarLegs());
        plano.adicionarTreino(DiaSemana.QUINTA, criarPush());
        plano.adicionarTreino(DiaSemana.SEXTA, criarPull());
        plano.adicionarTreino(DiaSemana.SÁBADO, criarLegs());
    }

    private static void criarUpperLower(PlanoTreino plano){
        plano.adicionarTreino(DiaSemana.SEGUNDA, criarUpper());
        plano.adicionarTreino(DiaSemana.TERCA, criarLower());
        plano.adicionarTreino(DiaSemana.QUINTA, criarUpper());
        plano.adicionarTreino(DiaSemana.SEXTA, criarLower());
    }

    private static void criarArnoldSplit(PlanoTreino plano){
        plano.adicionarTreino(DiaSemana.SEGUNDA, criarPeitoCostas());
        plano.adicionarTreino(DiaSemana.TERCA, criarPernas());
        plano.adicionarTreino(DiaSemana.QUARTA, criarOmbroBraco());
        plano.adicionarTreino(DiaSemana.QUINTA, criarPeitoCostas());
        plano.adicionarTreino(DiaSemana.SEXTA, criarPernas());
        plano.adicionarTreino(DiaSemana.SÁBADO, criarOmbroBraco());
    }

    private static void criarPPLUpperLower(PlanoTreino plano){
        plano.adicionarTreino(DiaSemana.SEGUNDA, criarPush());
        plano.adicionarTreino(DiaSemana.TERCA, criarPull());
        plano.adicionarTreino(DiaSemana.QUARTA, criarLegs());
        plano.adicionarTreino(DiaSemana.QUINTA, criarUpper());
        plano.adicionarTreino(DiaSemana.SEXTA, criarLower());
    }

    private static void criarArnoldSplitUpperLower(PlanoTreino plano){
        plano.adicionarTreino(DiaSemana.SEGUNDA, criarPeitoCostas());
        plano.adicionarTreino(DiaSemana.TERCA, criarPernas());
        plano.adicionarTreino(DiaSemana.QUARTA, criarOmbroBraco());
        plano.adicionarTreino(DiaSemana.QUINTA, criarLower());
        plano.adicionarTreino(DiaSemana.SEXTA, criarUpper());
    }
}