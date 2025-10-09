package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.VagaEstacionamento;
import view.TelaBuscaVaga;

public class ControllerBuscaVagaEstacionamento implements ActionListener {

    TelaBuscaVaga telaBuscaVaga;
    private List<VagaEstacionamento> listaVagas;

    public ControllerBuscaVagaEstacionamento(TelaBuscaVaga telaBuscaVaga, List<VagaEstacionamento> listaVagas) {
        this.telaBuscaVaga = telaBuscaVaga;
        this.listaVagas = listaVagas;

        this.telaBuscaVaga.getjButtonCarregar().addActionListener(this);
        this.telaBuscaVaga.getjButtonFiltar().addActionListener(this);
        this.telaBuscaVaga.getjButtonSair().addActionListener(this);
        
        carregarDadosNaTabela();
    }
    
    private void carregarDadosNaTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVaga.getjTableDados().getModel();
        tabela.setRowCount(0);

        for (VagaEstacionamento vaga : this.listaVagas) {
            tabela.addRow(new Object[]{
                vaga.getId(),
                vaga.getDescricao(),
                vaga.getMetragemVaga(),
                vaga.getStatus()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaVaga.getjButtonCarregar()) {
            if (this.telaBuscaVaga.getjTableDados().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um registro para carregar.");
            } else {
                ControllerCadVaga.codigo = (int) this.telaBuscaVaga.getjTableDados()
                        .getValueAt(this.telaBuscaVaga.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaVaga.dispose();
            }
        
        } else if (evento.getSource() == this.telaBuscaVaga.getjButtonFiltar()) {
            String filtro = this.telaBuscaVaga.getjTFFiltro().getText().trim();
            if (filtro.isEmpty()) {
                this.listaVagas = service.VagaEstacionamentoService.Carregar("descricao", "");
            } else {
                String tipoFiltro = this.telaBuscaVaga.getjCBFiltro().getSelectedItem().toString();

                if (tipoFiltro.equalsIgnoreCase("ID")) {
                    this.listaVagas.clear();
                    VagaEstacionamento vaga = service.VagaEstacionamentoService.Carregar(Integer.parseInt(filtro));
                    if (vaga != null) {
                        this.listaVagas.add(vaga);
                    }
                } else if (tipoFiltro.equalsIgnoreCase("Descricao")) {
                    this.listaVagas = service.VagaEstacionamentoService.Carregar("descricao", filtro);
                }
            }
            carregarDadosNaTabela();
            
        } else if (evento.getSource() == this.telaBuscaVaga.getjButtonSair()) {
            this.telaBuscaVaga.dispose();
        }
    }
}