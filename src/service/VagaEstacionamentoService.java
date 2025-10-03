/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import java.util.List;
import model.VagaEstacionamento;

/**
 *
 * @author IFSC
 */
public class VagaEstacionamentoService {
public static void Atualizar(model.VagaEstacionamento objeto) {
        model.DAO.VagaEstacionamentoDAO vagaEstacionamentoDAO = new model.DAO.VagaEstacionamentoDAO();
        vagaEstacionamentoDAO.Update(objeto);
    }

    public static model.VagaEstacionamento Carregar(int id) {
        model.DAO.VagaEstacionamentoDAO vagaEstacionamentoDAO = new model.DAO.VagaEstacionamentoDAO();
        return vagaEstacionamentoDAO.Retrieve(id);
    }

    public static List<VagaEstacionamento> Carregar(String atributo, String valor) {
        model.DAO.VagaEstacionamentoDAO vagaEstacionamentoDAO = new model.DAO.VagaEstacionamentoDAO();
        return vagaEstacionamentoDAO.Retrieve(atributo, valor);
    }

    public static void Criar(model.VagaEstacionamento objeto) {
        model.DAO.VagaEstacionamentoDAO vagaEstacionamentoDAO = new model.DAO.VagaEstacionamentoDAO();
        vagaEstacionamentoDAO.Create(objeto);
    }

    public static void Deletar(model.VagaEstacionamento objeto) {
        model.DAO.VagaEstacionamentoDAO vagaEstacionamentoDAO = new model.DAO.VagaEstacionamentoDAO();
        vagaEstacionamentoDAO.Delete(objeto);
    }
}
