/*
SERVICE RESPONSÁVEL PELA LÓGICA DE NEGÓCIO DA CLASSE FORNECEDOR
*/

package service;

import java.util.List;
import model.Fornecedor;
import model.DAO.FornecedorDAO;

/**
 *
 * @author Murilo
 */
public class FornecedorService {

    public static void Atualizar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.Update(objeto);
    }

    public static Fornecedor Carregar(int id) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.Retrieve(id);
    }

    public static List<Fornecedor> Carregar(String atributo, String valor) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.Retrieve(atributo, valor);
    }

    public static void Criar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.Create(objeto);
    }

    public static void Deletar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.Delete(objeto);
    }
}
