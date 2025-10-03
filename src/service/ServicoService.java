package service;

import java.util.List;
import model.Servico;
import model.DAO.ServicoDAO;

public class ServicoService {

    public static void Atualizar(Servico objeto) {
        ServicoDAO servicoDAO = new ServicoDAO();
        servicoDAO.Update(objeto);
    }

    public static Servico Carregar(int id) {
        ServicoDAO servicoDAO = new ServicoDAO();
        return servicoDAO.Retrieve(id);
    }

    public static List<Servico> Carregar(String atributo, String valor) {
        ServicoDAO servicoDAO = new ServicoDAO();
        return servicoDAO.Retrieve(atributo, valor);
    }

    public static void Criar(Servico objeto) {
        ServicoDAO servicoDAO = new ServicoDAO();
        servicoDAO.Create(objeto);
    }

    public static void Deletar(Servico objeto) {
        ServicoDAO servicoDAO = new ServicoDAO();
        servicoDAO.Delete(objeto);
    }

}
