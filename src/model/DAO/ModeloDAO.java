package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Marca;
import model.Modelo;

public class ModeloDAO implements InterfaceDAO<Modelo> {

    @Override
    public void Create(Modelo objeto) {
        String sqlInstrucao = "Insert into modelo(descricao, status, marca_id) values(?, ?, ?)";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, String.valueOf(objeto.getStatus()));
            pstm.setInt(3, objeto.getMarca().getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public Modelo Retrieve(int id) {
        String sqlInstrucao = "SELECT m.id AS modelo_id, m.descricao AS modelo_descricao, m.status AS modelo_status, "
                            + "ma.id AS marca_id, ma.descricao AS marca_descricao "
                            + "FROM modelo m JOIN marca ma ON m.marca_id = ma.id "
                            + "WHERE m.id = ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Modelo modelo = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            if (rst.next()) {
                modelo = new Modelo();
                Marca marca = new Marca();
                marca.setId(rst.getInt("marca_id"));
                marca.setDescricao(rst.getString("marca_descricao"));
                modelo.setId(rst.getInt("modelo_id"));
                modelo.setDescricao(rst.getString("modelo_descricao"));
                modelo.setStatus(rst.getString("modelo_status").charAt(0));
                modelo.setMarca(marca);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        return modelo;
    }

    @Override
    public List<Modelo> Retrieve(String atributo, String valor) {
        String sqlInstrucao = "SELECT m.id AS modelo_id, m.descricao AS modelo_descricao, m.status AS modelo_status, "
                            + "ma.id AS marca_id, ma.descricao AS marca_descricao "
                            + "FROM modelo m JOIN marca ma ON m.marca_id = ma.id "
                            + "WHERE " + atributo + " LIKE ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Modelo> listaModelos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                Modelo modelo = new Modelo();
                Marca marca = new Marca();
                marca.setId(rst.getInt("marca_id"));
                marca.setDescricao(rst.getString("marca_descricao"));
                modelo.setId(rst.getInt("modelo_id"));
                modelo.setDescricao(rst.getString("modelo_descricao"));
                modelo.setStatus(rst.getString("modelo_status").charAt(0));
                modelo.setMarca(marca);
                listaModelos.add(modelo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        return listaModelos;
    }

    @Override
    public void Update(Modelo objeto) {
        String sqlInstrucao = "Update modelo set descricao = ?, status = ?, marca_id = ? where id = ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, String.valueOf(objeto.getStatus()));
            pstm.setInt(3, objeto.getMarca().getId());
            pstm.setInt(4, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(Modelo objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}