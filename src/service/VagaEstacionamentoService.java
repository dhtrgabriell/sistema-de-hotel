/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import java.util.List;
import model.VagaEstacionamento;
import model.DAO.VagaEstacionamentoDAO;

/**
 *
 * @author IFSC
 */
public class VagaEstacionamentoService {
    public static void Atualizar(VagaEstacionamento objeto) {
            VagaEstacionamentoDAO vagaEstacionamentoDAO = new VagaEstacionamentoDAO();
            vagaEstacionamentoDAO.Update(objeto);
        }

        public static VagaEstacionamento Carregar(int id) {
            VagaEstacionamentoDAO vagaEstacionamentoDAO = new VagaEstacionamentoDAO();
            return vagaEstacionamentoDAO.Retrieve(id);
        }

        public static List<VagaEstacionamento> Carregar(String atributo, String valor) {
            VagaEstacionamentoDAO vagaEstacionamentoDAO = new VagaEstacionamentoDAO();
            return vagaEstacionamentoDAO.Retrieve(atributo, valor);
        }

        public static void Criar(VagaEstacionamento objeto) {
            VagaEstacionamentoDAO vagaEstacionamentoDAO = new VagaEstacionamentoDAO();
            vagaEstacionamentoDAO.Create(objeto);
        }

        public static void Deletar(VagaEstacionamento objeto) {
            VagaEstacionamentoDAO vagaEstacionamentoDAO = new VagaEstacionamentoDAO();
            vagaEstacionamentoDAO.Delete(objeto);
        }
}
