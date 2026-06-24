package Exception;

public class PlanoNaoCriadoException extends Exception {

    public PlanoNaoCriadoException(){
       super("Nenhum plano de trieno foi criado ainda");
   }
}
