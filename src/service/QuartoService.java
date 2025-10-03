/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import java.util.List;
import model.Quarto;
import model.DAO.QuartoDAO;

/**
 *
 * @author IFSC
 */
public class QuartoService {
    public static void Atualizar(Quarto objeto) {
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.Update(objeto);
    }

    public static Quarto Carregar(int id) {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.Retrieve(id);
    }

    public static List<Quarto> Carregar(String atributo, String valor) {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.Retrieve(atributo, valor);
    }

    public static void Criar(Quarto objeto) {
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.Create(objeto);
    }

    public static void Deletar(Quarto objeto) {
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.Delete(objeto);
    }
}
