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

    public ControllerCadFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
        this.listaDeFuncionarios = new ArrayList<>();
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
            // 1. Cria a View (a tela)
            TelaBuscaFuncionario telaBusca = new TelaBuscaFuncionario(null, true);
            ControllerBuscaFuncionario controllerBusca = new ControllerBuscaFuncionario(telaBusca, this.listaDeFuncionarios);

            // 3. Torna a tela visível. Agora ela tem um controller ativo.
            telaBusca.setVisible(true);

        } else if (e.getSource() == this.telaCadastroFuncionario.getjButtonGravar()) {
            Funcionario funcionarioDoFormulario = this.telaCadastroFuncionario.getDadosDoFormulario();
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
