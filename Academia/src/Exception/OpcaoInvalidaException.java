package Exception;

public class OpcaoInvalidaException extends RuntimeException {

    public OpcaoInvalidaException (){
        super ("Opção inválida, selecione uma opçao possível");
    }
}
