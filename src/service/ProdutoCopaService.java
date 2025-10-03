/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import java.util.List;
import model.ProdutoCopa;
import model.DAO.ProdutoCopaDAO;

/**
 *
 * @author IFSC
 */
public class ProdutoCopaService {
    public static void Atualizar(ProdutoCopa objeto) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        produtoCopaDAO.Update(objeto);
    }

    public static ProdutoCopa Carregar(int id) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        return produtoCopaDAO.Retrieve(id);
    }

    public static List<ProdutoCopa> Carregar(String atributo, String valor) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        return produtoCopaDAO.Retrieve(atributo, valor);
    }

    public static void Criar(ProdutoCopa objeto) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        produtoCopaDAO.Create(objeto);
    }

    public static void Deletar(ProdutoCopa objeto) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        produtoCopaDAO.Delete(objeto);
    }
}
