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

            Date dataAtual = new Date();
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String novaData = dataFormatada.format(dataAtual);
            this.telaCadastroHospede.getjFormattedTextFieldDataDeCadastro().setText(novaData);
            this.telaCadastroHospede.getjFormattedTextFieldDataDeCadastro().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroHospede.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);
        } else if (evento.getSource() == this.telaCadastroHospede.getjButtonGravar()) {
            ///////////// LOGICA DE VALIDAÇÃO CPF/CNPJ

            String cnpjToValidate = this.telaCadastroHospede.getjFormattedTextFieldCnpj().getText().replaceAll("\\D", "");
            String cpfToValidate = this.telaCadastroHospede.getjFormattedTextFieldCpf().getText().replaceAll("\\D","");
            boolean cpfvalido = service.ValidarDoc.validarCPF(cpfToValidate);
            boolean cnpjvalido = service.ValidarDoc.validarCNPJ(cnpjToValidate);

            if (cnpjToValidate.isEmpty() && cpfToValidate.isEmpty()) {
                JOptionPane.showMessageDialog(telaCadastroHospede,"Preencha pelo menos um dos campos (CPF ou CNPJ).");
                return;
            }
            if (!cnpjToValidate.isEmpty() && !cpfToValidate.isEmpty()) {
                JOptionPane.showMessageDialog(telaCadastroHospede, "Preencha somente um dos campos (CPF ou CNPJ).");
                return;
            }
            if (!cpfToValidate.isEmpty() && !cpfvalido) {
                JOptionPane.showMessageDialog(telaCadastroHospede, "CPF Invalido.");
                return;
            }
            if (!cnpjToValidate.isEmpty() && !cnpjvalido) {
                JOptionPane.showMessageDialog(telaCadastroHospede, "CNPJ Invalido.");
                return;
            }

            if (this.telaCadastroHospede.getjTextFieldNomeFantasia().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Nome é Obrigatório....");
                this.telaCadastroHospede.getjTextFieldNomeFantasia().requestFocus();
            } else {
                Hospede hospede = new Hospede();
                hospede.setNome(this.telaCadastroHospede.getjTextFieldNomeFantasia().getText());
                hospede.setRazaoSocial(this.telaCadastroHospede.getjTextFieldRazaoSocial().getText());
                hospede.setCpf(this.telaCadastroHospede.getjFormattedTextFieldCpf().getText());
                hospede.setCep(this.telaCadastroHospede.getjFormattedTextFieldCep().getText());
                hospede.setRg(this.telaCadastroHospede.getjTextFieldRg().getText());
                hospede.setBairro(this.telaCadastroHospede.getjTextFieldBairro().getText());
                hospede.setCidade(this.telaCadastroHospede.getjTextFieldCidade().getText());
                hospede.setComplemento(this.telaCadastroHospede.getjTextFieldComplemento().getText());
                hospede.setEmail(this.telaCadastroHospede.getjTextFieldEmail().getText());
                hospede.setFone1(this.telaCadastroHospede.getjFormattedTextFieldFone1().getText());
                hospede.setFone2(this.telaCadastroHospede.getjFormattedTextFieldFone2().getText());
                hospede.setLogradouro(this.telaCadastroHospede.getjTextFieldLogradouro().getText());
                hospede.setObs(this.telaCadastroHospede.getjTextFieldObs().getText());
                hospede.setContato(this.telaCadastroHospede.getjTextFieldContato().getText());
                hospede.setCnpj(this.telaCadastroHospede.getjFormattedTextFieldCnpj().getText());
                hospede.setInscricaoEstadual(this.telaCadastroHospede.getjTextFieldInscricaoEstadual().getText());
                hospede.setSexo(this.telaCadastroHospede.getjComboBoxSexo().getSelectedItem().toString().charAt(0));

                if (this.telaCadastroHospede.getjTextFieldId().getText().trim().equalsIgnoreCase("")) {
                    hospede.setStatus('A');
                    service.HospedeService.Criar(hospede);
                } else {
                    hospede.setId(Integer.parseInt(this.telaCadastroHospede.getjTextFieldId().getText()));
                    service.HospedeService.Atualizar(hospede);
                }

                utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);
            }
        } else if (evento.getSource() == this.telaCadastroHospede.getjButtonBuscar()) {

            codigo = 0;

            TelaBuscaHospede telaBuscaHospede = new TelaBuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospede = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);

            if (codigo != 0) {
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

                this.telaCadastroHospede.getjTextFieldNomeFantasia().requestFocus();

            }
        } else if (evento.getSource() == this.telaCadastroHospede.getjButtonSair()) {
            this.telaCadastroHospede.dispose();
        }
    }
}
