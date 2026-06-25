package Arquivos;

import Exception.Persistencia;
import Exercicio.PlanoTreino;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ArquivoBinario {

    public static void salvar(PlanoTreino plano) throws Persistencia {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    "plano.dat"
                            )
                    );

            out.writeObject(plano);

            out.close();

        } catch (IOException e) {

            throw new Persistencia(
                    "Erro ao salvar binário."
            );
        }
    }
}