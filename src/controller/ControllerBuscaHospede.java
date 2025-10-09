package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Hospede;
import view.TelaBuscaHospede;

public class ControllerBuscaHospede implements ActionListener {

    TelaBuscaHospede telaBuscaHospede;

    public ControllerBuscaHospede(TelaBuscaHospede telaBuscaHospede) {

        this.telaBuscaHospede = telaBuscaHospede;

        this.telaBuscaHospede.getjButtonCarregar().addActionListener(this);
        this.telaBuscaHospede.getjButtonFiltar().addActionListener(this);
        this.telaBuscaHospede.getjButtonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaHospede.getjButtonCarregar()) {
            if (this.telaBuscaHospede.getjTableDados().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Erro: \nNão Existem Dados Selecionados para Edição !");
            } else {
                ControllerCadHospede.codigo = (int) this.telaBuscaHospede.getjTableDados().
                        getValueAt(this.telaBuscaHospede.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaHospede.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaHospede.getjButtonFiltar()) {
            if (this.telaBuscaHospede.getjTFFiltro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem Dados para a Seleção...");
            } else {
                if (this.telaBuscaHospede.getjCBFiltro().getSelectedIndex() == 0) {

                    Hospede hospede = new Hospede();

                    hospede = service.HospedeService.Carregar(Integer.parseInt(this.telaBuscaHospede.getjTFFiltro().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});

                } else if (this.telaBuscaHospede.getjCBFiltro().getSelectedIndex() == 1) {
                    List<Hospede> listaHospedes = new ArrayList<>();
                    listaHospedes = service.HospedeService.Carregar("nome", this.telaBuscaHospede.getjTFFiltro().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Hospede hospedeAtualDaLista : listaHospedes) {
                        tabela.addRow(new Object[]{hospedeAtualDaLista.getId(),
                            hospedeAtualDaLista.getNome(),
                            hospedeAtualDaLista.getCpf(),
                            hospedeAtualDaLista.getStatus()});
                    }

                } else if (this.telaBuscaHospede.getjCBFiltro().getSelectedIndex() == 2) {
                    List<Hospede> listaHospedes = new ArrayList<>();
                    listaHospedes = service.HospedeService.Carregar("cpf", this.telaBuscaHospede.getjTFFiltro().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Hospede hospedeAtualDaLista : listaHospedes) {
                        tabela.addRow(new Object[]{hospedeAtualDaLista.getId(),
                            hospedeAtualDaLista.getNome(),
                            hospedeAtualDaLista.getCpf(),
                            hospedeAtualDaLista.getStatus()});
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaHospede.getjButtonSair()) {
            this.telaBuscaHospede.dispose();
        }
    }
}
