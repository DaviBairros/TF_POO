package Interface;

import Exception.Persistencia;

public interface Persistivel {

    void salvarTXT() throws Persistencia;

    void salvarBinario() throws Persistencia;
}