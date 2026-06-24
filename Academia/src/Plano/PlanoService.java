package Plano;
import java.util.*;
import Enums.*;
import Exception.*;

public class PlanoService {

    private PlanoTreino plano;

    public void criarPlano(Scanner teclado) {

        teclado.nextLine();
        System.out.print("Digite o nome do plano: ");
        String nome = teclado.nextLine();

        System.out.println("""
            Escolha o tipo de ficha:
            1 - Ficha pronta
            2 - Ficha personalizada
            """);
        int tipo = teclado.nextInt();

        if (tipo == 1) {
            System.out.println("Escolha a divisão de treino:");
            for (var f : FichaPronta.values()) {
                System.out.println((f.ordinal() + 1) + "  " + f);
            }
            int opcao = teclado.nextInt();
            FichaPronta ficha = FichaPronta.values()[opcao - 1];
            plano = GerarFichaPronta.gerarPlano(nome, ficha);

        } else {
            plano = new PlanoTreino(nome);

            System.out.print("Quantos dias de treino? ");
            int qtdDias = teclado.nextInt();

            for (int i = 0; i < qtdDias; i++) {

                System.out.println("Escolha o dia da semana:");
                for (DiaSemana d : DiaSemana.values()) {
                    System.out.println((d.ordinal() + 1) + "  " + d);
                }

                int ds = teclado.nextInt();
                DiaSemana dia = DiaSemana.values()[ds - 1];

                teclado.nextLine();
                System.out.print("Descrição do treino (ex: Push, Pull, grupo muscular trabalhado): ");
                String descricao = teclado.nextLine();

                Treino treino = new Treino(dia, descricao);

                System.out.print("Quantos exercícios nesse dia? ");
                int quantEx = teclado.nextInt();
                teclado.nextLine();

                for (int j = 0; j < quantEx; j++) {

                    System.out.print("Nome do exercício: ");
                    String nomeEx = teclado.nextLine();

                    System.out.println("Grupo muscular:");
                    for (GrupoMuscular g : GrupoMuscular.values()) {
                        System.out.println((g.ordinal() + 1) + "  " + g);
                    }

                    int gm = teclado.nextInt();
                    GrupoMuscular grupo = GrupoMuscular.values()[gm - 1];

                    System.out.print("Número de séries: ");
                    int series = teclado.nextInt();
                    teclado.nextLine();

                    Exercicio ex = new Exercicio(
                            nomeEx,
                            grupo,
                            series,
                            " até a falha"
                    );
                    treino.adicionarExercicio(ex);
                }
                plano.adicionarTreino(dia, treino);
            }
        }
        System.out.println("Plano criado com sucesso!");
    }

    public PlanoTreino getPlano() throws PlanoNaoCriadoException {
        if (plano == null) {
            throw new PlanoNaoCriadoException();
        }
        return plano;
    }
}