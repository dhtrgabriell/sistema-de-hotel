package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Funcionario;
import view.*;

/**
 *
 * @author IFSC
 * 
 */

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

        //Desenvolver as setagens de situação inicial dos componentes
        /*this.telaCadastroFuncionario.getjButtonNovo().setEnabled(true);
        this.telaCadastroFuncionario.getjButtonCancelar().setEnabled(false);
        this.telaCadastroFuncionario.getjButtonGravar().setEnabled(false);
        this.telaCadastroFuncionario.getjButtonBuscar().setEnabled(true);
        this.telaCadastroFuncionario.getjButtonSair().setEnabled(true);*/
        
        utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroFuncionario.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), true);
            //Adicionei o desligamento do textfield do id e coloquei o cursor no textfield do nome
            this.telaCadastroFuncionario.getjTextFieldId().setEnabled(false);
            this.telaCadastroFuncionario.controlaCampos(true);

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

            codigo = -1; //invalida a busca

            // 1. Cria a View (a tela)
            TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario(null, true);

            // 3. Torna a tela visível. Agora ela tem um controller ativo.
            telaBuscaFuncionario.setVisible(true);

            if(codigo != -1){
                utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), true);

                this.telaCadastroFuncionario.getjTextFieldId().setText(codigo + "");
                this.telaCadastroFuncionario.getjTextFieldId().setEnabled(false);

                Funcionario funcionario = new Funcionario();
                funcionario = service.FuncionarioService.Carregar(codigo);

                this.telaCadastroFuncionario.getjFormattedTextFieldCep().setText(funcionario.getCep());
                this.telaCadastroFuncionario.getjTextFieldNomeFantasia().setText(funcionario.getNome());
                this.telaCadastroFuncionario.getjTextFieldRg().setText(funcionario.getRg());
                //this.telaCadastroFuncionario.getjTextFieldCpf().setText(funcionario.getCpf());

                this.telaCadastroFuncionario.getjTextFieldNomeFantasia().requestFocus();
            }

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonGravar()) {

            if (this.telaCadastroFuncionario.getjTextFieldNomeFantasia().getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "O Atributo Nome é Obrigatório....");
                this.telaCadastroFuncionario.getjTextFieldNomeFantasia().requestFocus();
            } else{
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
                funcionario.setSexo(this.telaCadastroFuncionario.getjComboBoxSexo().getSelectedItem().toString().charAt(0));
                if (this.telaCadastroFuncionario.getjTextFieldId().getText().trim().equalsIgnoreCase("")) {
                    // inclusão
                    funcionario.setStatus('A');
                    service.FuncionarioService.Criar(funcionario);
                } else {
                    funcionario.setId(Integer.parseInt(this.telaCadastroFuncionario.getjTextFieldId().getText()));
                    service.FuncionarioService.Atualizar(funcionario);
                }
            }
            

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonSair()) {
            this.telaCadastroFuncionario.dispose();
        }
    }
}
