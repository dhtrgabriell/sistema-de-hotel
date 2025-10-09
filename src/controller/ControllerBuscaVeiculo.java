package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Veiculo;
import view.TelaBuscaVeiculo;

public class ControllerBuscaVeiculo implements ActionListener {

    TelaBuscaVeiculo telaBuscaVeiculo;

    private List<Veiculo> listaVeiculos;

    public ControllerBuscaVeiculo(TelaBuscaVeiculo telaBuscaVeiculo, List<Veiculo> listaVeiculos) {
        this.telaBuscaVeiculo = telaBuscaVeiculo;
        this.listaVeiculos = listaVeiculos;

        this.telaBuscaVeiculo.getjButtonCarregar().addActionListener(this);
        this.telaBuscaVeiculo.getjButtonFiltar().addActionListener(this);
        this.telaBuscaVeiculo.getjButtonSair().addActionListener(this);

        carregarDadosNaTabela();
    }

    private void carregarDadosNaTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
        tabela.setRowCount(0);

        for (Veiculo veiculo : listaVeiculos) {
            tabela.addRow(new Object[]{
                veiculo.getId(),
                veiculo.getPlaca(),
                veiculo.getModelo().getDescricao(),
                veiculo.getCor(),
                veiculo.getStatus()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaVeiculo.getjButtonCarregar()) {
            if (this.telaBuscaVeiculo.getjTableDados().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um registro para carregar.");
            } else {
                ControllerCadVeiculo.codigo = (int) this.telaBuscaVeiculo.getjTableDados()
                        .getValueAt(this.telaBuscaVeiculo.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaVeiculo.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaVeiculo.getjButtonFiltar()) {
            if (this.telaBuscaVeiculo.getjTFFiltro().getText().trim().isEmpty()) {
                this.listaVeiculos = service.VeiculoService.Carregar("v.placa", "");
            } else {
                String filtro = this.telaBuscaVeiculo.getjTFFiltro().getText();
                String tipoFiltro = this.telaBuscaVeiculo.getjCBFiltro().getSelectedItem().toString();

                if (tipoFiltro.equalsIgnoreCase("ID")) {
                    this.listaVeiculos.clear();
                    Veiculo veiculo = service.VeiculoService.Carregar(Integer.parseInt(filtro));
                    if (veiculo != null) {
                        this.listaVeiculos.add(veiculo);
                    }
                } else if (tipoFiltro.equalsIgnoreCase("Placa")) {
                    this.listaVeiculos = service.VeiculoService.Carregar("v.placa", filtro);

                } else if (tipoFiltro.equalsIgnoreCase("Modelo")) {
                    this.listaVeiculos = service.VeiculoService.Carregar("mo.descricao", filtro);
                }
            }
            carregarDadosNaTabela();

        } else if (evento.getSource() == this.telaBuscaVeiculo.getjButtonSair()) {
            this.telaBuscaVeiculo.dispose();
        }
    }
}