package poo.tf.Classes;

import java.time.Duration;
import java.time.LocalDateTime;

import poo.tf.Enuns.PerfilTreino;
import poo.tf.Enuns.Plano;
import poo.tf.Interfaces.Quantificavel;

public class Cliente extends Pessoa implements Quantificavel {

    private Plano plano;
    private PerfilTreino perfil;
    private int horasTreinadas;

    private LocalDateTime inicioTreino;
    private boolean treinando;

    public Cliente(String nome,
                   int idade,
                   String cpf,
                   Plano plano,
                   PerfilTreino perfil) {

        super(nome, idade, cpf);

        this.plano = plano;
        this.perfil = perfil;
        this.horasTreinadas = 0;
        this.treinando = false;
    }

    private void adicionarHoras(int horas) {
        horasTreinadas += horas;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public PerfilTreino getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilTreino perfil) {
        this.perfil = perfil;
    }

    public int getHorasTreinadas() {
        return horasTreinadas;
    }

    public boolean isTreinando() {
        return treinando;
    }

    public LocalDateTime getInicioTreino() {
        return inicioTreino;
    }

    public long getMinutosTreinoAtual() {

        if (!treinando) {
            return 0;
        }

        return Duration.between(
                inicioTreino,
                LocalDateTime.now())
                .toMinutes();
    }

    public String iniciarTreino() {

        if (treinando) {
            return "Treino já iniciado.";
        }

        inicioTreino = LocalDateTime.now();
        treinando = true;

        return "Treino iniciado com sucesso.";
    }

    public String finalizarTreino() {

        if (!treinando) {
            return "Nenhum treino em andamento.";
        }

        LocalDateTime fimTreino = LocalDateTime.now();

        long minutos = Duration.between(
                inicioTreino,
                fimTreino)
                .toMinutes();

        treinando = false;
        inicioTreino = null;

        if (minutos > 240) {
            return "Treino excedeu 4 horas e foi descartado.";
        }

        adicionarHoras((int) (minutos / 60));

        return "Treino concluído. Tempo treinado: "
                + minutos + " minutos.";
    }

    @Override
    public double getValorEstatistico() {
        return horasTreinadas;
    }
}