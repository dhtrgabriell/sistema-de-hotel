package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Servico;

public class ServicoDAO implements InterfaceDAO<Servico>{

    @Override
    public void Create(Servico objeto) {
        String sqlInstrucao = "INSERT INTO servico"
                + "(descricao, "
                + "obs, "
                + "status) "
                + "values(?, ?, ?)";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        
        try{
            
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getObs());
            pstm.setString(1, String.valueOf(objeto.getStatus()));
            
            pstm.executeQuery();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public Servico Retrieve(int id) {
        String sqlInstrucao = "SELECT"
                + "id, "
                + "descricao, "
                + "obs, "
                + "status "
                + "FROM servico WHERE id = ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        Servico servico = new Servico();
        
        try {
            
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                
                servico.setId(rst.getInt("id"));
                servico.setDescricao(rst.getString("descricao"));
                servico.setObs(rst.getString("obs"));
                servico.setStatus(rst.getString("status").charAt(0));
                
                return servico;
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return servico;
        }
    }

    @Override
    public List<Servico> Retrieve(String atributo, String valor) {
        String sqlInstrucao = "SELECT"
                + "id, "
                + "descricao, "
                + "obs, "
                + "status "
                + "FROM servico WHERE " + atributo + " like ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Servico> listaServicos = new ArrayList<>();
        
        try{
            
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while(rst.next()){
                
                Servico servico = new Servico();
                
                servico.setId(rst.getInt("id"));
                servico.setDescricao(rst.getString("descricao"));
                servico.setObs(rst.getString("obs"));
                servico.setStatus(rst.getString("status").charAt(0));
                
                listaServicos.add(servico);
                return listaServicos;
                
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaServicos;
        }
            
    }

    @Override
    public void Update(Servico objeto) {
        String sqlInstrucao = "UPDATE servico SET"
                + "descricao = ?, "
                + "obs = ?, "
                + "status = ? "
                + "WHERE id = ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        
        try{
            
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getObs());
            pstm.setString(3, String.valueOf(objeto.getStatus()));
            
            pstm.execute();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
        
    }

    @Override
    public void Delete(Servico objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
