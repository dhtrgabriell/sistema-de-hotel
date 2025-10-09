package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ProdutoCopa;
import view.TelaBuscaProdutoCopa;

public class ControllerBuscaProdutoCopa implements ActionListener {

    TelaBuscaProdutoCopa telaBuscaProdutoCopa;
    private List<ProdutoCopa> listaProdutos;

    public ControllerBuscaProdutoCopa(TelaBuscaProdutoCopa telaBuscaProdutoCopa, List<ProdutoCopa> listaProdutos) {
        this.telaBuscaProdutoCopa = telaBuscaProdutoCopa;
        this.listaProdutos = listaProdutos;

        this.telaBuscaProdutoCopa.getjButtonCarregar().addActionListener(this);
        this.telaBuscaProdutoCopa.getjButtonFiltar().addActionListener(this);
        this.telaBuscaProdutoCopa.getjButtonSair().addActionListener(this);
        
        carregarDadosNaTabela();
    }

    private void carregarDadosNaTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProdutoCopa.getjTableDados().getModel();
        tabela.setRowCount(0);

        for (ProdutoCopa produto : this.listaProdutos) {
            tabela.addRow(new Object[]{
                produto.getId(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getStatus()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaProdutoCopa.getjButtonCarregar()) {
            if (this.telaBuscaProdutoCopa.getjTableDados().getSelectedRow() != -1) {
                ControllerCadProdutoCopa.codigo = (int) this.telaBuscaProdutoCopa.getjTableDados()
                        .getValueAt(this.telaBuscaProdutoCopa.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaProdutoCopa.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um registro para carregar.");
            }
        
        } else if (evento.getSource() == this.telaBuscaProdutoCopa.getjButtonFiltar()) {
            String filtro = this.telaBuscaProdutoCopa.getjTFFiltro().getText().trim();
            if (filtro.isEmpty()) {
                this.listaProdutos = service.ProdutoCopaService.Carregar("decricao", "");
            } else {
                String tipoFiltro = this.telaBuscaProdutoCopa.getjCBFiltro().getSelectedItem().toString();

                if (tipoFiltro.equalsIgnoreCase("ID")) {
                    this.listaProdutos.clear();
                    ProdutoCopa produto = service.ProdutoCopaService.Carregar(Integer.parseInt(filtro));
                    if (produto != null) {
                        this.listaProdutos.add(produto);
                    }
                } else if (tipoFiltro.equalsIgnoreCase("Descricao")) {
                    this.listaProdutos = service.ProdutoCopaService.Carregar("decricao", filtro);
                }
            }
            carregarDadosNaTabela();
            
        } else if (evento.getSource() == this.telaBuscaProdutoCopa.getjButtonSair()) {
            this.telaBuscaProdutoCopa.dispose();
        }
    }
}