package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fornecedor;
import view.TelaBuscaFornecedor;

public class ControllerBuscaFornecedor implements ActionListener {

    TelaBuscaFornecedor telaBuscaFornecedor;

    public ControllerBuscaFornecedor(TelaBuscaFornecedor telaBuscaFornecedor) {

        this.telaBuscaFornecedor = telaBuscaFornecedor;

        this.telaBuscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonFiltar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaFornecedor.getjButtonCarregar()) {
            if (this.telaBuscaFornecedor.getjTableDados().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Erro: \nNão Existem Dados Selecionados para Edição !");
            } else {
                ControllerCadFornecedor.codigo = (int) this.telaBuscaFornecedor.getjTableDados().
                        getValueAt(this.telaBuscaFornecedor.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaFornecedor.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaFornecedor.getjButtonFiltar()) {
            if (this.telaBuscaFornecedor.getjTFFiltro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem Dados para a Seleção...");
            } else {
                if (this.telaBuscaFornecedor.getjCBFiltro().getSelectedIndex() == 0) {

                    Fornecedor fornecedor = new Fornecedor();

                    fornecedor = service.FornecedorService.Carregar(Integer.parseInt(this.telaBuscaFornecedor.getjTFFiltro().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{fornecedor.getId(), fornecedor.getNome(), fornecedor.getCpf(), fornecedor.getStatus()});

                } else if (this.telaBuscaFornecedor.getjCBFiltro().getSelectedIndex() == 1) {
                    List<Fornecedor> listaFornecedors = new ArrayList<>();
                    listaFornecedors = service.FornecedorService.Carregar("nome", this.telaBuscaFornecedor.getjTFFiltro().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Fornecedor fornecedorAtualDaLista : listaFornecedors) {
                        tabela.addRow(new Object[]{fornecedorAtualDaLista.getId(),
                            fornecedorAtualDaLista.getNome(),
                            fornecedorAtualDaLista.getCpf(),
                            fornecedorAtualDaLista.getStatus()});
                    }

                } else if (this.telaBuscaFornecedor.getjCBFiltro().getSelectedIndex() == 2) {
                    List<Fornecedor> listaFornecedors = new ArrayList<>();
                    listaFornecedors = service.FornecedorService.Carregar("cpf", this.telaBuscaFornecedor.getjTFFiltro().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Fornecedor fornecedorAtualDaLista : listaFornecedors) {
                        tabela.addRow(new Object[]{fornecedorAtualDaLista.getId(),
                            fornecedorAtualDaLista.getNome(),
                            fornecedorAtualDaLista.getCpf(),
                            fornecedorAtualDaLista.getStatus()});
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaFornecedor.getjButtonSair()) {
            this.telaBuscaFornecedor.dispose();
        }
    }
}
