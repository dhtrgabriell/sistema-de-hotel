package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.classfile.instruction.SwitchCase;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.*;

public class ControllerCadFuncionario implements ActionListener {

    TelaCadastroFuncionario telaCadastroFuncionario;

    public static int codigo;

    public ControllerCadFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
        this.telaCadastroFuncionario = telaCadastroFuncionario;

        this.telaCadastroFuncionario.getjButtonNovo().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonGravar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroFuncionario.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), true);

            this.telaCadastroFuncionario.controlaCampos(true);
            this.telaCadastroFuncionario.getjTextFieldId().setEnabled(false);

            Date dataAtual = new Date();
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String novaData = dataFormatada.format(dataAtual);
            this.telaCadastroFuncionario.getjFormattedTextFieldDataCadastro().setText(novaData);
            this.telaCadastroFuncionario.getjFormattedTextFieldDataCadastro().setEnabled(false);

            this.telaCadastroFuncionario.getjTextFieldNomeFantasia().requestFocus();

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonCancelar()) {
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
            this.telaCadastroFuncionario.controlaCampos(false);

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonBuscar()) {

            codigo = -1;

            TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario(null, true);
            ControllerBuscaFuncionario controllerBuscaFuncionario = new ControllerBuscaFuncionario(
                    telaBuscaFuncionario);
            telaBuscaFuncionario.setVisible(true);

            if (codigo != -1) {
                utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), true);

                this.telaCadastroFuncionario.getjTextFieldId().setText(codigo + "");
                this.telaCadastroFuncionario.getjTextFieldId().setEnabled(false);

                Funcionario funcionario = new Funcionario();
                funcionario = service.FuncionarioService.Carregar(codigo);

                this.telaCadastroFuncionario.getjFormattedTextFieldCep().setText(funcionario.getCep());
                this.telaCadastroFuncionario.getjTextFieldNomeFantasia().setText(funcionario.getNome());
                this.telaCadastroFuncionario.getjTextFieldRg().setText(funcionario.getRg());

                this.telaCadastroFuncionario.getjTextFieldNomeFantasia().requestFocus();
            }

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonGravar()) {
            ///////////// LOGICA DE VALIDAÇÃO CPF/CNPJ

            String cnpjToValidate = this.telaCadastroFuncionario.getjFormattedTextFieldCnpj().getText().replaceAll("\\D", "");
            String cpfToValidate = this.telaCadastroFuncionario.getjFormattedTextFieldCpf().getText().replaceAll("\\D","");
            boolean cpfvalido = service.ValidarDoc.validarCPF(cpfToValidate);
            boolean cnpjvalido = service.ValidarDoc.validarCNPJ(cnpjToValidate);

            if (cnpjToValidate.isEmpty() && cpfToValidate.isEmpty()) {
                JOptionPane.showMessageDialog(telaCadastroFuncionario,"Preencha pelo menos um dos campos (CPF ou CNPJ).");
                return;
            }
            if (!cnpjToValidate.isEmpty() && !cpfToValidate.isEmpty()) {
                JOptionPane.showMessageDialog(telaCadastroFuncionario, "Preencha somente um dos campos (CPF ou CNPJ).");
                return;
            }
            if (!cpfToValidate.isEmpty() && !cpfvalido) {
                JOptionPane.showMessageDialog(telaCadastroFuncionario, "CPF Invalido.");
                return;
            }
            if (!cnpjToValidate.isEmpty() && !cnpjvalido) {
                JOptionPane.showMessageDialog(telaCadastroFuncionario, "CNPJ Invalido.");
                return;
            }

            /*
             * if (vcnpj.isEmpty() && vcpf.isEmpty()) {
             * JOptionPane.showMessageDialog(telaCadastroFuncionario,
             * "Deve ser informado ao menos CPF ou CNPJ");
             * this.telaCadastroFuncionario.getjFormattedTextFieldCpf().requestFocus();
             * } else if (vcnpj.isEmpty() ^ vcpf.isEmpty() && vcnpj.isEmpty() &&
             * cpfValidator.validarCPF(vcpf)) {
             * } else if (!cnpjValidator.validarCNPJ(vcnpj)) {
             * JOptionPane.showMessageDialog(telaCadastroFuncionario,
             * "CNPJ Inserido é Invalido");
             * this.telaCadastroFuncionario.getjFormattedTextFieldCnpj().requestFocus();
             * } else {
             * JOptionPane.showMessageDialog(telaCadastroFuncionario,
             * "Deve ser informado somente um CPF ou um CNPJ");
             * }
             */
            if (this.telaCadastroFuncionario.getjTextFieldNomeFantasia().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Nome é Obrigatório....");
                this.telaCadastroFuncionario.getjTextFieldNomeFantasia().requestFocus();
            } else {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(this.telaCadastroFuncionario.getjTextFieldNomeFantasia().getText());
                funcionario.setCep(this.telaCadastroFuncionario.getjFormattedTextFieldCep().getText());
                funcionario.setRg(this.telaCadastroFuncionario.getjTextFieldRg().getText());
                funcionario.setCpf(this.telaCadastroFuncionario.getjFormattedTextFieldCpf().getText());
                funcionario.setBairro(this.telaCadastroFuncionario.getjTextFieldBairro().getText());
                funcionario.setCidade(this.telaCadastroFuncionario.getjTextFieldCidade().getText());
                funcionario.setComplemento(this.telaCadastroFuncionario.getjTextFieldComplemento().getText());
                funcionario.setEmail(this.telaCadastroFuncionario.getjTextFieldEmail().getText());
                funcionario.setFone1(this.telaCadastroFuncionario.getjFormattedTextFieldFone1().getText());
                funcionario.setFone2(this.telaCadastroFuncionario.getjFormattedTextFieldFone2().getText());
                funcionario.setLogradouro(this.telaCadastroFuncionario.getjTextFieldLogradouro().getText());
                funcionario.setObs(this.telaCadastroFuncionario.getjTextFieldObs().getText());
                funcionario.setRg(this.telaCadastroFuncionario.getjTextFieldRg().getText());
                funcionario.setSexo(
                        this.telaCadastroFuncionario.getjComboBoxSexo().getSelectedItem().toString().charAt(0));

                if (this.telaCadastroFuncionario.getjTextFieldId().getText().trim().equalsIgnoreCase("")) {
                    funcionario.setStatus('A');
                    service.FuncionarioService.Criar(funcionario);
                } else {
                    funcionario.setId(Integer.parseInt(this.telaCadastroFuncionario.getjTextFieldId().getText()));
                    service.FuncionarioService.Atualizar(funcionario);
                }

                utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
            }

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonSair()) {
            this.telaCadastroFuncionario.dispose();
        }
    }
}
