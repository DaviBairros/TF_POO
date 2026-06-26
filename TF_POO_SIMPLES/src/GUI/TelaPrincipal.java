package GUI;

import Classes.*;
import Enuns.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TelaPrincipal extends JFrame {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Venda> vendas = new ArrayList<>();

    private JTextField txtNomeCliente, txtIdadeCliente, txtCpfCliente;
    private JComboBox<Plano> cbPlano;
    private JComboBox<PerfilTreino> cbPerfil;
    private DefaultTableModel modelClientes;
    private JTable tblClientes;

    private JTextField txtNomeFuncionario, txtIdadeFuncionario, txtCpfFuncionario, txtSalario;
    private JTextField txtHorasTrabalhadas, txtValorHora;
    private JRadioButton rbAdministrativo, rbTreinador;
    private JPanel panelTreinadorExtra;
    private DefaultTableModel modelFuncionarios;
    private JTable tblFuncionarios;

    private JTextField txtNomeProduto, txtPrecoProduto;
    private DefaultTableModel modelProdutos;
    private JTable tblProdutos;

    private JComboBox<String> cbClienteVenda, cbProdutoVenda, cbVendedorVenda;
    private JTextField txtQuantidadeVenda;
    private DefaultTableModel modelVendas;
    private JTable tblVendas;

    private JComboBox<String> cbClienteTreino;
    private JLabel lblStatusTreino;
    private DefaultTableModel modelTreinos;
    private JTable tblTreinos;

    public TelaPrincipal() {
        setTitle("Sistema de Academia - TF POO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 600);
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();
        abas.addTab("Clientes", criarAbaClientes());
        abas.addTab("Funcionários", criarAbaFuncionarios());
        abas.addTab("Produtos", criarAbaProdutos());
        abas.addTab("Vendas", criarAbaVendas());
        abas.addTab("Treinos", criarAbaTreinos());
        abas.addTab("Estatísticas", criarAbaEstatisticas());

        add(abas);
        popularDadosExemplo();
    }

    //ABA CLIENTES

    private JPanel criarAbaClientes() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Cadastrar Cliente"));

        txtNomeCliente = new JTextField();
        txtIdadeCliente = new JTextField();
        txtCpfCliente = new JTextField();
        cbPlano = new JComboBox<>(Plano.values());
        cbPerfil = new JComboBox<>(PerfilTreino.values());

        form.add(new JLabel("Nome:"));    form.add(txtNomeCliente);
        form.add(new JLabel("Idade:"));   form.add(txtIdadeCliente);
        form.add(new JLabel("CPF:"));     form.add(txtCpfCliente);
        form.add(new JLabel("Plano:"));   form.add(cbPlano);
        form.add(new JLabel("Perfil:"));  form.add(cbPerfil);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnRemover = new JButton("Remover Selecionado");
        JPanel botoes = new JPanel(new GridLayout(1, 2, 5, 0));
        botoes.add(btnCadastrar); botoes.add(btnRemover);
        form.add(botoes);

        modelClientes = new DefaultTableModel(
                new String[]{"Nome", "Idade", "CPF", "Plano", "Perfil", "Min. Treinados"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblClientes = new JTable(modelClientes);

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(tblClientes), BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrarCliente());
        btnRemover.addActionListener(e -> removerCliente());
        return panel;
    }

    private void cadastrarCliente() {
        String nome = txtNomeCliente.getText().trim();
        String cpf = txtCpfCliente.getText().trim();
        String idadeStr = txtIdadeCliente.getText().trim();

        if (nome.isEmpty() || cpf.isEmpty() || idadeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(this, "CPF já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        int idade;
        try { idade = Integer.parseInt(idadeStr); if (idade <= 0) throw new NumberFormatException(); }
        catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Idade inválida."); return; }

        Plano plano = (Plano) cbPlano.getSelectedItem();
        PerfilTreino perfil = (PerfilTreino) cbPerfil.getSelectedItem();

        Cliente c = new Cliente(nome, idade, cpf, plano, perfil);
        clientes.add(c);
        modelClientes.addRow(new Object[]{c.getNome(), c.getIdade(), c.getCpf(), c.getPlano(), c.getPerfil(), c.getMinutosTreinados()});
        atualizarComboClientes();
        limparCamposCliente();
        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
    }

    private void removerCliente() {
        int row = tblClientes.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Selecione um cliente."); return; }
        clientes.remove(row);
        modelClientes.removeRow(row);
        atualizarComboClientes();
    }

    private void limparCamposCliente() {
        txtNomeCliente.setText(""); txtIdadeCliente.setText(""); txtCpfCliente.setText("");
        cbPlano.setSelectedIndex(0); cbPerfil.setSelectedIndex(0);
    }

    //ABA FUNCIONÁRIOS
    private JPanel criarAbaFuncionarios() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridLayout(8, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Cadastrar Funcionário"));

        txtNomeFuncionario = new JTextField();
        txtIdadeFuncionario = new JTextField();
        txtCpfFuncionario = new JTextField();
        txtSalario = new JTextField();
        txtHorasTrabalhadas = new JTextField();
        txtValorHora = new JTextField();
        rbAdministrativo = new JRadioButton("Administrativo", true);
        rbTreinador = new JRadioButton("Treinador");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbAdministrativo); bg.add(rbTreinador);

        panelTreinadorExtra = new JPanel(new GridLayout(1, 4, 3, 0));
        panelTreinadorExtra.add(new JLabel("Horas:")); panelTreinadorExtra.add(txtHorasTrabalhadas);
        panelTreinadorExtra.add(new JLabel("Vlr/hora:")); panelTreinadorExtra.add(txtValorHora);
        panelTreinadorExtra.setVisible(false);

        form.add(new JLabel("Nome:")); form.add(txtNomeFuncionario);
        form.add(new JLabel("Idade:")); form.add(txtIdadeFuncionario);
        form.add(new JLabel("CPF:")); form.add(txtCpfFuncionario);
        form.add(new JLabel("Salário Base:")); form.add(txtSalario);
        form.add(new JLabel("Tipo:"));
        JPanel rbPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        rbPanel.add(rbAdministrativo); rbPanel.add(rbTreinador);
        form.add(rbPanel);
        form.add(new JLabel("Extras (Treinador):")); form.add(panelTreinadorExtra);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnRemover   = new JButton("Remover Selecionado");
        JPanel botoes = new JPanel(new GridLayout(1, 2, 5, 0));
        botoes.add(btnCadastrar); botoes.add(btnRemover);
        form.add(botoes); form.add(new JLabel());

        modelFuncionarios = new DefaultTableModel(
                new String[]{"Nome", "Tipo", "CPF", "Salário Calculado"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblFuncionarios = new JTable(modelFuncionarios);

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(tblFuncionarios), BorderLayout.CENTER);

        rbTreinador.addActionListener(e -> panelTreinadorExtra.setVisible(true));
        rbAdministrativo.addActionListener(e -> panelTreinadorExtra.setVisible(false));
        btnCadastrar.addActionListener(e -> cadastrarFuncionario());
        btnRemover.addActionListener(e -> removerFuncionario());
        return panel;
    }

    private void cadastrarFuncionario() {
        String nome = txtNomeFuncionario.getText().trim();
        String cpf = txtCpfFuncionario.getText().trim();
        String idadeStr = txtIdadeFuncionario.getText().trim();
        String salStr = txtSalario.getText().trim();

        if (nome.isEmpty() || cpf.isEmpty() || idadeStr.isEmpty() || salStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos."); return;
        }
        int idade;
        try { idade = Integer.parseInt(idadeStr); }
        catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Idade inválida."); return; }
        double salario;
        try { salario = Double.parseDouble(salStr.replace(",", ".")); }
        catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Salário inválido."); return; }

        Funcionario f;
        if (rbTreinador.isSelected()) {
            String horasStr = txtHorasTrabalhadas.getText().trim();
            String vlrStr = txtValorHora.getText().trim();
            if (horasStr.isEmpty() || vlrStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha horas e valor/hora."); return;
            }
            int horas;
            try { horas = Integer.parseInt(horasStr); }
            catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Horas inválidas."); return; }
            double vlr;
            try { vlr = Double.parseDouble(vlrStr.replace(",", ".")); }
            catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Valor/hora inválido."); return; }
            f = new Treinador(nome, idade, cpf, salario, horas, vlr);
        } else {
            f = new FuncionarioAdministrativo(nome, idade, cpf, salario);
        }

        funcionarios.add(f);
        String tipo = (f instanceof Treinador) ? "Treinador" : "Administrativo";
        modelFuncionarios.addRow(new Object[]{f.getNome(), tipo, f.getCpf(), String.format("R$ %.2f", f.calcularSalario())});
        atualizarComboVendedores();
        limparCamposFuncionario();
        JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
    }

    private void removerFuncionario() {
        int row = tblFuncionarios.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Selecione um funcionário."); return; }
        funcionarios.remove(row);
        modelFuncionarios.removeRow(row);
        atualizarComboVendedores();
    }

    private void limparCamposFuncionario() {
        txtNomeFuncionario.setText(""); txtIdadeFuncionario.setText("");
        txtCpfFuncionario.setText(""); txtSalario.setText("");
        txtHorasTrabalhadas.setText(""); txtValorHora.setText("");
        rbAdministrativo.setSelected(true);
        panelTreinadorExtra.setVisible(false);
    }

    //ABA PRODUTOS

    private JPanel criarAbaProdutos() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Cadastrar Produto"));

        txtNomeProduto = new JTextField();
        txtPrecoProduto = new JTextField();

        form.add(new JLabel("Nome:")); form.add(txtNomeProduto);
        form.add(new JLabel("Preço:")); form.add(txtPrecoProduto);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnRemover = new JButton("Remover Selecionado");
        JPanel botoes = new JPanel(new GridLayout(1, 2, 5, 0));
        botoes.add(btnCadastrar); botoes.add(btnRemover);
        form.add(botoes);

        modelProdutos = new DefaultTableModel(new String[]{"Nome", "Preço"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblProdutos = new JTable(modelProdutos);

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(tblProdutos), BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrarProduto());
        btnRemover.addActionListener(e -> removerProduto());
        return panel;
    }

    private void cadastrarProduto() {
        String nome = txtNomeProduto.getText().trim();
        String precoStr = txtPrecoProduto.getText().trim();
        if (nome.isEmpty() || precoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos."); return;
        }
        double preco;
        try { preco = Double.parseDouble(precoStr.replace(",", ".")); }
        catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Preço inválido."); return; }

        Produto p = new Produto(nome, preco);
        produtos.add(p);
        modelProdutos.addRow(new Object[]{p.getNome(), String.format("R$ %.2f", p.getPreco())});
        atualizarComboProdutos();
        txtNomeProduto.setText(""); txtPrecoProduto.setText("");
        JOptionPane.showMessageDialog(this, "Produto cadastrado!");
    }

    private void removerProduto() {
        int row = tblProdutos.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Selecione um produto."); return; }
        produtos.remove(row);
        modelProdutos.removeRow(row);
        atualizarComboProdutos();
    }

    //ABA VENDAS

    private JPanel criarAbaVendas() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Registrar Venda"));

        cbClienteVenda = new JComboBox<>();
        cbProdutoVenda = new JComboBox<>();
        cbVendedorVenda = new JComboBox<>();
        txtQuantidadeVenda = new JTextField();

        form.add(new JLabel("Cliente:")); form.add(cbClienteVenda);
        form.add(new JLabel("Produto:")); form.add(cbProdutoVenda);
        form.add(new JLabel("Vendedor:")); form.add(cbVendedorVenda);
        form.add(new JLabel("Quantidade:")); form.add(txtQuantidadeVenda);

        JButton btnRegistrar = new JButton("Registrar Venda");
        form.add(btnRegistrar); form.add(new JLabel());

        modelVendas = new DefaultTableModel(
                new String[]{"Cliente", "Produto", "Qtd", "Vendedor", "Total c/ Desconto"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblVendas = new JTable(modelVendas);

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(tblVendas), BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> registrarVenda());
        return panel;
    }

    private void registrarVenda() {
        if (cbClienteVenda.getItemCount() == 0 || cbProdutoVenda.getItemCount() == 0 || cbVendedorVenda.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cadastre clientes, produtos e funcionários administrativos primeiro."); return;
        }
        String qtdStr = txtQuantidadeVenda.getText().trim();
        if (qtdStr.isEmpty()) { JOptionPane.showMessageDialog(this, "Informe a quantidade."); return; }
        int qtd;
        try { qtd = Integer.parseInt(qtdStr); if (qtd <= 0) throw new NumberFormatException(); }
        catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Quantidade inválida."); return; }

        Cliente cliente = clientes.get(cbClienteVenda.getSelectedIndex());
        Produto produto = produtos.get(cbProdutoVenda.getSelectedIndex());
        ArrayList<FuncionarioAdministrativo> admins = getAdministrativos();
        FuncionarioAdministrativo vendedor = admins.get(cbVendedorVenda.getSelectedIndex());

        Venda v = new Venda(cliente, produto, vendedor, qtd, LocalDate.now());
        vendas.add(v);
        modelVendas.addRow(new Object[]{
                cliente.getNome(), produto.getNome(), qtd,
                vendedor.getNome(), String.format("R$ %.2f", v.getValorTotal())
        });
        atualizarSalarioFuncionarios();
        txtQuantidadeVenda.setText("");
        JOptionPane.showMessageDialog(this, String.format("Venda registrada!\nTotal: R$ %.2f", v.getValorTotal()));
    }

    //ABA TREINOS

    private JPanel criarAbaTreinos() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Controle de Treino"));

        cbClienteTreino = new JComboBox<>();
        lblStatusTreino = new JLabel("Selecione um cliente.");

        form.add(new JLabel("Cliente:"));  form.add(cbClienteTreino);
        form.add(new JLabel("Status:"));   form.add(lblStatusTreino);

        JButton btnIniciar   = new JButton("Iniciar Treino");
        JButton btnFinalizar = new JButton("Finalizar Treino");
        form.add(btnIniciar); form.add(btnFinalizar);

        modelTreinos = new DefaultTableModel(
                new String[]{"Cliente", "Status", "Min. Acumulados"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblTreinos = new JTable(modelTreinos);

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(tblTreinos), BorderLayout.CENTER);

        cbClienteTreino.addActionListener(e -> atualizarStatusTreino());
        btnIniciar.addActionListener(e -> iniciarTreino());
        btnFinalizar.addActionListener(e -> finalizarTreino());
        return panel;
    }

    private void atualizarStatusTreino() {
        if (cbClienteTreino.getItemCount() == 0) return;
        Cliente c = clientes.get(cbClienteTreino.getSelectedIndex());
        lblStatusTreino.setText(c.isTreinando() ? "Em treino (" + c.getMinutosTreinoAtual() + " min)" : "Parado");
    }

    private void iniciarTreino() {
        if (cbClienteTreino.getItemCount() == 0) { JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado."); return; }
        Cliente c = clientes.get(cbClienteTreino.getSelectedIndex());
        JOptionPane.showMessageDialog(this, c.iniciarTreino());
        atualizarStatusTreino();
        atualizarTabelaTreinos();
    }

    private void finalizarTreino() {
        if (cbClienteTreino.getItemCount() == 0) { JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado."); return; }
        Cliente c = clientes.get(cbClienteTreino.getSelectedIndex());
        JOptionPane.showMessageDialog(this, c.finalizarTreino());
        atualizarStatusTreino();
        atualizarTabelaTreinos();
        atualizarTabelaClientes();
    }

    private void atualizarTabelaTreinos() {
        modelTreinos.setRowCount(0);
        for (Cliente c : clientes)
            modelTreinos.addRow(new Object[]{c.getNome(), c.isTreinando() ? "Treinando" : "Parado", c.getMinutosTreinados() + " min"});
    }

    //ABA ESTATÍSTICAS

    private JPanel criarAbaEstatisticas() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextArea txtEstat = new JTextArea();
        txtEstat.setEditable(false);
        txtEstat.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JButton btnAtualizar = new JButton("Atualizar Estatísticas");
        btnAtualizar.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            sb.append("=== ESTATÍSTICAS DA ACADEMIA ===\n\n");

            sb.append("-- Clientes (por horas treinadas) --\n");
            clientes.stream()
                    .sorted((a, b) -> Double.compare(b.getValorEstatistico(), a.getValorEstatistico()))
                    .forEach(c -> sb.append(String.format("  %-20s %d minutos\n", c.getNome(), (int) c.getValorEstatistico())));

            sb.append("\n-- Funcionários Administrativos (por comissão) --\n");
            getAdministrativos().stream()
                    .sorted((a, b) -> Double.compare(b.getValorEstatistico(), a.getValorEstatistico()))
                    .forEach(f -> sb.append(String.format("  %-20s Comissão: R$ %.2f | Salário: R$ %.2f\n",
                            f.getNome(), f.getValorEstatistico(), f.calcularSalario())));

            sb.append("\n-- Treinadores --\n");
            funcionarios.stream()
                    .filter(f -> f instanceof Treinador)
                    .forEach(f -> sb.append(String.format("  %-20s Salário: R$ %.2f\n", f.getNome(), f.calcularSalario())));

            double totalVendas = vendas.stream().mapToDouble(Venda::getValorTotal).sum();
            sb.append(String.format("\n-- Total Vendas: R$ %.2f (%d vendas) --\n", totalVendas, vendas.size()));

            txtEstat.setText(sb.toString());
        });

        panel.add(btnAtualizar, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtEstat), BorderLayout.CENTER);
        return panel;
    }

    //UTILITÁRIOS

    private ArrayList<FuncionarioAdministrativo> getAdministrativos() {
        ArrayList<FuncionarioAdministrativo> lista = new ArrayList<>();
        for (Funcionario f : funcionarios)
            if (f instanceof FuncionarioAdministrativo adm) lista.add(adm);
        return lista;
    }

    private void atualizarComboClientes() {
        cbClienteVenda.removeAllItems();
        cbClienteTreino.removeAllItems();
        for (Cliente c : clientes) { cbClienteVenda.addItem(c.getNome()); cbClienteTreino.addItem(c.getNome()); }
    }

    private void atualizarComboProdutos() {
        cbProdutoVenda.removeAllItems();
        for (Produto p : produtos) cbProdutoVenda.addItem(p.getNome());
    }

    private void atualizarComboVendedores() {
        cbVendedorVenda.removeAllItems();
        for (FuncionarioAdministrativo a : getAdministrativos()) cbVendedorVenda.addItem(a.getNome());
    }

    private void atualizarTabelaClientes() {
        modelClientes.setRowCount(0);
        for (Cliente c : clientes)
            modelClientes.addRow(new Object[]{c.getNome(), c.getIdade(), c.getCpf(), c.getPlano(), c.getPerfil(), c.getMinutosTreinados()});
    }

    private void atualizarSalarioFuncionarios() {
        for (int i = 0; i < funcionarios.size(); i++)
            modelFuncionarios.setValueAt(String.format("R$ %.2f", funcionarios.get(i).calcularSalario()), i, 3);
    }

    private void popularDadosExemplo() {
        Produto p1 = new Produto("Whey Protein 1kg", 89.90);
        Produto p2 = new Produto("Camiseta Academia", 49.90);
        produtos.add(p1); produtos.add(p2);
        modelProdutos.addRow(new Object[]{p1.getNome(), String.format("R$ %.2f", p1.getPreco())});
        modelProdutos.addRow(new Object[]{p2.getNome(), String.format("R$ %.2f", p2.getPreco())});

        FuncionarioAdministrativo adm = new FuncionarioAdministrativo("Carlos Admin", 30, "111.222.333-44", 2500.0);
        funcionarios.add(adm);
        modelFuncionarios.addRow(new Object[]{adm.getNome(), "Administrativo", adm.getCpf(), String.format("R$ %.2f", adm.calcularSalario())});

        Treinador tr = new Treinador("João Treinador", 28, "555.666.777-88", 1800.0, 160, 15.0);
        funcionarios.add(tr);
        modelFuncionarios.addRow(new Object[]{tr.getNome(), "Treinador", tr.getCpf(), String.format("R$ %.2f", tr.calcularSalario())});

        Cliente c1 = new Cliente("Ana Silva", 25, "999.888.777-66", Plano.PREMIUM, PerfilTreino.NORMAL);
        clientes.add(c1);
        modelClientes.addRow(new Object[]{c1.getNome(), c1.getIdade(), c1.getCpf(), c1.getPlano(), c1.getPerfil(), c1.getMinutosTreinados()});

        atualizarComboClientes();
        atualizarComboProdutos();
        atualizarComboVendedores();
        atualizarTabelaTreinos();
    }
}