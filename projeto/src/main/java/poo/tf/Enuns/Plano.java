package poo.tf.Enuns;

public enum Plano {

    BASICO(0.05, 30),
    PREMIUM(0.10, 30),
    VIP(0.20, 30);

    private double descontoProdutos;
    private int vencimentoDias;

    Plano(double descontoProdutos, int vencimentoDias) {
        this.descontoProdutos = descontoProdutos;
        this.vencimentoDias = vencimentoDias;
    }

    public double getDescontoProdutos() {
        return descontoProdutos;
    }
}
