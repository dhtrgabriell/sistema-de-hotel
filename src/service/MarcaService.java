/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import java.util.List;
import model.Marca;

/**
 *
 * @author IFSC
 */
public class MarcaService {
    public static void Atualizar(model.Marca objeto) {
        model.DAO.MarcaDAO marcaDAO = new model.DAO.MarcaDAO();
        marcaDAO.Update(objeto);
    }

    public static model.Marca Carregar(int id) {
        model.DAO.MarcaDAO marcaDAO = new model.DAO.MarcaDAO();
        return marcaDAO.Retrieve(id);
    }

    public static List<Marca> Carregar(String atributo, String valor) {
        model.DAO.MarcaDAO marcaDAO = new model.DAO.MarcaDAO();
        return marcaDAO.Retrieve(atributo, valor);
    }

    public static void Criar(model.Marca objeto) {
        model.DAO.MarcaDAO marcaDAO = new model.DAO.MarcaDAO();
        marcaDAO.Create(objeto);
    }

    public static void Deletar(model.Marca objeto) {
        model.DAO.MarcaDAO marcaDAO = new model.DAO.MarcaDAO();
        marcaDAO.Delete(objeto);
    }

}
