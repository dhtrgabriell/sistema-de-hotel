package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Veiculo;
import view.TelaBuscaVeiculo; // Alterado para Veiculo

public class ControllerBuscaVeiculo implements ActionListener { // Alterado

    TelaBuscaVeiculo telaBuscaVeiculo; // Alterado

    // O controller da busca agora precisa da lista de veículos
    private List<Veiculo> listaVeiculos;

    public ControllerBuscaVeiculo(TelaBuscaVeiculo telaBuscaVeiculo, List<Veiculo> listaVeiculos) { // Construtor Alterado
        this.telaBuscaVeiculo = telaBuscaVeiculo;
        this.listaVeiculos = listaVeiculos;

        this.telaBuscaVeiculo.getjButtonCarregar().addActionListener(this);
        this.telaBuscaVeiculo.getjButtonFiltar().addActionListener(this);
        this.telaBuscaVeiculo.getjButtonSair().addActionListener(this);

        // Preenche a tabela com os dados iniciais
        carregarDadosNaTabela();
    }

    // Método auxiliar para popular a tabela
    private void carregarDadosNaTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
        tabela.setRowCount(0); // Limpa a tabela

        for (Veiculo veiculo : listaVeiculos) {
            tabela.addRow(new Object[]{
                veiculo.getId(),
                veiculo.getPlaca(),
                veiculo.getModelo().getDescricao(), // Exibe a descrição do modelo
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
                // Retorna o código do Veiculo para a tela de cadastro de Veiculo
                ControllerCadVeiculo.codigo = (int) this.telaBuscaVeiculo.getjTableDados()
                        .getValueAt(this.telaBuscaVeiculo.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaVeiculo.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaVeiculo.getjButtonFiltar()) {
            if (this.telaBuscaVeiculo.getjTFFiltro().getText().trim().isEmpty()) {
                // Se o filtro está vazio, carrega todos os veículos
                this.listaVeiculos = service.VeiculoService.Carregar("v.placa", "");
            } else {
                String filtro = this.telaBuscaVeiculo.getjTFFiltro().getText();
                String tipoFiltro = this.telaBuscaVeiculo.getjCBFiltro().getSelectedItem().toString();

                // Busca por ID
                if (tipoFiltro.equalsIgnoreCase("ID")) {
                    this.listaVeiculos.clear();
                    Veiculo veiculo = service.VeiculoService.Carregar(Integer.parseInt(filtro));
                    if (veiculo != null) {
                        this.listaVeiculos.add(veiculo);
                    }
                // Busca por Placa do VEÍCULO
                } else if (tipoFiltro.equalsIgnoreCase("Placa")) {
                    this.listaVeiculos = service.VeiculoService.Carregar("v.placa", filtro);

                // Busca por Descrição do MODELO
                } else if (tipoFiltro.equalsIgnoreCase("Modelo")) {
                    // Assumindo que seu DAO usa o apelido 'mo' para a tabela de modelo no JOIN
                    this.listaVeiculos = service.VeiculoService.Carregar("mo.descricao", filtro);
                }
            }
            // Recarrega a tabela com os dados filtrados
            carregarDadosNaTabela();

        } else if (evento.getSource() == this.telaBuscaVeiculo.getjButtonSair()) {
            this.telaBuscaVeiculo.dispose();
        }
    }
}