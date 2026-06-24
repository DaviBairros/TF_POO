package Enums;
import java.util.*;

public enum DivisaoTreino {

    FULL_BODY(List.of(
            DiaSemana.SEGUNDA,
            DiaSemana.QUARTA,
            DiaSemana.SEXTA
    )),
    PPL(List.of(
            DiaSemana.SEGUNDA,
            DiaSemana.TERCA,
            DiaSemana.QUARTA,
            DiaSemana.QUINTA,
            DiaSemana.SEXTA,
            DiaSemana.SÁBADO
    )),
    UPPER_LOWER(List.of(
            DiaSemana.SEGUNDA,
            DiaSemana.TERCA,
            DiaSemana.QUINTA,
            DiaSemana.SEXTA
    )),
    ARNOLD_SPLIT(List.of(
            DiaSemana.SEGUNDA,
            DiaSemana.TERCA,
            DiaSemana.QUARTA,
            DiaSemana.QUINTA,
            DiaSemana.SEXTA,
            DiaSemana.SÁBADO
    )),
    PPL_UPPER_LOWER(List.of(
            DiaSemana.SEGUNDA,
            DiaSemana.TERCA,
            DiaSemana.QUARTA,
            DiaSemana.QUINTA,
            DiaSemana.SEXTA
    )),
    ARNOLD_SPLIT_UPPER_LOWER(List.of(
            DiaSemana.SEGUNDA,
            DiaSemana.TERCA,
            DiaSemana.QUARTA,
            DiaSemana.QUINTA,
            DiaSemana.SEXTA
    ));

    private final List<DiaSemana> dias;

    DivisaoTreino(List<DiaSemana> dias){
        this.dias = dias;
    }

    public List<DiaSemana> getDias(){
        return dias;
    }
}
