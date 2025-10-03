/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;


import java.util.List;
import model.Veiculo;
import model.DAO.VeiculoDAO;
/**
 *
 * @author IFSC
 */
public class VeiculoService {
    public static void Atualizar(Veiculo objeto) {
            VeiculoDAO veiculoDAO = new VeiculoDAO();
            veiculoDAO.Update(objeto);
        }

        public static Veiculo Carregar(int id) {
            VeiculoDAO veiculoDAO = new VeiculoDAO();
            return veiculoDAO.Retrieve(id);
        }

        public static List<Veiculo> Carregar(String atributo, String valor) {
            VeiculoDAO veiculoDAO = new VeiculoDAO();
            return veiculoDAO.Retrieve(atributo, valor);
        }

        public static void Criar(Veiculo objeto) {
            VeiculoDAO veiculoDAO = new VeiculoDAO();
            veiculoDAO.Create(objeto);
        }

        public static void Deletar(Veiculo objeto) {
            VeiculoDAO veiculoDAO = new VeiculoDAO();
            veiculoDAO.Delete(objeto);
        }
}
