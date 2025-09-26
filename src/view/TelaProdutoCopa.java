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

        JLabel lblDescricao = new JLabel("Descricao:");
        lblDescricao.setBounds(10, 10, 80, 25);
        add(lblDescricao);

        JTextField txtDescricao = new JTextField();
        txtDescricao.setBounds(100, 10, 160, 25);
        add(txtDescricao);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(10, 40, 80, 25);
        add(lblPreco);

        JTextField txtPreco = new JTextField();
        txtPreco.setBounds(100, 40, 160, 25);
        add(txtPreco);

        JLabel lblObs = new JLabel("Obs: ");
        lblObs.setBounds(10, 10, 80, 25);
        add(lblObs);
        
        JTextField txtObs = new JTextField();
        txtObs.setBounds(100, 40, 160, 25);
        add(txtObs);
        
        JLabel lblStatus = new JLabel("Status: ");
        lblStatus.setBounds(10, 10, 80, 25);
        add(lblObs);
        
        JTextField txtStatus = new JTextField();
        txtStatus.setBounds(100, 40, 160, 25);
        add(txtStatus);
        
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 10, 160, 25);
        add(btnSalvar);
        

        ProdutoCopaController controller = new ProdutoCopaController();

        btnSalvar.addActionListener(e -> {
            String descricao = txtDescricao.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            String obs = txtObs.getText();
            char status = txtStatus.getText().charAt(0);
            ProdutoCopa produto = new ProdutoCopa(0, descricao, preco, obs, status);
            controller.adicionarProduto(produto);
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
        });

        setVisible(true);
    }
}