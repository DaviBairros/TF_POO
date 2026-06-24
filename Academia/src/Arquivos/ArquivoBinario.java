package Arquivos;
import Exception.*;
import Plano.*;
import java.io.*;

public class ArquivoBinario {

    public static void salvar (PlanoTreino plano) throws PersistenciaException {
        try (ObjectOutputStream oos = new ObjectOutputStream
                (new FileOutputStream(plano.getNome() + ".ser"))) {
            oos.writeObject(plano);
        } catch (IOException e) {
            throw new PersistenciaException("Erro na hora de salvar o arquivo em binário", e);
        }
    }
}
