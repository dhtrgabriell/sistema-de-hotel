package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Quarto;
import view.TelaBuscaQuarto;

public class ControllerBuscaQuarto implements ActionListener {

    TelaBuscaQuarto telaBuscaQuarto;
    private List<Quarto> listaQuartos;

    public ControllerBuscaQuarto(TelaBuscaQuarto telaBuscaQuarto, List<Quarto> listaQuartos) {
        this.telaBuscaQuarto = telaBuscaQuarto;
        this.listaQuartos = listaQuartos;
        this.telaBuscaQuarto.getjButtonCarregar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonFiltar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonSair().addActionListener(this);
        carregarDadosNaTabela();
    }

    private void carregarDadosNaTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
        tabela.setRowCount(0);

        for (Quarto quarto : this.listaQuartos) {
            tabela.addRow(new Object[]{
                quarto.getId(),
                quarto.getDescricao(),
                quarto.getIdentificacao(),
                quarto.getAndar(),
                quarto.getStatus()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaQuarto.getjButtonCarregar()) {
            if (this.telaBuscaQuarto.getjTableDados().getSelectedRow() != -1) {
                ControllerCadQuarto.codigo = (int) this.telaBuscaQuarto.getjTableDados()
                        .getValueAt(this.telaBuscaQuarto.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaQuarto.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um registro para carregar.");
            }
        
        } else if (evento.getSource() == this.telaBuscaQuarto.getjButtonFiltar()) {
            String filtro = this.telaBuscaQuarto.getjTFFiltro().getText().trim();
            if (filtro.isEmpty()) {
                this.listaQuartos = service.QuartoService.Carregar("descricao", "");
            } else {
                String tipoFiltro = this.telaBuscaQuarto.getjCBFiltro().getSelectedItem().toString();

                if (tipoFiltro.equalsIgnoreCase("ID")) {
                    this.listaQuartos.clear();
                    Quarto quarto = service.QuartoService.Carregar(Integer.parseInt(filtro));
                    if (quarto != null) {
                        this.listaQuartos.add(quarto);
                    }
                } else { // Para todos os outros filtros de texto (Descricao, Identificacao, etc.)
                    this.listaQuartos = service.QuartoService.Carregar(tipoFiltro.toLowerCase(), filtro);
                }
            }
            carregarDadosNaTabela();
            
        } else if (evento.getSource() == this.telaBuscaQuarto.getjButtonSair()) {
            this.telaBuscaQuarto.dispose();
        }
    }
}