package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ProdutoCopa;

public class ProdutoCopaDAO implements InterfaceDAO<ProdutoCopa> {

    @Override
    public void Create(ProdutoCopa objeto) {
        // CORRIGIDO: Alterado 'descricao' para 'decricao' para bater com o seu SQL
        String sql = "INSERT INTO produto_copa (decricao, valor, obs, status) VALUES (?, ?, ?, ?)";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getDescricao());
            pstm.setDouble(2, objeto.getPreco());
            pstm.setString(3, objeto.getObs());
            pstm.setString(4, String.valueOf(objeto.getStatus()));
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public ProdutoCopa Retrieve(int id) {
        // CORRIGIDO: Alterado 'descricao' para 'decricao'
        String sql = "SELECT id, decricao, valor, obs, status FROM produto_copa WHERE id = ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        ProdutoCopa produtoCopa = null;

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            if (rst.next()) {
                produtoCopa = new ProdutoCopa();
                produtoCopa.setId(rst.getInt("id"));
                produtoCopa.setDescricao(rst.getString("decricao")); // CORRIGIDO
                produtoCopa.setPreco(rst.getDouble("valor"));
                produtoCopa.setObs(rst.getString("obs"));
                produtoCopa.setStatus(rst.getString("status").charAt(0));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        return produtoCopa;
    }

    @Override
    public List<ProdutoCopa> Retrieve(String atributo, String valor) {
        // CORRIGIDO: Alterado 'descricao' para 'decricao'
        String sql = "SELECT id, decricao, valor, obs, status FROM produto_copa WHERE " + atributo + " LIKE ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<ProdutoCopa> listaProdutosCopa = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                ProdutoCopa produtoCopa = new ProdutoCopa();
                produtoCopa.setId(rst.getInt("id"));
                produtoCopa.setDescricao(rst.getString("decricao")); // CORRIGIDO
                produtoCopa.setPreco(rst.getDouble("valor"));
                produtoCopa.setObs(rst.getString("obs"));
                produtoCopa.setStatus(rst.getString("status").charAt(0));
                listaProdutosCopa.add(produtoCopa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        return listaProdutosCopa;
    }

    @Override
    public void Update(ProdutoCopa objeto) {
        // CORRIGIDO: Alterado 'descricao' para 'decricao'
        String sql = "UPDATE produto_copa SET decricao = ?, valor = ?, obs = ?, status = ? WHERE id = ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objeto.getDescricao());
            pstm.setDouble(2, objeto.getPreco());
            pstm.setString(3, objeto.getObs());
            pstm.setString(4, String.valueOf(objeto.getStatus()));
            pstm.setInt(5, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(ProdutoCopa objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}