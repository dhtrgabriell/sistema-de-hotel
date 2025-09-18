package view;

import javax.swing.*;
import model.ProdutoCopa;
import controller.ProdutoCopaController;

public class TelaProdutoCopa extends JFrame {
    public TelaProdutoCopa() {
        setTitle("Cadastro de Produto da Copa");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 80, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 10, 160, 25);
        add(txtNome);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(10, 40, 80, 25);
        add(lblPreco);

        JTextField txtPreco = new JTextField();
        txtPreco.setBounds(100, 40, 160, 25);
        add(txtPreco);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 80, 100, 25);
        add(btnSalvar);

        ProdutoCopaController controller = new ProdutoCopaController();

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            ProdutoCopa produto = new ProdutoCopa(0, nome, preco);
            controller.adicionarProduto(produto);
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
        });

        setVisible(true);
    }
}