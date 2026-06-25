package poo.tf.Classes;

import java.time.LocalDate;

public class Venda {

    private Cliente cliente;
    private Produto produto;
    private FuncionarioAdministrativo vendedor;
    private int quantidade;
    private LocalDate data;

    public Venda(Cliente cliente,
                 Produto produto,
                 FuncionarioAdministrativo vendedor,
                 int quantidade,
                 LocalDate data) {

        this.cliente = cliente;
        this.produto = produto;
        this.vendedor = vendedor;
        this.quantidade = quantidade;
        this.data = data;

        vendedor.registrarVenda(produto.getPreco() * quantidade);
    }

    public double getValorTotal() {

        double total = produto.getPreco() * quantidade;

        double desconto =
                cliente.getPlano().getDescontoProdutos();

        return total * (1 - desconto);
    }

    public FuncionarioAdministrativo getVendedor() {
        return vendedor;
    }
}