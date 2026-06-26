package Classes;

import Enuns.Plano;

public class PlanoConfig {

    public static double getDescontoProdutos(Plano plano) {
        return switch (plano) {
            case BASICO  -> 0.05;
            case PREMIUM -> 0.10;
            case VIP     -> 0.20;
        };
    }

    public static int getVencimentoDias(Plano plano) {
        return 30;
    }
}