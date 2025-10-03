/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import java.util.List;
import model.Marca;
import model.DAO.MarcaDAO;

/**
 *
 * @author IFSC
 */
public class MarcaService {
    public static void Atualizar(Marca objeto) {
        model.DAO.MarcaDAO marcaDAO = new model.DAO.MarcaDAO();
        marcaDAO.Update(objeto);
    }

    public static Marca Carregar(int id) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.Retrieve(id);
    }

    public static List<Marca> Carregar(String atributo, String valor) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.Retrieve(atributo, valor);
    }

    public static void Criar(Marca objeto) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.Create(objeto);
    }

    public static void Deletar(Marca objeto) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.Delete(objeto);
    }

}
