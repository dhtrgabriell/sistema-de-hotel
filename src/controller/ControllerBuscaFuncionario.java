package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.Funcionario;
import view.*;

public class ControllerBuscaFuncionario implements ActionListener {

    private TelaBuscaFuncionario telaBuscaFuncionario;
    private ArrayList<Funcionario> listaDeFuncionarios; // 1. Adicione este atributo para guardar a lista

    // 2. Modifique o construtor para receber DOIS argumentos
    public ControllerBuscaFuncionario(TelaBuscaFuncionario telaBuscaFuncionario, ArrayList<Funcionario> listaDeFuncionarios) {
        this.telaBuscaFuncionario = telaBuscaFuncionario;
        this.listaDeFuncionarios = listaDeFuncionarios; // 3. Armazene a lista que veio de fora

        // O resto do seu construtor continua igual
        this.telaBuscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonFiltar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonSair().addActionListener(this);
    }
    // Dentro da classe view.TelaBuscaFuncionario

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.telaBuscaFuncionario.getjButtonCarregar()) {
            DefaultTableModel tabelaModelo = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();

            // 2. Limpa a tabela antes de adicionar novos dados.
            // Isso evita que os dados sejam duplicados se o botão for clicado várias vezes.
            tabelaModelo.setRowCount(0);

            // 3. Percorre a lista de funcionários que este controller já possui.
            for (Funcionario funcionarioAtual : this.listaDeFuncionarios) {

                // 4. Adiciona uma nova linha na tabela para cada funcionário.
                // A ORDEM dos dados aqui deve ser EXATAMENTE a mesma ordem das suas colunas.
                tabelaModelo.addRow(new Object[]{
                    funcionarioAtual.getId(),
                    funcionarioAtual.getNome(),
                    funcionarioAtual.getCpf(),
                    funcionarioAtual.getFone(),
                    funcionarioAtual.getEmail()
                // Adicione aqui os outros campos que você quer exibir
                });
            }
        } else if (e.getSource() == this.telaBuscaFuncionario.getjButtonFiltar()) {
            String tipoFiltro = this.telaBuscaFuncionario.getjCBFiltro().getSelectedItem().toString();
            String textoFiltro = this.telaBuscaFuncionario.getjTFFiltro().getText().trim();
            DefaultTableModel tabelaModelo = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
            tabelaModelo.setRowCount(0);

            for (Funcionario funcionarioAtual : this.listaDeFuncionarios) {
                boolean corresponde = false;
                switch (tipoFiltro) {
                    case "Id":
                        if (String.valueOf(funcionarioAtual.getId()).contains(textoFiltro)) {
                            corresponde = true;
                        }
                        break;
                    case "Nome":
                        if (funcionarioAtual.getNome().toLowerCase().contains(textoFiltro.toLowerCase())) {
                            System.out.println("Debug NOME: " + funcionarioAtual.toString()); // DEBUG
                            corresponde = true;
                        }
                        break;
                    case "CPF":
                        if (funcionarioAtual.getCpf().contains(textoFiltro)) {
                            System.out.println("Debug CPF: " + funcionarioAtual.toString()); // DEBUG
                            corresponde = true;
                        }
                        break;
                }
                if (corresponde) {
                    tabelaModelo.addRow(new Object[]{
                        funcionarioAtual.getId(),
                        funcionarioAtual.getNome(),
                        funcionarioAtual.getCpf(),
                        funcionarioAtual.getFone(),
                        funcionarioAtual.getEmail()
                    });
                }
            }
        } else if (e.getSource() == this.telaBuscaFuncionario.getjButtonSair()) {
            this.telaBuscaFuncionario.dispose();
        }
    }
}
