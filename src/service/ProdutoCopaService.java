/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import java.util.List;
import model.ProdutoCopa;

/**
 *
 * @author IFSC
 */
public class ProdutoCopaService {
    public static void Atualizar(model.ProdutoCopa objeto) {
        model.DAO.ProdutoCopaDAO produtoCopaDAO = new model.DAO.ProdutoCopaDAO();
        produtoCopaDAO.Update(objeto);
    }

    public static model.ProdutoCopa Carregar(int id) {
        model.DAO.ProdutoCopaDAO produtoCopaDAO = new model.DAO.ProdutoCopaDAO();
        return produtoCopaDAO.Retrieve(id);
    }

    public static List<ProdutoCopa> Carregar(String atributo, String valor) {
        model.DAO.ProdutoCopaDAO produtoCopaDAO = new model.DAO.ProdutoCopaDAO();
        return produtoCopaDAO.Retrieve(atributo, valor);
    }

    public static void Criar(model.ProdutoCopa objeto) {
        model.DAO.ProdutoCopaDAO produtoCopaDAO = new model.DAO.ProdutoCopaDAO();
        produtoCopaDAO.Create(objeto);
    }

    public static void Deletar(model.ProdutoCopa objeto) {
        model.DAO.ProdutoCopaDAO produtoCopaDAO = new model.DAO.ProdutoCopaDAO();
        produtoCopaDAO.Delete(objeto);
    }
}
