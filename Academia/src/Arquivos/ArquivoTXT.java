package Arquivos;
import Exception.*;
import Plano.*;
import java.io.*;

public class ArquivoTXT {

    public static void salvar (PlanoTreino plano) throws PersistenciaException {
        try (PrintWriter pw = new PrintWriter(plano.getNome() + ".txt")){
            pw.println(plano);
        }catch (Exception e) {
            throw new PersistenciaException("Erro na hora de salvar o arquivo em TXT", e);
        }
    }
}