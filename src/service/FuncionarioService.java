package service;

import java.util.List;
import model.DAO.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService {

    public static void Atualizar(Funcionario objeto) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.Update(objeto);

    }

    public static Funcionario Carregar(int id) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.Retrieve(id);
    }

    public static List<Funcionario> Carregar(String atributo, String valor) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.Retrieve(atributo, valor);
    }

    public static void Criar(Funcionario objeto) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.Create(objeto);

    }

    public static void Deletar(Funcionario objeto) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.Delete(objeto);

    }

}
