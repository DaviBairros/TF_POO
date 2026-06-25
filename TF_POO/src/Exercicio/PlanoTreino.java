package Exercicio;

import Interface.Persistivel;
import Exception.Persistencia;
import Arquivos.ArquivoTXT;
import Arquivos.ArquivoBinario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlanoTreino implements Serializable, Persistivel {

    private String nome;
    private List<Treino> treinos;

    public PlanoTreino(String nome) {
        this.nome = nome;
        this.treinos = new ArrayList<>();
    }

    public void adicionarTreino(Treino treino) {
        treinos.add(treino);
    }

    public void removerTreino(Treino treino) {
        treinos.remove(treino);
    }

    public String getNome() {
        return nome;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    @Override
    public void salvarTXT()
            throws Persistencia {

        ArquivoTXT.salvar(this);
    }

    @Override
    public void salvarBinario()
            throws Persistencia {

        ArquivoBinario.salvar(this);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("===== ")
                .append(nome)
                .append(" =====\n\n");

        for (Treino t : treinos) {
            sb.append(t).append("\n");
        }

        return sb.toString();
    }
}