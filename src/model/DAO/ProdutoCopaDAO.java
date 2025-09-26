package model.DAO;

import java.util.List;
import model.ProdutoCopa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoCopaDAO implements InterfaceDAO<ProdutoCopa>{

    @Override
    public void Create(ProdutoCopa objeto) {
        String sqlInstrucao = "INSERT INTO produto_copa "
                + "(descricao, "
                + "valor, "
                + "obs, "
                + "status) "
                + "VALUES (?, ?, ?, ?)";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        
        try{
            
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setDouble(2, objeto.getPreco());
            pstm.setString(3, objeto.getObs());
            pstm.setString(4, String.valueOf(objeto.getStatus()));
            
            pstm.execute();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public ProdutoCopa Retrieve(int id) {
        String sqlInstrucao = "SELECT "
                + "id, "
                + "descricao, "
                + "valor, "
                + "obs, "
                + "status "
                + "FROM produto_copa WHERE id = ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        ProdutoCopa produtoCopa = new ProdutoCopa();
        
        try{
            
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                
                produtoCopa.setId(rst.getInt("id"));
                produtoCopa.setDescricao(rst.getString("descricao"));
                produtoCopa.setPreco(rst.getDouble("valor"));
                produtoCopa.setObs(rst.getString("obs"));
                produtoCopa.setId(rst.getString("status").charAt(0));
                
                return produtoCopa;
                
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return produtoCopa;
        }
    }

    @Override
    public List<ProdutoCopa> Retrieve(String atributo, String valor) {
        String sqlInstrucao = "SELECT "
                + "id, "
                + "descricao, "
                + "valor, "
                + "obs, "
                + "status "
                + "FROM produto_copa WHERE " + atributo + " LIKE ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<ProdutoCopa> listaProdutosCopa = new ArrayList<>();
        
        try{
            
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + atributo + "%");
            rst = pstm.executeQuery();
            
            while(rst.next()){
                
                ProdutoCopa produtoCopa = new ProdutoCopa();
                
                produtoCopa.setId(rst.getInt("id"));
                produtoCopa.setDescricao(rst.getString("descricao"));
                produtoCopa.setPreco(rst.getDouble("valor"));
                produtoCopa.setObs(rst.getString("obs"));
                produtoCopa.setStatus(rst.getString("status").charAt(0));
                
                listaProdutosCopa.add(produtoCopa);
                return listaProdutosCopa;
                
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaProdutosCopa;
        }
    }

    @Override
    public void Update(ProdutoCopa objeto) {
        String sqlInstrucao = "UPDATE produto_copa SET "
                + "descricao = ?, "
                + "valor = ?, "
                + "obs = ?, "
                + "status = ? "
                + "WHERE id = ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        
        try{
            
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setDouble(1, objeto.getPreco());
            pstm.setString(1, objeto.getObs());
            pstm.setString(1, String.valueOf(objeto.getStatus()));
            
            pstm.execute();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(ProdutoCopa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
