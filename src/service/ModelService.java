/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Modelo;

public class ModelService {
    public static void Atualizar(model.Modelo objeto) {
        model.DAO.ModeloDAO modeloDAO = new model.DAO.ModeloDAO();
        modeloDAO.Update(objeto);
    }

    public static model.Modelo Carregar(int id) {
        model.DAO.ModeloDAO modeloDAO = new model.DAO.ModeloDAO();
        return modeloDAO.Retrieve(id);
    }

    public static List<Modelo> Carregar(String atributo, String valor) {
        model.DAO.ModeloDAO modeloDAO = new model.DAO.ModeloDAO();
        return modeloDAO.Retrieve(atributo, valor);
    }

    public static void Criar(model.Modelo objeto) {
        model.DAO.ModeloDAO modeloDAO = new model.DAO.ModeloDAO();
        modeloDAO.Create(objeto);
    }

    public static void Deletar(model.Modelo objeto) {
        model.DAO.ModeloDAO modeloDAO = new model.DAO.ModeloDAO();
        modeloDAO.Delete(objeto);
    }

}
