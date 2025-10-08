package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Modelo;
import view.TelaBuscaModelo;

public class ControllerBuscaModelo implements ActionListener {

    TelaBuscaModelo telaBuscaModelo;
    private List<Modelo> listaModelos;

    public ControllerBuscaModelo(TelaBuscaModelo telaBuscaModelo, List<Modelo> listaModelos) {
        this.telaBuscaModelo = telaBuscaModelo;
        this.listaModelos = listaModelos;

        this.telaBuscaModelo.getjButtonCarregar().addActionListener(this);
        this.telaBuscaModelo.getjButtonFiltar().addActionListener(this);
        this.telaBuscaModelo.getjButtonSair().addActionListener(this);
        
        carregarDadosNaTabela();
    }
    
    private void carregarDadosNaTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
        tabela.setRowCount(0);

        for (Modelo modelo : this.listaModelos) {
            tabela.addRow(new Object[]{
                modelo.getId(),
                modelo.getDescricao(),
                modelo.getMarca().getDescricao(),
                modelo.getStatus()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaModelo.getjButtonCarregar()) {
            if (this.telaBuscaModelo.getjTableDados().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um registro para carregar.");
            } else {
                ControllerCadModelo.codigo = (int) this.telaBuscaModelo.getjTableDados()
                        .getValueAt(this.telaBuscaModelo.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaModelo.dispose();
            }
        
        } else if (evento.getSource() == this.telaBuscaModelo.getjButtonFiltar()) {
            if (this.telaBuscaModelo.getjTFFiltro().getText().trim().isEmpty()) {
                this.listaModelos = service.ModelService.Carregar("m.descricao", "");
            } else {
                String filtro = this.telaBuscaModelo.getjTFFiltro().getText();
                String tipoFiltro = this.telaBuscaModelo.getjCBFiltro().getSelectedItem().toString();

                if (tipoFiltro.equalsIgnoreCase("ID")) {
                    this.listaModelos.clear();
                    Modelo modelo = service.ModelService.Carregar(Integer.parseInt(filtro));
                    if (modelo != null) {
                        this.listaModelos.add(modelo);
                    }
                } else if (tipoFiltro.equalsIgnoreCase("Descricao")) {
                    this.listaModelos = service.ModelService.Carregar("m.descricao", filtro);

                } else if (tipoFiltro.equalsIgnoreCase("Marca")) {
                    this.listaModelos = service.ModelService.Carregar("ma.descricao", filtro);
                }
            }
            carregarDadosNaTabela();
            
        } else if (evento.getSource() == this.telaBuscaModelo.getjButtonSair()) {
            this.telaBuscaModelo.dispose();
        }
    }
}