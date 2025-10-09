package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Quarto;
import view.TelaBuscaQuarto;
import view.TelaCadastroQuarto;

public class ControllerCadQuarto implements ActionListener {

    TelaCadastroQuarto telaCadQuarto;
    public static int codigo;

    public ControllerCadQuarto(TelaCadastroQuarto telaCadQuarto) {
        this.telaCadQuarto = telaCadQuarto;
        this.telaCadQuarto.getjButtonNovo().addActionListener(this);
        this.telaCadQuarto.getjButtonCancelar().addActionListener(this);
        this.telaCadQuarto.getjButtonGravar().addActionListener(this);
        this.telaCadQuarto.getjButtonBuscar().addActionListener(this);
        this.telaCadQuarto.getjButtonSair().addActionListener(this);
        utilities.Utilities.ativaDesativa(this.telaCadQuarto.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadQuarto.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadQuarto.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadQuarto.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadQuarto.getjPanelDados(), true);
            this.telaCadQuarto.getjTextFieldID().setEnabled(false);
            this.telaCadQuarto.getjTextFieldDescricao().requestFocus();

        } else if (e.getSource() == this.telaCadQuarto.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadQuarto.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadQuarto.getjPanelDados(), false);

        } else if (e.getSource() == this.telaCadQuarto.getjButtonBuscar()) {
            codigo = 0;
            List<Quarto> listaQuartos = service.QuartoService.Carregar("descricao", "");
            TelaBuscaQuarto telaBusca = new TelaBuscaQuarto(null, true);
            ControllerBuscaQuarto controllerBusca = new ControllerBuscaQuarto(telaBusca, listaQuartos);
            telaBusca.setVisible(true);

            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadQuarto.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadQuarto.getjPanelDados(), true);
                
                Quarto quarto = service.QuartoService.Carregar(codigo);
                this.telaCadQuarto.getjTextFieldID().setText(String.valueOf(quarto.getId()));
                this.telaCadQuarto.getjTextFieldDescricao().setText(quarto.getDescricao());
                
                this.telaCadQuarto.getjSpinnerCapacidade().setValue(quarto.getCapacidadeHospedes());
                
                this.telaCadQuarto.getjTextFieldMetragem().setText(String.valueOf(quarto.getMetragem()));
                this.telaCadQuarto.getjTextFieldIdentificacao().setText(quarto.getIdentificacao());

                this.telaCadQuarto.getjSpinnerAndar().setValue(quarto.getAndar());

                this.telaCadQuarto.getjCheckBox1().setSelected(quarto.isFlagAnimais());
                this.telaCadQuarto.getjTextFieldOBS().setText(quarto.getObs());
                this.telaCadQuarto.getjTextFieldID().setEnabled(false);
            }

        } else if (e.getSource() == this.telaCadQuarto.getjButtonGravar()) {
            if (this.telaCadQuarto.getjTextFieldDescricao().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "A Descrição é obrigatória.");
            } else {
                Quarto quarto = new Quarto();
                quarto.setDescricao(this.telaCadQuarto.getjTextFieldDescricao().getText());
                quarto.setIdentificacao(this.telaCadQuarto.getjTextFieldIdentificacao().getText());
                quarto.setObs(this.telaCadQuarto.getjTextFieldOBS().getText());
                quarto.setFlagAnimais(this.telaCadQuarto.getjCheckBox1().isSelected());
                quarto.setStatus('A');
                try {
                    quarto.setCapacidadeHospedes((int) this.telaCadQuarto.getjSpinnerCapacidade().getValue());
                    quarto.setMetragem(Float.parseFloat(this.telaCadQuarto.getjTextFieldMetragem().getText()));
                    quarto.setAndar((int) this.telaCadQuarto.getjSpinnerAndar().getValue());

                    if (this.telaCadQuarto.getjTextFieldID().getText().isEmpty()) {
                        service.QuartoService.Criar(quarto);
                    } else {
                        quarto.setId(Integer.parseInt(this.telaCadQuarto.getjTextFieldID().getText()));
                        service.QuartoService.Atualizar(quarto);
                    }
                    utilities.Utilities.ativaDesativa(this.telaCadQuarto.getjPanelBotoes(), true);
                    utilities.Utilities.limpaComponentes(this.telaCadQuarto.getjPanelDados(), false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O campo Metragem deve ser um número válido.");
                }
            }

        } else if (e.getSource() == this.telaCadQuarto.getjButtonSair()) {
            this.telaCadQuarto.dispose();
        }
    }
}