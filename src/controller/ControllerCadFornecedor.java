package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Fornecedor;
import view.*;

public class ControllerCadFornecedor implements ActionListener {

    TelaCadastroFornecedor telaCadastroFornecedor;

    public static int codigo;

    public ControllerCadFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaCadastroFornecedor = telaCadastroFornecedor;

        this.telaCadastroFornecedor.getjButtonNovo().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonGravar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroFornecedor.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), true);

            this.telaCadastroFornecedor.controlaCampos(true);
            this.telaCadastroFornecedor.getjTextFieldId().setEnabled(false);

            Date dataAtual = new Date();
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String novaData = dataFormatada.format(dataAtual);
            this.telaCadastroFornecedor.getjFormattedTextDataCad().setText(novaData);
            this.telaCadastroFornecedor.getjFormattedTextDataCad().setEnabled(false);

            this.telaCadastroFornecedor.getjTextFieldNomeFantasia().requestFocus();

        } else if (e.getSource() == this.telaCadastroFornecedor.getjButtonCancelar()) {
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false);
            utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), true);
            this.telaCadastroFornecedor.controlaCampos(false);
        } else if (e.getSource() == this.telaCadastroFornecedor.getjButtonBuscar()) {

            codigo = -1;

            TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor
            (null, true);
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
            telaBuscaFornecedor.setVisible(true);

            if (codigo != -1) {
                utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), true);

                this.telaCadastroFornecedor.getjTextFieldId().setText(codigo + "");
                this.telaCadastroFornecedor.getjTextFieldId().setEnabled(false);

                Fornecedor fornecedor = new Fornecedor();
                fornecedor = service.FornecedorService.Carregar(codigo);

                this.telaCadastroFornecedor.getjFormattedTextFieldCep().setText(fornecedor.getCep());
                this.telaCadastroFornecedor.getjTextFieldNomeFantasia().setText(fornecedor.getNome());
                this.telaCadastroFornecedor.getjTextFieldRg().setText(fornecedor.getRg());

                this.telaCadastroFornecedor.getjTextFieldNomeFantasia().requestFocus();
            }

        } else if (e.getSource() == this.telaCadastroFornecedor.getjButtonGravar()) {

            if (this.telaCadastroFornecedor.getjTextFieldNomeFantasia().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Nome é Obrigatório....");
                this.telaCadastroFornecedor.getjTextFieldNomeFantasia().requestFocus();
            } else {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(this.telaCadastroFornecedor.getjTextFieldNomeFantasia().getText());
                fornecedor.setCep(this.telaCadastroFornecedor.getjFormattedTextFieldCep().getText());
                fornecedor.setRg(this.telaCadastroFornecedor.getjTextFieldRg().getText());
                fornecedor.setCpf(this.telaCadastroFornecedor.getjFormattedTextFieldCpf().getText());
                fornecedor.setBairro(this.telaCadastroFornecedor.getjTextFieldBairro().getText());
                fornecedor.setCidade(this.telaCadastroFornecedor.getjTextFieldCidade().getText());
                fornecedor.setComplemento(this.telaCadastroFornecedor.getjTextFieldComplemento().getText());
                fornecedor.setEmail(this.telaCadastroFornecedor.getjTextFieldEmail().getText());
                fornecedor.setFone1(this.telaCadastroFornecedor.getjFormattedTextFieldFone1().getText());
                fornecedor.setFone2(this.telaCadastroFornecedor.getjFormattedTextFieldFone2().getText());
                fornecedor.setLogradouro(this.telaCadastroFornecedor.getjTextFieldLogradouro().getText());
                fornecedor.setObs(this.telaCadastroFornecedor.getjTextFieldObs().getText());
                fornecedor.setRg(this.telaCadastroFornecedor.getjTextFieldRg().getText());

                if (this.telaCadastroFornecedor.getjTextFieldId().getText().trim().equalsIgnoreCase("")) {
                    fornecedor.setStatus('A');
                    service.FornecedorService.Criar(fornecedor);
                } else {
                    fornecedor.setId(Integer.parseInt(this.telaCadastroFornecedor.getjTextFieldId().getText()));
                    service.FornecedorService.Atualizar(fornecedor);
                }

                utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false);
            }

        } else if (e.getSource() == this.telaCadastroFornecedor.getjButtonSair()) {
            this.telaCadastroFornecedor.dispose();
        }
    }
}