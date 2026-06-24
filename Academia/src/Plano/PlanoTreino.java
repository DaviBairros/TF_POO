package Plano;
import Enums.*;
import Interface.*;
import java.io.*;
import Exception.*;
import java.util.*;

public class PlanoTreino implements Serializable, Persistivel {

    private String nome;
    private Map<DiaSemana, Treino> treinos = new LinkedHashMap<>();

    public PlanoTreino(String nome) {
        this.nome = nome;
        this.treinos = new LinkedHashMap<>();
    }

    public void adicionarTreino(DiaSemana dia, Treino treino) {
        treinos.put(dia, treino);
    }

    public String getNome() {
        return nome;
    }

   public Map<DiaSemana, Treino> getTreinos(){
        return treinos;
   }

   public String nomeSeguro(){
        return nome.toLowerCase().replaceAll("[^a-z0-9]", "_");
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Plano: ").append(nome).append("\n");
        for (Map.Entry<DiaSemana, Treino> entry : treinos.entrySet()) {
            sb.append(entry.getKey()).append(":\n");
            sb.append(entry.getValue()).append("\n\n");
        }
        return sb.toString();
    }

    @Override
    public void salvarTXT() throws PersistenciaException {
        String arquivo = nomeSeguro() + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {

            writer.println("Plano de Treino: " + nome);
            writer.println("--------------------------------");
            for (Map.Entry<DiaSemana, Treino> entry : treinos.entrySet()) {
                writer.println(entry.getKey());
                writer.println(entry.getValue().toStringTxt());
                writer.println();
            }
        } catch (IOException e) {
            throw new PersistenciaException("Erro ao salvar plano em TXT", e);
        }
    }


    @Override
    public void salvarBinario() throws PersistenciaException {
        String arquivo = nomeSeguro() + ".bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new PersistenciaException("Erro ao salvar plano em binário", e);
        }
    }
}