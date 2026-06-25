package Arquivos;

import Exception.Persistencia;
import Exercicio.PlanoTreino;

import java.io.FileWriter;
import java.io.IOException;

public class ArquivoTXT {

    public static void salvar(PlanoTreino plano) throws Persistencia {

        try {

            FileWriter fw =
                    new FileWriter("plano.txt");

            fw.write(plano.toString());

            fw.close();

        } catch (IOException e) {

            throw new Persistencia(
                    "Erro ao salvar TXT."
            );
        }
    }
}