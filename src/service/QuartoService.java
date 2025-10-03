/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import java.util.List;
import model.Quarto;

/**
 *
 * @author IFSC
 */
public class QuartoService {
    public static void Atualizar(model.Quarto objeto) {
        model.DAO.QuartoDAO quartoDAO = new model.DAO.QuartoDAO();
        quartoDAO.Update(objeto);
    }

    public static model.Quarto Carregar(int id) {
        model.DAO.QuartoDAO quartoDAO = new model.DAO.QuartoDAO();
        return quartoDAO.Retrieve(id);
    }

    public static List<Quarto> Carregar(String atributo, String valor) {
        model.DAO.QuartoDAO quartoDAO = new model.DAO.QuartoDAO();
        return quartoDAO.Retrieve(atributo, valor);
    }

    public static void Criar(model.Quarto objeto) {
        model.DAO.QuartoDAO quartoDAO = new model.DAO.QuartoDAO();
        quartoDAO.Create(objeto);
    }

    public static void Deletar(model.Quarto objeto) {
        model.DAO.QuartoDAO quartoDAO = new model.DAO.QuartoDAO();
        quartoDAO.Delete(objeto);
    }
}
