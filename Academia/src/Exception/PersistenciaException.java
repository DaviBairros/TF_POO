package Exception;

public class PersistenciaException extends Exception {

    public PersistenciaException (String menssagem, Throwable causa) {
        super (menssagem, causa);
    }
}
