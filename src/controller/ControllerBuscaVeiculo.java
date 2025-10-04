/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Veiculo;
import view.TelaBuscaVeiculo;

/**
 *
 * @author IFSC
 */
public class ControllerBuscaVeiculo implements ActionListener {

    private TelaBuscaVeiculo telaBuscaVeiculo;
    private ArrayList<Veiculo> listaDeVeiculos;


public ControllerBuscaVeiculo(TelaBuscaVeiculo telaBuscaVeiculo, ArrayList<Veiculo> listaDeVeiculos) {
        this.telaBuscaVeiculo = telaBuscaVeiculo;
        this.listaDeVeiculos = listaDeVeiculos;

        this.telaBuscaVeiculo.getjButtonCarregar().addActionListener(this);
        this.telaBuscaVeiculo.getjButtonFiltar().addActionListener(this);
        this.telaBuscaVeiculo.getjButtonSair().addActionListener(this);
    }


    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == this.telaBuscaVeiculo.getjButtonCarregar()) {
        DefaultTableModel tabelaModelo = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
        tabelaModelo.setRowCount(0);
        for (Veiculo veiculoAtual : this.listaDeVeiculos) {
            tabelaModelo.addRow(new Object[]{
                veiculoAtual.getId(),
                veiculoAtual.getMarca(),
                veiculoAtual.getModelo(),
                veiculoAtual.getAno(),
                veiculoAtual.getPlaca()
            });
        }
        } else if (e.getSource() == this.telaBuscaVeiculo.getjButtonFiltar()) {
            String tipoFiltro = this.telaBuscaVeiculo.getjCBFiltro().getSelectedItem().toString();
            String textoFiltro = this.telaBuscaVeiculo.getjTFFiltro().getText().trim();
            DefaultTableModel tabelaModelo = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
            tabelaModelo.setRowCount(0);

            for (Veiculo veiculoAtual : this.listaDeVeiculos) {
                boolean corresponde = false;
                switch (tipoFiltro) {
                    case "Id":
                        corresponde = String.valueOf(veiculoAtual.getId()).equals(textoFiltro);
                        break;
                    case "Marca":
                        corresponde = veiculoAtual.getMarca().toLowerCase().contains(textoFiltro.toLowerCase());
                        break;
                    case "Modelo":
                        corresponde = veiculoAtual.getModelo().toLowerCase().contains(textoFiltro.toLowerCase());
                        break;
                    case "Ano":
                        corresponde = String.valueOf(veiculoAtual.getAno()).equals(textoFiltro);
                        break;
                    case "Placa":
                        corresponde = veiculoAtual.getPlaca().toLowerCase().contains(textoFiltro.toLowerCase());
                        break;
                }
                if (corresponde) {
                    tabelaModelo.addRow(new Object[]{
                        veiculoAtual.getId(),
                        veiculoAtual.getMarca(),
                        veiculoAtual.getModelo(),
                        veiculoAtual.getAno(),
                        veiculoAtual.getPlaca()
                    });
                }
            }
        } else if (e.getSource() == this.telaBuscaVeiculo.getjButtonSair()) {
            this.telaBuscaVeiculo.dispose();
        }

}
