package controller;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.Hospede;
import view.TelaBuscaHospede;

public class ControllerBuscaHospede implements ActionListener {

    TelaBuscaHospede telaBuscaHospede;

    public ControllerBuscaHospede(TelaBuscaHospede telaBuscaHospede) {

        this.telaBuscaHospede = telaBuscaHospede;

        this.telaBuscaHospede.getjButtonCarregar().addActionListener(this);
        this.telaBuscaHospede.getjButtonFiltar().addActionListener(this);
        this.telaBuscaHospede.getjButtonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaHospede.getjButtonCarregar()) {
            if (this.telaBuscaHospede.getjTableDados().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Errrrooooooouuu. \nNão Existem Dados Selecionados!");
            } else {
                ControllerCadHospede.codigo = (int) this.telaBuscaHospede.getjTableDados().getValueAt(this.telaBuscaHospede.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaHospede.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaHospede.getjButtonFiltar()) {
            JOptionPane.showMessageDialog(null, "Botão Filtrar Pressionado...");
            if (this.telaBuscaHospede.getjTFFiltro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem Dados para a Seleção...");
            } else {
                JOptionPane.showMessageDialog(null, "Filtrando informações...");
                if (this.telaBuscaHospede.getjCBFiltro().getSelectedIndex() == 0) {

                    //Criando objeto para receber os dados que viram do banco de dados.
                    Hospede hospede = new Hospede();

                    //Carregando o registro do hospede na entidade para o objeto.
                    hospede = service.HospedeService.Carregar(Integer.parseInt(this.telaBuscaHospede.getjTFFiltro().getText().trim()));
                    
                    //Criando um objeto tabela do tipo defaultTableModel e atribuindo a tabela da tela a ele.
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();

                    tabela.setRowCount(0);

                    //Adicionando uma nova linha na tabela.
                    tabela.addRow(new Object[]{hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});


                } else if (this.telaBuscaHospede.getjCBFiltro().getSelectedIndex() == 1) {
                    //Criando a lista para receber os hospedes
                    List<Hospede> listaHospedes = new ArrayList();

                    //Carregadno os hospedes via sql para dentro da lista
                    listaHospedes = service.HospedeService.Carregar("nome",  this.telaBuscaHospede.getjTFFiltro().getText().trim());
                    
                    //Criando um objeto tabela do tipo defaultTableModel e atribuindo a tabela da tela a ele.
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();

                    tabela.setRowCount(0);

                    for(Hospede hospedeAtualDaLista : listaHospedes){
                        //Adicionando um hospede na tabela.
                        tabela.addRow(new Object[]{hospedeAtualDaLista.getId(), hospedeAtualDaLista.getNome(), hospedeAtualDaLista.getCpf(), hospedeAtualDaLista.getStatus()});
                    }
                    
                } else if (this.telaBuscaHospede.getjCBFiltro().getSelectedIndex() == 2) {
                    JOptionPane.showMessageDialog(null, "Filtrando por CPF");
                    //Criando a lista para receber os hospedes
                    List<Hospede> listaHospedes = new ArrayList();

                    //Carregadno os hospedes via sql para dentro da lista
                    listaHospedes = service.HospedeService.Carregar("cpf",  this.telaBuscaHospede.getjTFFiltro().getText().trim());
                    
                    //Criando um objeto tabela do tipo defaultTableModel e atribuindo a tabela da tela a ele.
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();

                    tabela.setRowCount(0);

                    for(Hospede hospedeAtualDaLista : listaHospedes){
                        //Adicionando um hospede na tabela.
                        tabela.addRow(new Object[]{hospedeAtualDaLista.getId(), hospedeAtualDaLista.getNome(), hospedeAtualDaLista.getCpf(), hospedeAtualDaLista.getStatus()});
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaHospede.getjButtonSair()) {
            this.telaBuscaHospede.dispose();
        }
    }
}
