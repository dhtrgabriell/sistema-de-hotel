package controller;

import java.util.ArrayList;
import model.ProdutoCopa;
import view.TelaCadastroCopa;

public class ProdutoCopaController {
    private ArrayList<ProdutoCopa> produtos = new ArrayList<>();

    TelaCadastroCopa telaCadastroCopa;

    public ProdutoCopaController(TelaCadastroCopa telaCadastroCopa) {


        //NÃO É O CORRETO, MAS PARA TESTAR
        //IMPLEMENTAR BANCO DE DADOS
        telaCadastroCopa.getjButtonNovo().addActionListener(e -> {
            String descricao = telaCadastroCopa.getjTextFieldDesc().getText();
            double preco;
            String obs = telaCadastroCopa.getjTextFieldOBS().getText();

            try {
                preco = Double.parseDouble(telaCadastroCopa.getjTextFieldValor().getText());
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preço inválido!");
                return;
            }
            int id = 0; // Implementar lógica para gerar ID único
            char status = 'A'; // 'A' para ativo, 'I' para inativo, etc.

            ProdutoCopa produto = new ProdutoCopa(id, descricao, preco, obs, status);
            produtos.add(produto);
            javax.swing.JOptionPane.showMessageDialog(null, "Produto adicionado!");
            telaCadastroCopa.getjTextFieldDesc().setText("");
            telaCadastroCopa.getjTextFieldValor().setText("");
        });

        telaCadastroCopa.getjButtonBuscar().addActionListener(e -> {
            StringBuilder lista = new StringBuilder("Produtos na Copa:\n");
            for (ProdutoCopa produto : produtos) {
                lista.append(produto).append("\n");
            }
            javax.swing.JOptionPane.showMessageDialog(null, lista.toString());
        });
    }
}
/*
 * 
 * public void adicionarProduto(ProdutoCopa produto) {
 * 
 * produtos.add(produto);
 * }
 * 
 * public ArrayList<ProdutoCopa> listarProdutos() {
 * return produtos;]]///
 */