package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Modelo;
import model.Veiculo;
import view.TelaBuscaVeiculo;
import view.TelaCadastroModelo;
import view.TelaCadastroVeiculo;

public class ControllerCadVeiculo implements ActionListener {

    TelaCadastroVeiculo telaCadastroVeiculo;
    public static int codigo;

    public ControllerCadVeiculo(TelaCadastroVeiculo telaCadastroVeiculo) {
        this.telaCadastroVeiculo = telaCadastroVeiculo;

        // Adiciona os listeners
        this.telaCadastroVeiculo.getjButtonNovo().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonCancelar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonGravar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonBuscar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonSair().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonNovoModelo().addActionListener(this);

        // Preenche o ComboBox de Modelos
        preencheComboBoxModelos();

        utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
    }

    // MÉTODO NOVO PARA POPULAR O COMBOBOX DE MODELOS
    private void preencheComboBoxModelos() {
        this.telaCadastroVeiculo.getjComboBoxModelo().removeAllItems();
        this.telaCadastroVeiculo.getjComboBoxModelo().addItem("Selecione um Modelo");

        List<Modelo> listaModelos = service.ModelService.Carregar("m.descricao", "");
        for (Modelo modelo : listaModelos) {
            this.telaCadastroVeiculo.getjComboBoxModelo().addItem(modelo.getDescricao());
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), true);
            this.telaCadastroVeiculo.getjTextFieldId().setEnabled(false);
            this.telaCadastroVeiculo.getjTextFieldPlaca().requestFocus();
            preencheComboBoxModelos(); // Atualiza a lista de modelos

        } else if (evento.getSource() == this.telaCadastroVeiculo.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);

        } else if (evento.getSource() == this.telaCadastroVeiculo.getjButtonGravar()) {

            if (this.telaCadastroVeiculo.getjTextFieldPlaca().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O Atributo Placa é Obrigatório.");
                this.telaCadastroVeiculo.getjTextFieldPlaca().requestFocus();
            } else if (this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Selecione um Modelo.");
            } else {
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(this.telaCadastroVeiculo.getjTextFieldPlaca().getText());
                veiculo.setCor(this.telaCadastroVeiculo.getjTextFieldCor().getText());

                // CORRIGIDO: Pega a string do ComboBox, busca o objeto Modelo e o associa ao
                // Veiculo
                String modeloSelecionadoStr = this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedItem()
                        .toString();
                Modelo modeloSelecionadoObj = service.ModelService.Carregar("m.descricao", modeloSelecionadoStr).get(0);
                veiculo.setModelo(modeloSelecionadoObj);

                if (this.telaCadastroVeiculo.getjTextFieldId().getText().trim().isEmpty()) {
                    // Inclusão
                    veiculo.setStatus('A');
                    service.VeiculoService.Criar(veiculo);
                } else {
                    // Atualização
                    veiculo.setId(Integer.parseInt(this.telaCadastroVeiculo.getjTextFieldId().getText()));
                    service.VeiculoService.Atualizar(veiculo);
                }

                utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
            }
        } else if (evento.getSource() == this.telaCadastroVeiculo.getjButtonBuscar()) {

            codigo = 0;

            // CORRIGIDO: Passa o atributo com o apelido da tabela para evitar ambiguidade
            List<Veiculo> listaDeVeiculos = service.VeiculoService.Carregar("v.placa", "");

            TelaBuscaVeiculo telaBuscaVeiculo = new TelaBuscaVeiculo(null, true);
            ControllerBuscaVeiculo controllerBuscaVeiculo = new ControllerBuscaVeiculo(telaBuscaVeiculo,
                    listaDeVeiculos);
            telaBuscaVeiculo.setVisible(true);

            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), true);

                this.telaCadastroVeiculo.getjTextFieldId().setText(String.valueOf(codigo));
                this.telaCadastroVeiculo.getjTextFieldId().setEnabled(false);

                Veiculo veiculo = service.VeiculoService.Carregar(codigo);

                this.telaCadastroVeiculo.getjTextFieldCor().setText(veiculo.getCor());
                this.telaCadastroVeiculo.getjTextFieldPlaca().setText(veiculo.getPlaca());
                this.telaCadastroVeiculo.getjComboBoxModelo().setSelectedItem(veiculo.getModelo().getDescricao());

                this.telaCadastroVeiculo.getjTextFieldPlaca().requestFocus();
            }
        } else if (evento.getSource() == this.telaCadastroVeiculo.getjButtonSair()) {
            this.telaCadastroVeiculo.dispose();
        } else if (evento.getSource() == this.telaCadastroVeiculo.getjButtonNovoModelo()) {
            // Abre a tela de cadastro de modelo
            TelaCadastroModelo telaCadastroModelo = new TelaCadastroModelo(null, true);
            ControllerCadModelo controllerCadModelo = new ControllerCadModelo(telaCadastroModelo);
            telaCadastroModelo.setVisible(true);
            // Após fechar a tela de modelo, atualiza o ComboBox
            preencheComboBoxModelos();
        }
    }
}