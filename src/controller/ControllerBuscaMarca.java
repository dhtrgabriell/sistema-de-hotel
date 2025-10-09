package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Marca;
import view.TelaBuscaVaga;

public class ControllerBuscaMarca implements ActionListener {

    TelaBuscaVaga telaBuscaMarca;

    public ControllerBuscaMarca(TelaBuscaVaga telaBuscaMarca) {

        this.telaBuscaMarca = telaBuscaMarca;

        this.telaBuscaMarca.getjButtonCarregar().addActionListener(this);
        this.telaBuscaMarca.getjButtonFiltar().addActionListener(this);
        this.telaBuscaMarca.getjButtonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaMarca.getjButtonCarregar()) {
            if (this.telaBuscaMarca.getjTableDados().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Erro: \nNão Existem Dados Selecionados para Edição !");
            } else {
                /////Retornar os dados para a tela de cadastro
                ControllerCadMarca.codigo = (int) this.telaBuscaMarca.getjTableDados().
                        getValueAt(this.telaBuscaMarca.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaMarca.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaMarca.getjButtonFiltar()) {
            if (this.telaBuscaMarca.getjTFFiltro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem Dados para a Seleção...");
            } else {
                if (this.telaBuscaMarca.getjCBFiltro().getSelectedIndex() == 0) {
                    Marca marca = new Marca();

                    //Carregando o registro do marca na entidade para o objeto marca
                    marca = service.MarcaService.Carregar(Integer.parseInt(this.telaBuscaMarca.getjTFFiltro().getText()));

                    //Criando um objeto tabela do tipo defaulttablemodel e atribuindo o nosso modelo de tabela a ele
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMarca.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    //Adicionado o marca na tabela
                    tabela.addRow(new Object[]{marca.getId(), marca.getDescricao(), marca.getStatus()});

                } else if (this.telaBuscaMarca.getjCBFiltro().getSelectedIndex() == 1) {
                    //Criando a lista para receber os marcas
                    List<Marca> listaMarcas = new ArrayList<>();
                    //Carregando os marcas via sl para dentro da lista
                    listaMarcas = service.MarcaService.Carregar("descricao", this.telaBuscaMarca.getjTFFiltro().getText());

                    //Criando um objeto tabela do tipo defaulttablemodel e atribuindo o nosso modelo de tabela a ele
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMarca.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Marca marcaAtualDaLista : listaMarcas) {
                        //Adicionado o marca na tabela
                        tabela.addRow(new Object[]{
                            marcaAtualDaLista.getId(),
                            marcaAtualDaLista.getDescricao(),
                            marcaAtualDaLista.getStatus()});
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaMarca.getjButtonSair()) {
            this.telaBuscaMarca.dispose();
        }
    }
}
