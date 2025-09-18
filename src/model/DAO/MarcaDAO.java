package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Marca;

public class MarcaDAO implements InterfaceDAO<Marca>{

    @Override
    public void Create(Marca objeto) {

        String sqlInstrucao = "Insert into marca(descicao, status) values(?, ?)";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            
            pstm = conexao.prepareStatement(sqlInstrucao);

            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, String.valueOf(objeto.getStatus()));

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public Marca Retrieve(int id) {
        String sqlInstrucao = "Select id, descricao, status from marca where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Marca marca = new Marca();

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            while(rst.next()){
                marca.setId(rst.getInt("id"));
                marca.setDescricao(rst.getString("descricao"));
                marca.setStatus(rst.getString("status").charAt(0));

                return marca;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return marca;
        }

    }

    @Override
    public List<Marca> Retrieve(String atributo, String valor) {
        String sqlInstrucao = "Select id, descricao, status from marca where " + atributo + " like ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<Marca> listaMarcas = new ArrayList<>();

        try {
            
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while(rst.next()){
                Marca marca = new Marca();

                marca.setId(rst.getInt("id"));
                marca.setDescricao(rst.getString("descricao"));
                marca.setStatus(rst.getString("status").charAt(0));

                return listaMarcas;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaMarcas;
        }

    }

    @Override
    public void Update(Marca objeto) {
        String sqlInstrucao = "Update marca set descricao = ?, status = ? from marca where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);

            pstm.setString(0, objeto.getDescricao());
            pstm.setString(0, String.valueOf(objeto.getStatus()));

            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void Delete(Marca objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
