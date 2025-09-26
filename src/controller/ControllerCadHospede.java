package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Hospede;
import view.TelaBuscaHospede;
import view.TelaCadastroHospede;

public class ControllerCadHospede implements ActionListener {

    TelaCadastroHospede telaCadastroHospede;
    public static int codigo;

    public ControllerCadHospede(TelaCadastroHospede telaCadastroHospede) {

        this.telaCadastroHospede = telaCadastroHospede;

        this.telaCadastroHospede.getjButtonNovo().addActionListener(this);
        this.telaCadastroHospede.getjButtonCancelar().addActionListener(this);
        this.telaCadastroHospede.getjButtonGravar().addActionListener(this);
        this.telaCadastroHospede.getjButtonBuscar().addActionListener(this);
        this.telaCadastroHospede.getjButtonSair().addActionListener(this);

        //Desenvolver as setagens de situação inicial dos componentes
        /*this.telaCadastroHospede.getjButtonNovo().setEnabled(true);
        this.telaCadastroHospede.getjButtonCancelar().setEnabled(false);
        this.telaCadastroHospede.getjButtonGravar().setEnabled(false);
        this.telaCadastroHospede.getjButtonBuscar().setEnabled(true);
        this.telaCadastroHospede.getjButtonSair().setEnabled(true);*/
        utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroHospede.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), true);
            
            this.telaCadastroHospede.getjTextFieldId().setEnabled(false);
            this.telaCadastroHospede.getjTextFieldNomeFantasia().requestFocus();
            
            java.util.Date dataAtual = new Date();
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String novaData = dataFormatada.format(dataAtual);
            
            this.telaCadastroHospede.getjFormattedTextFieldDataCadastro().setText(novaData);
            this.telaCadastroHospede.getjFormattedTextFieldDataCadastro().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroHospede.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);
        } else if (evento.getSource() == this.telaCadastroHospede.getjButtonGravar()) {

            if (this.telaCadastroHospede.getjTextFieldNomeFantasia().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Obrigatório...");
                this.telaCadastroHospede.getjTextFieldNomeFantasia().requestFocus();
                return;
            } else {
                Hospede hospede = new Hospede();

                hospede.setNome(this.telaCadastroHospede.getjTextFieldNomeFantasia().getText());
                hospede.setRazaoSocial(this.telaCadastroHospede.getjTextFieldRazaoSocial().getText());
                hospede.setCpf(this.telaCadastroHospede.getjFormattedTextFieldCpf().getText());
                //Não pode setar o id se for um novo cadastro
                //Não efetuar o Status se for um novo cadastro

                if (this.telaCadastroHospede.getjTextFieldId().getText().trim().equalsIgnoreCase("")) {
                    //Gravar
                    hospede.setStatus('A');
                    service.HospedeService.Criar(hospede);
                } else {
                    //Alterar
                    hospede.setId(Integer.parseInt(this.telaCadastroHospede.getjTextFieldId().getText()));
                    service.HospedeService.Atualizar(hospede);
                }    
            }

            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);

        } else if (evento.getSource() == this.telaCadastroHospede.getjButtonBuscar()) {
            codigo = 0;
            
            TelaBuscaHospede telaBuscaHospede = new TelaBuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospede = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);

            if(codigo != 0){
                utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), true);

                this.telaCadastroHospede.getjTextFieldId().setText(codigo + "");
                this.telaCadastroHospede.getjTextFieldId().setEnabled(false);

                Hospede hospede = new Hospede();
                hospede = service.HospedeService.Carregar(codigo);

                this.telaCadastroHospede.getjFormattedTextFieldCep().setText(hospede.getCep());
                this.telaCadastroHospede.getjTextFieldNomeFantasia().setText(hospede.getNome());
                this.telaCadastroHospede.getjTextFieldRazaoSocial().setText(hospede.getRazaoSocial());
                this.telaCadastroHospede.getjFormattedTextFieldCpf().setText(hospede.getCpf());
            }
        } else if (evento.getSource() == this.telaCadastroHospede.getjButtonSair()) {
            this.telaCadastroHospede.dispose();
        }
    }
}
