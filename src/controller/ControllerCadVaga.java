package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.VagaEstacionamento; 
import view.*;

public class ControllerCadVaga implements ActionListener {

    TelaCadastroVagaEstac telaCadastroVagaEstac;
    public static int codigo;

    public ControllerCadVaga(TelaCadastroVagaEstac telaCadastroVagaEstac) {
        this.telaCadastroVagaEstac = telaCadastroVagaEstac;

        this.telaCadastroVagaEstac.getjButtonNovo().addActionListener(this);
        this.telaCadastroVagaEstac.getjButtonCancelar().addActionListener(this);
        this.telaCadastroVagaEstac.getjButtonGravar().addActionListener(this);
        this.telaCadastroVagaEstac.getjButtonBuscar().addActionListener(this);
        this.telaCadastroVagaEstac.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroVagaEstac.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstac.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroVagaEstac.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVagaEstac.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstac.getjPanelDados(), true);
            this.telaCadastroVagaEstac.getjTextFieldID().setEnabled(false);
            this.telaCadastroVagaEstac.getjTextFieldDesc().requestFocus();

        } else if (e.getSource() == this.telaCadastroVagaEstac.getjButtonCancelar()) {
            utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstac.getjPanelDados(), false);
            utilities.Utilities.ativaDesativa(this.telaCadastroVagaEstac.getjPanelBotoes(), true);

        } else if (e.getSource() == this.telaCadastroVagaEstac.getjButtonBuscar()) {
            codigo = 0;

            List<VagaEstacionamento> listaDeVagas = service.VagaEstacionamentoService.Carregar("descricao", "");
            TelaBuscaVaga telaBuscaVaga = new TelaBuscaVaga(null, true);
            ControllerBuscaVagaEstacionamento controllerBusca = new ControllerBuscaVagaEstacionamento(telaBuscaVaga, listaDeVagas);
            telaBuscaVaga.setVisible(true);

            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroVagaEstac.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstac.getjPanelDados(), true);

                this.telaCadastroVagaEstac.getjTextFieldID().setText(String.valueOf(codigo));
                this.telaCadastroVagaEstac.getjTextFieldID().setEnabled(false);

                VagaEstacionamento vaga = service.VagaEstacionamentoService.Carregar(codigo);

                // Popula os campos corretos para VagaEstacionamento
                this.telaCadastroVagaEstac.getjTextFieldDesc().setText(vaga.getDescricao());
                this.telaCadastroVagaEstac.getjTextFieldObs().setText(vaga.getObs());
                this.telaCadastroVagaEstac.getjTextFieldMetragem().setText(String.valueOf(vaga.getMetragemVaga()));

                this.telaCadastroVagaEstac.getjTextFieldDesc().requestFocus();
            }

        } else if (e.getSource() == this.telaCadastroVagaEstac.getjButtonGravar()) {

            if (this.telaCadastroVagaEstac.getjTextFieldDesc().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O atributo Descrição da Vaga é obrigatório.");
                this.telaCadastroVagaEstac.getjTextFieldDesc().requestFocus();
            } else {
                VagaEstacionamento vaga = new VagaEstacionamento();
                vaga.setDescricao(this.telaCadastroVagaEstac.getjTextFieldDesc().getText());
                vaga.setObs(this.telaCadastroVagaEstac.getjTextFieldObs().getText());
                vaga.setStatus('A'); // Ou o status que vier da tela

                try {
                    float metragem = Float.parseFloat(this.telaCadastroVagaEstac.getjTextFieldMetragem().getText());
                    vaga.setMetragemVaga(metragem);

                    // Lógica de salvar só acontece se a conversão for bem-sucedida
                    if (this.telaCadastroVagaEstac.getjTextFieldID().getText().trim().isEmpty()) {
                        service.VagaEstacionamentoService.Criar(vaga);
                    } else {
                        vaga.setId(Integer.parseInt(this.telaCadastroVagaEstac.getjTextFieldID().getText()));
                        service.VagaEstacionamentoService.Atualizar(vaga);
                    }

                    utilities.Utilities.ativaDesativa(this.telaCadastroVagaEstac.getjPanelBotoes(), true);
                    utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstac.getjPanelDados(), false);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O valor da Metragem é inválido. Use apenas números e ponto decimal.");
                }
            }

        } else if (e.getSource() == this.telaCadastroVagaEstac.getjButtonSair()) {
            this.telaCadastroVagaEstac.dispose();
        }
    }
}