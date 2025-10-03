/*
SERVICE RESPONSÁVEL PELA LÓGICA DE NEGÓCIO DA CLASSE FORNECEDOR
*/

package service;

import java.util.List;
import model.Fornecedor;

/**
 *
 * @author Murilo
 */
public class FornecedorService {

    public static void Atualizar(Fornecedor objeto) {
        model.DAO.FornecedorDAO fornecedorDAO = new model.DAO.FornecedorDAO();
        fornecedorDAO.Update(objeto);
    }

    public static Fornecedor Carregar(int id) {
        model.DAO.FornecedorDAO fornecedorDAO = new model.DAO.FornecedorDAO();
        return fornecedorDAO.Retrieve(id);
    }

    public static List<Fornecedor> Carregar(String atributo, String valor) {
        model.DAO.FornecedorDAO fornecedorDAO = new model.DAO.FornecedorDAO();
        return fornecedorDAO.Retrieve(atributo, valor);
    }

    public static void Criar(Fornecedor objeto) {
        model.DAO.FornecedorDAO fornecedorDAO = new model.DAO.FornecedorDAO();
        fornecedorDAO.Create(objeto);
    }

    public static void Deletar(Fornecedor objeto) {
        model.DAO.FornecedorDAO fornecedorDAO = new model.DAO.FornecedorDAO();
        fornecedorDAO.Delete(objeto);
    }
}
