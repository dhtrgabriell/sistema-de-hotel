package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Funcionario;
import view.*;

/**
 *
 * @author IFSC
 */
public class ControllerCadFuncionario implements ActionListener {

    TelaCadastroFuncionario telaCadastroFuncionario;
    private ArrayList<Funcionario> listaDeFuncionarios;
    public static int codigo;

    public ControllerCadFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
        this.telaCadastroFuncionario = telaCadastroFuncionario;
        this.listaDeFuncionarios = new ArrayList<>();

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

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonCancelar()) {
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
            this.telaCadastroFuncionario.controlaCampos(false);
        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonBuscar()) {

            codigo = -1; //invalida a busca

            // 1. Cria a View (a tela)
            TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario(null, true);
            ControllerBuscaFuncionario controllerBuscaFuncionario = new ControllerBuscaFuncionario(telaBuscaFuncionario, this.listaDeFuncionarios);

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
            Funcionario funcionarioDoFormulario = (Funcionario) this.telaCadastroFuncionario.getDadosDoFormulario();
            if (!funcionarioDoFormulario.getNome().trim().isEmpty()) {
                this.listaDeFuncionarios.add(funcionarioDoFormulario);
                javax.swing.JOptionPane.showMessageDialog(null, "Funcionário salvo!");
                //fecha/limpa campos
                utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
                utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
                this.telaCadastroFuncionario.controlaCampos(false);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "O nome é obrigatório!");
            }
            

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonSair()) {
            this.telaCadastroFuncionario.dispose();
        }
    }
}
