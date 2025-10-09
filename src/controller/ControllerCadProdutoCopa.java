package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.ProdutoCopa;
import view.TelaBuscaProdutoCopa;
import view.TelaCadastroCopa;

public class ControllerCadProdutoCopa implements ActionListener {

    TelaCadastroCopa telaCadastroCopa;
    public static int codigo;

    public ControllerCadProdutoCopa(TelaCadastroCopa telaCadastroCopa) {
        this.telaCadastroCopa = telaCadastroCopa;

        this.telaCadastroCopa.getjButtonNovo().addActionListener(this);
        this.telaCadastroCopa.getjButtonCancelar().addActionListener(this);
        this.telaCadastroCopa.getjButtonGravar().addActionListener(this);
        this.telaCadastroCopa.getjButtonBuscar().addActionListener(this);
        this.telaCadastroCopa.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroCopa.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroCopa.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroCopa.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroCopa.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroCopa.getjPanelDados(), true);
            this.telaCadastroCopa.getjTextFieldID().setEnabled(false);
            this.telaCadastroCopa.getjTextFieldDesc().requestFocus();

        } else if (e.getSource() == this.telaCadastroCopa.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroCopa.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroCopa.getjPanelDados(), false);

        } else if (e.getSource() == this.telaCadastroCopa.getjButtonBuscar()) {
            codigo = 0;
            List<ProdutoCopa> listaProdutos = service.ProdutoCopaService.Carregar("decricao", "");
            TelaBuscaProdutoCopa telaBusca = new TelaBuscaProdutoCopa(null, true);
            ControllerBuscaProdutoCopa controllerBusca = new ControllerBuscaProdutoCopa(telaBusca, listaProdutos);
            telaBusca.setVisible(true);

            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroCopa.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroCopa.getjPanelDados(), true);
                
                ProdutoCopa produto = service.ProdutoCopaService.Carregar(codigo);
                this.telaCadastroCopa.getjTextFieldID().setText(String.valueOf(produto.getId()));
                this.telaCadastroCopa.getjTextFieldDesc().setText(produto.getDescricao());
                this.telaCadastroCopa.getjTextFieldValor().setText(String.valueOf(produto.getPreco()));
                this.telaCadastroCopa.getjTextFieldOBS().setText(produto.getObs());
                this.telaCadastroCopa.getjTextFieldID().setEnabled(false);
            }

        } else if (e.getSource() == this.telaCadastroCopa.getjButtonGravar()) {
            if (this.telaCadastroCopa.getjTextFieldDesc().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "A Descrição é obrigatória.");
            } else {
                ProdutoCopa produto = new ProdutoCopa();
                produto.setDescricao(this.telaCadastroCopa.getjTextFieldDesc().getText());
                produto.setObs(this.telaCadastroCopa.getjTextFieldOBS().getText());
                produto.setStatus('A');
                try {
                    produto.setPreco(Double.parseDouble(this.telaCadastroCopa.getjTextFieldValor().getText()));

                    if (this.telaCadastroCopa.getjTextFieldID().getText().isEmpty()) {
                        service.ProdutoCopaService.Criar(produto);
                    } else {
                        produto.setId(Integer.parseInt(this.telaCadastroCopa.getjTextFieldID().getText()));
                        service.ProdutoCopaService.Atualizar(produto);
                    }
                    utilities.Utilities.ativaDesativa(this.telaCadastroCopa.getjPanelBotoes(), true);
                    utilities.Utilities.limpaComponentes(this.telaCadastroCopa.getjPanelDados(), false);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O valor do preço é inválido.");
                }
            }

        } else if (e.getSource() == this.telaCadastroCopa.getjButtonSair()) {
            this.telaCadastroCopa.dispose();
        }
    }
}