package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Marca;
import model.Modelo;
import model.Veiculo;

public class VeiculoDAO implements InterfaceDAO<Veiculo> {

    @Override
    public void Create(Veiculo objeto) {
        String sql = "INSERT INTO veiculo (placa, cor, status, modelo_id, funcionario_id, fornecedor_id, hospede_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getPlaca());
            pstm.setString(2, objeto.getCor());
            pstm.setString(3, String.valueOf(objeto.getStatus()));
            pstm.setInt(4, objeto.getModelo().getId());
            
            if (objeto.getFuncionario() != null) pstm.setInt(5, objeto.getFuncionario().getId()); else pstm.setNull(5, java.sql.Types.INTEGER);
            if (objeto.getFornecedor() != null) pstm.setInt(6, objeto.getFornecedor().getId()); else pstm.setNull(6, java.sql.Types.INTEGER);
            if (objeto.getHospede() != null) pstm.setInt(7, objeto.getHospede().getId()); else pstm.setNull(7, java.sql.Types.INTEGER);

            pstm.executeUpdate(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public Veiculo Retrieve(int id) {
        String sql = "SELECT v.id AS veiculo_id, v.placa, v.cor, v.status AS veiculo_status, "
                   + "mo.id AS modelo_id, mo.descricao AS modelo_descricao, "
                   + "ma.id AS marca_id, ma.descricao AS marca_descricao "
                   + "FROM veiculo v "
                   + "JOIN modelo mo ON v.modelo_id = mo.id "
                   + "JOIN marca ma ON mo.marca_id = ma.id "
                   + "WHERE v.id = ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Veiculo veiculo = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            if (rst.next()) {
                veiculo = new Veiculo();
                Modelo modelo = new Modelo();
                Marca marca = new Marca();

                marca.setId(rst.getInt("marca_id"));
                marca.setDescricao(rst.getString("marca_descricao"));
                
                modelo.setId(rst.getInt("modelo_id"));
                modelo.setDescricao(rst.getString("modelo_descricao"));
                modelo.setMarca(marca);

                veiculo.setId(rst.getInt("veiculo_id"));
                veiculo.setPlaca(rst.getString("placa"));
                veiculo.setCor(rst.getString("cor"));
                veiculo.setStatus(rst.getString("veiculo_status").charAt(0));
                veiculo.setModelo(modelo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        return veiculo;
    }

    @Override
    public List<Veiculo> Retrieve(String atributo, String valor) {
        String sql = "SELECT v.id AS veiculo_id, v.placa, v.cor, v.status AS veiculo_status, "
                   + "mo.id AS modelo_id, mo.descricao AS modelo_descricao, "
                   + "ma.id AS marca_id, ma.descricao AS marca_descricao "
                   + "FROM veiculo v "
                   + "JOIN modelo mo ON v.modelo_id = mo.id "
                   + "JOIN marca ma ON mo.marca_id = ma.id "
                   + "WHERE " + atributo + " LIKE ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Veiculo> listaVeiculos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                Veiculo veiculo = new Veiculo();
                Modelo modelo = new Modelo();
                Marca marca = new Marca();
                
                marca.setId(rst.getInt("marca_id"));
                marca.setDescricao(rst.getString("marca_descricao"));

                modelo.setId(rst.getInt("modelo_id"));
                modelo.setDescricao(rst.getString("modelo_descricao"));
                modelo.setMarca(marca);

                veiculo.setId(rst.getInt("veiculo_id"));
                veiculo.setPlaca(rst.getString("placa"));
                veiculo.setCor(rst.getString("cor"));
                veiculo.setStatus(rst.getString("veiculo_status").charAt(0));
                veiculo.setModelo(modelo);
                
                listaVeiculos.add(veiculo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        return listaVeiculos;
    }

    @Override
    public void Update(Veiculo objeto) {
        String sql = "UPDATE veiculo SET placa = ?, cor = ?, status = ?, modelo_id = ?, funcionario_id = ?, fornecedor_id = ?, hospede_id = ? WHERE id = ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getPlaca());
            pstm.setString(2, objeto.getCor());
            pstm.setString(3, String.valueOf(objeto.getStatus()));
            pstm.setInt(4, objeto.getModelo().getId());
            if (objeto.getFuncionario() != null) pstm.setInt(5, objeto.getFuncionario().getId()); else pstm.setNull(5, java.sql.Types.INTEGER);
            if (objeto.getFornecedor() != null) pstm.setInt(6, objeto.getFornecedor().getId()); else pstm.setNull(6, java.sql.Types.INTEGER);
            if (objeto.getHospede() != null) pstm.setInt(7, objeto.getHospede().getId()); else pstm.setNull(7, java.sql.Types.INTEGER);
            pstm.setInt(8, objeto.getId());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(Veiculo objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}   