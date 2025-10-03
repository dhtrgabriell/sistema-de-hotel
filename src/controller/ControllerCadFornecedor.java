package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Fornecedor;
import view.TelaBuscaFornecedor;

import view.TelaCadastroFornecedor;

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
        if(e.getSource() == this.telaCadastroFornecedor.getjButtonNovo()) {

            utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), true);

            this.telaCadastroFornecedor.getjTextFieldId().setEnabled(false);
            this.telaCadastroFornecedor.getjTextFieldNomeFantasia().requestFocus();

            Date dataAtual = new Date();
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String novaData = dataFormatada.format(dataAtual);
            this.telaCadastroFornecedor.getjFormattedTextFieldDataCadastro().setText(novaData);
            this.telaCadastroFornecedor.getjFormattedTextFieldDataCadastro().setEnabled(false);
            
        } else if(e.getSource() == this.telaCadastroFornecedor.getjButtonCancelar()){
            
            utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false);
            
        } else if(e.getSource() == this.telaCadastroFornecedor.getjButtonGravar()){
            
            if(this.telaCadastroFornecedor.getjTextFieldNomeFantasia().getText().trim().equalsIgnoreCase("")){
                
                JOptionPane.showMessageDialog(null, "O Atributo Nome é Obrigatório...");
                this.telaCadastroFornecedor.getjTextFieldNomeFantasia().requestFocus();
                
            } else{
                
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setNome(this.telaCadastroFornecedor.getjTextFieldNomeFantasia().getText());
                fornecedor.setRazaoSocial(this.telaCadastroFornecedor.getjTextFieldRazaoSocial().getText());
                fornecedor.setRg(this.telaCadastroFornecedor.getjTextFieldRg().getText());
                fornecedor.setCpf(this.telaCadastroFornecedor.getjFormattedTextFieldCpf().getText());
                fornecedor.setInscricaoEstadual(this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().getText());
                fornecedor.setCnpj(this.telaCadastroFornecedor.getjFormattedTextFieldCnpj().getText());
                fornecedor.setFone1(this.telaCadastroFornecedor.getjFormattedTextFieldFone1().getText());
                fornecedor.setFone2(this.telaCadastroFornecedor.getjFormattedTextFieldFone2().getText());
                fornecedor.setEmail(this.telaCadastroFornecedor.getjTextFieldEmail().getText());
                fornecedor.setCep(this.telaCadastroFornecedor.getjFormattedTextFieldCep().getText());
                fornecedor.setBairro(this.telaCadastroFornecedor.getjTextFieldBairro().getText());
                fornecedor.setLogradouro(this.telaCadastroFornecedor.getjTextFieldLogradouro().getText());
                fornecedor.setComplemento(this.telaCadastroFornecedor.getjTextFieldComplemento().getText());
                fornecedor.setContato(this.telaCadastroFornecedor.getjTextFieldContato().getText());
                fornecedor.setObs(this.telaCadastroFornecedor.getjTextFieldObs().getText());
                
                if(this.telaCadastroFornecedor.getjTextFieldId().getText().trim().equalsIgnoreCase("")){
                    
                    fornecedor.setStatus('A');
                    service.FornecedorService.Criar(fornecedor);
                    
                } else{
                    
                    fornecedor.setId(Integer.parseInt(this.telaCadastroFornecedor.getjTextFieldId().getText()));
                    service.FornecedorService.Atualizar(fornecedor);
                    
                }
                
                utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false);
                
            }
            
        } else if(e.getSource() == this.telaCadastroFornecedor.getjButtonBuscar()){
            
            codigo = 0;
            
            TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor(null, true);
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
            telaBuscaFornecedor.setVisible(true);
            
            if (codigo != 0){
                
                utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), true);
                
                this.telaCadastroFornecedor.getjTextFieldId().setText(codigo + "");
                this.telaCadastroFornecedor.getjTextFieldId().setEnabled(false);
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor = service.FornecedorService.Carregar(codigo);
                
                this.telaCadastroFornecedor.getjTextFieldNomeFantasia().setText(fornecedor.getNome());
                this.telaCadastroFornecedor.getjTextFieldRazaoSocial().setText(fornecedor.getRazaoSocial());
                this.telaCadastroFornecedor.getjFormattedTextFieldCpf().setText(fornecedor.getCpf());
                this.telaCadastroFornecedor.getjFormattedTextFieldCnpj().setText(fornecedor.getCnpj());
                this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().setText(fornecedor.getInscricaoEstadual());
                this.telaCadastroFornecedor.getjFormattedTextFieldFone1().setText(fornecedor.getFone());
                this.telaCadastroFornecedor.getjFormattedTextFieldFone2().setText(fornecedor.getFone2());
                this.telaCadastroFornecedor.getjTextFieldEmail().setText(fornecedor.getEmail());
                this.telaCadastroFornecedor.getjFormattedTextFieldCep().setText(fornecedor.getCep());
                this.telaCadastroFornecedor.getjTextFieldCidade().setText(fornecedor.getCidade());
                this.telaCadastroFornecedor.getjTextFieldBairro().setText(fornecedor.getBairro());
                this.telaCadastroFornecedor.getjTextFieldLogradouro().setText(fornecedor.getLogradouro());
                this.telaCadastroFornecedor.getjTextFieldComplemento().setText(fornecedor.getComplemento());
                this.telaCadastroFornecedor.getjTextFieldContato().setText(fornecedor.getContato());
                this.telaCadastroFornecedor.getjTextFieldObs().setText(fornecedor.getObs());
                
                this.telaCadastroFornecedor.getjTextFieldNomeFantasia().requestFocus();
                
            }
            
        } else if(e.getSource() == this.telaCadastroFornecedor.getjButtonSair()){
            
            this.telaCadastroFornecedor.dispose();
            
        }
    }
}
