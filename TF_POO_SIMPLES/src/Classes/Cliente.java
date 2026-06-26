package Classes;

import java.time.Duration;
import java.time.LocalDateTime;
import Enuns.*;
import Interfaces.Quantificavel;

public class Cliente extends Pessoa implements Quantificavel {

    private Plano plano;
    private PerfilTreino perfil;
    private int minutosTreinados;
    private LocalDateTime inicioTreino;
    private boolean treinando;

    public Cliente(String nome, int idade, String cpf, Plano plano, PerfilTreino perfil) {
        super(nome, idade, cpf);
        this.plano = plano;
        this.perfil = perfil;
        this.minutosTreinados = 0;;
        this.treinando = false;
    }

    private void adicionarMinutos(int minutos) {
        minutosTreinados += minutos;
    }

    public String iniciarTreino() {
        if (treinando) return "Treino já iniciado.";
        inicioTreino = LocalDateTime.now();
        treinando = true;
        return "Treino iniciado com sucesso.";
    }

    public String finalizarTreino() {
        if (!treinando) return "Nenhum treino em andamento.";
        long minutos = Duration.between(inicioTreino, LocalDateTime.now()).toMinutes();
        treinando = false;
        inicioTreino = null;
        adicionarMinutos((int) minutos);
        return "Treino concluído. Tempo treinado: " + minutos + " minuto(s).";
    }

    public long getMinutosTreinoAtual() {
        if (!treinando) return 0;
        return Duration.between(inicioTreino, LocalDateTime.now()).toMinutes();
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

    public int getMinutosTreinados() {
        return minutosTreinados;
    }

    public boolean isTreinando() {
        return treinando;
    }

    public LocalDateTime getInicioTreino() {
        return inicioTreino;
    }

    @Override
    public double getValorEstatistico() {
        return minutosTreinados;
    }
}