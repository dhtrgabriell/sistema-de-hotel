package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import view.TelaBuscaFuncionario;

public class ControllerBuscaFuncionario implements ActionListener {

    TelaBuscaFuncionario telaBuscaFuncionario;

    public ControllerBuscaFuncionario(TelaBuscaFuncionario telaBuscaFuncionario) {

        this.telaBuscaFuncionario = telaBuscaFuncionario;

        this.telaBuscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonFiltar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaFuncionario.getjButtonCarregar()) {
            if (this.telaBuscaFuncionario.getjTableDados().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Erro: \nNão Existem Dados Selecionados para Edição !");
            } else {
                ControllerCadFuncionario.codigo = (int) this.telaBuscaFuncionario.getjTableDados().
                        getValueAt(this.telaBuscaFuncionario.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaFuncionario.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaFuncionario.getjButtonFiltar()) {
            if (this.telaBuscaFuncionario.getjTFFiltro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem Dados para a Seleção...");
            } else {
                if (this.telaBuscaFuncionario.getjCBFiltro().getSelectedIndex() == 0) {

                    Funcionario funcionario = new Funcionario();

                    funcionario = service.FuncionarioService.Carregar(Integer.parseInt(this.telaBuscaFuncionario.getjTFFiltro().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getStatus()});

                } else if (this.telaBuscaFuncionario.getjCBFiltro().getSelectedIndex() == 1) {
                    List<Funcionario> listaFuncionarios = new ArrayList<>();
                    listaFuncionarios = service.FuncionarioService.Carregar("nome", this.telaBuscaFuncionario.getjTFFiltro().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Funcionario funcionarioAtualDaLista : listaFuncionarios) {
                        tabela.addRow(new Object[]{funcionarioAtualDaLista.getId(),
                            funcionarioAtualDaLista.getNome(),
                            funcionarioAtualDaLista.getCpf(),
                            funcionarioAtualDaLista.getStatus()});
                    }

                } else if (this.telaBuscaFuncionario.getjCBFiltro().getSelectedIndex() == 2) {
                    List<Funcionario> listaFuncionarios = new ArrayList<>();
                    listaFuncionarios = service.FuncionarioService.Carregar("cpf", this.telaBuscaFuncionario.getjTFFiltro().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Funcionario funcionarioAtualDaLista : listaFuncionarios) {
                        tabela.addRow(new Object[]{funcionarioAtualDaLista.getId(),
                            funcionarioAtualDaLista.getNome(),
                            funcionarioAtualDaLista.getCpf(),
                            funcionarioAtualDaLista.getStatus()});
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaFuncionario.getjButtonSair()) {
            this.telaBuscaFuncionario.dispose();
        }
    }
}
