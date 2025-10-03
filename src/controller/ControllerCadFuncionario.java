package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Funcionario;
import view.*;

/**
 *
 * @author IFSC
 * 
 */

public class ControllerCadFuncionario implements ActionListener {

    TelaCadastroFuncionario telaCadastroFuncionario;
    

    


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
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), false);
            this.telaCadastroFuncionario.controlaCampos(true);

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonCancelar()) {
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
            this.telaCadastroFuncionario.controlaCampos(false);
        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonBuscar()) {
        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonGravar()) {
            Funcionario funcionarioDoFormulario = (Funcionario) this.telaCadastroFuncionario.getDadosDoFormulario();
            if (!funcionarioDoFormulario.getNome().trim().isEmpty()) {
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
