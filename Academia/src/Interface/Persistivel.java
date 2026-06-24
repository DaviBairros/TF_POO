package Interface;
import Exception.*;

public interface Persistivel {

    void salvarTXT() throws PersistenciaException;
    void salvarBinario() throws PersistenciaException;
}
