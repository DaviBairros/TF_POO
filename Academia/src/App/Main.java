package App;
import Exception.*;
import Plano.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        PlanoService service = new PlanoService();
        int opcao;

        while (true) {
            System.out.println("Escolha uma das opções abaixo: \n" +
                    "1 - Criar plano\n" +
                    "2 - Mostrar plano\n" +
                    "3 - Salvar em TXT\n" +
                    "4 - Salvar em Binário\n" +
                    "0 - Sair");
            System.out.println("Opção: ");
            opcao = teclado.nextInt();

            try {
                switch (opcao) {
                    case 1 -> {
                        service.criarPlano(teclado);
                    }
                    case 2 -> {
                        System.out.println(service.getPlano());
                    }
                    case 3 -> {
                       service.getPlano().salvarTXT();
                       System.out.println("Arquivo salvo em TXT.");
                    }
                    case 4 -> {
                        service.getPlano().salvarBinario();
                        System.out.println("Arquivo salvo em binário");
                    }
                    case 0 -> {
                        System.out.println("Sair");
                        return;
                    }
                    default -> throw new OpcaoInvalidaException();
                }
            } catch (PlanoNaoCriadoException | PersistenciaException | OpcaoInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}