package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Marca;
import view.*;

/**
 *
 * @author IFSC
 */
public class ControllerCadMarca implements ActionListener {

    TelaCadastroMarca telaCadastroMarca;

    public static int codigo;

    public ControllerCadMarca(TelaCadastroMarca telaCadastroMarca) {
        this.telaCadastroMarca = telaCadastroMarca;

        this.telaCadastroMarca.getjButtonNovo().addActionListener(this);
        this.telaCadastroMarca.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMarca.getjButtonGravar().addActionListener(this);
        this.telaCadastroMarca.getjButtonBuscar().addActionListener(this);
        this.telaCadastroMarca.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroMarca.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);

                utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), false);            this.telaCadastroMarca.getjTextFieldMarcaID().setEnabled(false);

            this.telaCadastroMarca.getjTextFieldMarca().requestFocus();

        } else if (e.getSource() == this.telaCadastroMarca.getjButtonCancelar()) {
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
            utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), true);
        } else if (e.getSource() == this.telaCadastroMarca.getjButtonBuscar()) {

            codigo = -1; // invalida a busca

            TelaBuscaMarca telaBuscaMarca = new TelaBuscaMarca
            (null, true);
            //ControllerBuscaMarca controllerBuscaMarca = new ControllerBuscaMarca(telaBuscaMarca);
            telaBuscaMarca.setVisible(true);

            if (codigo != -1) {
                utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);

                this.telaCadastroMarca.getjTextFieldMarcaID().setText(codigo + "");
                this.telaCadastroMarca.getjTextFieldMarcaID().setEnabled(false);

                Marca marca = new Marca();
                marca = service.MarcaService.Carregar(codigo);
            }

        } else if (e.getSource() == this.telaCadastroMarca.getjButtonGravar()) {

            if (this.telaCadastroMarca.getjTextFieldMarca().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "O nome da marca é Obrigatório....");
                } else {
                Marca marca = new Marca();
                marca.setDescricao(this.telaCadastroMarca.getjTextFieldMarca().getText());

                if (this.telaCadastroMarca.getjTextFieldMarcaID().getText().trim().equalsIgnoreCase("")) {
                    // inclusão
                    marca.setStatus('A');
                    service.MarcaService.Criar(marca);
                } else {
                    marca.setId(Integer.parseInt(this.telaCadastroMarca.getjTextFieldMarcaID().getText()));
                    service.MarcaService.Atualizar(marca);
                }

                utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
            }

        } else if (e.getSource() == this.telaCadastroMarca.getjButtonSair()) {
            this.telaCadastroMarca.dispose();
        }
    }
}