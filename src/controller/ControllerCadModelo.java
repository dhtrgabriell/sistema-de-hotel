package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Marca;
import model.Modelo;
import view.*;

public class ControllerCadModelo implements ActionListener {

    TelaCadastroModelo telaCadastroModelo;
    public static int codigo;

    public ControllerCadModelo(TelaCadastroModelo telaCadastroModelo) {
        this.telaCadastroModelo = telaCadastroModelo;

        this.telaCadastroModelo.getjButtonNovo().addActionListener(this);
        this.telaCadastroModelo.getjButtonCancelar().addActionListener(this);
        this.telaCadastroModelo.getjButtonGravar().addActionListener(this);
        this.telaCadastroModelo.getjButtonBuscar().addActionListener(this);
        this.telaCadastroModelo.getjButtonSair().addActionListener(this);
        this.telaCadastroModelo.getjButtonNovaMarca().addActionListener(this);

        preencheComboBoxMarcas();

        utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);
    }

    private void preencheComboBoxMarcas() {
        this.telaCadastroModelo.getjComboBoxMarca().removeAllItems();
        this.telaCadastroModelo.getjComboBoxMarca().addItem("Selecione uma Marca");

        List<Marca> listaMarcas = service.MarcaService.Carregar("descricao", "");

        for (Marca marca : listaMarcas) {
            this.telaCadastroModelo.getjComboBoxMarca().addItem(marca.getDescricao());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroModelo.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), true);
            this.telaCadastroModelo.getjTextFieldID().setEnabled(false);
            this.telaCadastroModelo.getjTextFieldModelo().requestFocus();
            preencheComboBoxMarcas();

        } else if (e.getSource() == this.telaCadastroModelo.getjButtonCancelar()) {
            utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);
            utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanelBotoes(), true);

        } else if (e.getSource() == this.telaCadastroModelo.getjButtonBuscar()) {
            
            codigo = 0;
            
            List<Modelo> listaDeModelos = service.ModelService.Carregar("m.descricao", "");
            
            TelaBuscaModelo telaBuscaModelo = new TelaBuscaModelo(null, true);
            
            ControllerBuscaModelo controllerBuscaModelo = new ControllerBuscaModelo(telaBuscaModelo, listaDeModelos);
            
            telaBuscaModelo.setVisible(true);

            if (codigo != 0) {
                Modelo modelo = service.ModelService.Carregar(codigo);
                
                this.telaCadastroModelo.getjTextFieldID().setText(String.valueOf(modelo.getId()));
                this.telaCadastroModelo.getjTextFieldModelo().setText(modelo.getDescricao());
                this.telaCadastroModelo.getjComboBoxMarca().setSelectedItem(modelo.getMarca().getDescricao());
                
                this.telaCadastroModelo.getjTextFieldID().setEnabled(false);
                utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanelBotoes(), false);
            }
        } else if (e.getSource() == this.telaCadastroModelo.getjButtonGravar()) {
            if (this.telaCadastroModelo.getjTextFieldModelo().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "A Descrição do Modelo é obrigatória!");
            } else if (this.telaCadastroModelo.getjComboBoxMarca().getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Selecione uma Marca!");
            } else {
                Modelo modelo = new Modelo();
                modelo.setDescricao(this.telaCadastroModelo.getjTextFieldModelo().getText());
                modelo.setStatus('A');

                String marcaSelecionadaStr = this.telaCadastroModelo.getjComboBoxMarca().getSelectedItem().toString();
                Marca marcaSelecionadaObj = service.MarcaService.Carregar("descricao", marcaSelecionadaStr).get(0);

                modelo.setMarca(marcaSelecionadaObj);

                if (this.telaCadastroModelo.getjTextFieldID().getText().trim().isEmpty()) {
                    service.ModelService.Criar(modelo);
                } else {
                    modelo.setId(Integer.parseInt(this.telaCadastroModelo.getjTextFieldID().getText()));
                    service.ModelService.Atualizar(modelo);
                }

                utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);
            }

        } else if (e.getSource() == this.telaCadastroModelo.getjButtonSair()) {
            this.telaCadastroModelo.dispose();
            
        } else if (e.getSource() == this.telaCadastroModelo.getjButtonNovaMarca()) {
            TelaCadastroMarca telaCadastroMarca = new TelaCadastroMarca(null, true);
            ControllerCadMarca controllerCadMarca = new ControllerCadMarca(telaCadastroMarca);
            telaCadastroMarca.setVisible(true);
            preencheComboBoxMarcas();
        }
    }
}