/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;


import java.util.List;
import model.Veiculo;
/**
 *
 * @author IFSC
 */
public class VeiculoService {
public static void Atualizar(model.Veiculo objeto) {
        model.DAO.VeiculoDAO veiculoDAO = new model.DAO.VeiculoDAO();
        veiculoDAO.Update(objeto);
    }

    public static model.Veiculo Carregar(int id) {
        model.DAO.VeiculoDAO veiculoDAO = new model.DAO.VeiculoDAO();
        return veiculoDAO.Retrieve(id);
    }

    public static List<Veiculo> Carregar(String atributo, String valor) {
        model.DAO.VeiculoDAO veiculoDAO = new model.DAO.VeiculoDAO();
        return veiculoDAO.Retrieve(atributo, valor);
    }

    public static void Criar(model.Veiculo objeto) {
        model.DAO.VeiculoDAO veiculoDAO = new model.DAO.VeiculoDAO();
        veiculoDAO.Create(objeto);
    }

    public static void Deletar(model.Veiculo objeto) {
        model.DAO.VeiculoDAO veiculoDAO = new model.DAO.VeiculoDAO();
        veiculoDAO.Delete(objeto);
    }
}
